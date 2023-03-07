

import java.sql.PreparedStatement;
import java.sql.SQLException;

public class UpdateTest {
	private PreparedStatement prepStmt;
	private SqlServerDbAccessor dba;
	
	public UpdateTest() {
		dba = new SqlServerDbAccessor();
		dba.setDbName("StudTest");
		dba.connectToDb();
		prepStmt = dba.getPrepStmt();
	}

	public static void main(String[] args) {
		UpdateTest test = new UpdateTest();
		String tableName = "MZ01Login";
		String updateCol = "Password";
		String keyCol = "ID";
		String keyValue = "23"; // change with your id value
		String newValue = "NEW NEW"; // change with your password
		test.updateValueToColumnInTable(tableName, updateCol, keyCol, keyValue, newValue);
	
	}

	private void updateValueToColumnInTable(String tableName, String updateCol, 
			String keyCol, String keyValue, String newValue) {
		String query = "UPDATE " + tableName + " SET ";
		query += updateCol + " = '";
		query += newValue;
		query += "' WHERE " + keyCol + " = '";
		query += keyValue + "'";

		// print your query for testing
		System.out.println(query);
		// the stmt should print
		// UPDATE MZ01Login SET Password = '12' WHERE ID = 'pwd'
		
		try {
			prepStmt = dba.getConnection().prepareStatement(query);
			int rowAffected = prepStmt.executeUpdate();
			
			if (rowAffected == 1)
				System.out.println("One row updated successfully!");
			else
				System.out.println("Somehow it didn't go through...");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
