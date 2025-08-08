package in.pentagon.studentapp.dao;

//write jdbc logic here

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import in.pentagon.studentapp.connection.Connector;
import in.pentagon.studentapp.dto.Student;

public class StudentDAOImpl implements StudentDAO{
	private Connection con;
	
	public StudentDAOImpl() {
			this.con = Connector.requestConnection();
		}

//Add unimplemented methods
	@Override
	public boolean insertStudent(Student s) {
		int i=0;
		PreparedStatement ps=null;
		String query="INSERT INTO STUDENTS VALUES(0,?,?,?,?,?,?,SYSDATE())";
		try {
			ps=con.prepareStatement(query);
			ps.setString(1,s.getName());
			ps.setLong(2, s.getPhone());
			ps.setString(3,s.getMail());
			ps.setString(4,s.getBranch());
			ps.setString(5,s.getLoc());
			ps.setString(6,s.getPassword());
			i=ps.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		if(i>0) {
			return true;
		}
		else {
			return false;
		}
	}

	@Override
	public boolean updateStudent(Student s) {
		PreparedStatement ps=null; 
		String query="UPDATE STUDENTS SET NAME=?, PHONE=?, MAIL=?, BRANCH=?, LOC=?, PASSWORD=?, DATE=SYSDATE() WHERE ID=?";
		int i=0;
		try { 
		ps=con.prepareStatement(query); 
		ps.setString(1,s.getName()); 
		ps.setLong(2,s.getPhone()); 
		ps.setString(3, s.getMail()); 
		ps.setString(4,s.getBranch()); 
		ps.setString(5,s.getLoc());
		ps.setString(6, s.getPassword());
		ps.setInt(7, s.getId());
		i=ps.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		if(i>0) {
		return true;
		}
		else {
			return false;
		}
	}

	@Override
	public boolean deleteStudent(int id) {
		PreparedStatement ps=null; 
		int i=0;
		String query="DELETE FROM STUDENTS WHERE ID=?";
		try {
			ps=con.prepareStatement(query);
			ps.setInt(1,id);
			i=ps.executeUpdate();
		
		} catch (SQLException e) {
			e.printStackTrace();
		}
		if(i>0) {
			return true;
		}
		else {
			return false;
		}
	}
		
	

	@Override
	public Student getStudent(String mail, String password) {
		PreparedStatement ps=null;
		Student s=null;
		String query="SELECT * FROM STUDENTS WHERE MAIL=? AND PASSWORD=?";
		try {
			ps=con.prepareStatement(query);
			ps.setString(1, mail);
			ps.setString(2, password);
			ResultSet rs=ps.executeQuery();
			while(rs.next()) {
				s=new Student();
				//int id=rs.getInt("id");
				//s.setId(id);
				s.setId(rs.getInt("id"));
				s.setName(rs.getString("name"));
				s.setPhone(rs.getLong("phone"));
				s.setMail(rs.getString("mail"));
				s.setBranch(rs.getString("branch"));
				s.setLoc(rs.getString("loc"));
				s.setPassword(rs.getString("password"));
				s.setDate(rs.getString("date"));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return s;
	}

	@Override
	public Student getStudent(long phone, String mail) {
		PreparedStatement ps=null;
		Student s=null;
		String query="SELECT * FROM STUDENTS WHERE PHONE=? AND MAIL=?";
		try {
			ps=con.prepareStatement(query);
			ps.setLong(1,phone); 
			ps.setString(2, mail); 
			ResultSet rs=ps.executeQuery();
			while(rs.next()) {
				s=new Student();
				s.setId(rs.getInt("id"));
				s.setName(rs.getString("name"));
				s.setPhone(rs.getLong("phone"));
				s.setMail(rs.getString("mail"));
				s.setBranch(rs.getString("branch"));
				s.setLoc(rs.getString("loc"));
				s.setPassword(rs.getString("password"));
				s.setDate(rs.getString("date"));
			}
		
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return s;
	}

	@Override
	public ArrayList<Student> getStudent(String name) {
		ArrayList<Student> studList=new ArrayList<>();  //why? cos when u have multiple names we need to returb multiple ojects so arraylist
		Student s=null;
		String query="SELECT * FROM STUDENTS WHERE NAME=?";
		PreparedStatement ps=null;
		try {
			ps=con.prepareStatement(query);
			ps.setString(1, name);
			ResultSet rs=ps.executeQuery();
			while(rs.next()) {
				s=new Student();
				s.setId(rs.getInt("id"));
				s.setName(rs.getString("name"));
				s.setPhone(rs.getLong("phone"));
				s.setMail(rs.getString("mail"));
				s.setBranch(rs.getString("branch"));
				s.setLoc(rs.getString("loc"));
				s.setPassword(rs.getString("password"));
				s.setDate(rs.getString("date"));
				studList.add(s);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return studList;
	}

	@Override
	public ArrayList<Student> getStudent() {
		ArrayList<Student> studentList=new ArrayList<>();
		Student s=null;
		String query="SELECT * FROM STUDENTS";
		PreparedStatement ps=null;
		try {
			ps=con.prepareStatement(query);
			ResultSet rs=ps.executeQuery();
			while(rs.next()) {
				s=new Student();
				s.setId(rs.getInt("id"));
				s.setName(rs.getString("name"));
				s.setPhone(rs.getLong("phone"));
				s.setMail(rs.getString("mail"));
				s.setBranch(rs.getString("branch"));
				s.setLoc(rs.getString("loc"));
				s.setPassword(rs.getString("password"));
				s.setDate(rs.getString("date"));
				studentList.add(s);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return studentList;
	}

}