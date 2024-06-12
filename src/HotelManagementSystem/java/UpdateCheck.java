package HotelManagementSystem.java;


import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;


public class UpdateCheck implements ActionListener {
    JFrame f;
    JComboBox cid;
    JTextField tfroom,tfname,tfcheck,tfpaid,tfpending;
    JButton check,update,back;
    UpdateCheck()
    {
        f= new JFrame();
        f.setLayout(null);
        JLabel heading= new JLabel("Search by employee id");
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
        JLabel llbname= new JLabel("Name");
        llbname.setBounds(20,160,150,20);
        f.add(llbname);
        tfname = new JTextField();
        tfname.setBounds(190,160,150,20);
        f.add(tfname);
        JLabel llbcheck= new JLabel("Check In Time");
        llbcheck.setBounds(20,200,150,20);
        f.add(llbcheck);
        tfcheck = new JTextField();
        tfcheck.setBounds(190,200,150,20);
        f.add(tfcheck);
        JLabel llbpaid= new JLabel("Amount Paid");
        llbpaid.setBounds(20,240,150,20);
        f.add(llbpaid);
        tfpaid = new JTextField();
        tfpaid.setBounds(190,240,150,20);
        f.add(tfpaid);
        JLabel llbpending= new JLabel("Pending");
        llbpending.setBounds(20,280,150,20);
        f.add(llbpending);
        tfpending = new JTextField();
        tfpending.setBounds(190,280,150,20);
        f.add(tfpending);
        check= new JButton("Check");
        check.setBounds(20,320,100,20);
        check.setForeground(Color.WHITE);check.setBackground(Color.BLACK);f.add(check);
        update= new JButton("Update");
        update.setBounds(130,320,100,20);
        update.setForeground(Color.WHITE);update.setBackground(Color.BLACK);f.add(update);
        back= new JButton("Back");
        back.setBounds(240,320,100,20);
        back.setForeground(Color.WHITE);back.setBackground(Color.BLACK);f.add(back);
        check.addActionListener(this);
        update.addActionListener(this);
        back.addActionListener(this);
        ImageIcon i1= new ImageIcon("D:\\icons\\reception.jpg");
        Image i2= i1.getImage().getScaledInstance(500,400,Image.SCALE_DEFAULT);
        ImageIcon i3= new ImageIcon(i2);
        JLabel image= new JLabel(i3);
        image.setBounds(350,00,600,500);
        f.add(image);
        cid.addItemListener(new ItemListener() {
            @Override
            public void itemStateChanged(ItemEvent e) {

            }
        });



        f.setBounds(100,20,1000,700);
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
                    tfcheck.setText(rs.getString(8));
                    tfpaid.setText(rs.getString(7));
                    tfroom.setText(rs.getString(4));
                    tfname.setText(rs.getString(3));
                }
                ResultSet rs2= c.stmt.executeQuery("select* from room where room1='"+tfroom.getText()+"'");
                while(rs2.next()){
                    String p= rs2.getString(4);
                    int  amountPaid=Integer.parseInt(p)-Integer.parseInt(tfpaid.getText());
                    tfpending.setText(" "+amountPaid);
                }
            }catch (Exception ae)
            {
                System.out.println(ae);
            }
        } else if (e.getSource()==update) {
            String id= (String) cid.getSelectedItem();
            String roomn= tfroom.getText();
            String name= tfname.getText();
            String check= tfcheck.getText();
            String deposit= tfpaid.getText();
            try{
                Conn3 c= new Conn3();
                c.stmt.executeUpdate("update customer set roomNumber='"+roomn+"',name='"+name+"',chechIn='"+check+"',deposit='"+deposit+"' where  IDNUMBER='"+id+"'");
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
        new UpdateCheck();
    }
}

