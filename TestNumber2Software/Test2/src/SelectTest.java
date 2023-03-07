//package jdbccloud;

import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;

public class SelectTest {
	private Statement stmt;
	private SqlServerDbAccessor dba;
	private SqlServerDbAccessor dbb;
	private PublisherBean bean;
	
	public SelectTest() {
		dba = new SqlServerDbAccessor();
		//dba.setDbName("StudTest");
		dba.setDbName("JLBookstore");
		dba.connectToDb();
		stmt = dba.getStmt();
		
		dbb = new SqlServerDbAccessor();
		//dba.setDbName("StudTest");
		dbb.setDbName("StudTest");
		dbb.connectToDb();
		stmt = dbb.getStmt();
	}
	//public SelectTest() {
		//dba = new SqlServerDbAccessor();
		////dba.setDbName("StudTest");
		//dba.setDbName("JLBookstore");
		//dba.connectToDb();
		//stmt = dba.getStmt();
	//}
	public static void main(String[] args) {
		SelectTest test = new SelectTest();
		
		//String[] cols = {"ID", "Login", "Password"};
		String[] cols = {"PubID", "Name", "Contact", "Phone"}; //"CompanyPhotoPath", "ContactPhotoPath"};
		String[] colu = {"Name"};
		test.selectColumnsFromTable("Publisher", cols);
		//test.selectColumnsFromTable("Publisher", colu);
		String[] cols2 = {"CompanyPhotoPath", "ContactPhotoPath"};
		//test.selectColumnsFromTable("Test2", cols);
		//test.selectColumnsFromTable("JLBookstore", cols);
		//String[] bean = cols;
		//bean.getPubName();
		
		//PublisherBean bean = null;
		//bean.setPubId(cols[0]);
		//bean.getPubId(cols[0]);
		
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
					//bean[i] = result.getString(i) +                                 
							//((i==columns)?"":", ");  
					//bean.set
					System.out.print(result.getString(i) +                                 
							((i==columns)?"":", "));                
				System.out.println();            }
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

}
