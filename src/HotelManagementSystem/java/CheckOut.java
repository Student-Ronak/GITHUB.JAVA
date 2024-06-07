package HotelManagementSystem.java;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Date;

public class CheckOut implements ActionListener {
    JFrame f;
    JComboBox cid;
    JLabel tfroomno,tfcheckin,tfcheckout;
    JButton checkout,back;
    CheckOut()
    {
        f= new JFrame();
        f.setLayout(null);
        JLabel text= new JLabel("Check Out");
        text.setBounds(150,20,300,30);
        text.setFont(new Font("TAHOMA",Font.BOLD,25));
        f.add(text);
        ImageIcon i1 = new ImageIcon("D:\\icons\\exit.jpg");
        Image i2 = i1.getImage().getScaledInstance(400, 300, Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel image = new JLabel(i3);
        image.setBounds(370, 30, 380, 300);
        f.add(image);
        text.setForeground(Color.blue);
        JLabel llbid= new JLabel("Customer ID");
        llbid.setBounds(20,80,150,30);
//        text.setFont(new Font("TAHOMA",Font.BOLD,25));
        f.add(llbid);
        cid= new JComboBox<>();
        cid.setBounds(190,80,150,20);
        f.add(cid);
//
        JLabel llbroom= new JLabel("Room Number");
        llbroom.setBounds(20,120,150,20);
        f.add(llbroom);
        tfroomno= new JLabel();
        tfroomno.setBounds(190,120,150,20);
        f.add(tfroomno);
        JLabel llbcheckin= new JLabel("Check In Time");
        llbcheckin.setBounds(20,160,150,20);
        f.add(llbcheckin);
        tfcheckin =new JLabel();
        tfcheckin.setBounds(190,160,150,20);
        f.add(tfcheckin);
        JLabel llbcheckout= new JLabel("Check In Time");
        llbcheckout.setBounds(20,200,150,20);
        f.add(llbcheckout);
        Date d= new Date();
        tfcheckout =new JLabel(""+d);
        tfcheckout.setBounds(190,200,200,20);
        f.add(tfcheckout);
        checkout= new JButton("Check Out");
        checkout.setBounds(20,240,100,20);
        checkout.setBackground(Color.BLACK);checkout.setForeground(Color.WHITE);f.add(checkout);
        try{
            Class.forName("com.mysql.cj.jdbc.Driver");
            String url= "jdbc:mysql://localhost:3306/hms";
            String username="root";
            String pass="17122004";
            Connection con= DriverManager.getConnection(url,username,pass);
            Statement stmt=con.createStatement();
            ResultSet rs= stmt.executeQuery("select * from customer");

            while (rs.next())
            {
                cid.addItem(rs.getString(2));
                tfroomno.setText(rs.getString(4));
                tfcheckin.setText(rs.getString(8));
//                tfcheckout.setText();
            }
        }catch (Exception e)
        {
            System.out.println(e);
        }
        back= new JButton("Back");
        back.setBounds(190,240,100,20);
        back.setBackground(Color.BLACK);back.setForeground(Color.WHITE);f.add(back);
        checkout.addActionListener(this);back.addActionListener(this);
        f.getContentPane().setBackground(Color.WHITE);
        f.setBounds(100,50,800,400);
        f.setVisible(true);
    }
    public void actionPerformed(ActionEvent e){
        if(e.getSource()==checkout){
            String query="delete from customer where IDNUMBER='"+cid.getSelectedItem()+"'";
            String query2="update room set  available='Available' where room1='"+cid.getSelectedItem()+"'";
            try{
                Conn3 c= new Conn3();
//    ResultSet rs= c.stmt.executeQuery()
                c.stmt.executeUpdate(query2);
                c.stmt.executeUpdate(query);
                JOptionPane.showMessageDialog(null,"Checkout Done");
                f.setVisible(false);
                new Reception();
            }catch (Exception ae){
                System.out.println(ae);
            }
        }else{
            f.setVisible(false);
            new Reception();
        }
    }
    public static void main(String[] args) {
        new CheckOut();
    }
}

