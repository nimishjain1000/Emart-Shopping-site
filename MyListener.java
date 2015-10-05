import java.io.PrintStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;
import javax.servlet.ServletContext;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.http.HttpSession;
import javax.servlet.http.HttpSessionEvent;
import javax.servlet.http.HttpSessionListener;

public class MyListener
implements HttpSessionListener,
ServletContextListener {
    public void sessionCreated(HttpSessionEvent httpSessionEvent) {
        HttpSession httpSession = httpSessionEvent.getSession();
    }

    public void sessionDestroyed(HttpSessionEvent httpSessionEvent) {
        System.out.println("SEssion destroying...");
        HttpSession httpSession = httpSessionEvent.getSession();
        ServletContext servletContext = httpSession.getServletContext();
        String string = (String)httpSession.getAttribute("userId");
        String string2 = (String)httpSession.getAttribute("pass");
        System.out.println(string + "  : " + string2);
        try {
            Connection connection = (Connection)servletContext.getAttribute("con");
            Statement statement = connection.createStatement();
            statement.executeUpdate("update cust set loginStatus='F' where userId = '" + string + "' and pass = '" + string2 + "'");
        }
        catch (Exception e) {
            System.out.println(e);
        }
    }

    public void contextInitialized(ServletContextEvent servletContextEvent) {
        try {
            ServletContext servletContext = servletContextEvent.getServletContext();
            String string = servletContext.getInitParameter("driver");
            String string2 = servletContext.getInitParameter("url");
            String string3 = servletContext.getInitParameter("user");
            String string4 = servletContext.getInitParameter("pass");
            Class.forName(string);
            Connection connection = DriverManager.getConnection(string2, string3, string4);
            servletContext.setAttribute("con", (Object)connection);
            System.out.println("Context Created");
        }
        catch (Exception e) {
            System.out.println(e);
        }
    }

    public void contextDestroyed(ServletContextEvent servletContextEvent) {
    }
}