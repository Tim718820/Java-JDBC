package tw.org.iii;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Properties;

public class JDBC07 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Properties prop = new Properties();
		prop.setProperty("user", "root");
		prop.setProperty("password", "root");
		
		try(Connection conn = 
				DriverManager.getConnection("jdbc:mysql://localhost/brad",
						prop)){
				Statement stmt = conn.createStatement();
//				ResultSet rs = stmt.executeQuery("SELECT count(*) FROM gift");
//				rs.next();
//				System.out.println(rs.getString(1));
				String sql = "INSERT INTO member (account,passwd,realname)" +
							"VALUES ('brad','123','Brad Chao')";
				stmt.executeUpdate(sql);
				
				System.out.println("OK");
		}catch(Exception e){
			System.out.println(e);
		}
	}

}
