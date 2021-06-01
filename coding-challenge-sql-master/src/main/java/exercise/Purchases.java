package exercise;

import java.util.Collections;
import java.util.List;

public class Purchases extends Table {
	private List<Purchase> purchases;

	public Purchases() {
		
	}

	public Purchases(List<Purchase> purchases) {
		super();
		this.purchases = purchases;
	}

	
	public List<Purchase> getPurchases() {
		return purchases;
	}

	public void setPurchase(List<Purchase> purchases) {
		this.purchases = purchases;
	}

	@Override
	public void sort(String columnName) {
		switch(columnName) {
			case "TITLE" :
				Collections.sort(this.purchases, (p1, p2) -> p2.getTitle().compareTo(p1.getTitle()));
				break;
			case"USER_ID" :
				Collections.sort(this.purchases, (p1, p2) -> p2.getUserId() - p1.getUserId());
				break;
			default:
				Collections.sort(this.purchases, (p1, p2) -> p2.getAdId() - p1.getAdId());
		}
		for (Purchase purchase : this.purchases) {
			System.out.println(purchase.toString());
		}
	}
	
	
}

