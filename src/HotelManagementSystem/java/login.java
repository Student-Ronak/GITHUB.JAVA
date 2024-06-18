package HotelManagementSystem.java;


import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.*;

public class login implements ActionListener {

    JFrame f= new JFrame();
    JTextField tfusername,tfpassword;
    JButton login= new JButton("Login");
    JButton cancel= new JButton("Cancel");

    login()
    {
        f.getContentPane().setBackground(Color.WHITE);
        f.setLayout(null);
        JLabel llbusername= new JLabel("Username");
        llbusername.setBounds(40,20,100,20);
        llbusername.setFont(new Font("TAHOMA",Font.BOLD,12));
        f.add(llbusername);
        tfusername= new JTextField();
        tfusername.setBounds(150,20,100,20);
        f.add(tfusername);
        JLabel llbpassword= new JLabel("Password");
        llbpassword.setBounds(40,50,100,20);
        tfpassword= new JTextField();
        tfpassword.setBounds(150,50,100,20);
        f.add(tfpassword);
        f.add(llbpassword);
        login.setForeground(Color.WHITE);
        login.setBackground(Color.BLACK);
        login.setBounds(150,100,100,20);
        f.add(login);
        login.addActionListener(this);
        cancel.setForeground(Color.WHITE);
        cancel.setBackground(Color.BLACK);
        cancel.setBounds(150,100,100,20);
        f.add( cancel);
        cancel.addActionListener(this);
        ImageIcon i1= new ImageIcon("D:\\icons\\account1.jpg");
        Image i2= i1.getImage().getScaledInstance(200,200,Image.SCALE_DEFAULT);
        ImageIcon i3= new ImageIcon(i2);
        JLabel image= new JLabel(i3);
        image.setBounds(270,20,300,350);
        f.add(image);

        f.setBounds(200,30,600,300);
        f.setVisible(true);
    }
    public void actionPerformed(ActionEvent e)
    {
        if(e.getSource()==login){
            try{
                String name =tfusername.getText();
                String pass= tfpassword.getText();
                String query="select * from login where name='"+name+"'and password ='"+pass+"'";
                Conn3 c= new Conn3();
                ResultSet rs= c.stmt.executeQuery(query);
                if(rs.next())
                {
                    f.setVisible(false);
                    new Dashboard();
                }else{
                    JOptionPane.showMessageDialog(null,"Username or a password is wrong");
                    tfpassword.setText("");tfusername.setText("");
                }
            }catch (Exception ae)
            {
                System.out.println(ae);
            }
        }
        else {
            System.exit(0);
        }
    }
    public static void main(String[] args) {
        new login();
    }
}

