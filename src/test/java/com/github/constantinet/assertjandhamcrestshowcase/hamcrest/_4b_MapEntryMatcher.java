package com.github.constantinet.assertjandhamcrestshowcase.hamcrest;

import org.hamcrest.Description;
import org.hamcrest.TypeSafeMatcher;

import java.util.Map;


public class _4b_MapEntryMatcher extends TypeSafeMatcher<Map<?, ?>> {

    private final Object key;
    private final Object value;

    public _4b_MapEntryMatcher(final Object key, final Object value) {
        this.key = key;
        this.value = value;
    }

    @Override
    protected boolean matchesSafely(final Map<?, ?> item) {
        return item.entrySet()
                .stream()
                .anyMatch(entry -> key.equals(entry.getKey()) && value.equals(entry.getValue()));
    }

    @Override
    public void describeTo(final Description description) {
        description.appendText("has entry " + key + " -> " + value);
    }
}