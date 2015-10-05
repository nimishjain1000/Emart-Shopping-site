import ConnectionProvider;
import java.io.FileInputStream;
import java.io.PrintStream;
import java.sql.Connection;
import java.sql.Statement;
import java.util.StringTokenizer;

public class TableCreate {
    public static void createTab(String string) {
        try {
            FileInputStream fileInputStream = new FileInputStream(string);
            byte[] arrby = new byte[fileInputStream.available()];
            fileInputStream.read(arrby);
            fileInputStream.close();
            String string2 = new String(arrby);
            StringTokenizer stringTokenizer = new StringTokenizer(string2, "/");
            Connection connection = ConnectionProvider.getConn();
            Statement statement = connection.createStatement();
            while (stringTokenizer.hasMoreTokens()) {
                String string3 = stringTokenizer.nextToken();
                if (!string3.trim().equals("stop")) {
                    statement.executeUpdate(string3);
                    System.out.println(string3);
                    continue;
                } else {
                    break;
                }
            }
        }
        catch (Exception e) {
            System.out.println(e);
        }
    }
}