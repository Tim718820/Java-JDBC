package tw.org.iii;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Properties;



public class JDBC13 {

	public static void main(String[] args) {
		Properties prop = new Properties();
		prop.setProperty("user", "root");
		prop.setProperty("password", "root");
		
		try (Connection conn = 
			DriverManager.getConnection("jdbc:mysql://127.0.0.1/brad", 
				prop);
			FileInputStream in =
			new FileInputStream("./dir1/Java.jpg")){
			
			PreparedStatement pstmt = 
					conn.prepareStatement("SELECT * FROM member where id = 1");
			
//			pstmt.setBinaryStream(1, in);  讀進資料庫
//			pstmt.executeUpdate();
			
			ResultSet rs =  pstmt.executeQuery();
			rs.next();
			
			rs.getBinaryStream("img");
			
			FileOutputStream out = new FileOutputStream("./dir2/iii.jpg");
			byte[] buf = new byte[4096]; int len;
			while((len = in.read(buf)) != -1){
				out.write(buf, 0, len);
			}
			out.flush();
			out.close();
			
			System.out.println("OK");
			
		}catch(Exception e){
			System.out.println(e);
		}

	}

}
