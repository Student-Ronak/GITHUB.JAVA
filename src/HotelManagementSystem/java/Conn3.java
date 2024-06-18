package HotelManagementSystem.java;


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

public class Conn3 {
    Connection con;
    public Statement stmt;
    public Conn3()
    {
//        con=
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            String url= "jdbc:mysql://localhost:3306/hms";
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
//use hms;
//create table calenders(date	date,
//month	int,
//quater	int,
//year	int,
//Day	varchar(25));
//create table customer(ID	varchar(30),
//IDNUMBER	varchar(30),
//name	varchar(30),
//roomNumber	varchar(30),
//gender	varchar(30),
//country	varchar(30),
//deposit	varchar(30),
//chechIn	varchar(50));
//
//create table department(department	varchar(30),
//budget	varchar(30));
// create table driver( name	varchar(30),
//age	varchar(10),
//gender	varchar(20),
//car	varchar(30),
//model	varchar(30),
//location	varchar(30),
//driverAvailable	varchar(30));
//
//create table employee(name	varchar(20),
//age	varchar(10),
//gender	varchar(20),
//job	varchar(30),
//salary	varchar(20),
//phone	varchar(20),
//email	varchar(30),
//addhar	varchar(20));
//
//create table login(name	varchar(30),
//password varchar(30));
//insert into login values("admin","12345");
//
//create table room(room1	varchar(30),
//available	varchar(30),
//clean	varchar(20),
//price	varchar(20),
//type	varchar(30));