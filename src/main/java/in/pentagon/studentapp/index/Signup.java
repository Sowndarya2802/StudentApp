package in.pentagon.studentapp.index;

import java.util.Scanner;

import in.pentagon.studentapp.dao.StudentDAO;
import in.pentagon.studentapp.dao.StudentDAOImpl;
import in.pentagon.studentapp.dto.Student;

public class Signup {
	public static void signup() {
		Scanner sc=new Scanner(System.in);
		StudentDAO sdao=new StudentDAOImpl();//creating implementa
		//creating POJO class object
		Student s=new Student();
		System.out.println("<--Student Signup-->");
		System.out.println("Enter the name");
		//String name=sc.next();    old method
		//s.setname(name);
		s.setName(sc.next());   //short method
		System.out.println("Enter the phone");
		s.setPhone(sc.nextLong());
		System.out.println("Enter the mail");
		s.setMail(sc.next());
		System.out.println("Enter the branch");
		s.setBranch(sc.next());
		System.out.println("Enter the location");
		s.setLoc(sc.next());
		System.out.println("Enter the password");
		String password=sc.next();
		System.out.println("Enter the confirm password");
		String confirmpassword=sc.next();
		if(password.equals(confirmpassword)) {
			s.setPassword(confirmpassword);
			boolean res=sdao.insertStudent(s);
			if(res) {
				System.out.println("data added successfully");
			}
			else {
				System.out.println("failed to create account");
			}
		}
		else {
			System.out.println("password mismatch");
		}
	}

}
