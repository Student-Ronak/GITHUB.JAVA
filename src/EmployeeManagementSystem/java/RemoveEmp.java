package EmployeeManagementSystem.java;

//package employmanagement.java;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.sql.ResultSet;

public class RemoveEmp implements ActionListener {
    JFrame f;
    JComboBox cempID;
    JButton delete,back;
    RemoveEmp()
    {

        f= new JFrame();
        f.setBounds(100,40,1000,400);
        JLabel llbempID= new JLabel("Employee ID");
        llbempID.setBounds(50,50,100,30);
        f.add(llbempID);
        cempID= new JComboBox<>();
        cempID.setBounds(170,50,100,30);
        f.add(cempID);
        try{
            Conn c= new Conn();
            String query="select * from empdetails";
            ResultSet rs= c.stmt.executeQuery(query);
            while(rs.next())
            {
                cempID.addItem(rs.getString(1));
            }

        }catch (Exception ae)
        {
            System.out.println(ae);
        }
        JLabel llbname= new JLabel("Name");
        llbname.setBounds(50,100,100,30);
        f.add(llbname);
        JLabel tfname= new JLabel();
        tfname.setBounds(170,100,100,30);
        f.add(tfname);
        JLabel llbPhone= new JLabel("Phone");
        llbPhone.setBounds(50,150,100,30);
        f.add(llbPhone);
        JLabel tfPhone= new JLabel();
        tfPhone.setBounds(170,150,100,30);
        f.add(tfPhone);
        JLabel llbemail= new JLabel("Email");
        llbemail.setBounds(50,200,100,30);
        f.add(llbemail);
        JLabel tfemail= new JLabel();
        tfemail.setBounds(170,200,120,30);
        f.add(tfemail);
        try{
            Conn c= new Conn();
            String query="select * from empdetails where empID='"+cempID.getSelectedItem()+"'";
            ResultSet rs= c.stmt.executeQuery(query);
            while(rs.next())
            {
                tfname.setText(rs.getString("name"));
                tfPhone.setText(rs.getString("phone"));
                tfemail.setText(rs.getString("email"));
            }

        }catch (Exception ae)
        {
            System.out.println(ae);
        }
        cempID.addItemListener(new ItemListener() {
            @Override
            public void itemStateChanged(ItemEvent e) {
                try{
                    Conn c= new Conn();
                    String query="select * from empdetails where empID='"+cempID.getSelectedItem()+"'";
                    ResultSet rs= c.stmt.executeQuery(query);
                    while(rs.next())
                    {
                        tfname.setText(rs.getString("name"));
                        tfPhone.setText(rs.getString("phone"));
                        tfemail.setText(rs.getString("email"));
                    }

                }catch (Exception ae)
                {
                    System.out.println(ae);
                }
            }
        });
        delete= new JButton("Delete");
        delete.setForeground(Color.WHITE);
        delete.setBounds(80,300,120,30);
        delete.setBackground(Color.BLACK);
        f.add(delete);
        delete.addActionListener(this);

        back= new JButton("Back");
        back.setForeground(Color.WHITE);
        back.setBounds(220,300,120,30);
        back.setBackground(Color.BLACK);
        f.add(back);
        back.addActionListener(this);
        ImageIcon i1= new ImageIcon("D:\\icons\\cancel.jpg");
        Image i2= i1.getImage().getScaledInstance(600,400,Image.SCALE_DEFAULT);
        ImageIcon i3= new ImageIcon(i2);
        JLabel image= new JLabel(i3);
        image.setBounds(350,00,600,400);
        f.add(image);

        f.setLayout(null);
        f.setVisible(true);
        f.getContentPane().setBackground(Color.WHITE);
    }
    public void actionPerformed(ActionEvent aee)
    {
        if(aee.getSource()==delete)
        { try {
            Conn c = new Conn();
            String query = "delete from empdetails where empID= '" + cempID.getSelectedItem() + "' ";
            c.stmt.executeUpdate(query);
            JOptionPane.showMessageDialog(null,"Employee information Deleted Sucessfully");
            f.setVisible(false);
            new Home();
        }catch (Exception e)
        {
            System.out.println(e);
        }
        }else{
            f.setVisible(false);
            new Home();
        }
    }
    public static void main(String[] args) {
        new RemoveEmp();
    }
}

