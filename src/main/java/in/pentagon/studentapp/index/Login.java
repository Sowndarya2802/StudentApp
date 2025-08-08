package in.pentagon.studentapp.index;

import java.util.ArrayList;
import java.util.Scanner;

import in.pentagon.studentapp.dao.StudentDAO;
import in.pentagon.studentapp.dao.StudentDAOImpl;
import in.pentagon.studentapp.dto.Student;

public class Login {
	public static void login() {
		int choice;
		Scanner sc=new Scanner(System.in);
		StudentDAO sdao=new StudentDAOImpl();
		System.out.println("<--Login Page-->");
		System.out.println("Enter the mail:");
		String mail=sc.next();
		System.out.println("Enter the password:");
		String pass=sc.next();
		Student a=sdao.getStudent(mail,pass);
		if(a!=null) {
			System.out.println("Login Succesfull, Welcome "+a.getName());
			do {
				System.out.println("1. View Data");
				System.out.println("2. Search Users");
				System.out.println("3. Update account");
				System.out.println("4. Reset Password");
				System.out.println("5. Back to main menu");
				if(a.getId()==1) {                      //admin the first data student first line
					System.out.println("6. View All users");
					System.out.println("7. Delete the user");
				}
				choice = sc.nextInt();
				switch(choice) {
				case 1: System.out.println(a);
				break;
				case 2: System.out.println("Enter the name:");  //search user logic -Assignment
				        String name=sc.next();
					    ArrayList<Student> sr=sdao.getStudent(name);
					    for(Student s:sr) {
					    	System.out.println("Student id:"+s.getId());
					    	System.out.println("Student name:"+s.getName());
					    	System.out.println("Student branch:"+s.getBranch());
					    	System.out.println("Student loc:"+s.getLoc());
					    	System.out.println("-------------------------------------");
					    }
				break;
				case 3: Update.update(a);  //the person who logged in  //completed filled object "a"
				break;
				case 4: Password.reset(a);  //here also the person who logged in is getting reset
				break;
				case 5: System.out.println("Going back to main menu");
				break;
				case 6: System.out.println("....Our Users....");
				        ArrayList<Student> sL=sdao.getStudent();
				        for(Student s:sL) {
				        	System.out.println(s);
				        }
				break;
				case 7: System.out.println("enter the student id");
						int id=sc.nextInt();
						boolean res=sdao.deleteStudent(id);
						if(res) {
							System.out.println("student details deleted succcessfully");
						}
						else {
							System.out.println("delete failed");
						}
				
				break;
				default: System.out.println("Invalid Choice");
				}
			}while(choice!=5);
		}
		else {
			System.out.println("Failed to Login");
		}
	}
}