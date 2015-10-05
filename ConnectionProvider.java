import java.sql.Connection;
import java.sql.DriverManager;

public class ConnectionProvider {
    public static Connection con = null;

    public static Connection getConn() {
        if (con == null) {
            try {
                String string = System.getProperty("driver");
                String string2 = System.getProperty("url");
                String string3 = System.getProperty("user");
                String string4 = System.getProperty("pass");
                Class.forName(string);
                con = DriverManager.getConnection(string2, string3, string4);
            }
            catch (Exception e) {
                // empty catch block
            }
        }
        return con;
    }
}