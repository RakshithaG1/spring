package one;


import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


public class Login extends HttpServlet {

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		String form = "<HTML><BODY><form action='auth' method='post'>"
				+"<h2>Login Here</h2>"
				+"<input typ='text' name='uid' placeholder='UserName'/><br/><br/>"
				+"<input typ='text' name='passwd' placeholder='Password'/><br/><br/>"
				+ "<input type='submit' value='Login'/></form>"
				+ "</BODY></HTML>";
		PrintWriter out = response.getWriter();
		out.write(form);

	}
}
