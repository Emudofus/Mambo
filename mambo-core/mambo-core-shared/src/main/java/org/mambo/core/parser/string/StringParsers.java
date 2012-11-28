package org.mambo.core.parser.string;

import com.google.common.collect.ImmutableSet;
import org.mambo.core.parser.StringParserInterface;

import java.util.Set;

/**
 * Created with IntelliJ IDEA.
 * User: Blackrush
 * Date: 28/11/12
 * Time: 13:24
 */
public final class StringParsers {
    private StringParsers() {}

    private static final ImmutableSet<StringParserInterface> defaults = ImmutableSet.<StringParserInterface>builder()
            .add(new BigIntegerStringParser(), new DurationStringParser(), new InstantStringParser(), new IntStringParser(),
                 new LongStringParser(),       new ShortStringParser(),    new StringStringParser())
            .build();

    public static ImmutableSet<StringParserInterface> defaults() {
        return defaults;
    }

    public static Set<StringParserInterface> defaultsWith(ImmutableSet.Builder<StringParserInterface> builder) {
        return builder.addAll(defaults).build();
    }
}
