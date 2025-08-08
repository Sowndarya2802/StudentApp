package in.pentagon.studentapp.index;

import java.util.Scanner;

import in.pentagon.studentapp.dao.StudentDAO;
import in.pentagon.studentapp.dao.StudentDAOImpl;
import in.pentagon.studentapp.dto.Student;

public class Update {
	public static void update(Student s) {
		Scanner sc=new Scanner(System.in);
		StudentDAO sdao=new StudentDAOImpl();
		System.out.println("<--Update account-->");
		int choice=0;
		boolean res=false;
		do {
			System.out.println("enter the fields to be updated");
			System.out.println("1.Name");
			System.out.println("2.Phone");
			System.out.println("3.mail Id");
			System.out.println("4.Branch");
			System.out.println("5.Location");
			System.out.println("6.Go back to Dashboard");
			choice =sc.nextInt();
			
			switch(choice) {
			case 1:System.out.println("Enter the new name");
			s.setName(sc.next());
			break;
			case 2:System.out.println("Enter the new phone");
			s.setPhone(sc.nextLong());
			break;
			case 3:System.out.println("Enter the new mail id");
			s.setMail(sc.next());
			break;
			case 4:System.out.println("Enter the new branch");
			s.setBranch(sc.next());
			break;
			case 5:System.out.println("Enter the new location");
			s.setLoc(sc.next());
			break;
			case 6:System.out.println("dashboard is loading....!");
			break;
			default:System.out.println("Invalid choice,please enter the valid choice");
			break;
			}
			res=sdao.updateStudent(s);
			if(res) {
				System.out.println("account updated succesfully");
			}
			
			else {
				System.out.println("update failed");
			}
				
		
		}while(choice!=6);	
	}
}
