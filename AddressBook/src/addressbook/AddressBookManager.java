package addressbook;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Optional;

import addressbook.contact.Contact;
import addressbook.contact.ContactAcquaintance;
import addressbook.contact.ContactFactory;
import addressbook.contact.ContactFamily;
import addressbook.contact.ContactFriend;

/**
 * AddressBookManager - class for managing address book operations
 *
 */
public final class AddressBookManager {
	
	private ArrayList<Contact> addressBook = new ArrayList<Contact>();

	public ArrayList<Contact> getAddressBook() {
		return addressBook;
	}

	public AddressBookManager() {
		// constructor
	}
	
	/**
	 * Get total number of contacts in address book
	 * @return Total number of contacts in address book
	 */
	public int TotalContacts() {
		return this.addressBook.size();
	}
	
	/***
	 * 
	 * Edit existing friend contact
	 * 
	 * @param id Contact ID
	 * @param name	Contact Name
	 * @param surname	Contact Surname
	 * @param telephone	Contact Telephone
	 * @param email	Contact e-mail address
	 * @param age	Contact age
	 * @param hairColor	Contact hair color
	 * @param friendshipYears	Contact friendship years
	 * @return True if contact is edited otherwise false
	 */
	public boolean EditFriendContact(String id, String name, String surname, String telephone, String email, String age, String hairColor, String friendshipYears) {
		ContactFriend contact = (ContactFriend)GetContact(id);
		if(contact != null) {
			if(name != null) contact.setName(name);
			if(surname != null)contact.setSurname(surname);
			if(telephone != null) contact.setTelephone(telephone);
			if(email != null) contact.setEmail(email);
			if(age != null) contact.setAge(age);
			if(hairColor != null) contact.setHairColor(hairColor);
			if(friendshipYears != null) contact.setFriendshipYears(friendshipYears);
			
			DeleteContact(id);
			this.getAddressBook().add(contact);
			return true;
		}
		return false;
	}
	
	/***
	 * 
	 * Edit existing family contact
	 * 
	 * @param id Contact ID
	 * @param name	Contact Name
	 * @param surname	Contact Surname
	 * @param telephone	Contact Telephone
	 * @param email	Contact e-mail address
	 * @param age	Contact age
	 * @param hairColor	Contact hair color
	 * @param familyRelationship Contact family relationship
	 * @return True if contact is edited otherwise false
	 */
	public boolean EditFamilyContact(String id, String name, String surname, String telephone, String email, String age, String hairColor, String familyRelationship) {
		ContactFamily contact = (ContactFamily)GetContact(id);
		if(contact != null) {
			if(name != null) contact.setName(name);
			if(surname != null)contact.setSurname(surname);
			if(telephone != null) contact.setTelephone(telephone);
			if(email != null) contact.setEmail(email);
			if(age != null) contact.setAge(age);
			if(hairColor != null) contact.setHairColor(hairColor);
			if(familyRelationship != null) contact.setFamilyRelationship(familyRelationship);
			
			DeleteContact(id);
			this.getAddressBook().add(contact);
			return true;
		}
		return false;
	}
	
	/***
	 * 
	 * Edit existing acquaintance contact
	 * 
	 * @param id Contact ID
	 * @param name	Contact Name
	 * @param surname	Contact Surname
	 * @param telephone	Contact Telephone
	 * @param email	Contact e-mail address
	 * @param age	Contact age
	 * @param hairColor	Contact hair color
	 * @return True if contact is edited otherwise false
	 */
	public boolean EditAcquaintanceContact(String id, String name, String surname, String telephone, String email, String age, String hairColor) {
		ContactAcquaintance contact = (ContactAcquaintance)GetContact(id);
		if(contact != null) {
			if(name != null) contact.setName(name);
			if(surname != null)contact.setSurname(surname);
			if(telephone != null) contact.setTelephone(telephone);
			if(email != null) contact.setEmail(email);
			if(age != null) contact.setAge(age);
			if(hairColor != null) contact.setHairColor(hairColor);
			
			DeleteContact(id);
			this.getAddressBook().add(contact);
			return true;
		}
		return false;
	}
	
	/***
	 * Get Contact by ID
	 * @param id Contact ID
	 * @return Contact object if found otherwise null
	 */
	public Contact GetContact(String id) {
		Optional<Contact> contact = this.getAddressBook().stream().filter(c -> c.getId().equals(id)).findAny();
		if (contact != null && contact.isPresent()) {
			return contact.get();
		}
		
		return null;
	}
	
	/**
	 * Delete Contact by ID
	 * @param id Contact ID
	 */
	public boolean DeleteContact(String id) {
		Optional<Contact> contact = this.getAddressBook().stream().filter(c -> c.getId().equals(id)).findAny();
		if (contact != null && contact.isPresent()) {
			this.getAddressBook().remove(contact.get());
			return true;
		}
		return false;
	}
	
	/**
	 * Save address book to file
	 * 
	 * @param fileName File name
	 */
	public void SaveAddressBook(String fileName) {
		try {
			
			// sort address book by surname
			this.addressBook.sort((o1, o2)
                     -> o1.getSurname().compareTo(
                         o2.getSurname()));
			
			File file = new File(fileName);
			// check if file exists, delete it
	        if (file.exists()) {
	        	 file.delete();
	        }
	        // create new file
	        file.createNewFile();
	        
	        // write to file
	        FileWriter fw = new FileWriter(file);
	        for(Contact c : this.addressBook) {
	        	fw.write(c.toCSV() + "\n");
	        }
	        fw.flush();
	        fw.close();
        
		} catch (IOException e) { }  
	}
	
	/**
	 * Read address book from file
	 * 
	 * @param fileName File Name
	 */
	public void ReadAddressBook(String fileName) {
		try {
			BufferedReader br = new BufferedReader(new FileReader(fileName));
			String line = "";
			while ((line = br.readLine()) != null) 
	        {
	            String[] dataArray = line.split(";", -1);
	            
	            if(dataArray.length > 0 )
	            {
	            	
	            	String id = dataArray[0];
	            	String category = dataArray[1];
	            	String name = dataArray[2];
	            	String surname = dataArray[3];
	            	String telephone = dataArray[4];
	            	String email = dataArray[5];
	            	String age = dataArray[6];
	            	String hairColor = dataArray[7];
	            	String familyRelationship = null;
	            	String friendshipYears = null;
	            	
	            	switch(category) {
	            	case "friends":
	            		friendshipYears = dataArray[8];
	            		this.addressBook.add(ContactFactory.CreateFriendContact(id, name, surname, telephone, email, age, hairColor, friendshipYears));
	            		break;
	            	case "family":
	            		familyRelationship = dataArray[8];
	            		this.addressBook.add(ContactFactory.CreateFamilyContact(id, name, surname, telephone, email, age, hairColor, familyRelationship));
	            		break;
	            	case "acquaintance":
	            		this.addressBook.add(ContactFactory.CreateAcquaintanceContact(id, name, surname, telephone, email, age, hairColor));
	            		break;
	            	}
	            	
	            }
	        }
			br.close();
		} catch (IOException e) { }  
	}
	
}
