package com.github.constantinet.assertjandhamcrestshowcase.hamcrest;

import com.github.constantinet.assertjandhamcrestshowcase.Person;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.hamcrest.CoreMatchers.*;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.emptyOrNullString;


public class _1_BasicAndStringMatchers {

    private static final int ID = 101;
    private static final String FIRST_NAME = "John";
    private static final String LAST_NAME = "Smith";

    private Person person;

    @BeforeEach
    public void setUp() {
        // given
        person = Person.PersonBuilder.aPerson(ID)
                .withFirstName(FIRST_NAME)
                .withLastName(LAST_NAME)
                .build();
    }

    @Test
    public void testFirstNameIsCorrect() {
        // when
        final String firstName = person.getFirstName();

        // then
        assertThat(firstName, equalTo(FIRST_NAME));
    }

    @Test
    public void testMiddleNameIsNull() {
        // when
        final String middleName = person.getMiddleName();

        // then
        assertThat(middleName, nullValue());
    }

    @Test
    public void testLastNameIsCorrectUsingSyntacticSugar() {
        // when
        final String lastName = person.getLastName();

        // then
        assertThat(lastName, is(LAST_NAME));
    }

    @Test
    public void testInitialsIsNotEmptyOrNullString() {
        // when
        final String initials = person.getInitials();

        // then
        assertThat(initials, not(emptyOrNullString()));
    }

    @Test
    public void testInitialsStartWithFirstLetterOfFirstName() {
        // when
        final String initials = person.getInitials();

        // then
        assertThat(initials, startsWithIgnoringCase(String.valueOf(FIRST_NAME.charAt(0))));
    }

    @Test
    public void testInitialsDoNotEndWithDot() {
        // when
        final String initials = person.getInitials();

        // then
        // TODO: check if initials do not end with a dot
        // HINT: look for an appropriate matcher
        throw new AssertionError();
    }
}