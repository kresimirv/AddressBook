package addressbook;

import addressbook.operations.AddressBookOperation;
import addressbook.operations.AddressBookOperationFactory;
import addressbook.util.ArgumentsParser;

/**
 * Address Book - command line application for managing address book contacts
 * 
 * @author Kresimir Vekic
 * @version 1.0
 */
public class Main {

	private static AddressBookManager addressBookManager = new AddressBookManager();
	private static final String addressBookFileName = "addressbook.txt";
	
	public static void main(String[] args) {
		// read address book from file
		addressBookManager.ReadAddressBook(addressBookFileName);
	
		// parse input arguments and perform operation
		PerformOperation(args);
		
		// save address book to file
		addressBookManager.SaveAddressBook(addressBookFileName);
	}
	
	/**
	 * Parse application input parameters and perform operations
	 * @param args Application input parameters (String[])
	 */
	private static void PerformOperation(String[] args) {
		// parse input arguments
		ArgumentsParser argsParser = new ArgumentsParser(args);
	
		// get address book operation
		AddressBookOperation op = AddressBookOperationFactory.GetOperation(argsParser);
	
		// execute operation
		op.Execute(addressBookManager);
	}
	
}
