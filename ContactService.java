import java.util.HashMap;
import java.util.Map;

/**
 * Author: Robert Manalo
 * Description: Manages a collection of Contact objects using an in-memory HashMap, 
 * make sure that no duplicate IDs are created and allowing for rapid retrieval, updates, and deletions.
 */
public class ContactService {
    private final Map<String, Contact> contactDirectory;

    public ContactService() {
        this.contactDirectory = new HashMap<>();
    }

    public void addContact(Contact newContact) {
        if (newContact == null) {
            throw new IllegalArgumentException("Cannot add a null contact.");
        }
        if (contactDirectory.containsKey(newContact.getContactId())) {
            throw new IllegalArgumentException("A contact with this ID already exists.");
        }
        contactDirectory.put(newContact.getContactId(), newContact);
    }

    public void deleteContact(String targetId) {
        if (!contactDirectory.containsKey(targetId)) {
            throw new IllegalArgumentException("Contact ID not found in directory. Cannot delete.");
        }
        contactDirectory.remove(targetId);
    }

    public void updateContact(String targetId, String newFirstName, String newLastName, String newPhone, String newAddress) {
        if (!contactDirectory.containsKey(targetId)) {
            throw new IllegalArgumentException("Contact ID not found in directory. Cannot update.");
        }
        
        Contact existingContact = contactDirectory.get(targetId);
        
        if (newFirstName != null) existingContact.setFirstName(newFirstName);
        if (newLastName != null) existingContact.setLastName(newLastName);
        if (newPhone != null) existingContact.setPhone(newPhone);
        if (newAddress != null) existingContact.setAddress(newAddress);
    }

    public Contact retrieveContact(String targetId) {
        return contactDirectory.get(targetId);
    }
}