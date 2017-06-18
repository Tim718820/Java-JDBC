package tw.org.iii;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Properties;



public class JDBC05 {

	public static void main(String[] args) {
		Properties prop = new Properties();
		prop.setProperty("user", "root");
		prop.setProperty("password", "root");
		try(Connection conn = DriverManager.getConnection(
				"jdbc:mysql://localhost/brad",prop);){
		
		String sql = "INSERT INTO cust (cname,tel,birthday) VALUES (,,,);)";
		
		PreparedStatement pstmt = conn.prepareStatement(sql);
		pstmt.setString(1, "Peter");
		pstmt.setString(2, "321");
		pstmt.setString(3, "1998-05-09");
		pstmt.execute();	
				
				
			}catch(SQLException se){
				System.out.println(se);
		}

	}

}
