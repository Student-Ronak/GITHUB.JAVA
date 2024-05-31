package UNIVERSITYMANAGEMENTSYSTEM.JAVA;



import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.*;

import java.sql.*;

public class StudentLeaveDetails implements ActionListener {
    JFrame f;
    JTable table;
    JComboBox rollno;
    JButton serach ,print, back ;
    StudentLeaveDetails()
    {
        f= new JFrame();
//        f= new JFrame();
        f.setLayout(null);

        JLabel llbsearch= new JLabel("Search by Roll No");
        llbsearch.setBounds(20,20,150,20);
        f.add(llbsearch);
        rollno= new JComboBox<>();
        rollno.setBounds(190,20,100,20);
        f.add(rollno);
        try{
            Conn2 c= new Conn2();
            ResultSet rs= c.stmt.executeQuery("select * from studentleave");
            while (rs.next())
            {
                rollno.addItem(rs.getString(1));
            }
        }catch (Exception e1)
        {
            System.out.println("problem upar hh"+e1);
        }
        serach= new JButton("Serach");
        serach.setBounds(20,70,80,20);
        f.add(serach);
        serach.addActionListener(this);

        print= new JButton("Print");
        print.setBounds(120,70,80,20);
        f.add(print);
        print.addActionListener(this);

        back= new JButton("cancel");
        back.setBounds(220,70,80,20);
        f.add(back);
        back.addActionListener(this);
        table= new JTable();
        try{
            Conn2 c= new Conn2();
            ResultSet rs= c.stmt.executeQuery("select * from studentleave");
            ResultSetMetaData rsmd=rs.getMetaData();
            DefaultTableModel model= (DefaultTableModel) table.getModel();
            int cols= rsmd.getColumnCount();
            System.out.println(cols);
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
            System.out.println("problem beech me hh"+e);
        }
        table.setBounds(100,30,1000,600);
        f.add(table);

        JScrollPane scroll= new JScrollPane(table);
        scroll.setBounds(0,100,1100,600);
        f.add(scroll);

        f.setBounds(0,0,1100,700);
        f.setVisible(true);
        f.getContentPane().setBackground(Color.white);

    }
    public void actionPerformed(ActionEvent ae)
    {
        if(ae.getSource()==serach){
            String query="select * from student where rollNo='"+rollno.getSelectedItem()+"'";
            try{
                Conn2 c= new Conn2();

                ResultSet rs=c.stmt.executeQuery(query);
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
                System.out.println("ky7a batao"+e);
            }


        } else if (ae.getSource()==print) {
            try{
                table.print();
            }catch (Exception e)
            {
                System.out.println("problem in table "+ e);
            }
        } else if (ae.getSource()==back) {
            f.setVisible(false);
        }
    }
    public static void main(String[] args) {
        new StudentLeaveDetails();
    }
}

