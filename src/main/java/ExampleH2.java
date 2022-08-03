import java.sql.*;

public class ExampleH2 {
    public static void main(String[] args) {
        ExampleH2 obj = new ExampleH2();

        Connection connection;
        try{
            Class.forName("org.h2.Driver");
            connection = DriverManager.getConnection("jdbc:h2:tcp://localhost/~/test","sa","");
            obj.select(connection);
        }catch (Exception e){
            System.out.println("YAHAN ERROR HAI:= "+e);
        }/*finally {
                try {
                    assert connection != null;
                    connection.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
        }*/
    }
    public void select(Connection connection){
        String query = "Select * from human";
        try {
            Statement statement = connection.createStatement();
            ResultSet rs = statement.executeQuery(query);
            while(rs.next()){
                int id = rs.getInt("id");
                String name = rs.getString("name");
                System.out.println("ID:="+id+" | NAME:"+name);
            }
        }catch (Exception e){
            System.out.println("ERROR: "+e);
        }
    }
}
