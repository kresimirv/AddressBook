package addressbook.contact;
import java.util.UUID;

/**
 * Contact - abstract class used as base class for other Contact classes
 *
 */
public abstract class Contact {
	private String id;
	private String category;
	private String name;
	private String surname;
	private String telephone;
	private String email;
	
	private String age;
	private String hairColor;
	
	public Contact() {
		UUID uuid = UUID.randomUUID();
		this.id = uuid.toString();
	}
	
	public String getId() {
		return id;
	}
	
	public void setId(String id) {
		this.id = id;
	}

	public String getCategory() {
		return category;
	}

	public void setCategory(String category) {
		this.category = category;
	}
	
	public String getName() {
		return name;
	}
	
	public void setName(String name) {
		this.name = name;
	}
	
	public String getSurname() {
		return surname;
	}
	
	public void setSurname(String surname) {
		this.surname = surname;
	}
	
	public String getTelephone() {
		return telephone;
	}
	
	public void setTelephone(String telephone) {
		this.telephone = telephone;
	}
	
	public String getEmail() {
		return email;
	}
	
	public void setEmail(String email) {
		this.email = email;
	}

	public String getAge() {
		return age;
	}

	public void setAge(String age) {
		this.age = age;
	}

	public String getHairColor() {
		return hairColor;
	}

	public void setHairColor(String hairColor) {
		this.hairColor = hairColor;
	}
	
	@Override
    public String toString() {
		StringBuilder sb = new StringBuilder("");
		sb.append("ID: " + id + "\n");
		sb.append("Category: " + category + "\n");
		sb.append("Name: " + name + "\n");
		sb.append("Surname: " + surname + "\n");
		sb.append("Telephone: " + telephone + "\n");
		sb.append("Email: " + email + "\n");
		if(age != null && !age.isEmpty()) {
			sb.append("Age: " + (age != null ? age : "") + "\n");
		}
		if(hairColor != null && !hairColor.isEmpty()) {
			sb.append("Hair color: " + (hairColor != null ? hairColor : "") + "\n");
		}
		
		return sb.toString();
	}
	
	public String toCSV() {
		return id + ";" + category + ";" + name + ";"  + surname + ";" + telephone + ";" + email + ";" + (age != null ? age : "") + ";" + (hairColor != null ? hairColor : "");
	}
}
