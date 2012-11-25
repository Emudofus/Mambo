package org.mambo.core.parser.string;

import org.mambo.core.parser.StringParserInterface;

/**
 * Created with IntelliJ IDEA.
 * User: Blackrush
 * Date: 25/11/12
 * Time: 11:11
 */
public class StringStringParser implements StringParserInterface {
    @Override
    public Class<?> getTargetClass() {
        return String.class;
    }

    @Override
    public Object parse(String input) {
        return input;
    }
}
