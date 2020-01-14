package com.github.constantinet.assertjandhamcrestshowcase.assertj;

import com.github.constantinet.assertjandhamcrestshowcase.Person;
import org.assertj.core.api.Condition;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;


public class _1_BasicAndStringAssertions {

    private static final int ID = 101;
    private static final String FIRST_NAME = "John";
    private static final String LAST_NAME = "Smith";

    private Person person;

    @BeforeEach
    public void setUp() {
        // given
        person = new Person(ID, FIRST_NAME, LAST_NAME);
    }

    @Test
    public void testFirstNameIsCorrect() {
        // when
        final String firstName = person.getFirstName();

        // then
        assertThat(firstName).isEqualTo(FIRST_NAME);
    }

    @Test
    public void testMiddleNameIsNull() {
        // when
        final String middleName = person.getMiddleName();

        // then
        assertThat(middleName).isNull();
    }

    @Test
    public void testLastNameIsCorrectUsingCondition() {
        // when
        final String lastName = person.getLastName();

        // then
        assertThat(lastName).is(new Condition<>(LAST_NAME::equals, LAST_NAME));
    }

    @Test
    public void testInitialsIsNotEmptyOrNullString() {
        // when
        final String initials = person.getInitials();

        // then
        assertThat(initials).isNotEmpty();
    }

    @Test
    public void testInitialsStartWithFirstLetterOfFirstName() {
        // when
        final String initials = person.getInitials();

        // then
        assertThat(initials)
                .usingComparator(String.CASE_INSENSITIVE_ORDER)
                .startsWith(String.valueOf(FIRST_NAME.charAt(0)));
    }

    @Test
    public void testInitialsDoNotEndWithDot() {
        // when
        final String initials = person.getInitials();

        // then
        throw new AssertionError(); // TODO: check if initials do not end with a dot
    }
}