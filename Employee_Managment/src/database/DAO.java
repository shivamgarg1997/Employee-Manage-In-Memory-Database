package database;

import java.awt.List;
import java.sql.*;
import java.util.ArrayList;

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
	                 + e.getFirstName() +"'," +e.getMiddleName()+"'," + e.getLastName()+ "','" 
	    			 + e.getDob() + "'," + e.getAge() + ",'" + e.getGender() + "','" 
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
    
    public ArrayList<Employee> empInfo() {
    	ArrayList<Employee> list = new ArrayList<Employee>();
    	try {
    		String displayquery = "select * fom employee;";
        	statement  = connection.createStatement();
        	rs = statement.executeQuery(displayquery);
        	while(rs.next()) {
        		list.add(new Employee(rs.getString(1), rs.getString(2), rs.getString(3),
        				rs.getString(4), rs.getString(5), rs.getInt(6), rs.getString(7),
        				rs.getString(8), rs.getString(9), rs.getString(10), rs.getString(11)));
        	}
        	return list;
    	} catch(SQLException ex) {
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
    	return null;
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
