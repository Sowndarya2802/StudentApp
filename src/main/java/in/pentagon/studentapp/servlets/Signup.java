package in.pentagon.studentapp.servlets;

import java.io.IOException;
import java.io.PrintWriter;

import in.pentagon.studentapp.dao.StudentDAO;
import in.pentagon.studentapp.dao.StudentDAOImpl;
import in.pentagon.studentapp.dto.Student;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;


@WebServlet("/signup")
public class Signup extends HttpServlet{
	    @Override
	    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

	        // creating the object of POJO class
	        Student s = new Student();

	        // creating ref object of StudentDAO
	        StudentDAO sdao = new StudentDAOImpl();

	        // Creating PrintWriter class object
	        //PrintWriter out = resp.getWriter(); //prinnt writer is abstract class-->getwriter is present in reposence object

	        // collecting the data from the UI
	        
	        //String name=req.getparameter("name");
	        //s.setName(name);
	        s.setName(req.getParameter("name")); //here we are storing the name value in student object
	        //so here we use long of wrpper class and it has a methpod parseLong-->it will take string value and return long value
	        s.setPhone(Long.parseLong(req.getParameter("phone")));  //here geetparametre returns a string value but we need phone in long
	        s.setMail(req.getParameter("mail"));
	        s.setBranch(req.getParameter("branch"));
	        s.setLoc(req.getParameter("loc"));

	        // checking password and confirm password
	        if (req.getParameter("password").equals(req.getParameter("confirm"))) 
	        {
	            s.setPassword(req.getParameter("password"));
	           
	            
	            boolean res = sdao.insertStudent(s);

	            if (res) {
	                //out.println("<h1>Data added successfully!</h1>");//print writer is used heree to print the out so the referce var is used
	            	req.setAttribute("success","data added successfully!");
	            	RequestDispatcher rd=req.getRequestDispatcher("login.jsp");
	            	rd.forward(req, resp);
	            	
	            
	            } else {
	                //out.println("<h1>Failed to signup!</h1>");
	            	req.setAttribute("error","Failed to signup!");
	            	RequestDispatcher rd=req.getRequestDispatcher("signup.jsp");
	            	rd.forward(req, resp);
	            }
	        }
	        else {
	           // out.println("<h1>Password mismatch!</h1>");
	        	req.setAttribute("error","password mismatch");
            	RequestDispatcher rd=req.getRequestDispatcher("password.jsp");
            	rd.forward(req, resp);
	        	
	        }
	    }
	}


