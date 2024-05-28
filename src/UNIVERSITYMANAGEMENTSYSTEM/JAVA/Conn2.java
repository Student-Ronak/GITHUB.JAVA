package UNIVERSITYMANAGEMENTSYSTEM.JAVA;



import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

public class Conn2 {
    Connection con;
    Statement stmt;
    Conn2()
    {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            String url= "jdbc:mysql://localhost:3306/ums";
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
//FIRST WE CREATE A DATABASE  WITH  NAME ums
//USE THIS COMMAND
//CREATE DATABASE UMS;
//     use ums  ;
// create table collegefee(rollno varchar(40),course varchar(40),semester varchar(40),branch varchar(40),total varchar(40));
// create table feestructure(course varchar(40),semester1 varchar(40),semester2 varchar(40),semester3 varchar(40),semester4 varchar(40),semester5 varchar(40),semester6 varchar(40),semester7 varchar(40),semester8 varchar(40));
//  insert into feestructure(course,semester1,semester2,semester3,semester4,semester5,semester6,semester7,semester8)values("BTECH CS","70000","68000","70000","69000","70000","70000","69000","70000");
//  insert into feestructure(course,semester1,semester2,semester3,semester4,semester5,semester6,semester7,semester8)values("BTECH MECHANICAL","70000","65000","67000","69000","70000","70000","69000","70000");
//  insert into feestructure(course,semester1,semester2,semester3,semester4,semester5,semester6,semester7,semester8)values("BTECH CIVIL","70000","65000","67000","64000","70000","70000","69000","70000");
//  insert into feestructure(course,semester1,semester2,semester3,semester4,semester5,semester6,semester7,semester8)values("BTECH ELECTRICAL","70000","63000","62000","68000","70000","69000","69000","70000");
//  insert into feestructure(course,semester1,semester2,semester3,semester4,semester5,semester6)values("BCA","40000","38000","38000","36000","38000","40000" );
//  insert into feestructure(course,semester1,semester2,semester3,semester4,semester5,semester6)values("BSC IT","40000","38000","38000","36000","38000","40000" );
//  insert into feestructure(course,semester1,semester2,semester3,semester4,semester5,semester6)values("BSC PCM","35000","29000","30000","35000","34000","36000" );
//  insert into feestructure(course,semester1,semester2,semester3,semester4 )values("MCA ","60000","55000","55000","58000"  );
//  insert into feestructure(course,semester1,semester2,semester3,semester4 )values("MSC ","58000","55000","55000","58000"  );
//CREATE TABLE login(username varchar(20),password varchar(20));
// insert into login values("admin","12345");
//CREATE TABLE marks(rollNo varchar(50),semester varchar(50),mark1 varchar(50),mark2 varchar(50),mark3 varchar(50),mark4 varchar(50),mark5 varchar(50));

//create table student(rollNo	varchar(100),
//name	varchar(20),
//fname	varchar(20),
//dob	varchar(20),
//address	varchar(20),
//phone	varchar(20),
//email	varchar(30),
//classX	varchar(20),
//classXII	varchar(20),
//addhar	varchar(30),
//course	varchar(20),
// branch	varchar(20));

//create studentleave table
//  create table studentleave(rollNo	varchar(30),
//date	varchar(30),
//duration	varchar(30));

//cratea table  subject
//create table subject( semester varchar(30),
//sub1	varchar(50),
//sub2	varchar(50),
//sub3	varchar(50),
//sub4	varchar(50),
//sub5	varchar(50));

//create table teacher
//create table teacher(empId	varchar(30),
//name	varchar(25),
//fname	varchar(25),
//dob	varchar(20),
//address	varchar(30),
//phobe	varchar(20),
//email	varchar(30),
//classX	varchar(20),
//classXII	varchar(20),
//addhar	varchar(30),
//Qualification	varchar(30),
//department	varchar(30));

// teaher leave
// create table teacherleave( EmpID	varchar(30),
//date	varchar(30),duration	varchar(30));
