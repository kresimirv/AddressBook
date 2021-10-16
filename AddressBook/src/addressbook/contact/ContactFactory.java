package addressbook.contact;

/**
 * ContactFactory - Factory class for creating contacts
 *
 */
public final class ContactFactory {
	
	public ContactFactory() {
		// constructor
	}
	
	/**
	 * Create new friend contact
	 * 
	 * @param id Contact ID
	 * @param name	Contact Name
	 * @param surname	Contact Surname
	 * @param telephone	Contact Telephone
	 * @param email	Contact e-mail address
	 * @param age	Contact age
	 * @param hairColor	Contact hair color
	 * @param friendshipYears	Contact friendship years
	 * @return Contact object
	 */
	public static Contact CreateFriendContact(String id, String name, String surname, String telephone, String email, String age, String hairColor, String friendshipYears) {
		ContactFriend contact = new ContactFriend();
		if(id != null) {
			contact.setId(id);
		}
		contact.setName(name);
		contact.setSurname(surname);
		contact.setTelephone(telephone);
		contact.setEmail(email);
		contact.setAge(age);
		contact.setHairColor(hairColor);
		contact.setFriendshipYears(friendshipYears);
		return contact;
	}
	
	/**
	 * Create new family contact
	 * 
	 * @param id Contact ID
	 * @param name	Contact Name
	 * @param surname	Contact Surname
	 * @param telephone	Contact Telephone
	 * @param email	Contact e-mail address
	 * @param age	Contact age
	 * @param hairColor	Contact hair color
	 * @param familyRelationship Contact family relationship
	 * @return Contact object
	 */
	public static Contact CreateFamilyContact(String id, String name, String surname, String telephone, String email, String age, String hairColor, String familyRelationship) {
		ContactFamily contact = new ContactFamily();
		if(id != null) {
			contact.setId(id);
		}
		contact.setName(name);
		contact.setSurname(surname);
		contact.setTelephone(telephone);
		contact.setEmail(email);
		contact.setAge(age);
		contact.setHairColor(hairColor);
		contact.setFamilyRelationship(familyRelationship);
		return contact;
	}
	
	/***
	 * Create new acquaintance contact
	 * 
	 * @param id Contact ID
	 * @param name	Contact Name
	 * @param surname	Contact Surname
	 * @param telephone	Contact Telephone
	 * @param email	Contact e-mail address
	 * @param age	Contact age
	 * @param hairColor	Contact hair color
	 * @return Contact object
	 */
	public static Contact CreateAcquaintanceContact(String id, String name, String surname, String telephone, String email, String age, String hairColor) {
		ContactAcquaintance contact = new ContactAcquaintance();
		if(id != null) {
			contact.setId(id);
		}
		contact.setName(name);
		contact.setSurname(surname);
		contact.setTelephone(telephone);
		contact.setEmail(email);
		contact.setAge(age);
		contact.setHairColor(hairColor);
		return contact;
	}

}
