package com.github.constantinet.assertjandhamcrestshowcase.hamcrest;

import com.github.constantinet.assertjandhamcrestshowcase.Person;
import org.junit.jupiter.api.Test;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;


public class _2_JoinAndPropertyMatchers {

    private static final int ID = 101;
    private static final String FIRST_NAME = "John";
    private static final String LAST_NAME = "Smith";
    private static final String MICHAEL = "Michael";

    private Person person;

    @Test
    public void testAllPersonPropertiesAreCorrectUsingHasProperty() {
        // given, when
        person = Person.PersonBuilder.aPerson(ID)
                .withFirstName(FIRST_NAME)
                .withLastName(LAST_NAME)
                .build();
        // then
        assertThat(person, anyOf(
                hasProperty("id", is(ID)),
                hasProperty("firstName", is(FIRST_NAME)),
                hasProperty("lastName", is(LAST_NAME))
        ));
    }

    @Test
    public void testAnyOfTheNamesIsMichaelUsingHasProperty() {
        // given, when
        person = Person.PersonBuilder.aPerson(ID)
                .withFirstName(FIRST_NAME)
                .withMiddleName(MICHAEL)
                .build();

        // then
        assertThat(person, anyOf(
                hasProperty("firstName", is(MICHAEL)),
                hasProperty("middleName", is(MICHAEL))
        ));
    }

    @Test
    public void testNoneOfTheNamesIsNullUsingHasProperty() {
        // given, when
        person = Person.PersonBuilder.aPerson(ID)
                .withFirstName(FIRST_NAME)
                .withMiddleName(MICHAEL)
                .withLastName(LAST_NAME)
                .build();

        // then
        assertThat(person, allOf(
                hasProperty("firstName", notNullValue()),
                hasProperty("middleName", notNullValue()),
                hasProperty("lastName", notNullValue())
        ));
    }
}