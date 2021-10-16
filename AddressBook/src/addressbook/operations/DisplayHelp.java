package addressbook.operations;

import addressbook.AddressBookManager;

/**
 * DisplayHelp - class for handling help
 *
 */
public final class DisplayHelp implements AddressBookOperation {

	public DisplayHelp() {
		// constructor
	}

	/**
	 * Output help information to console
	 */
	@Override
	public void Execute(AddressBookManager addressBookManager) {
		StringBuilder sb = new StringBuilder("\n");
		sb.append("Address Book\n");
		sb.append("------------\n");
		sb.append("Command line contact manager. Allows you to display, create, edit and remove address book contacts.\n\n");

		sb.append("\nUSAGE\n");
		sb.append(String.format("\t%-20s\t%-20s\n", "--help", "Show help"));
		sb.append(String.format("\t%-20s\t%-20s\n", "--display", "Display all contacts"));
		sb.append(String.format("\t%-20s\t%-20s\n", "--add", "Add new contact"));
		sb.append(String.format("\t%-20s\t%-20s\n", "--edit", "Edit existing contact"));
		sb.append(String.format("\t%-20s\t%-20s\n", "--remove", "Remove existing contact"));
		
		sb.append("\nFIELDS\n");
		sb.append(String.format("\t%-20s\t%-20s\n", "--id", "Contact ID (mandatory when editing exising contact)"));
		sb.append(String.format("\t%-20s\t%-20s\n", "--category", "Contact category - family, friends, acquaintance (mandatory when creating new contact)"));
		sb.append(String.format("\t%-20s\t%-20s\n", "--name", "Name (mandatory)"));
		sb.append(String.format("\t%-20s\t%-20s\n", "--surname", "Surname (mandatory)"));
		sb.append(String.format("\t%-20s\t%-20s\n", "--telephone", "Telephone number (mandatory)"));
		sb.append(String.format("\t%-20s\t%-20s\n", "--email", "Email (mandatory)"));
		sb.append(String.format("\t%-20s\t%-20s\n", "--age", "Age"));
		sb.append(String.format("\t%-20s\t%-20s\n", "--hair-color", "Hair color"));
		sb.append(String.format("\t%-20s\t%-20s\n", "--family-relationship", "Family relationship - parent, granparent, son, etc. (only for category - family)"));
		sb.append(String.format("\t%-20s\t%-20s\n", "--friendship-years", " Years of friendship (only for category - friends)"));

		sb.append("\nADDING CONTACT\n");
		sb.append("\tjava -jar AddressBook.jar --add <fields>\n\n");
		sb.append("\tExample:\n");
		sb.append("\tjava -jar AddressBook.jar --add --name Winnie --surname Pooh --telephone 123456789 --email winnie.pooh@gmail.com\n");
		
		sb.append("\nEDITING EXISTING CONTACT\n");
		sb.append("\tjava -jar AddressBook.jar --edit --id <contact_id> <fields>\n\n");
		sb.append("\tExample:\n");
		sb.append("\tjava -jar AddressBook.jar --edit --id 12345 --telephone 543212345\n");
		
		sb.append("\nREMOVING EXISTING CONTACT\n");
		sb.append("\tjava -jar AddressBook.jar --remove --id <contact_id>\n\n");
		sb.append("\tExample:\n");
		sb.append("\tjava -jar AddressBook.jar --remove --id 12345\n");
		
		System.out.println(sb.toString());
	}

}
