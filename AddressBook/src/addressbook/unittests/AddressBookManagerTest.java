package addressbook.unittests;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import addressbook.AddressBookManager;
import addressbook.contact.Contact;
import addressbook.contact.ContactFriend;

public final class AddressBookManagerTest {

	private AddressBookManager addressBookManager = new AddressBookManager();
	
	public AddressBookManagerTest() {
		// constructor
	}

    @Before  
    public void setUp() throws Exception { 
        ContactFriend c1 = new ContactFriend();
        c1.setId("1");
        c1.setCategory("friends");
        c1.setName("First");
        c1.setSurname("FirstSurname");
        c1.setTelephone("111111");
        c1.setEmail("first@gmail.com");
        
        ContactFriend c2 = new ContactFriend();
        c2.setId("2");
        c2.setCategory("friends");
        c2.setName("Second");
        c2.setSurname("SecondSurname");
        c2.setTelephone("222222");
        c2.setEmail("second@gmail.com");
        
        ContactFriend c3 = new ContactFriend();
        c3.setId("3");
        c3.setCategory("friends");
        c3.setName("Third");
        c3.setSurname("ThirdSurname");
        c3.setTelephone("333333");
        c3.setEmail("third@gmail.com");
        
        this.addressBookManager.getAddressBook().add(c1);
        this.addressBookManager.getAddressBook().add(c2);
        this.addressBookManager.getAddressBook().add(c3);
    }  
    
    @After  
    public void cleanUp() throws Exception {  
    	this.addressBookManager.getAddressBook().clear();
    }  

	@Test  
	public void TotalContactsTest() {
		assertEquals(this.addressBookManager.TotalContacts(), 3);
	}
	
	@Test  
	public void GetContactTest() {
		Contact c = this.addressBookManager.GetContact("1");
		assertNotNull(c);
		assertEquals(c.getId(), "1");
	}
	
	@Test  
	public void GetContactUnknownReturnsNullTest() {
		Contact c = this.addressBookManager.GetContact("5");
		assertNull(c);
	}
	
	@Test  
	public void DeleteContactTest() {
		this.addressBookManager.DeleteContact("1");
		assertEquals(this.addressBookManager.TotalContacts(), 2);
	}
	
	@Test  
	public void DeleteContactUnknownReturnsFalseTest() {
		boolean result = this.addressBookManager.DeleteContact("5");
		assertEquals(result, false);
	}
	
}
