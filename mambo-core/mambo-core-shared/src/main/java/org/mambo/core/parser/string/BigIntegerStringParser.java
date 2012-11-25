package org.mambo.core.parser.string;

import org.mambo.core.parser.StringParserInterface;

import java.math.BigInteger;

/**
 * Created with IntelliJ IDEA.
 * User: Blackrush
 * Date: 25/11/12
 * Time: 11:10
 */
public class BigIntegerStringParser implements StringParserInterface {
    @Override
    public Class<?> getTargetClass() {
        return BigInteger.class;
    }

    @Override
    public Object parse(String input) {
        return new BigInteger(input);
    }
}
