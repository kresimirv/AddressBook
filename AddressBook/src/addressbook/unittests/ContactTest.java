package addressbook.unittests;

import static org.junit.Assert.*;

import org.junit.Test;

import addressbook.contact.ContactAcquaintance;
import addressbook.contact.ContactFactory;
import addressbook.contact.ContactFamily;
import addressbook.contact.ContactFriend;

public final class ContactTest {
	
	public ContactTest() {
		// constructor
	}
	
    @Test  
    public void testCreateFriendContact(){
    	String id = null;
    	String name = "FirstName";
    	String surname = "Surname";
    	String telephone = "12345";
    	String email = "test@gmail.com";
    	String age = "20";
    	String hairColor = "black";
    	String friendshipYears = "5";
    	
    	ContactFriend c = (ContactFriend)ContactFactory.CreateFriendContact(id, name, surname, telephone, email, age, hairColor, friendshipYears);
    	assertNotNull(c);
        assertNotNull(c.getId());
        assertEquals(c.getName(), name);
        assertEquals(c.getSurname(), surname);
        assertEquals(c.getTelephone(), telephone);
        assertEquals(c.getEmail(), email);
        assertEquals(c.getAge(), age);
        assertEquals(c.getHairColor(), hairColor);
        assertEquals(c.getFriendshipYears(), friendshipYears); 
    }  
    
    @Test  
    public void testCreateFriendContactWithId(){
    	String id = "1";
    	String name = "FirstName";
    	String surname = "Surname";
    	String telephone = "12345";
    	String email = "test@gmail.com";
    	String age = "20";
    	String hairColor = "black";
    	String friendshipYears = "5";
    	
    	ContactFriend c = (ContactFriend)ContactFactory.CreateFriendContact(id, name, surname, telephone, email, age, hairColor, friendshipYears);
    	assertNotNull(c);
    	assertEquals(c.getId(), id);
        assertEquals(c.getName(), name);
        assertEquals(c.getSurname(), surname);
        assertEquals(c.getTelephone(), telephone);
        assertEquals(c.getEmail(), email);
        assertEquals(c.getAge(), age);
        assertEquals(c.getHairColor(), hairColor);
        assertEquals(c.getFriendshipYears(), friendshipYears); 
    } 
    
    @Test  
    public void testCreateFamilyContact(){
    	String id = null;
    	String name = "FirstName";
    	String surname = "Surname";
    	String telephone = "12345";
    	String email = "test@gmail.com";
    	String age = "20";
    	String hairColor = "black";
    	String familyRelationship = "father";
    	
    	ContactFamily c = (ContactFamily)ContactFactory.CreateFamilyContact(id, name, surname, telephone, email, age, hairColor, familyRelationship);
    	assertNotNull(c);
        assertNotNull(c.getId());
        assertEquals(c.getName(), name);
        assertEquals(c.getSurname(), surname);
        assertEquals(c.getTelephone(), telephone);
        assertEquals(c.getEmail(), email);
        assertEquals(c.getAge(), age);
        assertEquals(c.getHairColor(), hairColor);
        assertEquals(c.getFamilyRelationship(), familyRelationship); 
    } 
    
    @Test  
    public void testCreateFamilyContactWithId(){
    	String id = "1";
    	String name = "FirstName";
    	String surname = "Surname";
    	String telephone = "12345";
    	String email = "test@gmail.com";
    	String age = "20";
    	String hairColor = "black";
    	String familyRelationship = "father";
    	
    	ContactFamily c = (ContactFamily)ContactFactory.CreateFamilyContact(id, name, surname, telephone, email, age, hairColor, familyRelationship);
    	assertNotNull(c);
    	assertEquals(c.getId(), id);
        assertEquals(c.getName(), name);
        assertEquals(c.getSurname(), surname);
        assertEquals(c.getTelephone(), telephone);
        assertEquals(c.getEmail(), email);
        assertEquals(c.getAge(), age);
        assertEquals(c.getHairColor(), hairColor);
        assertEquals(c.getFamilyRelationship(), familyRelationship); 
    } 
    
    @Test  
    public void testCreateAcquaintanceContact(){
    	String id = null;
    	String name = "FirstName";
    	String surname = "Surname";
    	String telephone = "12345";
    	String email = "test@gmail.com";
    	String age = "20";
    	String hairColor = "black";
    	
    	ContactAcquaintance c = (ContactAcquaintance)ContactFactory.CreateAcquaintanceContact(id, name, surname, telephone, email, age, hairColor);
    	assertNotNull(c);
        assertNotNull(c.getId());
        assertEquals(c.getName(), name);
        assertEquals(c.getSurname(), surname);
        assertEquals(c.getTelephone(), telephone);
        assertEquals(c.getEmail(), email);
        assertEquals(c.getAge(), age);
        assertEquals(c.getHairColor(), hairColor);
    } 
    
    @Test  
    public void testCreateAcquaintanceContactWithId(){
    	String id = "1";
    	String name = "FirstName";
    	String surname = "Surname";
    	String telephone = "12345";
    	String email = "test@gmail.com";
    	String age = "20";
    	String hairColor = "black";
    	
    	ContactAcquaintance c = (ContactAcquaintance)ContactFactory.CreateAcquaintanceContact(id, name, surname, telephone, email, age, hairColor);
    	assertNotNull(c);
    	assertEquals(c.getId(), id);
        assertEquals(c.getName(), name);
        assertEquals(c.getSurname(), surname);
        assertEquals(c.getTelephone(), telephone);
        assertEquals(c.getEmail(), email);
        assertEquals(c.getAge(), age);
        assertEquals(c.getHairColor(), hairColor);
    } 

}
