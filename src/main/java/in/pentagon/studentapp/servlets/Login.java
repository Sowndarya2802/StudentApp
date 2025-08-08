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
import jakarta.servlet.http.HttpSession;

@WebServlet("/login")
public class Login extends HttpServlet{
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		StudentDAO sdao=new StudentDAOImpl();
		//creation of new session object
		HttpSession session=req.getSession(true);
		//PrintWriter out=resp.getWriter();
		Student s=sdao.getStudent(req.getParameter("mail"),req.getParameter("password"));
	
		if(s!=null) {
			//out.println("<h1>Login Successful</h1>");
			//req.setAttribute("student",s);
			session.setAttribute("student",s);  //storing in session object so it can be carried out till logout
			req.setAttribute("success", "login succesfull!");  //message displayed only once
			RequestDispatcher rd=req.getRequestDispatcher("dashboard.jsp");
			rd.forward(req, resp);
		}
		else {
			//out.println("<h1>Failed to login</h1>");
			req.setAttribute("error","failed to login");
			RequestDispatcher rd=req.getRequestDispatcher("login.jsp");
			rd.forward(req, resp);
		}
	}
}
