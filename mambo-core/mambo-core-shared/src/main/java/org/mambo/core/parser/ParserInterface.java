package org.mambo.core.parser;

/**
 * Created with IntelliJ IDEA.
 * User: Blackrush
 * Date: 25/11/12
 * Time: 11:07
 */
public interface ParserInterface<T> {
    Class<?> getTargetClass();

    Object parse(T input);
}
