/**
 * Nahom Haile
 * 05.24.2026
 * Software Test & Automation
 * Contact.java
 * Represents a contact object
*/

public class Contact {

    private final String contactId;
    private String firstName;
    private String lastName;
    private String phone;
    private String address;

    /**
     * Constructs a Contact with all required fields.
     *
     * @param contactId unique identifier (non-null, max 10 chars, not updatable)
     * @param firstName first name (non-null, max 10 chars)
     * @param lastName  last name  (non-null, max 10 chars)
     * @param phone     phone number (non-null, exactly 10 digits)
     * @param address   mailing address (non-null, max 30 chars)
     */
    
    public Contact(String contactId, String firstName, String lastName,
                   String phone, String address) {

        if (contactId == null || contactId.length() > 10) {
            throw new IllegalArgumentException(
                "Contact ID must be non-null and no longer than 10 characters.");
        }
        if (firstName == null || firstName.length() > 10) {
            throw new IllegalArgumentException(
                "First name must be non-null and no longer than 10 characters.");
        }
        if (lastName == null || lastName.length() > 10) {
            throw new IllegalArgumentException(
                "Last name must be non-null and no longer than 10 characters.");
        }
        if (phone == null || !phone.matches("\\d{10}")) {
            throw new IllegalArgumentException(
                "Phone must be non-null and exactly 10 digits.");
        }
        if (address == null || address.length() > 30) {
            throw new IllegalArgumentException(
                "Address must be non-null and no longer than 30 characters.");
        }

        this.contactId = contactId;
        this.firstName = firstName;
        this.lastName  = lastName;
        this.phone     = phone;
        this.address   = address;
    }

    //Getters
    public String getContactId() { return contactId; }

    public String getFirstName()  { return firstName; }

    public String getLastName()   { return lastName; }

    public String getPhone()      { return phone; }

    public String getAddress()    { return address; }


    //Setters
    public void setFirstName(String firstName) {
        if (firstName == null || firstName.length() > 10) {
            throw new IllegalArgumentException(
                "First name must be non-null and no longer than 10 characters.");
        }
        this.firstName = firstName;
    }

    public void setLastName(String lastName) {
        if (lastName == null || lastName.length() > 10) {
            throw new IllegalArgumentException(
                "Last name must be non-null and no longer than 10 characters.");
        }
        this.lastName = lastName;
    }

    public void setPhone(String phone) {
        if (phone == null || !phone.matches("\\d{10}")) {
            throw new IllegalArgumentException(
                "Phone must be non-null and exactly 10 digits.");
        }
        this.phone = phone;
    }

    public void setAddress(String address) {
        if (address == null || address.length() > 30) {
            throw new IllegalArgumentException(
                "Address must be non-null and no longer than 30 characters.");
        }
        this.address = address;
    }
}