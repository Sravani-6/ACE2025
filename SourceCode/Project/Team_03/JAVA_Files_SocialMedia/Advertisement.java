package SocialMedia;

public class Advertisement {
	private Int adId;
	private String adTitle;
	private String adContent;
	
public Advertisement(Int adId,String adTitle,String adContent) {
	this.adId = adId;
	this.adTitle = adTitle;
	this.adContent = adContent;
}
public Int getAdId() {
	return adId;
}
public String getAdTitle() {
	return adTitle;
}
public String getAdContent() {
	return adContent;
}
public String grtAdUrl() {
	return adUrl;
}
public void setAdId(Int adId) {
	this.adId = adId;
}
public void setAdTitle(String adTitle) {
	this.adTitle = adTitle;
}
public void setAdContent(String adContent) {
	this.adContent = adContent;
}
public void display() {
	System.out.println("Advertisement Details:");
	System.out.println("Add Id: "+adId);
	System.out.println("Add title: "+adTitle);
	System.out.println("Add content: "+adContent);
}
