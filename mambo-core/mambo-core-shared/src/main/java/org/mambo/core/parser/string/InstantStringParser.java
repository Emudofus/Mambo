package org.mambo.core.parser.string;

import org.joda.time.Instant;
import org.mambo.core.parser.StringParserInterface;

/**
 * Created with IntelliJ IDEA.
 * User: Blackrush
 * Date: 25/11/12
 * Time: 11:12
 */
public class InstantStringParser implements StringParserInterface {
    @Override
    public Class<?> getTargetClass() {
        return Instant.class;
    }

    @Override
    public Object parse(String input) {
        return Instant.parse(input);
    }
}
