/**
 * Contact Class
 * @author Jordan Davis
 * @version 1.0
 * @date 3/22/22
 */

package Main;

public class Contact {

	final String contactID;
	String firstName;
	String lastName;
	String phone;
	String address;
	Contact Contact;
	
	/**
	 * Constructor for Contact object. Checks that the parameter variables are valid and then sets them.
	 * 
	 * @param	contactId   Unique ID assigned to the contact
	 * @param	firstName   The first name of the contact
	 * @param   lastName    The last name of the contact
	 * @param	phone       The phone number of the contact
	 * @param   address     The address of the contact
	 * 
	 * @return              A new instance of the Contact object
	 */
	public Contact(String contactID, String firstName, String lastName, String phone, String address) {
		
		if (firstName == null || firstName.length() > 10) {
			throw new IllegalArgumentException("Invalid First Name");
		}
		if (lastName == null || lastName.length() > 10) {
			throw new IllegalArgumentException("Invalid Last Name");
		}
		if (phone == null || phone.length() != 10 || !phone.matches("[0-9]+")) {
			throw new IllegalArgumentException("Invalid Phone Number");
		}
		if (address == null || address.length() > 30) {
			throw new IllegalArgumentException("Invalid Phone Number");
		}
		
		if (contactID == null || contactID.length() > 10 || contactID == "0") {
			throw new IllegalArgumentException("Invalid ID");
		}
		
		this.contactID = contactID;
		this.firstName = firstName;
		this.lastName = lastName;
		this.phone = phone;
		this.address = address;
	}
	
	/**
	 * Retrieves the ID for a Contact object
	 *
	 * @return  Return the contactID variable for the Contact object
	 */
	public String getID() {
		return this.contactID;
	}
	
	/**
	 * Retrieves the first name for a Contact object
	 *
	 * @return  Return the firstName variable for the Contact object
	 */
	public String getFirstName() {
		return this.firstName;
	}
	
	/**
	 * Retrieves the last name for a Contact object
	 *
	 * @return  Return the lastName variable for the Contact object
	 */
	public String getLastName() {
		return this.lastName;
	}
	
	/**
	 * Retrieves the phone number for a Contact object
	 *
	 * @return  Return the phone variable for the Contact object
	 */
	public String getPhone() {
		return this.phone;
	}
	
	/**
	 * Retrieves the address for a Contact object
	 *
	 * @return  Return the address variable for the Contact object
	 */
	public String getAddress() {
		return this.address;
	}
	
	/**
	 * Updates and changes the first name for a Contact object
	 *
	 * @return  the Contact variable with the change of the new first name
	 */
	public Contact setFirstName(String firstName) {
		this.firstName = firstName;
		return this;
	}
	
	/**
	 * Updates and changes the last name for a Contact object
	 *
	 * @return  the Contact variable with the change of the new last name
	 */
	public Contact setLastName(String lastName) {
		this.lastName = lastName;
		return this;
	}
	
	/**
	 * Updates and changes the phone number for a Contact object
	 *
	 * @return  the Contact variable with the change of the new phone number
	 */
	public Contact setPhoneNumber(String phone) {
		this.phone = phone;
		return this;
	}
	
	/**
	 * Updates and changes the address for a Contact object
	 *
	 * @return  the Contact variable with the change of the new address
	 */
	public Contact setAddress(String address) {
		this.address = address;
		return this;
	}
	
}
