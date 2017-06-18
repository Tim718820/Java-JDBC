package tw.org.iii;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Properties;

public class JDBC03 {

	public static void main(String[] args) {
		//1.Driver
		try{
		Class.forName("com.mysql.jdbc.Driver");
		System.out.println("OK");
		}catch(ClassNotFoundException ee){			
		System.out.println(ee);
		}
		//2.conn
		Properties prop = new Properties();
		prop.setProperty("user", "root");
		prop.setProperty("password", "root");
		try{
		Connection conn = DriverManager.getConnection(
				"jdbc:mysql://localhost/brad",prop);
		//3.SQL statment
		Statement stmt = conn.createStatement();
		//4.query
//		String sql = "INSERT INTO cust(cname,tel,birthday)" + 
//				"VALUES ('Amy','123','1994-07-18')";
		String sql2 = "SELECT * from cust";
		ResultSet rs = stmt.executeQuery(sql2);
			while(rs.next()){
				String id = rs.getString("id");
				String cname = rs.getString("cname");
				String brth = rs.getString("birthday");
				System.out.println(id + ":" + cname + ":" + brth);
			}
				
				
			}catch(SQLException se){
				System.out.println(se);
		}

	}

}
