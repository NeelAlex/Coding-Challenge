package exercise;

public class Purchase {
	private int adId; //AD_ID
	private int userId; // USER_ID
	private String title; // TITLE
	
	public Purchase() {
		
	}

	public Purchase(int adId, int userId, String title) {
		this.adId = adId;
		this.userId = userId;
		this.title = title;
	}

	public int getAdId() {
		return adId;
	}

	public void setAdId(int adId) {
		this.adId = adId;
	}

	public int getUserId() {
		return userId;
	}

	public void setUserId(int userId) {
		this.userId = userId;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	@Override
	public String toString() {
		return "Purchase [adId=" + adId + ", userId=" + userId + ", title=" + title + "]";
	}
	
}
