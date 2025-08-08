package in.pentagon.studentapp.dto;

public class Student {
	//create instance variable 
	//pojo class
	//for encapsulation the instance variables should be private
	
	private String name;
	private long phone;
	private String mail;
	private String branch;
	private String loc;
	private String password;
	private String date;
	private int id;
	
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public long getPhone() {
		return phone;
	}
	public void setPhone(long phone) {
		this.phone = phone;
	}
	public String getMail() {
		return mail;
	}
	public void setMail(String mail) {
		this.mail = mail;
	}
	public String getBranch() {
		return branch;
	}
	public void setBranch(String branch) {
		this.branch = branch;
	}
	public String getLoc() {
		return loc;
	}
	public void setLoc(String loc) {
		this.loc = loc;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getDate() {
		return date;
	}
	public void setDate(String date) {
		this.date = date;
	}
	
	 
	@Override     //rightclick--source--genreate tostring--then select whatevr u want  --we are dng this to print the 
	public String toString() {
		return "Student [name=" + name + ", phone=" + phone + ", mail=" + mail + ", branch=" + branch + ", loc=" + loc
				+ ", id=" + id + "]";
	}
	
}
