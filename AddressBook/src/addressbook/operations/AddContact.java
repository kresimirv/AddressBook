package addressbook.operations;

import addressbook.AddressBookManager;
import addressbook.contact.Contact;
import addressbook.contact.ContactFactory;
import addressbook.util.ArgumentsParser;

public final class AddContact implements AddressBookOperation {

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
	
	public AddContact(ArgumentsParser argsParser) {
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
		
		Contact c = null;
		switch(category) {
			case "family":
				c = ContactFactory.CreateFamilyContact(id, name, surname, telephone, email, age, hairColor, familyRelationship);
				break;
			case "friends":
				c = ContactFactory.CreateFriendContact(id, name, surname, telephone, email, age, hairColor, friendshipYears);
				break;
			case "acquaintance":
				c = ContactFactory.CreateAcquaintanceContact(id, name, surname, telephone, email, age, hairColor);
				break;
		}
		
		if(c != null) {
			addressBookManager.getAddressBook().add(c);
			System.out.println("Contact created.");
		}
		
	}
	
	private void Validate() {
		if(!(category != null && name != null && surname != null && telephone != null && email != null)) {
			System.err.println("Some mandatory fields are missing. Please check help (--help).");
			System.exit(1);
		}
	}

}
