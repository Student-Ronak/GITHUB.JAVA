package HotelManagementSystem.java;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.sql.*;


public class UpdateRoom implements ActionListener {
    JFrame f;
    JComboBox cid;
    JTextField tfroom ,tfcheck, tfavi;
    JButton check,update,back;
    UpdateRoom()
    {
        f= new JFrame();
        f.setLayout(null);
        JLabel heading= new JLabel("Update Room Status");
        heading.setFont(new Font("TAHOMA",Font.BOLD,30));
        heading.setForeground(Color.WHITE);
        heading.setBounds(40,20,250,40);
        f.add(heading);
        JLabel llbsearch= new JLabel("CUSTOMER ID");
        llbsearch.setBounds(20,80,150,20);
        f.add(llbsearch);
        cid= new JComboBox<>();
        cid.setBounds(190,80,150,20);
        f.add(cid);
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
            }
        }catch (Exception e)
        {
            System.out.println(e);
        }
        JLabel llbroom= new JLabel("Room Number");
        llbroom.setBounds(20,120,150,20);
        f.add(llbroom);
        tfroom = new JTextField();
        tfroom.setBounds(190,120,150,20);
        f.add(tfroom);
        JLabel llbname= new JLabel("Availability");
        llbname.setBounds(20,160,150,20);
        f.add(llbname);
        tfavi = new JTextField();
        tfavi.setBounds(190,160,150,20);
        f.add(tfavi);
        JLabel llbcheck= new JLabel("Cleaning Status");
        llbcheck.setBounds(20,200,150,20);
        f.add(llbcheck);
        tfcheck = new JTextField();
        tfcheck.setBounds(190,200,150,20);
        f.add(tfcheck);
        check= new JButton("Check");
        check.setBounds(20,240,100,20);
        check.setForeground(Color.WHITE);check.setBackground(Color.BLACK);f.add(check);
        update= new JButton("Update");
        update.setBounds(130,240,100,20);
        update.setForeground(Color.WHITE);update.setBackground(Color.BLACK);f.add(update);
        back= new JButton("Back");
        back.setBounds(240,240,100,20);
        back.setForeground(Color.WHITE);back.setBackground(Color.BLACK);f.add(back);
        check.addActionListener(this);
        update.addActionListener(this);
        back.addActionListener(this);
        ImageIcon i1= new ImageIcon("D:\\icons\\room.jpg");
        Image i2= i1.getImage().getScaledInstance(500,300,Image.SCALE_DEFAULT);
        ImageIcon i3= new ImageIcon(i2);
        JLabel image= new JLabel(i3);
        image.setBounds(350,00,600,300);
        f.add(image);
        cid.addItemListener(new ItemListener() {
            @Override
            public void itemStateChanged(ItemEvent e) {

            }
        });



        f.setBounds(100,20,1000,500);
        f.getContentPane().setBackground(Color.WHITE);
        f.setVisible(true);
    }
    public void actionPerformed(ActionEvent e)
    {
        if(e.getSource()==check)
        {
            String id= (String) cid.getSelectedItem();
            String query="select * from customer where IDNUMBER='"+id+"'";
            try{
                Conn3 c= new Conn3();
                ResultSet rs= c.stmt.executeQuery(query);
                while(rs.next()){

                    tfroom.setText(rs.getString(4));

                }
                ResultSet rs2= c.stmt.executeQuery("select* from room where room1='"+tfroom.getText()+"'");
                while(rs2.next()){

                    tfavi.setText(rs2.getString(2));
                    tfcheck.setText(rs2.getString(3));
                }
            }catch (Exception ae)
            {
                System.out.println(ae);
            }
        } else if (e.getSource()==update) {
            String id= (String) cid.getSelectedItem();
            String roomn= tfroom.getText();
//            String name= tfname.getText();
            String check= tfcheck.getText();
            String available =tfavi.getText();
//            String deposit= tfpaid.getText();
            try{
                Conn3 c= new Conn3();
                c.stmt.executeUpdate("update room set  available='"+available+"',clean='"+check+"' where  room1='"+roomn+"'");
                JOptionPane.showMessageDialog(null,"Data Updated Sucessfully");
                f.setVisible(false);
                new Reception();
            }catch (Exception ae){
                System.out.println( ae);
            }
        } else if (e.getSource()==back) {
            f.setVisible(false);
            new Reception();
        }
    }
    public static void main(String[] args) {
        new UpdateRoom();
    }
}
