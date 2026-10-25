import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

/**
 * Author: Robert Manalo
 * Description: JUnit test suite to verify the CRUD operations of the ContactService class
 * utilizing an in-memory HashMap.
 */
class ContactServiceTest {
    private ContactService kingdomDirectory;

    @BeforeEach
    void initializeService() {
        kingdomDirectory = new ContactService();
    }

    @Test
    void testAddUniqueContactSuccessfully() {
        Contact axelContact = new Contact("Org13", "Axel", "Flurries", "1112223333", "Castle Oblivion");
        kingdomDirectory.addContact(axelContact);
        assertEquals(axelContact, kingdomDirectory.retrieveContact("Org13"));
    }

    @Test
    void testAddDuplicateContactFails() {
        Contact soraContact = new Contact("Keyblade01", "Sora", "Light", "9998887777", "Traverse Town");
        Contact rikuContact = new Contact("Keyblade01", "Riku", "Darkness", "1231231234", "Hollow Bastion");
        
        kingdomDirectory.addContact(soraContact);
        
        assertThrows(IllegalArgumentException.class, () -> {
            kingdomDirectory.addContact(rikuContact);
        });
    }

    @Test
    void testDeleteContactSuccessfully() {
        Contact xehanortContact = new Contact("Seeker01", "Master", "Xehanort", "0000000000", "Keyblade Graveyard");
        kingdomDirectory.addContact(xehanortContact);
        
        kingdomDirectory.deleteContact("Seeker01");
        assertNull(kingdomDirectory.retrieveContact("Seeker01"));
    }

    @Test
    void testUpdateContactSuccessfully() {
        Contact nobodyContact = new Contact("Nobody08", "Axel", "Flurries", "1112223333", "Castle Oblivion");
        kingdomDirectory.addContact(nobodyContact);
        
        kingdomDirectory.updateContact("Nobody08", "Lea", "Radiant", "4445556666", "Radiant Garden");
        
        Contact updatedContact = kingdomDirectory.retrieveContact("Nobody08");
        assertEquals("Lea", updatedContact.getFirstName());
        assertEquals("Radiant", updatedContact.getLastName());
        assertEquals("4445556666", updatedContact.getPhone());
        assertEquals("Radiant Garden", updatedContact.getAddress());
    }
}