import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class NetbankServlet
extends HttpServlet {
    public void service(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse) throws IOException, ServletException {
        httpServletResponse.setContentType("text/html");
        String string = httpServletRequest.getParameter("cardno");
        String string2 = httpServletRequest.getParameter("bankname");
        String string3 = httpServletRequest.getParameter("name");
        ServletContext servletContext = this.getServletContext();
        PrintWriter printWriter = httpServletResponse.getWriter();
        printWriter.println("<html><body>");
        try {
            Connection connection = (Connection)servletContext.getAttribute("con");
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery("select * from bank where cardno = '" + string + "' and name='" + string3 + "'");
            if (resultSet.next()) {
                printWriter.println("<html><body><h1>Thank You for Buying. Happy Shopping!!!!!</h1></body></html>");
                printWriter.println("<html><body><h2>Payment Completed!!!!!</h2></body></html>");
                httpServletResponse.setHeader("Refresh", "4;welcome.html");
            } else {
                printWriter.println("<html><body><h2>Invalid Details Try Again!!!</h2></body></html>");
                httpServletResponse.setHeader("Refresh", "3;netbank.html");
            }
        }
        catch (Exception var8_9) {
            printWriter.println(var8_9);
        }
        printWriter.println("</html></body>");
    }
}