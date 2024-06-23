package ElectricityBillingSystem.java;



import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;

public class CustumerDetails implements ActionListener {

    JFrame f= new JFrame();
    JTable table;
    JButton print;
    CustumerDetails()
    {
        table= new JTable();
        try {
            Conn1 c= new Conn1();
            ResultSet rs= c.stmt1.executeQuery("select * from bill");
            ResultSetMetaData rsmd=rs.getMetaData();
            DefaultTableModel model= (DefaultTableModel) table.getModel();
            int cols=rsmd.getColumnCount();
            String []colname= new String[cols];
            for(int i=0;i<cols;i++)
            {
                colname[i]= rsmd.getColumnName(i+1);

            }
            model.setColumnIdentifiers(colname);

            while(rs.next())
            {
                String[]row={rs.getString(1),rs.getString(2),rs.getString(3),rs.getString(4),rs.getString(5)};

                model.addRow(row);
            }
//            table.setModel(DbUtils.resultSetToTableModel(rs));
        }catch (Exception e)
        {
            System.out.println("senond  "+e);
        }

        JScrollPane scroll= new JScrollPane(table);
//        scroll.setBounds(0,100,700,600);
        f.add(scroll);
        print= new JButton("Print");
//        print.setBounds(130,70,100,20);
        print.setBackground(Color.BLACK);
        print.setForeground(Color.WHITE);
        f.add(print,"South");
        print.addActionListener(this);



        f.setSize(1100,600);
        f.setLocation(100,100);
        f.getContentPane().setBackground(Color.WHITE);
        f.setVisible(true);
        f.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
    }
    public void actionPerformed(ActionEvent e)
    {
        try{
            table.print();
        }catch (Exception e1)
        {
            System.out.println(e1);
        }
    }
    public static void main(String[] args) {
        new CustumerDetails();
    }

}
