package org.mambo.core.configuration;

import com.google.common.base.Strings;
import com.google.common.collect.Maps;
import org.jdom2.Attribute;
import org.jdom2.Document;
import org.jdom2.Element;
import org.jdom2.input.SAXBuilder;
import org.jdom2.input.sax.SAXEngine;
import org.jetbrains.annotations.NotNull;
import org.mambo.core.parser.StringParserInterface;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.InputStream;
import java.util.List;
import java.util.Map;
import java.util.Set;

import static com.google.common.base.Preconditions.checkNotNull;

/**
 * Created with IntelliJ IDEA.
 * User: Blackrush
 * Date: 25/11/12
 * Time: 10:39
 */
public class XmlConfigurationProvider extends BaseConfigurationProvider {
    private static final Logger log = LoggerFactory.getLogger(XmlConfigurationProvider.class);

    private static final String ELEMENT_NAME = "config",
                                ATTR_KEY = "key",
                                ATTR_TYPE = "type",
                                ATTR_VALUE = "value";

    private static String combine(String left, String right) {
        return left + "." + right;
    }

    private final SAXEngine builder = new SAXBuilder();
    private final Map<String, StringParserInterface> parsers = Maps.newHashMap();

    public XmlConfigurationProvider(@NotNull Set<StringParserInterface> otherParsers) {
        for (StringParserInterface parser : checkNotNull(otherParsers)) {
            parsers.put(parser.getTargetClass().getSimpleName(), parser);
        }
    }

    @Override
    public void load(@NotNull InputStream input) {
        Document document;
        try {
            document = builder.build(input);
        } catch (Throwable e) {
            throw new ConfigurationLoadException("can't load configuration", e);
        }

        loadChildren(null, document.getRootElement());
    }

    private void loadChildren(String parentKey, Element element) {
        List<Element> children = element.getChildren(ELEMENT_NAME);
        if (children.size() > 0) {
            load(parentKey, children);
        }
    }

    private void load(String parentKey, Iterable<Element> elements) {
        for (Element element : elements) {
            Attribute keyAttr   = element.getAttribute(ATTR_KEY),
                      typeAttr  = element.getAttribute(ATTR_TYPE),
                      valueAttr = element.getAttribute(ATTR_VALUE);

            String key = keyAttr == null
                    ? parentKey
                    : Strings.isNullOrEmpty(parentKey)
                        ? keyAttr.getValue()
                        : combine(parentKey, keyAttr.getValue());

            if (!Strings.isNullOrEmpty(key) && typeAttr != null && valueAttr != null) {
                load(key, typeAttr.getValue(), valueAttr.getValue());
            }

            loadChildren(key, element);
        }
    }

    private void load(String key, String type, String input) {
        StringParserInterface parser = parsers.get(type);
        if (parser == null) {
            log.warn("key={} unknown type \"{}\", value is not parsed", key, type);
        } else {
            Object value = parser.parse(input);

            configure(key, value);
        }
    }
}
