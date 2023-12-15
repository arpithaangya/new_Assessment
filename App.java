package jdbc.dataaccess;

import java.security.DomainCombiner;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

/**
 * Hello world!
 *
 */
public class App 
{
	
	public static final String DRIVER_CLASS_NAME = "oracle.jdbc.driver.OracleDriver";

	public static final String URL = "jdbc:oracle:thin:@localhost:1521:XE";
	public static final String USER_NAME= "SYSTEM";
	public static final String PASSWORD ="Database";
	public static final String CREATE_QUERY="CREATE TABLE ARPITHASHEKHAR.PRODUCT(" 
												+ "PRODUCTID  NUMBER , " 
												+ "PRODUCTNAME VARCHAR(20) , " 
												+ "PRODUCTPRICE NUMBER(4,2))";
	
	public static final String INSERT_QUERY = "INSERT INTO ARPITHASHEKHAR.PRODUCT VALUES("
												+"12345,"
												+"'"+"laptop"+"'"+','
												+"32.45)";
	
	public static final String SELECT_QUERY ="SELECT * FROM ARPITHASHEKHAR.PRODUCT";
	
	public static final String UPDATE_QUERY = "UPDATE ARPITHASHEKHAR.PRODUCT SET PRODUCTID = 3456 WHERE PRODUCTNAME = 'headphone'";
	
	public static final String DELETE_QUERY = "DELETE FROM ARPITHASHEKHAR.PRODUCT WHERE PRODUCTID = 3456";
	
	
	public static Statement ConnectionandStatement() throws ClassNotFoundException,SQLException 
    {
    	Connection connection =null;
    	Statement statement =null;
    	
    	try{
    		
    		 //Step 1 :Register the Drive Class
    		Class.forName(DRIVER_CLASS_NAME);
    		
    		//Step 2:Create the connection
        	 connection = DriverManager.getConnection(URL,USER_NAME,PASSWORD);
        	
        	if(connection!=null) {
        		System.out.println("Connection succesful");
        	}
        	else {
        		System.out.println("Connection failed");
        	}
        	
        	//Step 3:Create the statement
        	statement= connection.createStatement();
        	
            //Step 4: Execute the Query
        	
			statement.execute(CREATE_QUERY);
			
    		}catch(ClassNotFoundException e) {
    		System.out.println(e.getMessage());
    		}
    		catch(SQLException e) {
    		System.out.println(e.getMessage());
    		} 
		return statement;
    	
    	
    }
    
	public static void userMenu() {
		
		System.out.println("1.CREATE TABLE \n"
				+"2.LOADTABLE \n"
				+"3.READ \n"
				+"4.UPDATE \n"
				+"5.DELETE \n"
				+"6.EXIT \n");
		}
    
    public static void main(String[] args) throws SQLException {
    	try {
    		//STEP 2&3 Connection and Statement
    		Statement statement =null;
    		statement = ConnectionandStatement();
    		int rows =0;
    		//USER OPTION
    		userMenu();
    		System.out.println("User choice:");
    		int option = new Scanner(System.in).nextInt();
    		
    		if(option == 1) 
    			{
    			statement.execute(CREATE_QUERY);
    			}
    		
    		else if(option == 2) 
    			{
    			statement.execute(INSERT_QUERY);
    			}
    		
    		else if(option == 3 ){
    			ResultSet rs=statement.executeQuery(SELECT_QUERY);
    			while(rs.next()) {
    				System.out.println(rs.getInt(1)+"|"+rs.getString(2)+"|"+rs.getFloat(3)+"|");
    				}
    			}
    		
    		else if(option == 4) {
    			 rows = statement.executeUpdate(UPDATE_QUERY);
    			if(rows > 0) 
    				System.out.println("Product record updated");
    			else
    				System.out.println("Please check again");
    			}
    		
    		else if(option == 5) {
    			rows = statement.executeUpdate(DELETE_QUERY);
    			if(rows > 0)
    				System.out.println("Record deleted");
    			else
    				System.out.println("Please check again");
    			}
    		
    		else if(option == 6){
    			System.out.println("THANK YOU !!");
    			return;
    		}
    		
    		else {
    			System.out.println("Please enter valid choice");
    		}
    		
    	}catch(ClassNotFoundException e){
    		System.out.println(e.getMessage());
    	}
    	

	}

   sysouasdfghjkl;'

}
