package addressbook.operations;

import addressbook.util.ArgumentsParser;

/**
 * AddressBookOperationFactory - factory method for handling address book operations
 *
 */
public final class AddressBookOperationFactory {

	public AddressBookOperationFactory() {
		// constructor
	}
	
	/**
	 * 
	 * @param argsParser ArgumentsParser object
	 * @return Operation object
	 */
	public static AddressBookOperation GetOperation(ArgumentsParser argsParser) {
		boolean operationHelp = argsParser.KeyExists("--help");
		boolean operationDisplay = argsParser.KeyExists("--display"); 
		boolean operationAdd = argsParser.KeyExists("--add");
		boolean operationEdit = argsParser.KeyExists("--edit");
		boolean operationRemove = argsParser.KeyExists("--remove");
		
		// input validation
		int totalOperations = (operationHelp ? 1 : 0) + (operationDisplay ? 1 : 0) + 
				(operationAdd ? 1 : 0) + (operationEdit ? 1 : 0) + (operationRemove ? 1 : 0);
		
		if(totalOperations >= 2) {
			System.err.println("Only one operation is allowed at time. Please check help (--help).");
			System.exit(1);
		}
		
		// determine right operation
		try {
			if(operationHelp) {
				return new DisplayHelp();
			} else if (operationDisplay) {
				return new DisplayContacts();
			} else if (operationAdd) {
				return new AddContact(argsParser);
			} else if (operationEdit) {
				return new EditContact(argsParser);
			} else if (operationRemove) {
				return new RemoveContact(argsParser);
			} else {
				return new DisplayHelp();
			}
		} catch (Exception e) {
			return new DisplayHelp();
		}
		
	}

}
