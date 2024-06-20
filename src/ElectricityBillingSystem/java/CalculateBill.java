package ElectricityBillingSystem.java;


import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.sql.ResultSet;

public class CalculateBill implements ActionListener {

    JFrame f= new JFrame();
    JPanel frame;
    JComboBox meterNumber,cbmonth;
    JTextField reading;
    JLabel llname,llbAddress;
    JButton next,cancel;
    CalculateBill()
    {
        f= new JFrame("Calculate Bill");
        f.setLayout(null);
        f.setSize(700,500);
        f.setLocation(400,200);
        frame= new JPanel();
        frame.setBounds(0,0,700,500);
        frame.setBackground(Color.LIGHT_GRAY);
        f.add(frame);
        JLabel heading= new JLabel("Calculate Electricity Bill");
        heading.setBounds(150,10,300,25);
        heading.setFont(new Font("Tahoma",Font.PLAIN,25));
        frame.add(heading);
        JLabel meterno= new JLabel("Meter Number");
        meterno.setBounds(120,80,150,20);
        meterno.setFont(new Font("Tahoma",Font.BOLD,12));
        meterno.setForeground(Color.WHITE);
        frame.add(meterno);
//        String[] number={"Outside","Inside"};
        meterNumber= new JComboBox<>();
        try{
            Conn1 c= new Conn1();
            ResultSet rs= c.stmt1.executeQuery("select * from custumer");
            while ((rs.next()))
            {
                meterNumber.addItem(rs.getString("meter_no"));
            }
        }catch (Exception e)
        {
            System.out.println(e);

        }

        meterNumber.setBounds(240,80,200,20);
        frame.add(meterNumber);
        meterNumber.addItemListener(new ItemListener() {
            @Override
            public void itemStateChanged(ItemEvent e) {
                try{
                    Conn1 c1 = new Conn1();
                    String query="select * from custumer where meter_no='"+meterNumber.getSelectedItem()+"'";
                    ResultSet rs= c1.stmt1.executeQuery(query);

                    while (rs.next())
                    {
                        llname.setText(rs.getString("name"));
                        llbAddress.setText(rs.getString("address"));

                    }
                }catch (Exception ee)
                {
                    System.out.println(ee);
                }

            }
        });
        JLabel Name= new JLabel("Name");
        Name.setBounds(120,120,150,20);
        Name.setFont(new Font("Tahoma",Font.BOLD,12));
        Name.setForeground(Color.WHITE);
        frame.add(Name);
        llname= new JLabel();
        llname.setBounds(240,120,150,20);
        llname.setFont(new Font("Tahoma",Font.BOLD,12));
        llname.setForeground(Color.WHITE);
        frame.add( llname);

        JLabel Address= new JLabel("Address");
        Address.setBounds(120,160,200,20);
        Address.setFont(new Font("Tahoma",Font.BOLD,12));
        Address.setForeground(Color.WHITE);
        frame.add(Address);
        llbAddress= new JLabel();
        llbAddress.setBounds(240,160,150,20);
        llbAddress.setFont(new Font("Tahoma",Font.BOLD,12));
        llbAddress.setForeground(Color.WHITE);
        frame.add(   llbAddress);

        try{
            Conn1 c1 = new Conn1();
            String query="select * from custumer where meter_no='"+meterNumber.getSelectedItem()+"'";
            ResultSet rs= c1.stmt1.executeQuery(query);



            while (rs.next())
            {
                llname.setText(rs.getString("name"));
                llbAddress.setText(rs.getString("address"));

            }
        }catch (Exception e)
        {
            System.out.println(e);
        }
        JLabel unit= new JLabel("Unit Consume");
        unit.setBounds(120,200,150,20);
        unit.setFont(new Font("Tahoma",Font.BOLD,12));
        unit.setForeground(Color.WHITE);
        frame.add(unit);
        reading= new JTextField();
        reading.setBounds(240,200,200,20);
        frame.add(reading);
        JLabel month= new JLabel("Month");
        month.setBounds(120,240,200,20);
        month.setFont(new Font("Tahoma",Font.BOLD,12));
        month.setForeground(Color.WHITE);
        frame.add(month);
        String[] mon={"January","February","March","April","May","June","July","August","September","October","November","December"};
        cbmonth= new JComboBox(mon);
        cbmonth.setBounds(240,240,150,20);
        frame.add(cbmonth);
        frame.setLayout(null);
        next= new JButton("Submit");
        next.setBounds(140,280,100,20);
        next.setBackground(Color.BLACK);
        next.setForeground(Color.WHITE);
        frame.add(next);
        next.addActionListener(this);
        cancel= new JButton("Cancel");
        cancel.setBounds(220,280,100,20);
        cancel.setBackground(Color.BLACK);
        cancel.setForeground(Color.WHITE);
        frame.add( cancel);
        next.addActionListener(this);
        f.setLayout(new BorderLayout());
        f.add(frame,"Center");
        ImageIcon i1= new ImageIcon("D:\\icons\\images (1).jpg");
        Image i2= i1.getImage().getScaledInstance(150,100,Image.SCALE_DEFAULT);
        ImageIcon i3 =new ImageIcon(i2);
        JLabel image= new JLabel(i3);
        f.add(image,"West");
        f.getContentPane().setBackground(Color.WHITE);
        f.setVisible(true);
        f.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);



    }
    public void actionPerformed(ActionEvent e)
    {
        if(e.getSource()==next)
        {
            String meter= (String) meterNumber.getSelectedItem();
            String unit= reading.getText();
            String month= (String) cbmonth.getSelectedItem();
            int total_bill=0;
            int unitCousmed=Integer.parseInt(unit);

            try{
                String query ="select * from tax";
                Conn1 c= new Conn1();
                ResultSet rs=c.stmt1.executeQuery(query);
                while (rs.next())
                {
                    total_bill+=unitCousmed* Integer.parseInt(rs.getString("cost_per_unit"));
                    total_bill+=Integer.parseInt(rs.getString("meter_rent"));
                    total_bill+=Integer.parseInt(rs.getString("service_charge"));
                    total_bill+=Integer.parseInt(rs.getString("service_tax"));
                    total_bill+=Integer.parseInt(rs.getString("swatch_bhart"));
                    total_bill+=Integer.parseInt(rs.getString("find_tax"));
                }
            }catch (Exception ex1)
            {
                System.out.println(ex1);
            }

            try{
                String query="insert into bill values('"+meter+"','"+month+"','"+unit+"','"+total_bill+"','Not paid')";
                Conn1 c= new Conn1();
                c.stmt1.executeUpdate(query);
                JOptionPane.showMessageDialog(null,"Coustumer Bill Calculated Sucessfully");
                f.setVisible(false);
            }catch (Exception ex)
            {

                System.out.println("ppp");
                System.out.println(ex);
            }
//
        }
    }
    public static void main(String[] args) {
        new CalculateBill();
    }
}

