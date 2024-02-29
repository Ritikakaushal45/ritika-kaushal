package university.managment.system;

import java.sql.*;

public class conn {
    Connection c;
    Statement s;
    conn(){
        try {
            //regester driver class
            Class.forName("com.mysql.cj.jdbc.Driver");
            //connection string
            c=DriverManager.getConnection("jdbc:mysql:///universitymanagmentsystem","root","ritika291202");
            s=c.createStatement();
        }catch (Exception e){
            e.printStackTrace();
        }
    }
    public static void main(String[] args) {
        new conn();
    }
}
