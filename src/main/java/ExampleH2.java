import java.sql.*;

public class ExampleH2 {
    public static void main(String[] args) {
        String url = "jdbc:postgresql://localhost:5432/reportcard";
        String user="postgres";
        String password="isha@123";
        ExampleH2 obj = new ExampleH2();

        Connection connection = null;
        Connection connect;
        try{
            Class.forName("org.h2.Driver");
            connection = DriverManager.getConnection("jdbc:h2:tcp://localhost/~/test","sa","");

            obj.select(connection);
        }catch (Exception e){
            System.out.println("YAHAN ERROR HAI:= "+e);
        }finally {
                try {
                    assert connection != null;
                    connection.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
        }
        try{
            Class.forName("org.postgresql.Driver");
            connect = DriverManager.getConnection(url,user,password) ;
            obj.selection(connect);
        }catch (Exception e){
            System.out.println(e);
        }
        finally {
            System.out.println();
        }
    }
    public void select(Connection connection){
        String query = "Select * from student";
        try {
            Statement statement = connection.createStatement();
            ResultSet rs = statement.executeQuery(query);
            while(rs.next()){
                int id = rs.getInt("rollno");
                String name = rs.getString("Fullname");
                String address = rs.getString("Fathername");
                String dob = rs.getString("dob");
                float english =rs.getFloat("english");
                float hindi = rs.getFloat("hindi");
                float maths = rs.getFloat("maths");
                float science = rs.getFloat("science");
                float social = rs.getFloat("social");
                float percentage = rs.getFloat("percentage");

                System.out.println("ID:="+id+" | NAME:"+name+" | ADDRESS:"+address+" | DOB:"+dob+" | ENGLISH:"+english+" | HINDI:"+hindi+" | MATHS:"+maths+" | SCIENCE:"+science+" | SOCIAL:"+social+"PERCENTAGE:"+percentage);
            }
        }catch (Exception e){
            System.out.println("ERROR: "+e);
        }
    }
    public void selection(Connection connect) {
        int count = 0;
        try {
            Statement s1 = connect.createStatement();
            String se = "select * from student";
            ResultSet rs = s1.executeQuery(se);
            while (rs.next()) {
                System.out.print("Roll-No:" + rs.getInt("rollno") + " ");
                System.out.print(", Name: " + rs.getString("fullname") + " ");
                System.out.print(", Father's name: " + rs.getString("fathername"));
                System.out.println(", Address: " + rs.getString("address") + " ");
                System.out.print(", Date-of-Birth: " + rs.getString("dob") + " ");
                System.out.print(", English: " + rs.getFloat("english") + " ");
                System.out.print(", Maths: " + rs.getFloat("maths") + " ");
                System.out.print(", Science: " + rs.getFloat("science") + " ");
                System.out.println(", Social Science: " + rs.getFloat("social") + " ");
                System.out.print(", Percentage: " + rs.getFloat("percentage") + " ");
                System.out.println(" ");
                count++;
            }
            if (count <= 0) {
                System.out.println("No data available");
            }
            rs.close();
            s1.close();
            connect.close();
        } catch (Exception e) {
            System.out.println("ERROR:=" + e);
        }
    }

}
