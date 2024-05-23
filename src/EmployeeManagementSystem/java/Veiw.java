package EmployeeManagementSystem.java;

//package employmanagement.java;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.*;
//ResultSet;


public class Veiw  implements ActionListener {
    JFrame f;
    JTable table;
    JComboBox ccempId;
    JButton serach,print,update,back;
    Veiw(){
        f= new JFrame();
        f.setLayout(null);

        JLabel llbsearch= new JLabel("Search by employee id");
        llbsearch.setBounds(20,20,150,20);
        f.add(llbsearch);
        ccempId= new JComboBox<>();
        ccempId.setBounds(190,20,100,20);
        f.add(ccempId);
        try{
            Class.forName("com.mysql.cj.jdbc.Driver");
            String url= "jdbc:mysql://localhost:3306/ems";
            String username="root";
            String pass="17122004";
            Connection con= DriverManager.getConnection(url,username,pass);
            Statement stmt=con.createStatement();
            ResultSet rs= stmt.executeQuery("select * from empdetails");


            while (rs.next())
            {
                ccempId.addItem(rs.getString("empID"));
            }
        }catch (Exception e)
        {
            System.out.println(e);
        }
        serach= new JButton("Serach");
        serach.setBounds(20,70,80,20);
        f.add(serach);
        serach.addActionListener(this);

        print= new JButton("Print");
        print.setBounds(120,70,80,20);
        f.add(print);
        print.addActionListener(this);
        update= new JButton("Update");
        update.setBounds(220,70,80,20);
        f.add(update);
        update.addActionListener(this);
        back= new JButton("Back");
        back.setBounds(320,70,80,20);
        f.add(back);
        back.addActionListener(this);





        table= new JTable();
        try{
            Class.forName("com.mysql.cj.jdbc.Driver");
            String url= "jdbc:mysql://localhost:3306/ems";
            String username="root";
            String pass="17122004";
            Connection con= DriverManager.getConnection(url,username,pass);
            Statement stmt=con.createStatement();
            ResultSet rs= stmt.executeQuery("select * from empdetails");
            ResultSetMetaData rsmd=rs.getMetaData();
            DefaultTableModel model= (DefaultTableModel) table.getModel();
            int cols= rsmd.getColumnCount();
//            System.out.println(cols);
            String[]colName=new String[cols];
            for(int i=0;i<cols;i++){
                colName[i]=rsmd.getColumnName(i+1);
//                System.out.println(colName[i]);
            }
            model.setColumnIdentifiers(colName);

//            while(rs.next())
//            {
//              String[]row={rs.getString(1),rs.getString(2),rs.getString(3),rs.getString(4),rs.getString(5),rs.getString(6),rs.getString(7),rs.getString(8),rs.getString(9),rs.getString(10),rs.getString(11)};
//              model.addRow(row);
//
//            }
            con.close();
            stmt.cancel();
        }catch (Exception e)
        {
            System.out.println(e);
        }
        table.setBounds(100,30,1000,600);
        f.add(table);

        JScrollPane scroll= new JScrollPane(table);
        scroll.setBounds(0,100,1100,600);
        f.add(scroll);

        f.setBounds(0,0,1100,700);
        f.setVisible(true);
        f.getContentPane().setBackground(Color.white);

//
    }
    public void actionPerformed(ActionEvent ae)
    {
        if(ae.getSource()==serach){
            String query="select * from empdetails where empID='"+ccempId.getSelectedItem()+"'";
            try{
                Class.forName("com.mysql.cj.jdbc.Driver");
                String url= "jdbc:mysql://localhost:3306/ems";
                String username="root";
                String pass="17122004";
                Connection con= DriverManager.getConnection(url,username,pass);
                Statement stmt=con.createStatement();
                ResultSet rs= stmt.executeQuery(query);
                ResultSetMetaData rsmd=rs.getMetaData();
                DefaultTableModel model= (DefaultTableModel) table.getModel();
                int cols= rsmd.getColumnCount();
//            System.out.println(cols);
                String[]colName=new String[cols];
                for(int i=0;i<cols;i++){
                    colName[i]=rsmd.getColumnName(i+1);
//                System.out.println(colName[i]);
                }
                model.setColumnIdentifiers(colName);

                while(rs.next())
                {
                    String[]row={rs.getString(1),rs.getString(2),rs.getString(3),rs.getString(4),rs.getString(5),rs.getString(6),rs.getString(7),rs.getString(8),rs.getString(9),rs.getString(10),rs.getString(11)};
                    model.addRow(row);

                }
            }catch (Exception e)
            {
                System.out.println(e);
            }



        } else if (ae.getSource()==print) {
            try{
                table.print();
            }catch (Exception e)
            {

            }
        } else if (ae.getSource()==update) {
            f.setVisible(false);
            new UpdateEmp((String) ccempId.getSelectedItem());
        } else if (ae.getSource()==back) {
            f.setVisible(false);
            new Home();
        }
    }
    public static void main(String[] args) {
        new Veiw();
    }
}
