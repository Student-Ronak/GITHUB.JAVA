package ElectricityBillingSystem.java;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;

public class BillDetails  {

    JFrame f= new JFrame();
    JTable table;
    //    JButton print;
    String meter;
    BillDetails(String meter)
    {
        this.meter= meter;
        table= new JTable();
        try {
            Conn1 c= new Conn1();
            ResultSet rs= c.stmt1.executeQuery("select * from bill where meter_no='"+meter+"' ");
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
                String[]row={rs.getString("meter_no"),rs.getString(2),rs.getString(3),rs.getString(4),rs.getString(5)};

                model.addRow(row);
            }
//            table.setModel(DbUtils.resultSetToTableModel(rs));
        }catch (Exception e)
        {
            System.out.println(" "+e);
        }

        JScrollPane scroll= new JScrollPane(table);
        scroll.setBounds(0,1050,700,600);
        f.add(scroll);



        f.setSize(1100,600);
        f.setLocation(100,100);
        f.getContentPane().setBackground(Color.WHITE);
        f.setVisible(true);

        f.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
    }

    public static void main(String[] args) {
        new BillDetails("6124");
    }

}

