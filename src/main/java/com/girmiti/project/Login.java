package com.girmiti.project;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletContext;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
@WebServlet("/Login")
public class Login extends HttpServlet {
	private static final long serialVersionUID = 1L;


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		PrintWriter pw=response.getWriter();
		String user=request.getParameter("username");
		String psw=request.getParameter("password");
		
		try {
			Class.forName("com.mysql.jdbc.Driver");
			Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/vamsi","root","Vamsi08@");
			Statement stmt=con.createStatement();
			
			String Query="insert into login values('"+user+"','"+psw+"')";
			stmt.executeUpdate(Query);
			con.close();
		}
		
		catch(Exception e) {e.printStackTrace();
		}
		// Get the response object
		try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();

		// Write the success message to the response
		out.println("<html><body>");
		out.println("<h2>Login Successful!</h2>");
		out.println("</body></html>");
		out.println("Back to homepage");
		out.println("<a href='index.html'>HomePage</a>");
		//RequestDispatcher rd=request.getRequestDispatcher("index.html");
		//rd.include(request, response);

	}
	}
//Login autherization.

