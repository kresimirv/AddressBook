package addressbook.operations;

import addressbook.AddressBookManager;
import addressbook.util.ArgumentsParser;

/**
 * RemoveContact - class for handling removal of contact
 *
 */
public final class RemoveContact implements AddressBookOperation {

	private String id;
	
	public RemoveContact(ArgumentsParser argsParser) {
		this.id = argsParser.ValueForKey("--id");
		
		this.Validate();
	}

	@Override
	public void Execute(AddressBookManager addressBookManager) {
		boolean deleteSuccess = addressBookManager.DeleteContact(id);
		if(deleteSuccess) {
			System.out.println("Contact deleted.");
		}
	}
	
	private void Validate() {
		if(id == null) {
			System.err.println("Some mandatory fields are missing. Please check help (--help).");
			System.exit(1);
		}
	}

}
