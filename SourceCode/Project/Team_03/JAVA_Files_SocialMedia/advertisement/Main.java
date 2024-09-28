package advertisement;

import java.util.*;

public class Main {

	public static void main(String[] args) {
		List<Advertisement> al=new ArrayList<>();
		System.out.format("%-10s %-15s %-10s\n","AdID","AdTitle","AdContent");
		AdverDao dao=new AdverDao();
		al=dao.getAllAdvertisements();
		for(Advertisement m:al){
			System.out.format("%-10s %-15s %-10s\n",m.getAdId(),m.getAdTitle(),m.getAdContent());
		}

	}

	}
