package exercise;

import java.util.Collections;
import java.util.List;

public class Users extends Table {
	private List<User> users;
	
	public Users(List<User> users) {
		this.users = users;
	}

	public Users() {
		super();
	}

	public List<User> getUsers() {
		return users;
	}

	public void setUsers(List<User> users) {
		this.users = users;
	}

	@Override
	public void sort(String columnName) {
		switch(columnName) {
			case "NAME" :
				Collections.sort(this.users, (u1, u2) -> u2.getName().compareTo(u1.getName()));
				break;
			case"EMAIL" :
				Collections.sort(this.users, (u1, u2) -> u2.getEmail().compareTo(u1.getEmail()));
				break;
			default:
				Collections.sort(this.users, (u1, u2) -> u2.getUserId()-u1.getUserId());
		}
		for (User user : this.users) {
			System.out.println(user.toString());
		}
	}

	@Override
	public String toString() {
		return "Users [users=" + users + "]";
	}

}
