package UNIVERSITYMANAGEMENTSYSTEM.JAVA;


import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;

public class FeesStructure {
    JFrame f;
    JTable table;
    FeesStructure()
    {
        f= new JFrame();
        f.setLayout(null);

        JLabel heading= new JLabel("Fee Structure");
        heading.setBounds(50,10,400,30);
        heading.setFont(new Font("TAHOMA",Font.PLAIN,25));
        f.add(heading);

        table= new JTable();
        try{

            Conn2 c= new Conn2();
            ResultSet rs= c.stmt.executeQuery("select * from feeStructure");
            ResultSetMetaData rsmd=rs.getMetaData();
            DefaultTableModel model= (DefaultTableModel) table.getModel();
            int cols= rsmd.getColumnCount();
//
            String[]colName=new String[cols];
            for(int i=0;i<cols;i++){
                colName[i]=rsmd.getColumnName(i+1);
//
            }
            model.setColumnIdentifiers(colName);

            while(rs.next())
            {
                String[]row={rs.getString(1),rs.getString(2),rs.getString(3),rs.getString(4),rs.getString(5),rs.getString(6),rs.getString(7),rs.getString(8),rs.getString(9)};model.addRow(row);

            }

        }catch (Exception e1)
        {
            System.out.println(e1);
        }
        JScrollPane scroll = new JScrollPane(table);
        scroll.setBounds(0,60,1000,700);
        f.add(scroll);
        f.setBounds(250,50,1000,700);

        f.getContentPane().setBackground(Color.WHITE);
        f.setVisible(true);

    }
    public static void main(String[] args) {
        new FeesStructure();
    }
}
