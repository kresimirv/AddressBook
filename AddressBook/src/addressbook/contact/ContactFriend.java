package addressbook.contact;

/*
 * ContactFriend
 * 
 */
public final class ContactFriend extends Contact {

	private String friendshipYears = "0";
	
	public ContactFriend() {
		super.setCategory("friends");
	}

	public String getFriendshipYears() {
		return friendshipYears;
	}

	public void setFriendshipYears(String friendshipYears) {
		this.friendshipYears = friendshipYears;
	}
	
	@Override
    public String toString() {
		StringBuilder sb = new StringBuilder("");
		sb.append(super.toString());
		if(friendshipYears != null && !friendshipYears.isEmpty()) {
			sb.append("Friendship Years: " + (friendshipYears != null ? friendshipYears : "") + "\n");
		}
		return sb.toString();
	}
	
	public String toCSV() {
		return super.toCSV() +  ";" + (friendshipYears != null ? friendshipYears : "");
	}
	
}
