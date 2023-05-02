package usuario.bd;

import java.sql.Connection;
import java.sql.DriverManager;

public class MysqlConnection {

	
	
	public static  Connection getConnection() {
		Connection coon = null   ;
	
		
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
		}catch(Exception e) {
			e.printStackTrace();
		}
		
		try {
			coon = DriverManager.getConnection("jdbc:mysql://localhost:3306/jspweb","root","");
		}catch(Exception e) {
			e.printStackTrace();
		}
	
		return coon;
	}
	
	
	
	
	
	
	
	
	
	
}
