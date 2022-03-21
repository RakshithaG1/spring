package one;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class UserInfo
 */
@WebServlet("/uinfo")
public class UserDetails extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    
    public UserDetails() {
        super();
        // TODO Auto-generated constructor stub
    }

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		PrintWriter pw=response.getWriter();
	    String userName= (String) request.getSession().getAttribute("username");//get session attr
		ResultSet set=DataClass.getData(userName);
		String fname=null;
		String lname=null;
		String email=null;
		try {
			if (set.next()) {
				fname=set.getString("firstname");
				lname=set.getString("lnamename");
				email=set.getString("email");
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		pw.println("<html>"
				+"<body>"
				+"<h1> HELLO!!!: "+userName+"</h1>"
				+"<h3> FisrtName: "+fname+"</h3>"
				+"<h3> LastName: "+lname+"</h3>"
				+"<h3> Email: "+email+"</h3>"
				+"</body>"
				+ "</html>");
	}

	

}
