package tw.org.iii;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Properties;

import org.json.JSONStringer;
import org.json.JSONWriter;

public class JDBC06 {

	public static void main(String[] args) {
		Properties prop = new Properties();
		prop.setProperty("user", "root");
		prop.setProperty("password", "root");
		try(Connection conn = DriverManager.getConnection(
				"jdbc:mysql://localhost/brad",prop);){
		
		String sql = "SELECT * from gift";
		JSONWriter jw = new JSONStringer().array();
		
		PreparedStatement pstmt = conn.prepareStatement(sql);
		ResultSet rs = pstmt.executeQuery();
		while(rs.next()){
			String Name = rs.getString("Name");
			String Feature = rs.getString("Feature");
			String gid = rs.getString("gid");
			System.out.println(Feature);
			jw.object();
			jw.key("gid").value(gid);
			jw.key("Name").value(Name);
			//jw.key("Feature").value(Feature);
			jw.endObject();
			
		}
		jw.endArray();
		System.out.println(jw.toString());
			}catch(Exception e){
			System.out.println(e);
			}
	}

}
