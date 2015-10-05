import javax.servlet.http.*;
import javax.servlet.*;
import java.sql.*;
import java.io.*;
public class RegisterFilter implements Filter
{
FilterConfig config;
	public void init(FilterConfig config)throws ServletException
	{this.config=config;
	
	}
	public void doFilter(ServletRequest req,ServletResponse res,FilterChain chain)throws ServletException,IOException
	{
	  PrintWriter out=res.getWriter();
      String userId=req.getParameter("userId");
      String pass=req.getParameter("pass");
	  String repass=req.getParameter("repass");
	  if(pass.equals(repass))
	  {
	  ServletContext ctx=config.getServletContext();
	  
			try{
			Connection c=(Connection)ctx.getAttribute("con");// getting connection via web.xml
			Statement s=c.createStatement();
			ResultSet rs=s.executeQuery("select * from cust where userId='"+userId+"' and pass='"+pass+"'");
				
				if(rs.next())
				{
				chain.doFilter(req,res); //if the user is alreadfy exixt then it send control to next page otherwise create new account
				}
				else
				{
				int x= s.executeQuery("insert into cust values('"+userId+"','"+pass+"','F')");
				out.prinln("<html><body><br><h1>Registered succesfully!!!-> LOGIN NOW </h1>");
				out.println("<b><h2> LOGIN PAGE RELOADING .....</h2>");
				HttpServletResponse rss= (HttpServletResponse)res;
				rss.setHeader("Refresh","4;index.html");
				
				}
				
			} catch(Exception e)
			{
				out.prinln(e);
			}
	  }
	  else{
		  out.prinln("<html><body><br><h1> password re-entered did not match</h1>");
		  out.prinln("<br><h2>REGISTRATION PAGE RELOADING .....</h2>");
		  HttpServletResponse rss= (HttpServletResponse)res;
				rss.setHeader("Refresh","4;register.html");
	  }
	  
	
	}
	public void destroy()
	{
		//
	}
	
	
}

