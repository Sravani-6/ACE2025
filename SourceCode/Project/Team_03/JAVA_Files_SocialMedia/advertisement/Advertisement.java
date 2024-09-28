package advertisement;

public class Advertisement {
	private int adId;
	private String adTitle;
	private String adContent;
	
public Advertisement(int adId,String adTitle,String adContent) {
	this.adId = adId;
	this.adTitle = adTitle;
	this.adContent = adContent;
}
public int getAdId() {
	return adId;
}
public String getAdTitle() {
	return adTitle;
}
public String getAdContent() {
	return adContent;
}
public void setAdId(int adId) {
	this.adId = adId;
}
public void setAdTitle(String adTitle) {
	this.adTitle = adTitle;
}
public void setAdContent(String adContent) {
	this.adContent = adContent;
}
}
