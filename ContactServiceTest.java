/**
 * ContactServiceTest Class
 * @author Jordan Davis
 * @version 1.0
 * @date 3/22/22
 */

package Test;

import static org.junit.Assert.assertSame;
import static org.junit.Assert.assertTrue;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertNull;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.RepeatedTest;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import org.junit.jupiter.api.TestInstance.Lifecycle;
import Main.Contact;
import Main.ContactService;

@TestInstance(Lifecycle.PER_CLASS)

public class ContactServiceTest {
	
	// Creates an instance of the ContactService class to utilize methods and ArrayLists for testing.
	ContactService contactServ = new ContactService();
	
	@Test
	@Tag("add")
	void addConstructedContact() {
		contactServ.addContact(new Contact("12345678", "Jane", "Doe", "7701234568", "124 Sesame Street"));
		assertTrue(contactServ.contacts.get(contactServ.contacts.size() - 1).getID().equals("12345678"));
		assertTrue(contactServ.contacts.get(contactServ.contacts.size() - 1).getFirstName().equals("Jane"));
		assertTrue(contactServ.contacts.get(contactServ.contacts.size() - 1).getLastName().equals("Doe"));
		assertTrue(contactServ.contacts.get(contactServ.contacts.size() - 1).getPhone().equals("7701234568"));
		assertTrue(contactServ.contacts.get(contactServ.contacts.size() - 1).getAddress().equals("124 Sesame Street"));
	}
	
	@Test
	@Tag("delete")
	void deleteConstructedContact() {
		contactServ.addContact(new Contact("12345", "Harry", "Potter", "7704041234", "731 Diagon Alley"));
		contactServ.deleteContact("12345");
		assertNull(contactServ.findContact("12345"));
	}
	
	@Test
	@Tag("delete")
	void deleteNullContact() {
		Assertions.assertThrows(NullPointerException.class, () -> {contactServ.deleteContact("911");
		});
	}
	
	@Test
	@Tag("add")
	void addNewContactWithoutContact() {
		contactServ.addContact("Jacob", "Black", "4042345678", "123 Ephraim Lane");
		assertTrue(contactServ.contacts.get(contactServ.contacts.size() - 1).getFirstName().equals("Jacob"));
		assertTrue(contactServ.contacts.get(contactServ.contacts.size() - 1).getLastName().equals("Black"));
		assertTrue(contactServ.contacts.get(contactServ.contacts.size() - 1).getPhone().equals("4042345678"));
		assertTrue(contactServ.contacts.get(contactServ.contacts.size() - 1).getAddress().equals("123 Ephraim Lane"));
		assertNotNull(contactServ.contacts.get(contactServ.contacts.size() - 1).getID());
	}
	
	@Test
	@Tag("update")
	void updateFirstNameTest() {
		contactServ.addContact(new Contact("56765", "Maribel", "Madrigal", "7701234567", "567 Encanto Rd"));
		contactServ.updateFirstName("56765", "Luisa");
		assertTrue(contactServ.contacts.get(contactServ.contacts.size() - 1).getFirstName().equals("Luisa"));
	}
	
	@Test
	@Tag("update")
	void updateLastNameTest() {
		contactServ.addContact(new Contact("56777", "Isabella", "Madrigal", "4047654321", "0908 Encanto Twilight Ln"));
		contactServ.updateLastName("56777", "Swan");
		assertTrue(contactServ.contacts.get(contactServ.contacts.size() - 1).getLastName().equals("Swan"));
	}
	
	@Test
	@Tag("update")
	void updatNumberTest() {
		contactServ.addContact(new Contact("24532", "Hermione", "Granger", "7700987654", "876 Bookworm Rd"));
		contactServ.updateNumber("24532", "7709873456");
		assertTrue(contactServ.contacts.get(contactServ.contacts.size() - 1).getPhone().equals("7709873456"));
	}
	
	@Test
	@Tag("update")
	void updateAddress() {
		contactServ.addContact(new Contact("3456765", "Caitlyn", "Kiramman", "4046547890", "1234 Arcane Piltover Lane"));
		contactServ.updateAddress("3456765", "4321 Arcane Undercity Lanes");
		assertTrue(contactServ.contacts.get(contactServ.contacts.size() - 1).getAddress().equals("4321 Arcane Undercity Lanes"));
	}
	
	@RepeatedTest(40)
	@Tag("add")
	void multipleIDs() {
		for (Integer i = 0; i < 100000; i++) {
			String ID = Integer.toString(i);
			contactServ.addContact(new Contact(ID, "Edward", "Cullen", "1234567891", "1234 Forks Rd"));
		}
	contactServ.addContact("Madeye", "Moody", "8907894567", "2345 Hogwarts Castle");
	assertSame(contactServ.findContact("15"), contactServ.findContact("15")); // Tests the findContact method to 100%
	}
}
