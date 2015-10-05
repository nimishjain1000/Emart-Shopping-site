import javax.servlet.http.*;
import javax.servlet.*;
import java.sql.*;
import java.io.*;
public class RegisterServlet extends HttpServlet
{
		public void service(HttpServletRequest req,HttpServletResponse res)throws ServletException,IOException
		{
		res.setContentType("text/html");
		PrintWriter out=res.getWriter();
		out.println("<html><body><h1>user already exist</h1>");
		out.println("<br><h2>
		reloading registration page "</h2></body></html>);
		res.setHeader("Refresh",4;register.html);
		
		}
}