/**
 * Nahom Haile
 * 05.24.2026
 * Software Test & Automation
 * ContactTest.java
 * Unit tests for the Contact class using JUnit 4.
*/

import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;
public class ContactTest {

    private Contact contact;

    @Before
    public void setUp() {
        contact = new Contact("ID1234567", "John", "Doe", "5551234567", "123 Main St Springfield");
    }


    //Constructors
    @Test
    public void testContactCreatedSuccessfully() {
        assertEquals("ID1234567", contact.getContactId());
        assertEquals("John", contact.getFirstName());
        assertEquals("Doe", contact.getLastName());
        assertEquals("5551234567", contact.getPhone());
        assertEquals("123 Main St Springfield", contact.getAddress());
    }

    
    //Contact ID validation
    @Test(expected = IllegalArgumentException.class)
    public void testContactIdNull_throwsException() {
        new Contact(null, "John", "Doe", "5551234567", "123 Main St");
    }

    @Test(expected = IllegalArgumentException.class)
    public void testContactIdTooLong_throwsException() {
        new Contact("12345678901", "John", "Doe", "5551234567", "123 Main St");
    }

    @Test
    public void testContactIdExactly10Chars_isValid() {
        Contact c = new Contact("1234567890", "John", "Doe", "5551234567", "123 Main St");
        assertEquals("1234567890", c.getContactId());
    }

    @Test
    public void testContactIdIsImmutable() {
        String originalId = contact.getContactId();
        assertEquals(originalId, contact.getContactId());
    }

    
    //First Name validation
    @Test(expected = IllegalArgumentException.class)
    public void testFirstNameNull_throwsException() {
        new Contact("ID001", null, "Doe", "5551234567", "123 Main St");
    }

    @Test(expected = IllegalArgumentException.class)
    public void testFirstNameTooLong_throwsException() {
        new Contact("ID001", "JohnJohnJohn", "Doe", "5551234567", "123 Main St");
    }

    @Test
    public void testFirstNameExactly10Chars_isValid() {
        Contact c = new Contact("ID001", "Abcdefghij", "Doe", "5551234567", "123 Main St");
        assertEquals("Abcdefghij", c.getFirstName());
    }


    //Last Name validation
    @Test(expected = IllegalArgumentException.class)
    public void testLastNameNull_throwsException() {
        new Contact("ID001", "John", null, "5551234567", "123 Main St");
    }

    @Test(expected = IllegalArgumentException.class)
    public void testLastNameTooLong_throwsException() {
        new Contact("ID001", "John", "DoeDoeDoeDoe", "5551234567", "123 Main St");
    }

    @Test
    public void testLastNameExactly10Chars_isValid() {
        Contact c = new Contact("ID001", "John", "Abcdefghij", "5551234567", "123 Main St");
        assertEquals("Abcdefghij", c.getLastName());
    }


    //Phone validation
    @Test(expected = IllegalArgumentException.class)
    public void testPhoneNull_throwsException() {
        new Contact("ID001", "John", "Doe", null, "123 Main St");
    }

    @Test(expected = IllegalArgumentException.class)
    public void testPhoneTooShort_throwsException() {
        new Contact("ID001", "John", "Doe", "123456789", "123 Main St");
    }

    @Test(expected = IllegalArgumentException.class)
    public void testPhoneTooLong_throwsException() {
        new Contact("ID001", "John", "Doe", "12345678901", "123 Main St");
    }

    @Test(expected = IllegalArgumentException.class)
    public void testPhoneWithLetters_throwsException() {
        new Contact("ID001", "John", "Doe", "555ABC4567", "123 Main St");
    }

    @Test
    public void testPhoneExactly10Digits_isValid() {
        Contact c = new Contact("ID001", "John", "Doe", "5551234567", "123 Main St");
        assertEquals("5551234567", c.getPhone());
    }


    //Address validation
    @Test(expected = IllegalArgumentException.class)
    public void testAddressNull_throwsException() {
        new Contact("ID001", "John", "Doe", "5551234567", null);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testAddressTooLong_throwsException() {
        new Contact("ID001", "John", "Doe", "5551234567", "1234567890123456789012345678901");
    }

    @Test
    public void testAddressExactly30Chars_isValid() {
        String addr = "123456789012345678901234567890";
        Contact c = new Contact("ID001", "John", "Doe", "5551234567", addr);
        assertEquals(addr, c.getAddress());
    }


    //Setters — valid updates
    @Test
    public void testSetFirstName_updatesSuccessfully() {
        contact.setFirstName("Jane");
        assertEquals("Jane", contact.getFirstName());
    }

    @Test
    public void testSetLastName_updatesSuccessfully() {
        contact.setLastName("Smith");
        assertEquals("Smith", contact.getLastName());
    }

    @Test
    public void testSetPhone_updatesSuccessfully() {
        contact.setPhone("9876543210");
        assertEquals("9876543210", contact.getPhone());
    }

    @Test
    public void testSetAddress_updatesSuccessfully() {
        contact.setAddress("456 Oak Ave");
        assertEquals("456 Oak Ave", contact.getAddress());
    }


    //Setters — invalid updates throw exceptions
    @Test(expected = IllegalArgumentException.class)
    public void testSetFirstNameNull_throwsException() {
        contact.setFirstName(null);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testSetFirstNameTooLong_throwsException() {
        contact.setFirstName("JohnJohnJohn");
    }

    @Test(expected = IllegalArgumentException.class)
    public void testSetLastNameNull_throwsException() {
        contact.setLastName(null);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testSetLastNameTooLong_throwsException() {
        contact.setLastName("DoeDoeDoeDoe");
    }

    @Test(expected = IllegalArgumentException.class)
    public void testSetPhoneNull_throwsException() {
        contact.setPhone(null);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testSetPhoneInvalidFormat_throwsException() {
        contact.setPhone("ABCDEFGHIJ");
    }

    @Test(expected = IllegalArgumentException.class)
    public void testSetAddressNull_throwsException() {
        contact.setAddress(null);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testSetAddressTooLong_throwsException() {
        contact.setAddress("1234567890123456789012345678901");
    }
}