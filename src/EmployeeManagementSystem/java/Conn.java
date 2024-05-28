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
//DATABASE CODE
//FIRST WE CREATE A DATABASE  WITH  NAME EMS
//USE THIS COMMAND
//CREATE DATABASE EMS;
//    use ems;

//    create table empdetails( empID	varchar(30),
//    name	varchar(20),
//    fname	varchar(20),
//    dob	varchar(30),
//    salary	varchar(20),
//    address	varchar(40),
//    email	varchar(39),
//    phone	varchar(40),
//    addhar	varchar(20),
//    desi	varchar(30),
//    educ	varchar(30));
//
//        create table login(username	varchar(30),
//        password	varchar(20));
//
//insert into login(username,password) values("admin","12345");








