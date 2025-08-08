package in.pentagon.studentapp.dao;

import java.util.ArrayList;

import in.pentagon.studentapp.dto.Student;

public interface StudentDAO {
	//jdbc declarations
	public boolean insertStudent(Student s);  //the agru will be taken as object here student is object
	public boolean updateStudent(Student s);
	public boolean deleteStudent(int id);
	public Student getStudent(String mail,String password);//login
	public Student getStudent(long phone,String mail);   //for forget password
	public ArrayList<Student> getStudent(String name);  //arraylist is used if multiple same name is there it will be stored in arraylist 
	public ArrayList<Student> getStudent();  //for select * from Students all values taken so default const

}
