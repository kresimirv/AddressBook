package addressbook.unittests;

import static org.junit.Assert.*;

import org.junit.Test;

import addressbook.operations.AddContact;
import addressbook.operations.AddressBookOperation;
import addressbook.operations.AddressBookOperationFactory;
import addressbook.operations.DisplayContacts;
import addressbook.operations.DisplayHelp;
import addressbook.operations.EditContact;
import addressbook.operations.RemoveContact;
import addressbook.util.ArgumentsParser;

public final class AddressBookOperationTest {

	public AddressBookOperationTest() {
		// constructor
	}
	
	@Test  
	public void GetOperationDisplayHelpTest() {
		String args[] = { "--help" };
		ArgumentsParser argsParser = new ArgumentsParser(args);
		AddressBookOperation op = AddressBookOperationFactory.GetOperation(argsParser);
		
		assertEquals(op.getClass(), DisplayHelp.class);
	}
	
	@Test  
	public void GetOperationDisplayContactsTest() {
		String args[] = { "--display" };
		ArgumentsParser argsParser = new ArgumentsParser(args);
		AddressBookOperation op = AddressBookOperationFactory.GetOperation(argsParser);
		
		assertEquals(op.getClass(), DisplayContacts.class);
	}
	
	@Test  
	public void GetOperationAddContactTest() {
		String args[] = { "--add", "--category", "family", "--name", "John", "--surname", "Doe",
				"--telephone", "111111", "--email", "john.doe@gmail.com" };
		ArgumentsParser argsParser = new ArgumentsParser(args);
		AddressBookOperation op = AddressBookOperationFactory.GetOperation(argsParser);
		
		assertEquals(op.getClass(), AddContact.class);
	}
	
	@Test  
	public void GetOperationEditContactTest() {
		String args[] = { "--edit", "--id", "1", "--telephone", "123456" };
		ArgumentsParser argsParser = new ArgumentsParser(args);
		AddressBookOperation op = AddressBookOperationFactory.GetOperation(argsParser);
		
		assertEquals(op.getClass(), EditContact.class);
	}
	
	@Test  
	public void GetOperationRemoveContactTest() {
		String args[] = { "--remove", "--id", "1" };
		ArgumentsParser argsParser = new ArgumentsParser(args);
		AddressBookOperation op = AddressBookOperationFactory.GetOperation(argsParser);
		
		assertEquals(op.getClass(), RemoveContact.class);
	}
	
	@Test  
	public void GetOperationUnknownReturnsDisplayHelpTest() {
		String args[] = { "--unknown" };
		ArgumentsParser argsParser = new ArgumentsParser(args);
		AddressBookOperation op = AddressBookOperationFactory.GetOperation(argsParser);
		
		assertEquals(op.getClass(), DisplayHelp.class);
	}

}
