package com.github.constantinet.assertjandhamcrestshowcase.hamcrest;

import org.hamcrest.Description;
import org.hamcrest.TypeSafeMatcher;

import java.util.Arrays;
import java.util.Collection;
import java.util.Map;


public class _4a_KeyValuesMatcher extends TypeSafeMatcher<Map<?, ?>> {

    private final Collection<Object> keys;

    public _4a_KeyValuesMatcher(final Object... keys) {
        this.keys = Arrays.asList(keys);
    }

    @Override
    protected boolean matchesSafely(final Map<?, ?> item) {
        return item.keySet().containsAll(keys);
    }

    @Override
    public void describeTo(final Description description) {
        description.appendText("has keys " + keys);
    }
}