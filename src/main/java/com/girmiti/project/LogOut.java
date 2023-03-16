package com.girmiti.project;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import java.io.IOException;
import java.io.PrintWriter;
@WebServlet("/LogOut")
public class LogOut extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		 response.setContentType("text/html");  
         PrintWriter out=response.getWriter();  
        //  RequestDispatcher rd=request.getRequestDispatcher(request,response);
         request.getRequestDispatcher("index.html").include(request, response);  
           
         HttpSession session=request.getSession();  
         session.invalidate();
           
         out.print("You are successfully logged out!");  
           
         out.close();  
	}

	
	
	    


}
