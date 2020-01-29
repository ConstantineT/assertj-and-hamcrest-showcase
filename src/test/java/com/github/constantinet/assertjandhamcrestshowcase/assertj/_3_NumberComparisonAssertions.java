package com.github.constantinet.assertjandhamcrestshowcase.assertj;

import com.github.constantinet.assertjandhamcrestshowcase.Person;
import com.github.constantinet.assertjandhamcrestshowcase.Person.PersonBuilder;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;


public class _3_NumberComparisonAssertions {

    private static final int ID = 101;

    private Person person;

    @BeforeEach
    public void setUp() {
        // given
        person = PersonBuilder
                .aPerson(ID)
                .build();
    }

    @Test
    public void testIdNumberIsCorrect() {
        // when
        final double idNumber = person.getIdNumber();

        // then
        assertThat(idNumber).isEqualTo(ID);
    }

    @Test
    public void testIdNumberIsLessThan200() {
        // when
        final double idNumber = person.getIdNumber();

        // then
        assertThat(idNumber).isLessThan(200);
    }

    @Test
    public void testIdNumberIsGreaterThanOrEqualTo101() {
        // when
        final double idNumber = person.getIdNumber();

        // then
        assertThat(idNumber).isGreaterThanOrEqualTo(101);
    }

    @Test
    public void testPersonIdIsBetween101And200() {
        // when
        final int idNumber = person.getIdNumber();

        // then
        assertThat(idNumber).isBetween(101, 200);
    }
}