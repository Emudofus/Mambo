package org.mambo.core.parser.string;

import org.joda.time.Duration;
import org.mambo.core.parser.StringParserInterface;

/**
 * Created with IntelliJ IDEA.
 * User: Blackrush
 * Date: 25/11/12
 * Time: 11:12
 */
public class DurationStringParser implements StringParserInterface {
    @Override
    public Class<?> getTargetClass() {
        return Duration.class;
    }

    @Override
    public Object parse(String input) {
        return Duration.parse(input);
    }
}
