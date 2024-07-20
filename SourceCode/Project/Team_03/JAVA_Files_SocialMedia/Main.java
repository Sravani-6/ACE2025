package SocialMedia;
import java.util.*;
public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
User u1 = new User(01,"sravani_19","madhagonisravani@gmail.com","Srav1234");
User u2 = new User(02,"manswi_10","manaswi@gmail.com","Manu1234");
User u3 = new User(03,"sowmya_25","sowmya@gmail.com","Sowmya1234");
User u4 = new User(04,"nagalakshmi_19","nagalakshmi@gmail.com","naga1234");
User u5 = new User(05,"vaishu_14","vaishnavi@gmail.com","Vaish1234");

User[] users = {u1,u2,u3,u4,u5};
for(int i=0;i<users.length;i++) {
	user[i].display();
}

Post p1 = new Post(108,12,"Keep pushing, keep growing","exercise demonstrations");
Post p2 = new Post(110,14,"Creativity knows no bounds","Image showcasing artwork");
Post p3 = new Post(112,18,"Get crafty and unleash your inner artist!","Step-by-step images");
Post p4 = new Post(118,24,"Nourish your body, nurture your soul","Infographic health tips");
Post p5 = new Post(103,03,"Indulge your senses with every bite","Video of a delicious dish");

Post[] posts = {p1,p2,p3,p4,p5};
for(int i=0;i<posts.length;i++) {
	post[i].display();
}

Notification n1 = new Notification(1001,01);
Notification n2 = new Notification(1002,06);
Notification n3 = new Notification(1003,08);
Notification n4 = new Notification(1004,10);

Notification[] notify = {n1,n2,n3,n4};
for(int i=0;i<notify.length;i++) {
	notify[i].display();
}

Like l1 = new Like(301,101,01);
Like l2 = new Like(302,102,02);
Like l3 = new Like(303,103,03);
Like l4 = new Like(304,104,04);

Like[] likes = {l1,l2,l3,l4};
for(int i=0;i<likes.length;i++) {
	likes[i].display();
}

Group g1 = new Group(1101,"3 idiots",3);
Group g2 = new Group(1102,"pumpkins",5);
Group g3 = new Group(1103,"squad",4);
Group g4 = new Group(1104,"butterfiles",3);

Group[] groups = {g1,g2,g3,g4};
for(int i=0;i<groups.length;i++) {
	groups[i].display();
}

Comment c1 = new Comment(211,111,11,"You have an incredible voice! This cover gave me goosebumps");
Comment c2 = new Comment(216,118,17,"I can almost taste the flavors through the screen!");
Comment c3 = new Comment(218,119,20,"I can almost taste the flavors through the screen!");

Comment[] comments = {c1,c2,c3};
for(int i=0;i<comments.length;i++) {
	comments[i].display();
}

Event e1 = new Event(2004,"Sports event",191,"11-06-2024","warangal");
Event e2 = new Event(2002,"Musical Fest",152,"20-08-2024","delhi");
Event e3 = new Event(2003,"Award fest",132,"07-07-2024","kerala");

Event[] events = {e1,e2,e3};
for(int i=0;i<events.length;i++) {
	events[i].display();
}
Message m1 = new Message(101,105,108,"Spectacular!");
Message m2 = new Message(102,107,111,"Wanderlust vibes!"); 
Message m3 = new Message(103,113,116,"Yum!");
Message m4 = new Message(104,115,118,"Impressive!");
Message[] mess = {m1,m2,m3,m4};
for(int i=0;i<mess.length;i++) {
	mess[i].display();
}
Friend f1 = new Friend(301,105,"Communication"); 
Friend f2 = new Friend(302,107,"visibility"); 
Friend f3 = new Friend(303,113,"Close"); 
Friend f4 = new Friend(304,115,"Timeliness");
Friend[] fri = {f1,f2,f3,f4};
for(int i=0;i<fri.length;i++) {
	fri[i].display();
}

Advertisement a1 = new Advetisement(401, "Summer Sale", "Get 50% off on all summer collections!", "http://example.com/summer-sale");
Advertisement a2 = new Advertisement(402, "New Smartphone Launch", "Discover the latest smartphone with cutting-edge technology!", "http://example.com/smartphone-launch");
Advertisement a3 = new Advertisement(403, "Fitness Challenge", "Join our 30-day fitness challenge and win exciting prizes!", "http://example.com/fitness-challenge");
Advertisement a4 = new Advertisement(404, "Travel Deals", "Explore new destinations with our exclusive travel deals!", "http://example.com/travel-deals"); 
Advertisement[] ad = {a1,a2,a3,a4};
for(int i=0;i<ad;i++) {
	ad[i].display();
}
}
}
