package com.github.constantinet.assertjandhamcrestshowcase.assertj;

import com.github.constantinet.assertjandhamcrestshowcase.Person;
import com.github.constantinet.assertjandhamcrestshowcase.Person.PersonBuilder;
import org.assertj.core.api.Condition;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.*;


public class _2_JoinAndPropertyAssertions {

    private static final int ID = 101;
    private static final String FIRST_NAME = "John";
    private static final String LAST_NAME = "Smith";
    private static final String MICHAEL = "Michael";

    private Person person;

    @Test
    public void testAllPersonPropertiesAreCorrect() {
        // given, when
        person = PersonBuilder
                .aPerson(ID)
                .withFirstName(FIRST_NAME)
                .withLastName(LAST_NAME)
                .build();

        // then
        assertThat(person).is(allOf(
                new Condition<>(person -> ID == person.getIdNumber(), "id equal to " + ID),
                new Condition<>(person -> FIRST_NAME.equals(person.getFirstName()), "firstName equal to " + FIRST_NAME),
                new Condition<>(person -> LAST_NAME.equals(person.getLastName()), "lastName equal to " + LAST_NAME)));
    }

    @Test
    public void testAnyOfTheNamesIsMichael() {
        // given, when
        person = PersonBuilder
                .aPerson(ID)
                .withFirstName(FIRST_NAME)
                .withMiddleName(MICHAEL)
                .build();

        // then
        assertThat(person).is(anyOf(
                new Condition<>(person -> MICHAEL.equals(person.getFirstName()), "firstName equal to " + MICHAEL),
                new Condition<>(person -> MICHAEL.equals(person.getMiddleName()), "middleName equal to " + MICHAEL)));
    }

    @Test
    public void testNoneOfTheNamesIsNull() {
        // given, when
        person = PersonBuilder
                .aPerson(ID)
                .withFirstName(FIRST_NAME)
                .withMiddleName(MICHAEL)
                .withLastName(LAST_NAME)
                .build();

        // then
        assertThat(person).is(allOf(
                new Condition<>(person -> person.getFirstName() != null, "firstName not null"),
                new Condition<>(person -> person.getMiddleName() != null, "middleName not null"),
                new Condition<>(person -> person.getLastName() != null, "lastName not null")));
    }
}