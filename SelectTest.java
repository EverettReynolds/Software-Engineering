package jdbccloud;

import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;

public class SelectTest {
	private Statement stmt;
	private SqlServerDbAccessor dba;
	
	public SelectTest() {
		dba = new SqlServerDbAccessor();
		dba.setDbName("StudTest");
		dba.connectToDb();
		stmt = dba.getStmt();
	}

	public static void main(String[] args) {
		SelectTest test = new SelectTest();
		
		String[] cols = {"ID", "Login", "Password"};
		test.selectColumnsFromTable("MZ01Login", cols);
	}

	private void selectColumnsFromTable(String table, String[] cols) {
		String query = "SELECT ";
		int index = 1;
		for (String col : cols) {
			query += col;
			if (index++ < cols.length)
				query += ", ";
		}
			
		query += " FROM " + table;
		
		ResultSet result = null;
		try {
			stmt = dba.getConnection().createStatement();
			result = stmt.executeQuery(query);
			
			// get meta data from result and print column labels
			ResultSetMetaData meta = result.getMetaData();            
			int columns = meta.getColumnCount();            
			System.out.println(columns);            
			int j;            
			for (j=1; j<columns; j++)                
				System.out.print(meta.getColumnName(j) + ", ");            
			
			System.out.println(meta.getColumnName(j));            

			while (result.next()) {
				for (int i=1; i<=columns; i++)                        
					System.out.print(result.getString(i) +                                 
							((i==columns)?"":", "));                
				System.out.println();            }
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

}