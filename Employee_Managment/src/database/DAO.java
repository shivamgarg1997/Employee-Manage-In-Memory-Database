package database;

import java.sql.*;

import Basic.Employee;

public class DAO {
	static Connection connection= null;
    static Statement statement = null;
    static ResultSet rs = null;
   
    public DAO() {
    	try {
    		Class.forName ("org.h2.Driver"); 
    		connection = DriverManager.getConnection ("jdbc:h2:~/Employee", "root","infoobjects");
    	} catch(Exception ex) {
    		ex.printStackTrace();
    	}
    }

    public void insert(Employee e) throws SQLException {
    	try {
	    	String insertquery = "INSERT INTO employee VALUES ('" + e.getId() +"','"
	                 + e.getName() + "','" + e.getDob() + "'," + e.getAge() + ",'" + e.getGender() + "','" 
	    			 + e.getPhno() + "','" + e.getEmail() + "','" + e.getAddress() + "','" + e.getDept()+"');";
	    	statement = connection.createStatement();
	    	statement.executeUpdate(insertquery);
    	} catch(Exception ex) {
    		ex.printStackTrace();
    	} finally {
    		if (rs != null) {
                try {
                    rs.close();
                } catch (SQLException ex) {
                	ex.printStackTrace();
                	}
                rs = null;
            }
            if (statement != null) {
                try {
                    statement.close();
                } catch (SQLException ex) {
                	ex.printStackTrace();
                	}
                statement = null;
            }
            if (connection != null) {
                try {
                    connection.close();
                } catch (SQLException ex) {
                	ex.printStackTrace();
                	}
                connection = null;
            }
         }
    }
    
    public void empInfo() {
    	
    }

    public void deleteEntry(String iD) {
    	try {
	    	String deletequery = "delete from employee where ID = '" + iD + "';";
	    	statement = connection.createStatement();
	    	statement.executeUpdate(deletequery);
    	} catch(Exception ex) {
    		ex.printStackTrace();
    	} finally {
    		if (rs != null) {
                try {
                    rs.close();
                } catch (SQLException ex) {
                	ex.printStackTrace();
                	}
                rs = null;
            }
            if (statement != null) {
                try {
                    statement.close();
                } catch (SQLException ex) {
                	ex.printStackTrace();
                	}
                statement = null;
            }
            if (connection != null) {
                try {
                    connection.close();
                } catch (SQLException ex) {
                	ex.printStackTrace();
                	}
                connection = null;
            }
         }
    }
}
