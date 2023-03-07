import javax.swing.ImageIcon;
/**
 * 
 * 
 * @author Everett Reynolds
 * A class declaration which creates all necessary elements to a database entry
 */
public class PublisherBean {

	
		String pubID,pubName,contactName,phoneNumber;
		ImageIcon CompanyPhotoPath,ContactPhotoPath;
		/**
		 * A constructor which puts into place all necessary components of a database entry
		 * within our database
		 * 
		 * There will always be a place for all variables created, even if there is currently nothing
		 * holding its slot
		 * @param pubID The Publisher's ID number
		 * @param pubName The Publishing Company's Name
		 * @param contactName The Contact Name for The Publishing Company
		 * @param phoneNumber The phone Number for the publishing Company
		 * @param CompanyPhotoPath The Publishing Company's Branding Photo
		 * @param ContactPhotoPath The Publishing Company's Contact Person's Photo
		 */
		 public PublisherBean(String pubID,String pubName, String contactName, String phoneNumber, ImageIcon CompanyPhotoPath, ImageIcon ContactPhotoPath) {
			this.pubID = pubID;
			this.pubName = pubName;
			this.contactName = contactName;
			this.phoneNumber = phoneNumber;
			this.CompanyPhotoPath = CompanyPhotoPath;
			this.ContactPhotoPath = ContactPhotoPath;
		}
		 /**
		  *  A constructor which is used to put into place the pictures for both the company's photo and the contact person's photo
		  */
		public PublisherBean() {
			CompanyPhotoPath = new ImageIcon("img/*");
			ContactPhotoPath = new ImageIcon("img/*");
		}
		/**
		 * A method which is used to grab the Publisher's Identification Number
		 * 
		 * @return pubId The Publisher's Identification Number
		 */
		public String getPubId() {
			return pubID;
		}
		/**
		 *  A method which is used to grab the Publisher's Name
		 * 
		 * @return pubName The Publisher's Name
		 */
		public String getPubName() {
			return pubName;
		}
		 /**
		  * 
		  * A method which is used to grab the Contact Person's Name
		  * 
		  * @return contactName The Publishing Company's Contact Name
		  */
		public String getContactName() {
			return contactName;
		}
		/**
		  * 
		  * A method which is used to grab the Company's Phone Number
		  * 
		  * @return phoneNumber The Publishing Company's Phone Number
		  */
		public String getPhoneNumber() {
			return phoneNumber;
		}
		/**
		  * 
		  * A method which is used to grab the Company's Photo
		  * 
		  * @return CompanyPhotoPath The Publishing Company's Branding Photo
		  */
		public ImageIcon getCompanyPhoto() {
			return CompanyPhotoPath;
		}
		/**
		  * 
		  * A method which is used to grab the Contact Person's Photo
		  * 
		  * @return ContactPhotoPath The Publishing Company's Contact Person's Photo
		  */
		public ImageIcon getContactPhoto() {
			return ContactPhotoPath;
		}
	
		/**
		 * A method which is used to grab the Publisher's Identification Number
		 * 
		 * @return pubId The Publisher's Identification Number
		 */
		public void setPubId(String col) {
			//return pubID;
			col = pubID;
		}
		/**
		 * Sets the Name of The Publisher from a Table
		 * @param col A given position within a 2d array table
		 */
		public void setPubName(String col) {
			//return pubID;
			col = pubName;
		}
		/**
		 * Sets the Name of The Contact from a Table
		 * @param col A given position within a 2d array table
		 */
		public void setContactName(String col) {
			//return pubID;
			col = contactName;
		}
		/**
		 * Sets the Phone Number from a Table
		 * @param col A given position within a 2d array table
		 */
		public void setPhoneNumber(String col) {
			//return pubID;
			col = phoneNumber;
		}
		/**
		 * Sets the Company's Photo from a Table
		 * @param col A given position within a 2d array table
		 */
		public void setCompanyPhoto(ImageIcon col) {
			//return pubID;
			col = CompanyPhotoPath;
		}
		/**
		 * Sets the Contact's Photo from a Table
		 * @param col A given position within a 2d array table
		 */
		public void setContactPhoto(ImageIcon col) {
			//return pubID;
			col = ContactPhotoPath;
		}
			
	}
		