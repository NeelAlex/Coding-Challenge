package exercise;

import java.util.ArrayList;
import java.util.List;


public class App {
	public static Users users;
	public static Purchases purchases;
	public static UserPurchases userPurchases;
	
	public static void main(String[] args) {
		App app = new App();
		List<List<String>> getUserData = CSVInputParser.readFile("users.csv");
		List<List<String>> getPurchaseData = CSVInputParser.readFile("purchases.csv");
		
		users = new Users(getUserRecords(getUserData));
		purchases = new Purchases(getPurchaseRecords(getPurchaseData));

//		* Input:
//		    * the name of the column to use for the join from the right table
//		    * the name of the column to use for the join from the left table
		userPurchases = new UserPurchases(innerJoin("USER_ID", "USER_ID"));
		
	}

	public static List<UserPurchase> innerJoin(String column1, String column2) {
		List<UserPurchase> userPurchases = new ArrayList<UserPurchase>();
		if (column1.compareTo(column2) != 0) {
			return userPurchases;
		}
		for (Purchase purchase : purchases.getPurchases()) {
			for (User user : users.getUsers()) {
				if (user.getUserId() == purchase.getUserId()) {
					UserPurchase userpurchase = new UserPurchase(user.getUserId(), 
							user.getName(), user.getEmail(),
							purchase.getAdId(),
							purchase.getTitle());
					userPurchases.add(userpurchase);
				}
			}
		}
		return userPurchases;
	}

	public static List<User> getUserRecords(List<List<String>> records) {
		List<User> users = new ArrayList<User>();
		records.remove(0);
		for (List<String> record : records) {
			User user = new User();
			user.setUserId(Integer.parseInt(record.get(0)));
			user.setName(record.get(1));
			user.setEmail(record.get(2));
			users.add(user);
		}
		return users;
	}

	public static List<Purchase> getPurchaseRecords(List<List<String>> records) {
		List<Purchase> purchases = new ArrayList<Purchase>();
		records.remove(0);
		for (List<String> record : records) {
			Purchase purchase = new Purchase();
			purchase.setAdId(Integer.parseInt(record.get(0)));
			purchase.setTitle(record.get(1));
			purchase.setUserId(Integer.parseInt(record.get(2)));
			purchases.add(purchase);
		}		
		return purchases;
	}
}
