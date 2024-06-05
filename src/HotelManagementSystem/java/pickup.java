package HotelManagementSystem.java;


import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.*;
//ResultSet;


public class pickup implements ActionListener {
    JFrame f;
    JTable table;
    JComboBox  carType;
//    JCheckBox   display;
    JButton submit,back;
    //    JButton serach,print,update,back;
    pickup(){
        f= new JFrame();
        f.setLayout(null);
        JLabel text= new JLabel("Pick Up Service");
        text.setBounds(200,10,150,25);
        text.setFont(new Font("TAHOMA",Font.PLAIN,20));
        f.add(text);
        JLabel llbsearch= new JLabel("Type Of Car");
        llbsearch.setBounds(20,40,150,20);
        f.add(llbsearch);
//        String []type={"single Bed","Double Bed","Double+Single Bed"};
        carType= new JComboBox<>();
        carType.setBounds(190,40,200,20);
        f.add(carType);
        try{
            Conn3 c= new Conn3();
            ResultSet rs= c.stmt.executeQuery("select * from driver");
            while(rs.next())
            {
                carType.addItem(rs.getString("model"));
            }
        }catch (Exception e1)
        {
            System.out.println(e1);
        }
        table= new JTable();
        try{
            Class.forName("com.mysql.cj.jdbc.Driver");
            String url= "jdbc:mysql://localhost:3306/hms";
            String username="root";
            String pass="17122004";
            Connection con= DriverManager.getConnection(url,username,pass);
            Statement stmt=con.createStatement();
            ResultSet rs= stmt.executeQuery("select * from driver");
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
//
            while(rs.next())
            {
                String[]row={rs.getString(1),rs.getString(2),rs.getString(3),rs.getString(4),rs.getString(5),rs.getString(6),rs.getString(7)};
                model.addRow(row);

            }
            con.close();
            stmt.cancel();
        }catch (Exception e)
        {
            System.out.println(e);
        }
        table.setBounds(100,30,1000,500);
        f.add(table);

        JScrollPane scroll= new JScrollPane(table);
        scroll.setBounds(0,100,1100,500);
        f.add(scroll);
        submit= new JButton("Submit");
        submit.setBounds(200,650,100,20);
        f.add(submit);
        submit.addActionListener(this);
        back= new JButton("Back");
        back.setBounds(350,650,100,20);
        f.add(back);
        back.addActionListener(this);
        f.setBounds(0,0,1100,900);
        f.setVisible(true);
        f.getContentPane().setBackground(Color.white);

//
    }
    public void actionPerformed(ActionEvent ae)
    {
        if(ae.getSource()==submit){
            String query="select * from driver where model='"+carType.getSelectedItem()+"' ";
//            String query1="select * from room where  available = 'Available' and type='"+bedType.getSelectedItem()+"' ";
            try{

                Class.forName("com.mysql.cj.jdbc.Driver");
                String url= "jdbc:mysql://localhost:3306/hms";
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
                    String[]row={rs.getString(1),rs.getString(2),rs.getString(3),rs.getString(4),rs.getString(5),rs.getString(6),rs.getString(7)};
                    model.addRow(row);

                }
            }catch (Exception e)
            {
                System.out.println(e);
            }

        }else{
            f.setVisible(false);
            new Reception();
        }
//
    }
    public static void main(String[] args) {
        new pickup();
    }
}
