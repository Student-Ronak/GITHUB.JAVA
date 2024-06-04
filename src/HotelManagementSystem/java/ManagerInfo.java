package HotelManagementSystem.java;


import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.*;

public class ManagerInfo implements ActionListener {
    JFrame f;
    JTable table;
    //    JComboBox ccempId;
    JButton back;
    ManagerInfo(){
        f= new JFrame();
        f.setLayout(null);
        JLabel l1= new JLabel("MANAGER INFORMATION");
        l1.setFont(new Font("TAHOMA",Font.BOLD,50));
        l1.setBounds(70,10,900,60);
        f.add(l1);

        table= new JTable();
        try{
            Class.forName("com.mysql.cj.jdbc.Driver");
            String url= "jdbc:mysql://localhost:3306/hms";
            String username="root";
            String pass="17122004";
            Connection con= DriverManager.getConnection(url,username,pass);
            Statement stmt=con.createStatement();
            ResultSet rs= stmt.executeQuery("select * from Employee where job='Manager'");
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
                String[]row={rs.getString(1),rs.getString(2),rs.getString(3),rs.getString(4),rs.getString(5),rs.getString(6),rs.getString(7),rs.getString(8)};
                model.addRow(row);

            }
            con.close();
            stmt.cancel();
        }catch (Exception e)
        {
            System.out.println(e);
        }
        table.setBounds(100,10,1000,500);
        f.add(table);

        JScrollPane scroll= new JScrollPane(table);
        scroll.setBounds(0,100,1100,500);
        f.add(scroll);
        back= new JButton("Back");
        back.setBounds(300,650,100,20);
        back.setBackground(Color.BLACK);back.setForeground(Color.WHITE);f.add(back);
        back.addActionListener(this);

        f.setBounds(0,0,1100,800);
        f.setVisible(true);
        f.getContentPane().setBackground(Color.white);


    }
    public void actionPerformed(ActionEvent e)
    {
        f.setVisible(false);
        new Reception();
    }
    public static void main(String[] args) {
        new ManagerInfo();
    }
}

