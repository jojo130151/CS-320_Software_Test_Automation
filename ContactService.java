/**
 * ContactService Class
 * @author Jordan Davis
 * @version 1.0
 * @date 3/22/22
 */

package Main;

import java.util.ArrayList;
import java.util.Random;

public class ContactService {

	// Create ArrayLists to store created Contacts and IDs that are currently in use
	public ArrayList<Contact> contacts = new ArrayList<Contact>();
	ArrayList<Integer> randomIDs = new ArrayList<Integer>();
	
	/**
	 * Add an already made contact information to ArrayLists
	 *
	 * @param	Contact object that already has an ID, first name, last name, phone number, and address.
	 */
	public void addContact(Contact contact) {
		contacts.add(contact);
		randomIDs.add(Integer.decode(contact.getID()));
	}
	
	/**
	 * Add a new contact with a generated unique ID and provided name, phone number, and address.
	 *
	 * @param	firstName  The first name of contact
	 * @param	lastName   The last name of contact
	 * @param	phone      Phone number of contact
	 * @param	address    The address of the contact
	 */
	public void addContact(String firstName, String lastName, String phone, String address) {
		Random rand = new Random();
		int randomID = rand.nextInt(1000000000);
		
		while (randomID > 1000000000 || randomID < 0 || randomIDs.contains(randomID)) {
			randomID = rand.nextInt(1000000000);
		}
		
		randomIDs.add(randomID);
		String contactID = String.valueOf(randomID);
		
		contacts.add(new Contact(contactID, firstName, lastName, phone, address));
	}
	
	/**
	 * Delete a contact, given the information of what ID is associated with the contact, from ArrayList and system
	 *
	 * @param	contactID  The contactID of a given Contact object
	 */
	public void deleteContact(String contactID) {
		Contact contact = findContact(contactID);
		if (contact == null) {
			throw new NullPointerException("Contact ID is invalid, Does Not Exist");
		}
		randomIDs.remove(Integer.decode(contact.getID()));
		contacts.remove(contact);
		
		if (findContact(contactID) != null) {
			throw new NullPointerException("Did Not Delete");
		}
	}
	
	/**
	 * Update and change the first name of a given contact, which is found by given contactID
	 *
	 * @param	contactID   The contact ID for contact that needs name changed
	 * @param	firstName   The new desired first name of contact
	 */
	public void updateFirstName(String contactID, String firstName) {
		Contact contact = findContact(contactID);
		contacts.set(contacts.indexOf(contact), contact.setFirstName(firstName));
	}
	
	/**
	 * Update and change the last name of a given contact, which is found by given contactID
	 *
	 * @param	contactID   The contact ID for contact that needs name changed
	 * @param	lastName   The new desired last name of contact
	 */
	public void updateLastName(String contactID, String lastName) {
		Contact contact = findContact(contactID);
		contacts.set(contacts.indexOf(contact), contact.setLastName(lastName));
	}
	
	/**
	 * Update and change the phone number of a given contact, which is found by given contactID
	 *
	 * @param	contactID   The contact ID for contact that needs phone number changed
	 * @param	phone       The new desired phone number of contact
	 */
	public void updateNumber(String contactID, String phone) {
		Contact contact = findContact(contactID);
		contacts.set(contacts.indexOf(contact), contact.setPhoneNumber(phone));
	}
	
	/**
	 * Update and change the address of a given contact, which is found by given contactID
	 *
	 * @param	contactID   The contact ID for contact that needs address changed
	 * @param	address     The new desired address for contact
	 */
	public void updateAddress(String contactID, String address) {
		Contact contact = findContact(contactID);
		contacts.set(contacts.indexOf(contact), contact.setAddress(address));
	}
	
	/**
	 * Looks for the specific contact with the contactID given in the parameter
	 *
	 * @param	contactID   The contact ID for contact that system is looking for
	 * @return              The contact that the system was looking for based on ID
	 * @return              The value of null if list is empty or there is no matching value
	 */
	public Contact findContact(String contactID) {
		if (contacts.isEmpty() == false);{
			for (int i = 0; i < contacts.size(); i++) {
				if (contacts.get(i).getID() == contactID) {
					return contacts.get(i);
				}
			}
		}
		return null;
	}
}
