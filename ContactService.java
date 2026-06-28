/**
 * Nahom Haile
 * 05.24.2026
 * Software Test & Automation
 * ContactService.java
 * Manages an in-memory collection of Contact objects.
*/

import java.util.HashMap;
import java.util.Map;

public class ContactService {

    // In-memory data structure: contactId -> Contact
    private final Map<String, Contact> contacts = new HashMap<>();

    // ------------------------------------------------------------------ //
    //  Add
    // ------------------------------------------------------------------ //

    /**
     * Adds a new contact to the service.
     *
     * @param contact the Contact to add
     * @throws IllegalArgumentException if the contact is null or the ID already exists
     */
    public void addContact(Contact contact) {
        if (contact == null) {
            throw new IllegalArgumentException("Contact must not be null.");
        }
        if (contacts.containsKey(contact.getContactId())) {
            throw new IllegalArgumentException(
                "A contact with ID '" + contact.getContactId() + "' already exists.");
        }
        contacts.put(contact.getContactId(), contact);
    }

    /**
     * Deletes the contact with the given ID.
     *
     * @param contactId the ID of the contact to remove
     * @throws IllegalArgumentException if no contact with that ID is found
     */
    
    public void deleteContact(String contactId) {
        if (!contacts.containsKey(contactId)) {
            throw new IllegalArgumentException(
                "No contact found with ID '" + contactId + "'.");
        }
        contacts.remove(contactId);
    }

    /**
     * Updates the first name of the contact with the given ID.
     *
     * @param contactId the ID of the contact to update
     * @param firstName the new first name (non-null, max 10 chars)
     */
    
    //Helpers
    public void updateFirstName(String contactId, String firstName) {
        getExistingContact(contactId).setFirstName(firstName);
    }

    /**
     * Updates the last name of the contact with the given ID.
     *
     * @param contactId the ID of the contact to update
     * @param lastName  the new last name (non-null, max 10 chars)
     */
    
    public void updateLastName(String contactId, String lastName) {
        getExistingContact(contactId).setLastName(lastName);
    }

    /**
     * Updates the phone number of the contact with the given ID.
     *
     * @param contactId the ID of the contact to update
     * @param phone     the new phone number (non-null, exactly 10 digits)
     */
    
    public void updatePhone(String contactId, String phone) {
        getExistingContact(contactId).setPhone(phone);
    }

    /**
     * Updates the address of the contact with the given ID.
     *
     * @param contactId the ID of the contact to update
     * @param address   the new address (non-null, max 30 chars)
     */
    
    public void updateAddress(String contactId, String address) {
        getExistingContact(contactId).setAddress(address);
    }

    /**
     * Retrieves the contact with the given ID (read-only reference).
     *
     * @param contactId the ID to look up
     * @return the matching Contact, or null if not found
     */
    
    public Contact getContact(String contactId) {
        return contacts.get(contactId);
    }

    //Returns the contact for the given ID or throws if not found.
    private Contact getExistingContact(String contactId) {
        Contact contact = contacts.get(contactId);
        if (contact == null) {
            throw new IllegalArgumentException(
                "No contact found with ID '" + contactId + "'.");
        }
        return contact;
    }
}