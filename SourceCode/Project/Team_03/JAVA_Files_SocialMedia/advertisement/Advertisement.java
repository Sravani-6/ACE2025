package advertisement;

public class Advertisement {
<<<<<<< HEAD
	private int adId;
	private String adTitle;
	private String adContent;
	
public Advertisement(int adId,String adTitle,String adContent) {
=======
	private String adId;
	private String adTitle;
	private String adContent;
	
public Advertisement(String adId,String adTitle,String adContent) {
>>>>>>> 65a822c6ec19055c2c9c5c63383b00503d887e7a
	this.adId = adId;
	this.adTitle = adTitle;
	this.adContent = adContent;
}
<<<<<<< HEAD
public int getAdId() {
=======
public String getAdId() {
>>>>>>> 65a822c6ec19055c2c9c5c63383b00503d887e7a
	return adId;
}
public String getAdTitle() {
	return adTitle;
}
public String getAdContent() {
	return adContent;
}
<<<<<<< HEAD
public void setAdId(int adId) {
=======
public void setAdId(String adId) {
>>>>>>> 65a822c6ec19055c2c9c5c63383b00503d887e7a
	this.adId = adId;
}
public void setAdTitle(String adTitle) {
	this.adTitle = adTitle;
}
public void setAdContent(String adContent) {
	this.adContent = adContent;
}
}
