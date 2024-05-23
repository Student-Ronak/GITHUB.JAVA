package EmployeeManagementSystem.java;
//package employmanagement.java;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
//ActionListener;
import java.util.Random;

public class AddEmployee implements ActionListener {
    JFrame f= new JFrame();
    JTextField tfname,tffname,tfDOB,tfsalary,tfadd,tfemail,tfphone,tfaddhar,tfdesignation;
    JLabel tfempId;JButton add,back;
    JComboBox tfeducation;
    Random ran=new Random();
    int num= ran.nextInt(999999);
    AddEmployee()
    {
        f.setSize(900,700);
        f.setLocation(50,30);
        f.setLayout(null);
        JLabel heading= new JLabel(" ADD EMPLOYEE DETAILS");
        heading.setFont(new Font("RALWEY",Font.BOLD,25));
        heading.setBounds(200,30,450,25);
        heading.setForeground(Color.BLACK);
        f.add(heading);
        JLabel llbname=new JLabel("Name");
        llbname.setFont(new Font("TAHOMA",Font.BOLD,20));
        llbname.setBounds(50,70,150,20);
        f.add(llbname);
        tfname= new JTextField();
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
        tfDOB= new JTextField();
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
        String []edu={ "BBA","MBA","BCA","MCA","BCOM","MCOM","BSC","MSC","PHD"};
        tfeducation= new JComboBox(edu);
        tfeducation.setBounds(670,220,150,20);
        f.add( tfeducation);
        JLabel llbaddhar=new JLabel("Addhar Number");
        llbaddhar.setFont(new Font("TAHOMA",Font.BOLD,20));
        llbaddhar.setBounds(50,270,150,20);
        f.add(llbaddhar);
        tfaddhar= new JTextField();
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
        tfempId= new JLabel(" "+num);
        tfempId.setBounds(250,320,150,20);
        f.add(  tfempId);

        add= new JButton("Add Details");
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
            String name=tfname.getText();
            String fname=tffname.getText();
            String dob=tfDOB.getText();
            String salary= tfsalary.getText();
            String address= tfadd.getText();String email=tfemail.getText();String phone= tfphone.getText();String addhar=tfaddhar.getText();
            String designation= tfdesignation.getText();
            String education= String.valueOf(tfeducation.getSelectedItem());
//            String education1= String.valueOf(tfeducation.getSelectedIndex());
//            System.out.println("index"+education1);
//            System.out.println("item"+education);
            String empID=tfempId.getText();
            String query="insert into empdetails values('"+empID+"','"+name+"','"+fname+"','"+dob+"','"+salary+"','"+address+"','"+email+"','"+phone+"','"+addhar+"','"+designation+"','"+education+"')";
            try{
                Conn c= new Conn();
                c.stmt.executeUpdate(query) ;
                JOptionPane.showMessageDialog(null,"Employee Details add Sucessfully");
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
        new AddEmployee();
    }
}


