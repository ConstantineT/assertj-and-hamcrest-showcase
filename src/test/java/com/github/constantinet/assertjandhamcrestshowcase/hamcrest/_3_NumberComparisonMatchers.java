package com.github.constantinet.assertjandhamcrestshowcase.hamcrest;

import com.github.constantinet.assertjandhamcrestshowcase.Person;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;


public class _3_NumberComparisonMatchers {

    private static final int ID = 101;

    private Person person;

    @BeforeEach
    public void setUp() {
        // given
        person = Person.PersonBuilder
                .aPerson(ID)
                .build();
    }

    @Test
    public void testIdNumberIsCorrect() {
        // when
        final int idNumber = person.getIdNumber();

        // then
        assertThat(idNumber, is(equalTo(ID)));
    }

    @Test
    public void testIdNumberIsLessThan200() {
        // when
        final int idNumber = person.getIdNumber();

        // then
        assertThat(idNumber, is(lessThan(200)));
    }

    @Test
    public void testIdNumberIsGreaterThanOrEqualTo101() {
        // when
        final int idNumber = person.getIdNumber();

        // then
        assertThat(idNumber, is(greaterThanOrEqualTo(101)));
    }

    @Test
    public void testPersonIdIsBetween100And200() {
        // when
        final int idNumber = person.getIdNumber();

        // TODO: check if person id is between 100 and 200
        // HINT: use allOf and appropriate matchers
        throw new AssertionError();
    }
}