package exercise;

import java.util.List;

public class UserPurchases extends Table{
	private List<UserPurchase> userPurchases;
	
	
	public UserPurchases(List<UserPurchase> userPurchases) {
		super();
		this.userPurchases = userPurchases;
	}

	public UserPurchases() {
		super();
	}

	public List<UserPurchase> getUserPurchases() {
		return userPurchases;
	}
	
	public void setUserPurchases(List<UserPurchase> userPurchases) {
		this.userPurchases = userPurchases;
	}

	@Override
	public void sort(String columnName) {
		// TODO Auto-generated method stub
		
	}

}
