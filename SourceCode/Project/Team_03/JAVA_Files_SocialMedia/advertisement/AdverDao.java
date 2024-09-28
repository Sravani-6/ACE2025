package advertisement;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class AdverDao {
	public List<Advertisement>getAllAdvertisements(){
		List<Advertisement> mes=new ArrayList<>();
		try {
			Connection con=DbConnection.getConnection();
			Statement stmt = con.createStatement();
			ResultSet rs=stmt.executeQuery("select * from advertisement");
			while(rs.next()) {
			int adId=rs.getInt("AdId");
			String adTitle=rs.getString("adTitle");
			String adContent=rs.getString("adContent");
			Advertisement msg=new Advertisement(adId,adTitle,adContent);
			mes.add(msg);
			}
		}catch(Exception e)
		{
			e.printStackTrace();
		}
		return mes;
}
}
