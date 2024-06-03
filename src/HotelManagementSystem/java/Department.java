package HotelManagementSystem.java;



import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;

public class Department implements ActionListener {
    JFrame f;
    JTable table;
    JButton back;
    Department(){
        f= new JFrame();
        f.setLayout(null);

        JLabel llbroom= new JLabel("Department");
        llbroom.setBounds(150,10,100,20);
        f.add(llbroom);
        JLabel llbavailable= new JLabel("Budget");
        llbavailable.setBounds(370,10,100,20);
        f.add(llbavailable);



        table= new JTable();
        table.setBounds(0,40,480,400);
        f.add(table);
//JScrollPane scroll = new JScrollPane(table);
//        scroll.setBounds(480,20,20,400);
//        f.add(scroll);
        try{
            Conn3 c= new Conn3();
            String query="select * from department";
            ResultSet rs= c.stmt.executeQuery(query);
            ResultSetMetaData rsmd=rs.getMetaData();
            DefaultTableModel model= (DefaultTableModel) table.getModel();
            int cols= rsmd.getColumnCount();
            String[]colName=new String[cols];
            for(int i=0;i<cols;i++){
                colName[i]=rsmd.getColumnName(i+1);

            }
            model.setColumnIdentifiers(colName);

            while(rs.next())
            {
                String[]row={rs.getString(1),rs.getString(2)};
                model.addRow(row);

            }
        }catch (Exception ex)
        {
            System.out.println(ex);
        }
        back= new JButton("Back");
        back.setBackground(Color.BLACK);
        back.setForeground(Color.WHITE);
        back.setBounds(200,300,100,20);
        f.add(back);
        back.addActionListener(this);
//JScrollBar scroll = new JScrollBar(t);
//        scroll.setBounds(480,20,20,400);
//        f.add(scroll);



        f.setBounds(0,50,500,600);
        f.getContentPane().setBackground(Color.WHITE);

        f.setVisible(true);

    }
    public void actionPerformed(ActionEvent e)
    {
        f.setVisible(false);
        new Reception();
    }
    public static void main(String[] args) {
        new Department();
    }
}
