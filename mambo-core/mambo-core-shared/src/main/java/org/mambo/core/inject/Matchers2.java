package org.mambo.core.inject;

import com.google.inject.TypeLiteral;
import com.google.inject.matcher.AbstractMatcher;
import com.google.inject.matcher.Matcher;

/**
 * Created with IntelliJ IDEA.
 * User: Blackrush
 * Date: 28/11/12
 * Time: 18:47
 */
public final class Matchers2 {
    private Matchers2() {}

    public static Matcher<? super TypeLiteral<?>> subclassesOf(Class<?> clazz) {
        return subclassesOf(TypeLiteral.get(clazz));
    }

    public static Matcher<? super TypeLiteral<?>> subclassesOf(TypeLiteral<?> type) {
        return new SubclassesOf(type);
    }

    private static final class SubclassesOf extends AbstractMatcher<TypeLiteral<?>> {
        private final TypeLiteral<?> type;

        private SubclassesOf(TypeLiteral<?> type) {
            this.type = type;
        }

        @Override
        public boolean matches(TypeLiteral<?> typeLiteral) {
            return type.getRawType().isAssignableFrom(typeLiteral.getRawType());
        }
        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;

            SubclassesOf that = (SubclassesOf) o;
            return type.equals(that.type);
        }

        @Override
        public int hashCode() {
            return type.hashCode();
        }
    }
}
