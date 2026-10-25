import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

/**
 * Author: Robert Manalo
 * Description: JUnit test suite verifying the boundary constraints and exception handling 
 * for the Contact object fields.
 */
class ContactTest {

    @Test
    void testSuccessfulContactCreation() {
        Contact kairiContact = new Contact("Islands01", "Kairi", "Princess", "0123456789", "Destiny Islands Beach");
        assertEquals("Islands01", kairiContact.getContactId());
        assertEquals("Kairi", kairiContact.getFirstName());
        assertEquals("Princess", kairiContact.getLastName());
        assertEquals("0123456789", kairiContact.getPhone());
        assertEquals("Destiny Islands Beach", kairiContact.getAddress());
    }

    @Test
    void testContactIdTooLongThrowsException() {
        assertThrows(IllegalArgumentException.class, () -> {
            new Contact("OrganizationXIII", "Axel", "Flurries", "0987654321", "Castle Oblivion");
        });
    }

    @Test
    void testContactFirstNameNullThrowsException() {
        assertThrows(IllegalArgumentException.class, () -> {
            new Contact("Nobody01", null, "Nobody", "1234567890", "The World That Never Was");
        });
    }

    @Test
    void testContactPhoneNotTenDigitsThrowsException() {
        assertThrows(IllegalArgumentException.class, () -> {
            new Contact("Twilight01", "Roxas", "Struggle", "12345", "Twilight Town Clocktower");
        });
    }

    @Test
    void testContactPhoneContainsLettersThrowsException() {
        assertThrows(IllegalArgumentException.class, () -> {
            new Contact("Twilight01", "Roxas", "Struggle", "12345HELLO", "Twilight Town Clocktower");
        });
    }
}