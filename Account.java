package jdbc.dataaccess;
import java.security.DomainCombiner;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

public class Account {
	
	public static final String DRIVER_CLASS_NAME = "oracle.jdbc.driver.OracleDriver";

	public static final String URL = "jdbc:oracle:thin:@localhost:1521:XE";
	public static final String USER_NAME= "SYSTEM";
	public static final String PASSWORD ="Database";
	public static final String CREATE_QUERY="CREATE TABLE ARPITHASHEKHAR.ACCOUNT(" 
												+ "ACCOUNTID  NUMBER PRIMARY KEY, " 
												+ "ACCOUNTHOLDER VARCHAR(20) , " 
												+ "BALANCE NUMBER)";
	
	public static final String INSERT_QUERY = "INSERT INTO ARPITHASHEKHAR.ACCOUNT VALUES(?,?,?)";
	
	Connection conn = null;
	
	public static void main(String[] args) throws SQLException, ClassNotFoundException {
			
		Connection connection =null;
		PreparedStatement stmt = null;
    	Statement statement =null;
    	 connection = DriverManager.getConnection(URL,USER_NAME,PASSWORD);
     	
     	if(connection!=null) {
     		System.out.println("Connection succesful");
     	}
     	else {
     		System.out.println("Connection failed");
     	}
//     	try {
//     		
//        	//statement= connection.createStatement();
//        	//statement.execute(CREATE_QUERY);
//			
//    		}catch(SQLException e) {
//    		System.out.println(e.getMessage());
//    		} 
//     	
     	
     	
		Scanner sc=new Scanner(System.in);
		System.out.println("Enter the account id ");
		int id=sc.nextInt();
		System.out.println("Enter the account holder name ");
		String name = sc.next();
		System.out.println("Enter the account Balance ");
		int balance = sc.nextInt();
		
		try {
			stmt = connection.prepareStatement(INSERT_QUERY);
			stmt.setInt(1, id);
			stmt.setString(2, name);
			stmt.setInt(3, balance);
			int r = stmt.executeUpdate();
			if(r >0) System.out.println("Inserted");
			else System.out.println("Not Inserted");
			
		}catch(SQLException  e) {
			System.out.println(e.getMessage());
		}
		
	}
	
}
