package com.github.constantinet.assertjandhamcrestshowcase;

import java.util.*;

/**
 * Mutable representation of a person.
 */
public final class Person {

    private final int idNumber;

    private String firstName;
    private String middleName;
    private String lastName;
    private double height;

    private Person spouse;
    private final Set<String> childrenNames = new HashSet<>();

    public Person(final int idNumber) {
        this.idNumber = idNumber;
    }

    public Person(final int idNumber, final String firstName, final String lastName) {
        Objects.requireNonNull(firstName);
        Objects.requireNonNull(lastName);
        if (firstName.isEmpty() || lastName.isEmpty()) {
            throw new IllegalArgumentException("Names can not be empty");
        }

        this.idNumber = idNumber;
        this.firstName = firstName;
        this.lastName = lastName;
    }

    public Person(final int idNumber, final String firstName, final String middleName, final String lastName) {
        Objects.requireNonNull(firstName);
        Objects.requireNonNull(middleName);
        Objects.requireNonNull(lastName);
        if (firstName.isEmpty() || middleName.isEmpty() || lastName.isEmpty()) {
            throw new IllegalArgumentException("Names can not be empty");
        }

        this.idNumber = idNumber;
        this.firstName = firstName;
        this.middleName = middleName;
        this.lastName = lastName;
    }

    /**
     * Sets height.
     *
     * @param height height in cm and mm
     * @return this for chaining
     */
    public Person setHeight(final double height) {
        if (height <= 0.0) {
            throw new IllegalArgumentException("Height must be positive");
        }

        this.height = height;

        return this;
    }

    /**
     * Add a person as a spouse.
     *
     * @param person person
     * @return this for chaining
     */
    public Person setSpouse(final Person person) {
        Objects.requireNonNull(person);

        this.spouse = person;

        return this;
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
     * Returns height.
     *
     * @return height
     */
    public double getHeight() {
        return height;
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
     * Returns spouse.
     *
     * @return Optional of spouse or empty optional
     */
    public Optional<Person> getSpouse() {
        return Optional.ofNullable(spouse);
    }

    /**
     * Returns unmodifiable view of children names.
     *
     * @return set of {@link Person}
     */
    public Set<String> getChildrenNames() {
        return Collections.unmodifiableSet(childrenNames);
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
                ", height=" + height +
                ", spouse=" + spouse +
                ", childrenNames=" + childrenNames +
                '}';
    }
}