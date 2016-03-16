package hotelDBMS;

import java.sql.*;

public class DBConnection {
	
	Connection conn = null;
		
	
	public DBConnection(String hosting, String username, String password){
		
		try{
			 conn = DriverManager.getConnection(hosting, username, password);
			 System.out.println("Successfully connecting to Database ... ");
		} catch(Exception e){
			System.out.println("Failed when connecting to Database ...");
		}		
	}
	
	public void executeQuery(String query){
		try {
			//
			Statement myStmt = conn.createStatement();
			// get result table set
			ResultSet myRs = myStmt.executeQuery(query);
			// print out the table 
			while(myRs.next()){
				// fill in column name
				System.out.println(myRs.getString("lName"));
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}	
	
	public void addCutsomer(String fName, String lName, Integer IDnumber, String emailAddress, String country){
		try {
			// create new Statement
			Statement myStmt = conn.createStatement();
			// the entity with need to be added
			String entity = fName + "," + lName + "," + IDnumber + "," + emailAddress + "," + country ;
			// the query for inserting
			String query = "insert into Customer"
					+ " (fName, lName, IDnumber, emailAddress, country)"
					+ "values (" + entity + ")"; 
			
			myStmt.executeUpdate(query);
			System.out.println("Insert Complete");
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public void addRooms(){
		
	}
	
	
	
	
	public static void main(String[] args) {
//		  try { 
//			   Class.forName("com.mysql.jdbc.Driver");   //¼ÓÔØMYSQL JDBCÇý¶¯³ÌÐò  
//			   //Class.forName("org.gjt.mm.mysql.Driver"); 
//			   System.out.println("Success loading Mysql Driver!"); 
//			  } 
//			  catch (Exception e) { 
//			   System.out.print("Error loading Mysql Driver!"); 
//			   e.printStackTrace(); 
//			  }
		DBConnection myDB = new DBConnection("jdbc:mysql://localhost:3306/firstSchema", "root", "260225towncenter");
		myDB.executeQuery("SELECT * FROM firstschema.customers;");
		//myDB.addCutsomer("a", "b", 1234, "123@123", "CAN");
		
		
		
		
	
	}

	
	
	
	
	
	
}

