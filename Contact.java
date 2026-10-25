/**
 * Author: Robert Manalo
 * Description: The Contact class creates an in-memory object with a unique, immutable ID. 
 * This uses strict setter methods to enforce length and null constraints on all fields.
 */
public class Contact {
    private final String contactId;
    private String firstName;
    private String lastName;
    private String phone;
    private String address;

    public Contact(String contactId, String firstName, String lastName, String phone, String address) {
        if (contactId == null || contactId.length() > 10) {
            throw new IllegalArgumentException("Invalid Contact ID: Must be non-null and 10 characters or less.");
        }
        this.contactId = contactId;
        
        this.setFirstName(firstName);
        this.setLastName(lastName);
        this.setPhone(phone);
        this.setAddress(address);
    }

    public String getContactId() { return this.contactId; }
    public String getFirstName() { return this.firstName; }
    public String getLastName() { return this.lastName; }
    public String getPhone() { return this.phone; }
    public String getAddress() { return this.address; }

    public void setFirstName(String firstName) {
        if (firstName == null || firstName.length() > 10) {
            throw new IllegalArgumentException("Invalid First Name: Must be non-null and 10 characters or less.");
        }
        this.firstName = firstName;
    }

    public void setLastName(String lastName) {
        if (lastName == null || lastName.length() > 10) {
            throw new IllegalArgumentException("Invalid Last Name: Must be non-null and 10 characters or less.");
        }
        this.lastName = lastName;
    }

    public void setPhone(String phone) {
        if (phone == null || phone.length() != 10 || !phone.matches("\\d{10}")) {
            throw new IllegalArgumentException("Invalid Phone: Must be exactly 10 digits.");
        }
        this.phone = phone;
    }

    public void setAddress(String address) {
        if (address == null || address.length() > 30) {
            throw new IllegalArgumentException("Invalid Address: Must be non-null and 30 characters or less.");
        }
        this.address = address;
    }
}