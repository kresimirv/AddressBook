package addressbook.operations;

import addressbook.AddressBookManager;
import addressbook.contact.Contact;
import addressbook.util.ArgumentsParser;

/**
 * EditContact - class for handling contact editing
 *
 */
public final class EditContact implements AddressBookOperation {

	private String id;
	private String category;
	private String name;
	private String surname;
	private String telephone;
	private String email;
	private String age;
	private String hairColor;
	private String familyRelationship;
	private String friendshipYears;
	
	public EditContact(ArgumentsParser argsParser) {
		this.category = argsParser.ValueForKey("--category");
		this.id = argsParser.ValueForKey("--id");
		this.name = argsParser.ValueForKey("--name");
		this.surname = argsParser.ValueForKey("--surname");
		this.telephone = argsParser.ValueForKey("--telephone");
		this.email = argsParser.ValueForKey("--email");
		this.age = argsParser.ValueForKey("--age");
		this.hairColor = argsParser.ValueForKey("--hair-color");
		this.familyRelationship = argsParser.ValueForKey("--family-relationship");
		this.friendshipYears = argsParser.ValueForKey("--friendship-years");
		
		this.Validate();
	}

	@Override
	public void Execute(AddressBookManager addressBookManager) {
		Contact c = addressBookManager.GetContact(id);
		boolean editSuccess = false;
		if(c != null) {
			switch(c.getCategory()) {
				case "family":
					editSuccess = addressBookManager.EditFamilyContact(id, name, surname, telephone, email, age, hairColor, familyRelationship);
					break;
				case "friends":
					editSuccess = addressBookManager.EditFriendContact(id, name, surname, telephone, email, age, hairColor, friendshipYears);
					break;
				case "acquaintance":
					editSuccess = addressBookManager.EditAcquaintanceContact(id, name, surname, telephone, email, age, hairColor);
					break;
			}
		}
		
		if(editSuccess) {
			System.out.println("Contact edited.");
		}
	}
	
	private void Validate() {
		if(id == null) {
			System.err.println("Some mandatory fields are missing. Please check help (--help).");
			System.exit(1);
		}
		
		if(id != null & category != null) {
			System.err.println("Changing contact category is not supported.");
			System.exit(1);
		}
	}

}
