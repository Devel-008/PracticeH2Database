import java.sql.Connection;
import java.sql.DriverManager;

public class ExampleH2 {
    public static void main(String[] args) {
        try{
            Class.forName("org.h2.Driver").newInstance();
            Connection connection = DriverManager.getConnection("jdbc:h2");
        }catch (Exception e){
            System.out.println("YAHAN ERROR HAI"+e);
        }


    }
}
