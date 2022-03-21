package one;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;


/**
 * Servlet implementation class Auth
 */
@WebServlet("/auth")
public class Authorization extends HttpServlet {

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("Inside Auth");
		String uname=request.getParameter("uid");
		String pass=request.getParameter("passwd");
		if (DataClass.dbCheck(uname,pass)) {
			System.out.println("Login Successfull");
			HttpSession sn=request.getSession();
			sn.setAttribute("username", uname);//set session attribute
			response.sendRedirect("uinfo");
		} else {
			response.sendRedirect("dis");
		}
		System.out.println(request.getParameter("uid")+" "+request.getParameter("passwd"));
	}
}
