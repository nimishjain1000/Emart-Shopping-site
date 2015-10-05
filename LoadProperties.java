import java.io.FileInputStream;
import java.io.InputStream;
import java.io.PrintStream;
import java.util.Enumeration;
import java.util.Properties;

public class LoadProperties {
    public static void propLoad(String string) {
        try {
            FileInputStream fileInputStream = new FileInputStream(string);
            Properties properties = new Properties();
            properties.load(fileInputStream);
            Enumeration enumeration = properties.propertyNames();
            while (enumeration.hasMoreElements()) {
                String string2 = (String)enumeration.nextElement();
                String string3 = properties.getProperty(string2);
                System.setProperty(string2, string3);
                System.out.println(string2 + " : " + string3);
            }
        }
        catch (Exception e) {
            
        }
    }
}