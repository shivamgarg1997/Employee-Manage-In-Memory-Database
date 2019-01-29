package database;

import java.sql.*;

public class DAO {
	static Connection con= null;
    static Statement statement = null;
    static ResultSet rs = null;
    public void empInfo() {
    	try {
    		Class.forName ("org.h2.Driver"); 
    		con = DriverManager.getConnection ("jdbc:h2:~/test", "root","infoobjects");
    	} catch(Exception ex) {
    		ex.printStackTrace();
    	}
    }
}
