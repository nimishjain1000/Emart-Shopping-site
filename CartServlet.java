import javax.servlet.http.*;
import javax.servlet.*;
import java.sql.*;
import java.io.*;
public class CartServlet extends HttpServlet
{
		public void service(HttpServletRequest req,HttpServletResponse res)throws ServletException,IOException
		{

		res.setContentType("text/html");
		PrintWriter out=res.getWriter();
		HttpSession session=req.getSession(false);//this ensures the session is used which is created 
		if(session!=null)
		{String watches[]=(String[])session.getAttribute("watches");
	     String cars[]=(String[])session.getAttribute("cars");
	     String mobiles[]=(String[])session.getAttribute("mobiles");
	     String laptops[]=(String[])session.getAttribute("laptops");
	     String men[]=(String[])session.getAttribute("men");
	     String women[]=(String[])session.getAttribute("women");
		 
		 out.println("<html><body>");
		 out.println("<table bg color='yello' border =1 width=400");
		 
			if(mobiles!=null)
			{
				out.println("<tr>");
				for(int i=0;i<mobiles.length;i++)
					out.println("<td>"+mobiles[i]+"</td>");
				out.println("</tr>");
			}
	     
		 	if(laptops!=null)
			{
				out.println("<tr>");
				for(int i=0;i<mobiles.length;i++)
					out.println("<td>"+laptops[i]+"</td>");
				out.println("</tr>");
			}
			
				if(watches!=null)
			{
				out.println("<tr>");
				for(int i=0;i<mobiles.length;i++)
					out.println("<td>"+watches[i]+"</td>");
				out.println("</tr>");
			}
	     
		 	if(cars!=null)
			{
				out.println("<tr>");
				for(int i=0;i<mobiles.length;i++)
					out.println("<td>"+cars[i]+"</td>");
				out.println("</tr>");
			}
			
				if(men!=null)
			{
				out.println("<tr>");
				for(int i=0;i<mobiles.length;i++)
					out.println("<td>"+men[i]+"</td>");
				out.println("</tr>");
			}
	     
	     	if(women!=null)
			{
				out.println("<tr>");
				for(int i=0;i<mobiles.length;i++)
					out.println("<td>"+women[i]+"</td>");
				out.println("</tr>");
			}
	     
		 out.prinln("</table>");
		 out.println("<br><br><a href='netbank.html'><input type ='submit' value= 'back'/></a>");
		}
		else
		{
			RequestDispatcher rd=getRequestDispatcher("/index.html");
			rd.forward(req,res);
		}
		}	
	 
}	 