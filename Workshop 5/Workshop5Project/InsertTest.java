
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class InsertTest {
	private PreparedStatement prepStmt;
	private SqlServerDbAccessor dba;
	
	public InsertTest() {
		dba = new SqlServerDbAccessor();
		dba.setDbName("StudTest");
		dba.connectToDb();
		prepStmt = dba.getPrepStmt();
	}

	public static void main(String[] args) {
		InsertTest test = new InsertTest();
		String[] cols = {"ID", "Login", "Password"};
		test.insertValueToColumnsInTable("MZ01Login", cols);
	}

	private void insertValueToColumnsInTable(String table, String[] cols) {
		String query = "INSERT INTO " + table + "(";
		int index = 1;
		for (String col : cols) {
			query += col;
			if (index++ < cols.length)
				query += ", ";
		}
			
		query += ") VALUES(";
		
		/*
		// one example given here...
		query += 9 + ", "; //change 1 to ## : your two-digit number  
		query += "'cust_user_09'" + ", "; // change to your login in between ' '
		query += "'cu09'" + ")";  // change to your password in between ' '
		*/
		query += 23 + ", "; //change 1 to ## : your two-digit number  
		query += "'ez_reynolds_23'" + ", "; // change to your login in between ' '
		query += "'Password'" + ")";  // change to your password in between ' '
		// print your query for testing
		System.out.println(query);
		
		try {
			prepStmt = dba.getConnection().prepareStatement(query);
			int rowAffected = prepStmt.executeUpdate();
			
			if (rowAffected == 1)
				System.out.println("One row inserted successfully!");
			else
				System.out.println("Somehow it didn't go through...");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
