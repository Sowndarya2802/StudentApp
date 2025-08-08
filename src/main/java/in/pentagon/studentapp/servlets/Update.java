package in.pentagon.studentapp.servlets;

import jakarta.servlet.RequestDispatcher;

public class Update {
	
	
	if(res) {
		req.setAttribute("success","Account updated successfully");
		RequestDispatcher rd=req.getrequestDispatcher("dasboard.jsp");
		rd.forward(req, res);
	}
	else {
		
	}

}
