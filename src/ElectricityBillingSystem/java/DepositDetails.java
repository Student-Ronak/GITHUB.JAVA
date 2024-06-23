package ElectricityBillingSystem.java;



import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;

public class DepositDetails implements ActionListener {
    JFrame f= new JFrame();
    JComboBox meterNumber,cbmonth;
    JTable table;
    JButton serach,print;
    DepositDetails() {
//        super("deposit details");
        f.setLayout(null);
        JLabel llbmeter= new JLabel("Serach by meter number");
        llbmeter.setFont(new Font("Tahoma",Font.BOLD,12));
        llbmeter.setBounds(20,20,200,20);
        f.add(llbmeter);
        meterNumber= new JComboBox<>();
        meterNumber.setBounds(210,20,100,20);
        f.add(meterNumber);
        try{
            Conn1 c= new Conn1();
            ResultSet rs= c.stmt1.executeQuery("select * from custumer");
            while (rs.next())
            {
                meterNumber.addItem(rs.getString("meter_no"));
            }
        }catch (Exception e)
        {
            System.out.println(e);
        }
        JLabel llbmonth= new JLabel("Serach by Month");
        llbmonth.setFont(new Font("Tahoma",Font.BOLD,12));
        llbmonth.setBounds(350,20,100,20);
        f.add(llbmonth);
        String[] mon={"January","February","March","April","May","June","July","August","September","October","November","December"};
        cbmonth= new JComboBox(mon);
        cbmonth.setBounds(520,20,150,20);
        f.add(cbmonth);
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

//             while(rs.next())
//             {
//                 String[]row={rs.getString(1),rs.getString(2),rs.getString(3),rs.getString(4),rs.getString(5)};
//
//               model.addRow(row);
//             }





//            table.setModel(DbUtils.resultSetToTableModel(rs));
        }catch (Exception e)
        {
            System.out.println("senond  "+e);
        }
        JScrollPane scroll= new JScrollPane(table);
        scroll.setBounds(0,100,700,600);
        f.add(scroll);
        serach= new JButton("Serach");
        serach.setBounds(20,70,100,20);
        serach.setBackground(Color.BLACK);
        serach.setForeground(Color.WHITE);
        f.add(serach);
        serach.addActionListener(this);
        print= new JButton("Print");
        print.setBounds(130,70,100,20);
        print.setBackground(Color.BLACK);
        print.setForeground(Color.WHITE);
        f.add(print);
        print.addActionListener(this);

        f.getContentPane().setBackground(Color.WHITE);
        f.setVisible(true);
        f.setBounds(200,60,700,700);
        f.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        System.out.println("");
    }
    public void actionPerformed(ActionEvent event)
    {
        if(event.getSource()==serach)
        {
            try {
                String query= "select * from bill where meter_no='"+meterNumber.getSelectedItem()+"'and month='"+cbmonth.getSelectedItem()+"'";
                Conn1 c= new Conn1();
                ResultSet rs= c.stmt1.executeQuery(query);
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
            }catch (Exception qe){
                System.out.println(qe);
            }
//            while(rs.next())
//            {
//
//            }

        } else if (event.getSource()==print) {
            try{
                table.print();
            }catch (Exception e)
            {
                System.out.println(e);
            }

        }
    }
    public static void main(String[] args) {
        new DepositDetails();
    }
}

