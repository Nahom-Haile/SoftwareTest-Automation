/**
 * Nahom Haile
 * 05.24.2026
 * Software Test & Automation
 * 
 * ContactServiceTest.java
*/

import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

public class ContactServiceTest {
 
    private ContactService service;
 
    //Add contact
    @Before
    public void setUp() {
        service = new ContactService();
        service.addContact(new Contact("ID001", "John", "Doe", "5551234567", "123 Main St"));
    }
 
    private Contact makeContact(String id) {
        return new Contact(id, "Jane", "Smith", "9876543210", "456 Oak Ave Springfield");
    }
 
    @Test
    public void testAddContact_success() {
        service.addContact(makeContact("ID002"));
        assertNotNull(service.getContact("ID002"));
    }
 
    @Test(expected = IllegalArgumentException.class)
    public void testAddContact_duplicateId_throwsException() {
        service.addContact(new Contact("ID001", "Alice", "Brown", "1112223333", "789 Pine Rd"));
    }
 
    @Test(expected = IllegalArgumentException.class)
    public void testAddContact_nullContact_throwsException() {
        service.addContact(null);
    }
 
    @Test
    public void testAddMultipleContacts_allStoredSuccessfully() {
        service.addContact(makeContact("ID002"));
        service.addContact(makeContact("ID003"));
        assertNotNull(service.getContact("ID001"));
        assertNotNull(service.getContact("ID002"));
        assertNotNull(service.getContact("ID003"));
    }
 
    //Delete contact
    @Test
    public void testDeleteContact_success() {
        service.deleteContact("ID001");
        assertNull(service.getContact("ID001"));
    }
 
    @Test(expected = IllegalArgumentException.class)
    public void testDeleteContact_nonExistentId_throwsException() {
        service.deleteContact("ZZZZZZ");
    }
 
    @Test
    public void testDeleteContact_onlyRemovesTargetContact() {
        service.addContact(makeContact("ID002"));
        service.deleteContact("ID001");
        assertNull(service.getContact("ID001"));
        assertNotNull(service.getContact("ID002"));
    }
 
    @Test
    public void testDeleteContact_thenAddSameId_succeeds() {
        service.deleteContact("ID001");
        service.addContact(new Contact("ID001", "New", "Person", "0000000000", "1 New St"));
        assertNotNull(service.getContact("ID001"));
        assertEquals("New", service.getContact("ID001").getFirstName());
    }
 
    //Update first name
    @Test
    public void testUpdateFirstName_success() {
        service.updateFirstName("ID001", "Johnny");
        assertEquals("Johnny", service.getContact("ID001").getFirstName());
    }
 
    @Test(expected = IllegalArgumentException.class)
    public void testUpdateFirstName_nonExistentId_throwsException() {
        service.updateFirstName("ZZZZZZ", "Alice");
    }
 
    @Test(expected = IllegalArgumentException.class)
    public void testUpdateFirstName_null_throwsException() {
        service.updateFirstName("ID001", null);
    }
 
    @Test(expected = IllegalArgumentException.class)
    public void testUpdateFirstName_tooLong_throwsException() {
        service.updateFirstName("ID001", "JohnJohnJohn");
    }

    
    //Update last name
    @Test
    public void testUpdateLastName_success() {
        service.updateLastName("ID001", "Johnson");
        assertEquals("Johnson", service.getContact("ID001").getLastName());
    }
 
    @Test(expected = IllegalArgumentException.class)
    public void testUpdateLastName_nonExistentId_throwsException() {
        service.updateLastName("ZZZZZZ", "Johnson");
    }
 
    @Test(expected = IllegalArgumentException.class)
    public void testUpdateLastName_null_throwsException() {
        service.updateLastName("ID001", null);
    }
 
    @Test(expected = IllegalArgumentException.class)
    public void testUpdateLastName_tooLong_throwsException() {
        service.updateLastName("ID001", "DoeDoeDoeDoe");
    }
 

    //Update Phone
    @Test
    public void testUpdatePhone_success() {
        service.updatePhone("ID001", "9998887777");
        assertEquals("9998887777", service.getContact("ID001").getPhone());
    }
 
    @Test(expected = IllegalArgumentException.class)
    public void testUpdatePhone_nonExistentId_throwsException() {
        service.updatePhone("ZZZZZZ", "9998887777");
    }
 
    @Test(expected = IllegalArgumentException.class)
    public void testUpdatePhone_null_throwsException() {
        service.updatePhone("ID001", null);
    }
 
    @Test(expected = IllegalArgumentException.class)
    public void testUpdatePhone_wrongLength_throwsException() {
        service.updatePhone("ID001", "12345");
    }
 
    @Test(expected = IllegalArgumentException.class)
    public void testUpdatePhone_containsLetters_throwsException() {
        service.updatePhone("ID001", "555ABC4567");
    }

    
    //Update Address
    @Test
    public void testUpdateAddress_success() {
        service.updateAddress("ID001", "999 Elm St");
        assertEquals("999 Elm St", service.getContact("ID001").getAddress());
    }
 
    @Test(expected = IllegalArgumentException.class)
    public void testUpdateAddress_nonExistentId_throwsException() {
        service.updateAddress("ZZZZZZ", "999 Elm St");
    }
 
    @Test(expected = IllegalArgumentException.class)
    public void testUpdateAddress_null_throwsException() {
        service.updateAddress("ID001", null);
    }
 
    @Test(expected = IllegalArgumentException.class)
    public void testUpdateAddress_tooLong_throwsException() {
        service.updateAddress("ID001", "1234567890123456789012345678901");
    }
 
    @Test
    public void testUpdateAddress_exactly30Chars_success() {
        String addr = "123456789012345678901234567890";
        service.updateAddress("ID001", addr);
        assertEquals(addr, service.getContact("ID001").getAddress());
    }

    
    //Get Contact
    @Test
    public void testGetContact_existingId_returnsContact() {
        Contact c = service.getContact("ID001");
        assertNotNull(c);
        assertEquals("ID001", c.getContactId());
    }
 
    @Test
    public void testGetContact_nonExistentId_returnsNull() {
        assertNull(service.getContact("ZZZZZZ"));
    }
}
 