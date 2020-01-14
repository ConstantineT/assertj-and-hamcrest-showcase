package com.github.constantinet.assertjandhamcrestshowcase;

import java.util.*;
import java.util.stream.Stream;

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
    private final Map<ParentRelation, Person> parents = new HashMap<>();
    private final Set<Person> children = new HashSet<>();

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
     * Changes first name and last name.
     *
     * @param firstName first name
     * @param lastName last name
     * @return this for chaining
     */
    public Person changeName(final String firstName, final String lastName) {
        Objects.requireNonNull(firstName);
        Objects.requireNonNull(lastName);
        if (firstName.isEmpty() || lastName.isEmpty()) {
            throw new IllegalArgumentException("Names can not be empty");
        }

        this.firstName = firstName;
        this.lastName = lastName;

        return this;
    }

    /**
     * Adds height.
     *
     * @param height height in cm and mm
     * @return this for chaining
     */
    public Person addHeight(final double height) {
        if (height <= 0.0) {
            throw new IllegalArgumentException("Height must be positive");
        }

        this.height = height;

        return this;
    }

    /**
     * Add a person as a spouse. Adds {@code this} as a spouse of passed person.
     *
     * @param person person
     * @return this for chaining
     */
    public Person addSpouse(final Person person) {
        Objects.requireNonNull(person);

        this.spouse = person;
        person.spouse = this;

        return this;
    }

    /**
     * Add a person with {@code ParentRelation.FATHER}. Adds {@code this} as a children to passed person.
     *
     * @param person person
     * @return this for chaining
     */
    public Person addFather(final Person person) {
        Objects.requireNonNull(person);

        addParent(ParentRelation.FATHER, person);

        return this;
    }

    /**
     * Add a person with {@code ParentRelation.MOTHER}. Adds {@code this} as a children to passed person.
     *
     * @param person person
     * @return this for chaining
     */
    public Person addMother(final Person person) {
        Objects.requireNonNull(person);

        addParent(ParentRelation.MOTHER, person);

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
     * Returns unmodifiable view of parents.
     *
     * @return map of {@link ParentRelation} to {@link Person}
     */
    public Map<ParentRelation, Person> getParents() {
        return Collections.unmodifiableMap(parents);
    }

    /**
     * Returns unmodifiable view of children.
     *
     * @return set of {@link Person}
     */
    public Set<Person> getChildren() {
        return Collections.unmodifiableSet(children);
    }

    /**
     * Returns an ID number of the spouse.
     *
     * @return optional of ID or empty optional if no info available
     */
    public Optional<Integer> getSpouseId() {
        return extractId(spouse);
    }

    /**
     * Returns an ID number of a parent with relation {@code ParentRelation.FATHER}.
     *
     * @return optional of ID or empty optional if no info available
     */
    public Optional<Integer> getFatherId() {
        return extractId(parents.get(ParentRelation.FATHER));
    }

    /**
     * Returns an ID number of a parent with relation {@code ParentRelation.MOTHER}.
     *
     * @return optional of ID or empty optional if no info available
     */
    public Optional<Integer> getMotherId() {
        return extractId(parents.get(ParentRelation.MOTHER));
    }

    /**
     * Returns all available relatives.
     *
     * @return iterable of {@link Person}
     */
    public Stream<Person> getAllRelatives() {
        final Stream<Person> parentsAndChildrenStream = Stream.concat(parents.values().stream(), children.stream());
        final Stream<Person> spouseStream = spouse == null ? Stream.empty() : Stream.of(spouse);
        return Stream.concat(parentsAndChildrenStream, spouseStream);
    }

    private void addParent(final ParentRelation parentRelation, final Person person) {
        this.parents.put(parentRelation, person);
        person.children.add(this);
    }

    private Optional<Integer> extractId(final Person person) {
        return Optional.ofNullable(person)
                .map(Person::getIdNumber);
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
}