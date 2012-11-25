package org.mambo.core.parser.string;

import org.mambo.core.parser.StringParserInterface;

/**
 * Created with IntelliJ IDEA.
 * User: Blackrush
 * Date: 25/11/12
 * Time: 11:09
 */
public class IntStringParser implements StringParserInterface {
    @Override
    public Class<?> getTargetClass() {
        return Integer.class;
    }

    @Override
    public Object parse(String input) {
        return Integer.parseInt(input);
    }
}
