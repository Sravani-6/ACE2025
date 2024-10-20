package advertisement;

public class Advertisement {
	private String adId;
	private String adTitle;
	private String adContent;
	
public Advertisement(String adId,String adTitle,String adContent) {
	this.adId = adId;
	this.adTitle = adTitle;
	this.adContent = adContent;
}
public String getAdId() {
	return adId;
}
public String getAdTitle() {
	return adTitle;
}
public String getAdContent() {
	return adContent;
}
public void setAdId(String adId) {
	this.adId = adId;
}
public void setAdTitle(String adTitle) {
	this.adTitle = adTitle;
}
public void setAdContent(String adContent) {
	this.adContent = adContent;
}
}
