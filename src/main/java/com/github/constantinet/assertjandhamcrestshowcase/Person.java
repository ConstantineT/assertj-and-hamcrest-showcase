package com.github.constantinet.assertjandhamcrestshowcase;

import java.util.*;
import java.util.stream.Collectors;


public final class Person {

    private final int idNumber;
    private final String firstName;
    private final String middleName;
    private final String lastName;
    private final List<String> childrenNames;

    private Person(final int idNumber,
                   final String firstName,
                   final String middleName,
                   final String lastName,
                   final List<String> childrenNames) {
        this.idNumber = idNumber;
        this.firstName = firstName;
        this.middleName = middleName;
        this.lastName = lastName;
        this.childrenNames = childrenNames;
    }

    /**
     * Returns id number.
     *
     * @return id number
     */
    public int getIdNumber() {
        return idNumber;
    }

    /**
     * Returns first name.
     *
     * @return first name
     */
    public String getFirstName() {
        return firstName;
    }

    /**
     * Returns first name.
     *
     * @return first name
     */
    public String getMiddleName() {
        return middleName;
    }

    /**
     * Returns last name.
     *
     * @return last name
     */
    public String getLastName() {
        return lastName;
    }

    /**
     * Returns initials.
     *
     * @return initials from first name and lastname
     */
    public String getInitials() {
        if (firstName == null || lastName == null) {
            return null;
        } else {
            return (String.valueOf(firstName.charAt(0)) + lastName.charAt(0)).toUpperCase();
        }
    }

    /**
     * Returns unmodifiable view of children names.
     *
     * @return set of {@link Person}
     */
    public List<String> getChildrenNames() {
        return Collections.unmodifiableList(childrenNames);
    }

    /**
     * Returns map of number of letters to list of children names with this name length.
     *
     * @return set of {@link Person}
     */
    public Map<Integer, List<String>> getChildrenNameLengthMap() {
        return childrenNames
                .stream()
                .collect(Collectors.groupingBy(String::length));
    }

    @Override
    public boolean equals(final Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        final Person person = (Person) o;
        return idNumber == person.idNumber;
    }

    @Override
    public int hashCode() {
        return Objects.hash(idNumber);
    }

    @Override
    public String toString() {
        return "Person{" +
                "idNumber=" + idNumber +
                ", firstName='" + firstName + '\'' +
                ", middleName='" + middleName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", childrenNames=" + childrenNames +
                '}';
    }


    public static final class PersonBuilder {

        private final int idNumber;
        private String firstName;
        private String middleName;
        private String lastName;
        private List<String> childrenNames = new ArrayList<>();

        private PersonBuilder(final int idNumber) {
            this.idNumber = idNumber;
        }

        public static PersonBuilder aPerson(final int idNumber) {
            return new PersonBuilder(idNumber);
        }

        public PersonBuilder withFirstName(final String firstName) {
            this.firstName = firstName;
            return this;
        }

        public PersonBuilder withMiddleName(final String middleName) {
            this.middleName = middleName;
            return this;
        }

        public PersonBuilder withLastName(final String lastName) {
            this.lastName = lastName;
            return this;
        }

        public PersonBuilder withChildrenNames(final List<String> childrenNames) {
            this.childrenNames = childrenNames;
            return this;
        }

        public Person build() {
            return new Person(idNumber, firstName, middleName, lastName, childrenNames);
        }
    }
}