import javax.servlet.http.*;
import javax.servlet.*;
import java.sql.*;
import java.io.*;
public class LogoutServlet extends HttpServlet
{
		public void service(HttpServletRequest req,HttpServletResponse res)throws ServletException,IOException
		{
		res.setContentType("text/html");
		PrintWriter out=res.getWriter();
		
		req.getRequestDispatcher("/welcome.html").forward(req,res);
		HttpSession session =req.getSession();
		session.invalidate();
		out.println("you are succesfully logged out");
		out.close();
		}
}
		
