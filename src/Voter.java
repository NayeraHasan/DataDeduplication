/**
 The Voter class represents a person who is eligible to vote.
 It contains information about the person's name and birthdate.
 It also implements the Comparable interface to enable sorting of Voter objects.
 */
public class Voter implements Comparable<Voter> {
    private String firstName; // The first name of the voter.
    private String middleName; // The middle name of the voter.
    private String lastName; // The last name of the voter.
    private String birthdate; // The birthdate of the voter

    /**
     Constructs a Voter object with the given first name, middle name, last name, and birthdate.
     * @param firstName the first name of the voter.
     * @param middleName the middle name of the voter.
     * @param lastName the last name of the voter.
     * @param birthdate the birthdate of the voter.
     */
    public Voter(String firstName, String middleName, String lastName, String birthdate) {
        this.firstName = firstName;
        this.middleName = middleName;
        this.lastName = lastName;
        this.birthdate = birthdate;
    }

    /**
     Gets the first name of the voter.
     @return the first name of the voter.
     */
    public String getFirstName() {
        return firstName;
    }

    /**
     Sets the first name of the voter.
     @param firstName the new first name of the voter.
     */
    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    /**

     Returns the middle name of the voter.
     @return the middle name of the voter.
     */
    public String getMiddleName() {
        return middleName;
    }
    /**

     Sets the middle name of the voter.
     @param middleName the new middle name of the voter.
     */
    public void setMiddleName(String middleName) {
        this.middleName = middleName;
    }
    /**

     Returns the last name of the voter.
     @return the last name of the voter.
     */
    public String getLastName() {
        return lastName;
    }
    /**
     Sets the last name of the voter.
     @param lastName the new last name of the voter.
     */
    public void setLastName(String lastName) {
        this.lastName = lastName;
    }
    /**

     Returns the birthdate of the voter.
     @return the birthdate of the voter in the format "yyyy-MM-dd".
     */
    public String getBirthdate() {
        return birthdate;
    }
    /**

     Sets the birthdate of the voter.
     @param birthdate the new birthdate of the voter in the format "yyyy-MM-dd".
     */
    public void setBirthdate(String birthdate) {
        this.birthdate = birthdate;
    }

    /**
     Compares this Voter object with another Voter object for ordering.
     The comparison is based on the last name, first name, and middle name of the voters.
     @param other the other Voter object to compare with.
     @return a negative integer, zero, or a positive integer as this Voter is less than, equal to, or greater than the other Voter.
     */

    @Override
    public int compareTo(Voter other) {
        // Compare last names first
        int lastNameCompare = this.lastName.compareTo(other.lastName);
        if (lastNameCompare != 0) {
            return lastNameCompare;
        } else {
        // If last names are the same, compare first names
        int firstNameCompare = this.firstName.compareTo(other.firstName);
            return firstNameCompare;
        }
    }

    /**
     Returns a string representation of this Voter object.
     The string consists of the last name followed by a comma and space, and then the first name.
     @return a string representation of this Voter object.
     */
    @Override
    public String toString() {
        return lastName + ", " + firstName;
    }
}
