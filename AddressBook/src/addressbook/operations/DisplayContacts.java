package addressbook.operations;

import addressbook.AddressBookManager;
import addressbook.contact.Contact;

/**
 * DisplayContacts - class for handling contact display
 *
 */
public final class DisplayContacts implements AddressBookOperation {

	public DisplayContacts() {
		// constructor
	}

	@Override
	public void Execute(AddressBookManager addressBookManager) {
		System.out.println("");
		System.out.println("Address Book");
		System.out.println("------------");
		System.out.println("");
		
		if(addressBookManager.TotalContacts() == 0) {
			System.out.println("No contacts found.");
		}
		
		// output contacts
		for(Contact c : addressBookManager.getAddressBook()) {
			System.out.println(c.toString());
		}
	}

}
