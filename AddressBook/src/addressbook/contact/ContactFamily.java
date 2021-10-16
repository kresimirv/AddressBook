package addressbook.contact;

/**
 * ContactFamily
 *
 */
public final class ContactFamily extends Contact {
	
	private String familyRelationship;
	
	public ContactFamily() {
		super.setCategory("family");
	}

	public String getFamilyRelationship() {
		return familyRelationship;
	}

	public void setFamilyRelationship(String familyRelationship) {
		this.familyRelationship = familyRelationship;
	}
	
	@Override
    public String toString() {
		StringBuilder sb = new StringBuilder("");
		sb.append(super.toString());
		if(familyRelationship != null && !familyRelationship.isEmpty()) {
			sb.append("Family Relationship: " + (familyRelationship != null ? familyRelationship : "") + "\n");
		}
		return sb.toString();
	}
	
	public String toCSV() {
		return super.toCSV() + ";" + (familyRelationship != null ? familyRelationship : "");
	}

}
