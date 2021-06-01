package exercise;

public class UserPurchase {
	private int userId; // USER_ID
	private String name; // NAME
	private String email; // EMAIL
	private int adId; //AD_ID
	private String title; // TITLE
	
	public UserPurchase(int userId, String name, String email, int adId, String title) {
		super();
		this.userId = userId;
		this.name = name;
		this.email = email;
		this.adId = adId;
		this.title = title;
	}

	public UserPurchase() {
		super();
	}

	public int getUserId() {
		return userId;
	}

	public void setUserId(int userId) {
		this.userId = userId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public int getAdId() {
		return adId;
	}

	public void setAdId(int adId) {
		this.adId = adId;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	@Override
	public String toString() {
		return "UserPurchase [userId=" + userId + ", name=" + name + ", email=" + email + ", adId=" + adId + ", title="
				+ title + "]";
	}
	
}
