package exercise;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.List;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class AnyTest {
	private Users users;
	private Purchases purchases;
	private UserPurchases userPurchases;
	
	@BeforeEach
	void before() {
		users = new Users(App.getUserRecords(CSVInputParser.readFile("users.csv")));
		purchases = new Purchases(App.getPurchaseRecords(CSVInputParser.readFile("purchases.csv")));
	}
	
    @Test
    void testCSVInputParser() {
    	List<List<String>> getUserData = CSVInputParser.readFile("users.csv");
    	assertEquals(6, getUserData.size());    
    	getUserData = CSVInputParser.readFile("purchases.csv");
    	assertEquals(9, getUserData.size());    
    }
    
    @Test
    void testSortTables() {
    	users.sort("USER_ID");
    	assertEquals(5, users.getUsers().get(0).getUserId());
    	assertEquals("paul", users.getUsers().get(0).getName());
		assertEquals("paul@foo.de", users.getUsers().get(0).getEmail());
		users.sort("NAME");
		assertEquals(3, users.getUsers().get(0).getUserId());
		assertEquals("swen", users.getUsers().get(0).getName());
		assertEquals("swen@foo.de", users.getUsers().get(0).getEmail());
		users.sort("EMAIL");
    	assertEquals(3, users.getUsers().get(0).getUserId());
		assertEquals("swen", users.getUsers().get(0).getName());
		assertEquals("swen@foo.de", users.getUsers().get(0).getEmail());
		purchases.sort("AD_ID");
		assertEquals(9, purchases.getPurchases().get(0).getAdId());
		assertEquals(1, purchases.getPurchases().get(0).getUserId());
		assertEquals("chair-1", purchases.getPurchases().get(0).getTitle());
		purchases.sort("TITLE");
		assertEquals(6, purchases.getPurchases().get(0).getAdId());
		assertEquals(4, purchases.getPurchases().get(0).getUserId());
		assertEquals("table-2", purchases.getPurchases().get(0).getTitle());
		purchases.sort("USER_ID");
		assertEquals(6, purchases.getPurchases().get(0).getAdId());
		assertEquals(4, purchases.getPurchases().get(0).getUserId());
		assertEquals("table-2", purchases.getPurchases().get(0).getTitle());
    }
    
    @Test
    void innerJoin() {
    	App.users = users;
    	App.purchases = purchases;
    	System.out.println("-------");
    	userPurchases = new UserPurchases(App.innerJoin("USER_ID", "USER_ID"));
    	assertEquals(8, userPurchases.getUserPurchases().size());
    	assertEquals(1, userPurchases.getUserPurchases().get(0).getUserId());
    	assertEquals("andre", userPurchases.getUserPurchases().get(0).getName());
    	assertEquals("andre@bar.de", userPurchases.getUserPurchases().get(0).getEmail());
    	assertEquals(1, userPurchases.getUserPurchases().get(0).getAdId());
    	assertEquals("car-1", userPurchases.getUserPurchases().get(0).getTitle());
    	userPurchases = new UserPurchases(App.innerJoin("USER_ID", "NAME"));
    	assertEquals(0, userPurchases.getUserPurchases().size());
    }

}
