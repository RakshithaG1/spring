package one;


import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.mysql.jdbc.Driver;


public class Register extends HttpServlet {
	
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Connection con=null;
		PreparedStatement pmt=null;
		PrintWriter out = response.getWriter();

		try {
		
			Class.forName("com.mysql.cj.jdbc.Driver");
		    con=DriverManager.getConnection("jdbc:mysql://localhost:3306/mysql","root","Ganesha7#");
			pmt=con.prepareStatement("insert into userdetails values(?,?,?,?,?)");
			pmt.setString(1, request.getParameter("fname"));
			pmt.setString(2, request.getParameter("lname"));
			pmt.setString(3, request.getParameter("uname"));
			pmt.setString(4, request.getParameter("email"));
			pmt.setString(5, request.getParameter("pass"));
			int res=pmt.executeUpdate();
			System.out.println("called exe");
		
			if (res!=0) {
				response.sendRedirect("login");//login page 
				System.out.println("Result Out");
			}else {
				out.println("Not Registered Try Again");
			}
			
			if (con!=null) {
				con.close();
			}
			if (pmt!=null) {
				pmt.close();
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
