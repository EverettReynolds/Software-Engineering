

import java.awt.image.BufferedImage;
import java.sql.Statement;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;

public class UpdatePhotoTest {
	private PreparedStatement prepStmt;
	private SqlServerDbAccessor dba;
	
	public UpdatePhotoTest() {
		dba = new SqlServerDbAccessor();
		dba.setDbName("JLBookstore");
		dba.connectToDb();
		prepStmt = dba.getPrepStmt();
	}

	public void updateImageInColumn(String table, String column, 
		String imageFile, String condition) {
		FileInputStream imageInputStream = null;
		String updateSql = "UPDATE " + table + " SET " + column + " = ? " +
							condition;
		System.out.println(imageFile);
		System.out.println(updateSql);
		try {
			prepStmt = dba.getConnection().prepareStatement(updateSql);
			imageInputStream = new FileInputStream(new File(imageFile));
			prepStmt.setBinaryStream(1, imageInputStream);
			int success = prepStmt.executeUpdate();
			
			if (success == 1) {
				System.out.println("One photo loaded successfully!");
				retrievePhotoFromDB();
			}
			else
				System.out.println("Somehow it didn't go through...");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	private void retrievePhotoFromDB() {
		String query = "SELECT PubID, CompanyPhotoPath FROM Publisher WHERE PubID = ";

		query += 0  ; // replace value 9 with your ## : 2-digit number
		System.out.println(query);
		
		try {
			Statement stmt = dba.getConnection().createStatement();
			ResultSet result = stmt.executeQuery(query);
			
			// point to the next and only row in the result set
			result.next();
			int id = result.getInt(1); // index is 1-based: 1 is the first field
			BufferedImage photo = ImageIO.read(result.getBinaryStream(2));
			ImageIcon iconWithPhoto = new ImageIcon(photo);
			JOptionPane.showConfirmDialog(null, "Photo of user " + id,
					"Image Retrieval Test", JOptionPane.OK_OPTION,
					JOptionPane.INFORMATION_MESSAGE, iconWithPhoto);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		UpdatePhotoTest test = new UpdatePhotoTest();
		//test.updateImageInColumn("MZ01Login", "Photo", "image/user_cu_09.png",
		//		"WHERE ID = 9");
		
		// may be used to test retrieve without inserting a photo
		// currently all users except 7 and 8 have a photo in table
		test.retrievePhotoFromDB();
	}

}