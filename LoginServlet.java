import javax.servlet.http.*;
import javax.servlet.*;
import java.sql.*;
import java.io.*;
public class LoginServlet extends HttpServlet
{
		public void service(HttpServletRequest req,HttpServletResponse res)throws ServletException,IOException
		{
		String userId=req.getParameter("userId");
		String pass=req.getParameter("pass");
		
		res.setContentType("text/html");
		PrintWriter out=res.getWriter();
		
		try
		{
		HttpSession session=req.getSession();
		session.setAttribute("userId",userId);
		session.setAttribute("pass",pass);
		
		
		}
		catch(Exception e)
		{out.println(e);
		
		
		}
		}
}
		