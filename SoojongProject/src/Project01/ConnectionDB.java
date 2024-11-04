package Project01;

import java.sql.Connection;
import java.sql.DriverManager;

public class ConnectionDB {

	private static final String DRIVER = "oracle.jdbc.driver.OracleDriver";
	private static final String URL = "jdbc:oracle:thin:@localhost:1521:xe";
	private static final String USERID = "scott";
	private static final String PASSWORD = "tiger";
	
	public static Connection getConn() {
		Connection con = null;
	       
        try {
            Class.forName(DRIVER);
            con = DriverManager.getConnection(URL,USERID,PASSWORD);
           
        } catch (Exception e) {
            e.printStackTrace();
        }
       
        return con;
		
	}
	
}