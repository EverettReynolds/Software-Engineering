package prepare;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;

public class dataSelection {
	private Statement stmt;
	private dataBaseAccessor dba;
	private dataBaseAccessor dbb;
	private GeneralBean bean;
	
	public dataSelection() {
		dba = new dataBaseAccessor();
		
		dba.setDbName(null); // Database Name Unknown
		dba.connectToDb();
		stmt = dba.getStmt();
		
		dbb = new dataBaseAccessor();
		
		dbb.setDbName(" "); // Database Name Unknown
		dbb.connectToDb();
		stmt = dbb.getStmt();
	}
	
	public static void main(String[] args) {
		dataSelection test = new dataSelection();
		
		
		String[] data;  // Unknown Database Parameters , Need in order to parse data
		String[] points;
		
		
		
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

