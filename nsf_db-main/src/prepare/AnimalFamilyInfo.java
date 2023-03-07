package prepare;

public class AnimalFamilyInfo {
	String subjId;
	String momId;
	String dadId;
	String sex;
	String founderId;
	int pedigree;
	int siblingNo;
	String dob;
	String bGroup;
	String unicode;

	public AnimalFamilyInfo(String founderId, String subjId) {
		this.subjId = subjId;
		this.founderId = founderId;
		sex = "f";
		pedigree = 1;
		unicode = founderId;
	}

	public AnimalFamilyInfo(String subjId, String momId, String dadId, 
			String sex, String dob, String bGroup, String unicode) {
		this.subjId = subjId;
		this.momId = momId;
		this.dadId = dadId;
		this.sex = sex;
		this.dob = dob;
		this.bGroup = bGroup;
		this.unicode = unicode;
	}
	
	public String toString() {
		String s = subjId;
		return  s + "," + momId + "," + dadId + "," + bGroup + "," + dob + 
				"," + sex + "," + founderId + "," + pedigree + 
				"," + siblingNo + "," + unicode;
	}

	public void setFounderId(String familyId) {
		// TODO Auto-generated method stub
		this.founderId = familyId;
	}

	public void setSiblingNo(Integer integer) {
		this.siblingNo = integer;
		
	}

	public void setPedigree(Integer integer) {
		// TODO Auto-generated method stub
		this.pedigree = integer;
	}

	public String getAnimalId() {
		// TODO Auto-generated method stub
		return subjId;
	}

	public String getMomId() {
		// TODO Auto-generated method stub
		return momId;
	}

	public String getGender() {
		// TODO Auto-generated method stub
		return this.sex;
	}

	public String getUnicode() {
		// TODO Auto-generated method stub
		return unicode;
	}
	
	public String getDadID() {
		// TODO Auto-generated method stub
		return dadId;
	}

}
