package EmployeeManagementSystem.java;



import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

public class Conn {
    Connection con;
    Statement stmt;

    Conn()
    {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            String url= "jdbc:mysql://localhost:3306/ems";
            String username="root";
            String pass="17122004";
            con= DriverManager.getConnection(url,username,pass);
            stmt=con.createStatement();

        } catch(Exception e)
        {
            System.out.println(e);
        }

    }
}

