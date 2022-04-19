/**
 * ContactTest Class
 * @author Jordan Davis
 * @version 1.0
 * @date 3/22/22
 */

package Test;

import static org.junit.Assert.assertTrue;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import Main.Contact;

public class ContactTest {

	@Test
	void testContact() {
		Contact contact = new Contact("12345", "John", "Smith", "7701234567", "123 Sesame Street");
		assertTrue(contact.getFirstName().equals("John"));
		assertTrue(contact.getLastName().equals("Smith"));
		assertTrue(contact.getPhone().equals("7701234567"));
		assertTrue(contact.getAddress().equals("123 Sesame Street"));
	}
	
	@Test
	@Tag("ID")
	void contactIDTooLong() {
		Assertions.assertThrows(IllegalArgumentException.class, () -> {
			new Contact("12345678912345", "John", "Smith", "7701234567", "123 Sesame Street");
		});
	}
	
	@Test
	@Tag("ID")
	void contactIDIsNull() {
		Assertions.assertThrows(IllegalArgumentException.class, () -> {
			new Contact(null, "John", "Smith", "7701234567", "123 Sesame Street");
		});
	}
	
	@Test
	@Tag("firstName")
	void contactFirstNameTooLong() {
		Assertions.assertThrows(IllegalArgumentException.class, () -> {
			new Contact("12345", "MrHowDoYouDo", "Smith", "7701234567", "123 Sesame Street");
		});
	}
	
	@Test
	@Tag("firstName")
	void contactFirstNameIsNull() {
		Assertions.assertThrows(IllegalArgumentException.class, () -> {
			new Contact("12345", null, "Smith", "7701234567", "123 Sesame Street");
		});
	}
	
	@Test
	@Tag("lastName")
	void contactLastNameTooLong() {
		Assertions.assertThrows(IllegalArgumentException.class, () -> {
			new Contact("12345", "John", "Smithertoonson", "7701234567", "123 Sesame Street");
		});
	}
	
	@Test
	@Tag("lastName")
	void contactLastNameIsNull() {
		Assertions.assertThrows(IllegalArgumentException.class, () -> {
			new Contact("12345", "John", null, "7701234567", "123 Sesame Street");
		});
	}
	
	@Test
	@Tag("phone")
	void contactPhoneTooLong() {
		Assertions.assertThrows(IllegalArgumentException.class, () -> {
			new Contact("12345", "John", "Smith", "77012345671", "123 Sesame Street");
		});
	}
	
	@Test
	@Tag("phone")
	void contactPhoneTooShort() {
		Assertions.assertThrows(IllegalArgumentException.class, () -> {
			new Contact("143", "Katniss", "Everdeen", "678098123", "District 12");
		});
	}
	
	@Test
	@Tag("phone")
	void contactPhoneIsNull() {
		Assertions.assertThrows(IllegalArgumentException.class, () -> {
			new Contact("12345", "John", "Smith", null, "123 Sesame Street");
		});
	}
	
	@Test
	@Tag("phone")
	void contactPhoneHasNonDigits() {
		Assertions.assertThrows(IllegalArgumentException.class, () -> {
			new Contact("12345", "John", "Smith", "77r-23/56g", "123 Sesame Street");
		});
	}
	
	@Test
	@Tag("address")
	void contactAddressTooLong() {
		Assertions.assertThrows(IllegalArgumentException.class, () -> {
			new Contact("12345", "John", "Smith", "7701234567", "123 Sesame Street on the Town down the Lane at the end of the Roundabout");
		});
	}
	
	@Test
	@Tag("address")
	void contactddressIsNull() {
		Assertions.assertThrows(IllegalArgumentException.class, () -> {
			new Contact("12345", "John", "Smith", "7701234567", null);
		});
	}
}
