package UNIVERSITYMANAGEMENTSYSTEM.JAVA;



import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.*;

public class TeacherDetails implements ActionListener {
    JFrame f;
    JTable table;
    JComboBox empId;
    JButton serach ,print,update,back,add;
    TeacherDetails()
    {
        f= new JFrame();
        f= new JFrame();
        f.setLayout(null);

        JLabel llbsearch= new JLabel("Search by EmpID No");
        llbsearch.setBounds(20,20,150,20);
        f.add(llbsearch);
        empId= new JComboBox<>();
        empId.setBounds(190,20,100,20);
        f.add(empId);
        try{
            Conn2 c= new Conn2();
            ResultSet rs= c.stmt.executeQuery("select * from teacher");


            while (rs.next())
            {
                empId.addItem(rs.getString(1));
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
        add= new JButton("Add");

        add.setBounds(320,70,80,20);
        add.addActionListener(this);
        f.add(add);
        back= new JButton("cancel");
        back.setBounds(420,70,80,20);
        f.add(back);
        back.addActionListener(this);





        table= new JTable();
        try{
            Conn2 c= new Conn2();
            ResultSet rs= c.stmt.executeQuery("select * from teacher");
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





//     f.getContentPane().setBackground(Color.WHITE);
//        f.setLayout(null);
//     f.setBounds(100,20,900,700);
//     f.setVisible(true);
    }
    public void actionPerformed(ActionEvent ae)
    {
        if(ae.getSource()==serach){
            String query="select * from teacher where empId='"+empId.getSelectedItem()+"'";
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
                System.out.println(e);
            }


        } else if (ae.getSource()==print) {
            try{
                table.print();
            }catch (Exception e)
            {
                System.out.println("problem in table "+ e);
            }
        } else if (ae.getSource()==update) {

        }else if(ae.getSource()==add)
        {f.setVisible(false);
            new AddTeacher();
        } else if (ae.getSource()==back) {
            f.setVisible(false);
        }
    }
    public static void main(String[] args) {
        new TeacherDetails();
    }
}


