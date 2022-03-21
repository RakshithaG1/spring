package one;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class Test3
 */
@WebServlet("/dis")
public class Display extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
 
    public Display() {
        super();
        // TODO Auto-generated constructor stub
    }

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		System.out.println("Inside Test3");
		response.getWriter().println("<html><h1>Login Un-Successfull Please Check Username & PassWord</h1></html>");
		RequestDispatcher rd=request.getRequestDispatcher("login");
		rd.include(request, response);
	}
}
