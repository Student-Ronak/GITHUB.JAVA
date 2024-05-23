package EmployeeManagementSystem.java;



import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.*;

public class UpdateEmp implements ActionListener {
    JFrame f= new JFrame();
    JTextField tfname,tffname,tfDOB,tfsalary,tfadd,tfemail,tfphone,tfaddhar,tfdesignation,tfeducation;
    JLabel tfempId;JButton add,back;
    //    JComboBox tfeducation;
    String empId;
    UpdateEmp(String empId)
    {this.empId=empId;
        f.setSize(900,700);
        f.setLocation(50,30);
        f.setLayout(null);
        JLabel heading= new JLabel(" UPDATE EMPLOYEE DETAILS");
        heading.setFont(new Font("RALWEY",Font.BOLD,25));
        heading.setBounds(200,30,450,25);
        heading.setForeground(Color.BLACK);
        f.add(heading);
        JLabel llbname=new JLabel("Name");
        llbname.setFont(new Font("TAHOMA",Font.BOLD,20));
        llbname.setBounds(50,70,150,20);
        f.add(llbname);
        JLabel tfname= new JLabel();
        tfname.setBounds(250,70,150,20);
        f.add(tfname);
        JLabel llbfname=new JLabel("Father Name");
        llbfname.setFont(new Font("TAHOMA",Font.BOLD,20));
        llbfname.setBounds(420,70,150,20);
        f.add(llbfname);
        tffname= new JTextField();
        tffname.setBounds(620,70,150,20);
        f.add(tffname);
        JLabel llbDOB=new JLabel("D.O.B");
        llbDOB.setFont(new Font("TAHOMA",Font.BOLD,20));
        llbDOB.setBounds(50,120,150,20);
        f.add(llbDOB);
        JLabel  tfDOB= new JLabel();
        tfDOB.setBounds(250,120,150,20);
        f.add(tfDOB);
        JLabel llbsalary=new JLabel("Salary");
        llbsalary.setFont(new Font("TAHOMA",Font.BOLD,20));
        llbsalary.setBounds(420,120,150,20);
        f.add(llbsalary);
        tfsalary= new JTextField();
        tfsalary.setBounds(670,120,150,20);
        f.add(tfsalary);
        JLabel llbAddress=new JLabel("Address");
        llbAddress.setFont(new Font("TAHOMA",Font.BOLD,20));
        llbAddress.setBounds(50,170,150,20);
        f.add(llbAddress);
        tfadd= new JTextField();
        tfadd.setBounds(250,170,150,20);
        f.add(tfadd);

        JLabel llbemail=new JLabel("Email");
        llbemail.setFont(new Font("TAHOMA",Font.BOLD,20));
        llbemail.setBounds(420,170,150,20);
        f.add(llbemail);
        tfemail= new JTextField();
        tfemail.setBounds(670,170,150,20);
        f.add( tfemail);

        JLabel llbPhone=new JLabel("Phone Number");
        llbPhone.setFont(new Font("TAHOMA",Font.BOLD,20));
        llbPhone.setBounds(50,220,150,20);
        f.add(llbPhone);
        tfphone= new JTextField();
        tfphone.setBounds(250,220,150,20);
        f.add(tfphone);
        JLabel llbeducation=new JLabel("Highest Education");
        llbeducation.setFont(new Font("TAHOMA",Font.BOLD,14));
        llbeducation.setBounds(420,220,150,20);
        f.add(llbeducation);
//        String []edu={ "BBA","MBA","BCA","MCA","BCOM","MCOM","BSC","MSC","PHD"};
        tfeducation= new JTextField();
        tfeducation.setBounds(670,220,150,20);
        f.add( tfeducation);
        JLabel llbaddhar=new JLabel("Addhar Number");
        llbaddhar.setFont(new Font("TAHOMA",Font.BOLD,20));
        llbaddhar.setBounds(50,270,150,20);
        f.add(llbaddhar);
        JLabel  tfaddhar= new JLabel();
        tfaddhar.setBounds(250,270,150,20);
        f.add( tfaddhar);
        JLabel llbdesignation=new JLabel("Designation");
        llbdesignation.setFont(new Font("TAHOMA",Font.BOLD,20));
        llbdesignation.setBounds(420,270,150,20);
        f.add(llbdesignation);
        tfdesignation= new JTextField();
        tfdesignation.setBounds(670,270,150,20);
        f.add( tfdesignation);
        JLabel llbempId=new JLabel("Emp ID");
        llbempId.setFont(new Font("TAHOMA",Font.BOLD,20));
        llbempId.setBounds(50,320,150,20);
        f.add(llbempId);
        tfempId= new JLabel();
        tfempId.setBounds(250,320,150,20);
        f.add(  tfempId);
        try{
            Conn c= new Conn();
            ResultSet rs=  c.stmt.executeQuery("select * from empdetails where empID='"+empId+"'");
            while(rs.next())
            {
                tfempId.setText(rs.getString(1));
                tfname.setText(rs.getString(2));
                tffname.setText(rs.getString(3));
                tfDOB.setText(rs.getString(4));
                tfsalary.setText(rs.getString(5));
                tfadd.setText(rs.getString(6));
                tfemail.setText(rs.getString(7));
                tfphone.setText(rs.getString(8));
                tfaddhar.setText(rs.getString(9));
                tfdesignation.setText(rs.getString(10));
                tfeducation.setText(rs.getString(11));
            }
        }catch(Exception ae)
        {
            System.out.println(ae);
        }

        add= new JButton("Update Details");
        add.setBounds(280,400,100,20);
        add.setForeground(Color.WHITE);
        add.setBackground(Color.BLACK);
        f.add(add);
        add.addActionListener(this);
        back= new JButton("Back");
        back.setBounds(400,400,100,20);
        back.setBackground(Color.BLACK);
        back.setForeground(Color.WHITE);
        f.add(back);
        back.addActionListener(this);
        f.setVisible(true);

        f.getContentPane().setBackground(Color.WHITE);
    }
    public void actionPerformed(ActionEvent e)
    {
//        JTextField tfname,tffname,tfDOB,tfsalary,tfadd,tfemail,tfphone,tfaddhar,tfdesignation;
//        JLabel tfempId;JButton add,back;
//        JComboBox tfeducation;



        if(e.getSource()==add)
        {
//            String name=tfname.getText();
            String fname=tffname.getText();
//            String dob=tfDOB.getText();
            String salary= tfsalary.getText();
            String address= tfadd.getText();String email=tfemail.getText();String phone= tfphone.getText();
//            String addhar=tfaddhar.getText();
            String designation= tfdesignation.getText();
            String education= tfeducation.getText();
//            String education1= String.valueOf(tfeducation.getSelectedIndex());
//            System.out.println("index"+education1);
//            System.out.println("item"+education);
//            String empID=tfempId.getText();
            String query="update  empdetails set fname='"+fname+"',salary='"+salary+"',address='"+address+"',email='"+email+"',phone='"+phone+"',desi='"+designation+"',educ='"+education+"'where empID='"+empId+"'";
            try{
                Conn c= new Conn();
                c.stmt.executeUpdate(query) ;
                JOptionPane.showMessageDialog(null,"Employee Details Update Sucessfully");
                f.setVisible(false);new Home();
            }catch (Exception aee)
            {
                System.out.println(aee);
            }
        }else {
            f.setVisible(false);
            new Home();
        }
    }

    public static void main(String[] args) {
        new UpdateEmp("");
    }
}

