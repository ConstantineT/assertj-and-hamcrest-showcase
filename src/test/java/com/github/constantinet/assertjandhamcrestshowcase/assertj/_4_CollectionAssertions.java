package com.github.constantinet.assertjandhamcrestshowcase.assertj;

import com.github.constantinet.assertjandhamcrestshowcase.Person;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;
import java.util.Map;

import static org.assertj.core.api.Assertions.assertThat;


public class _4_CollectionAssertions {

    private static final int ID = 101;

    private static final String JOHN = "John";
    private static final String MARY = "Mary";
    private static final String MICHAEL = "Michael";

    private Person person;

    @BeforeEach
    public void setUp() {
        // given
        person = Person.PersonBuilder
                .aPerson(ID)
                .withChildrenNames(Arrays.asList(JOHN, MARY, MICHAEL))
                .build();
    }

    @Test
    public void testChildrenNamesListContains3Names() {
        // when
        final List<String> childrenNames = person.getChildrenNames();

        // then
        assertThat(childrenNames).hasSize(3);
    }

    @Test
    public void testChildrenNamesListContainsAllNames() {
        // when
        final List<String> childrenNames = person.getChildrenNames();

        // then
        assertThat(childrenNames).containsExactly(JOHN, MARY, MICHAEL);
    }

    @Test
    public void testChildrenNamesListContainsMary() {
        // when
        final List<String> childrenNames = person.getChildrenNames();

        // then
        assertThat(childrenNames).contains(MARY);
    }

    @Test
    public void testChildrenNamesLengthMapContainsCorrectKeys() {
        // when
        final Map<Integer, List<String>> childrenNameLengthMap = person.getChildrenNameLengthMap();

        // then
        assertThat(childrenNameLengthMap).containsKeys(4, 7);
    }

    @Test
    public void testChildrenNamesLengthMapContainsEntryForMichael() {
        // when
        final Map<Integer, List<String>> childrenNameLengthMap = person.getChildrenNameLengthMap();

        // then
        // TODO: check if theres is 7->["Michael"] entry
        // HINT: look for an appropriate method
        throw new AssertionError();
    }
}