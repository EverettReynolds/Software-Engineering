package prepare;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
public class dataBaseAccessor {
	private Connection con;
	private Statement stmt;
	private PreparedStatement prepStmt;
	private ResultSet rs;
	
	private String connectionUrl;
	
	private String defaultConnUrl; // Unknown Connection Address
	
	public dataBaseAccessor() {
		connectionUrl = defaultConnUrl;
	}
	
	public dataBaseAccessor(String serverName, String user, String pwd, 
			String dbName) {
		connectionUrl = "jdbc:sqlserver://;";
		connectionUrl += "servername=" + serverName + ";"; 
		connectionUrl += "user=" + user + ";"; 
		connectionUrl += "password=" + pwd + ";"; 
		connectionUrl += "databaseName=" + dbName + ";"; 
	}
	
	public void setDbName(String dbName) {
		connectionUrl += "databaseName=" + dbName;
	}
	
	public void connectToDb() {
    	try {
    		// Establish the connection.
    		Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
        	con = DriverManager.getConnection(connectionUrl);
    	} catch (Exception e) {
			e.printStackTrace();
		}

	}

	public Statement getStmt() {
		// TODO Auto-generated method stub
		return stmt;
	}

	public PreparedStatement getPrepStmt() {
		// TODO Auto-generated method stub
		return prepStmt;
	}

	public Connection getConnection() {
		// TODO Auto-generated method stub
		return con;
	}

	public String getUrl() {
		// TODO Auto-generated method stub
		return connectionUrl;
	}
}
