package com.girmiti.project;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;
@WebServlet("/SignUp")
public class SignUp extends HttpServlet {
	private static final long serialVersionUID = 1L;
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		//PrintWriter pw=response.getWriter();
		String username=request.getParameter("username");
		String email=request.getParameter("email");
		String password=request.getParameter("password");
		String confrompsw=request.getParameter("confirmpassword");
		String mobile=request.getParameter("phone");
		
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/vamsi","root","Vamsi08@");
			Statement stmt=con.createStatement();
			String Query="insert into signup values('"+username+"','"+email+"','"+password+"','"+confrompsw+"','"+mobile+"')";
			stmt.executeUpdate(Query);
			con.close();
		}catch(Exception e) {
			e.printStackTrace();
		}
		PrintWriter out=response.getWriter();
		out.println("<html><body>");
		out.println("<h2>Your Registration is Successful!</h2>");
		out.println("</body></html>");
		out.println("Back to homepage");
		out.println("<a href='index.html'>HomePage</a>");
	}

}	
