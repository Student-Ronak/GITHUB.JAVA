package HotelManagementSystem.java;


import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;
import java.util.Date;

public class newCoustumer implements ActionListener {
    JFrame f;
    JComboBox id,tfroomnumber;
    JTextField tfnumber,tfname,tfcountry,tfdeposit;
    JLabel tfcashin;
    JRadioButton male ,female;
    JButton addCustumer,back;
    newCoustumer()
    {
        f= new JFrame();
        JLabel heading= new JLabel("NEW CUSTOMER FORM");
        heading.setBounds(40,10,400,30);
        heading.setFont(new Font("TAHOMA",Font.BOLD,25));
        heading.setForeground(Color.BLUE);
        f.add(heading);
        JLabel llbid= new JLabel("ID");
        llbid.setBounds(20,60,200,20);
        llbid.setFont(new Font("TAHOMA",Font.PLAIN,18));
        f.add(llbid);
        String[] sid= {"Addhar Card","Passport","Driving Lincense","Voter-ID","Ration Card"};
        id= new JComboBox<>(sid);
        id.setBounds(220,60,200,20);
        id.setFont(new Font("TAHOMA",Font.PLAIN,18));
        f.add(id);
        JLabel llbnumber= new JLabel("ID Number");
        llbnumber.setBounds(20,100,200,20);
        llbnumber.setFont(new Font("TAHOMA",Font.PLAIN,18));
        f.add(llbnumber);
        tfnumber= new JTextField();
        tfnumber.setBounds(220,100,200,20);
        tfnumber.setFont(new Font("TAHOMA",Font.PLAIN,18));
        f.add( tfnumber);

        JLabel llbname= new JLabel("Name");
        llbname.setBounds(20,140,200,20);
        llbname.setFont(new Font("TAHOMA",Font.PLAIN,18));
        f.add(llbname);
        tfname= new JTextField();
        tfname.setBounds(220,140,200,20);
        tfname.setFont(new Font("TAHOMA",Font.PLAIN,18));
        f.add( tfname);


        JLabel llbgender= new JLabel("Gender");
        llbgender.setBounds(20,180,200,20);
        llbgender.setFont(new Font("TAHOMA",Font.PLAIN,18));
        f.add(llbgender);
        male= new JRadioButton("Male");
        male.setBounds(220,180,90,20);
        male.setFont(new Font("TAHOMA",Font.PLAIN,18));
        f.add( male);
        female= new JRadioButton("Female");
        female.setBounds(320,180,90,20);
        female.setFont(new Font("TAHOMA",Font.PLAIN,18));
        f.add( female);
        ButtonGroup bg= new ButtonGroup();
        bg.add(male);
        bg.add(female);

        JLabel llbcountry= new JLabel("Country");
        llbcountry.setBounds(20,220,200,20);
        llbcountry.setFont(new Font("TAHOMA",Font.PLAIN,18));
        f.add(llbcountry);
        tfcountry= new JTextField();
        tfcountry.setBounds(220,220,200,20);
        tfcountry.setFont(new Font("TAHOMA",Font.PLAIN,18));
        f.add(tfcountry);
        JLabel llbroomnumber= new JLabel("Allowed Room Number");
        llbroomnumber.setBounds(20,260,200,20);
        llbroomnumber.setFont(new Font("TAHOMA",Font.PLAIN,18));
        f.add(llbroomnumber);
//        String []num={};
        tfroomnumber= new JComboBox<>();
//        tfroomnumber= new Choice();
        try{
            Conn3 c= new Conn3();
            String query="select * from room";
            ResultSet rs= c.stmt.executeQuery(query);
            while (rs.next())
            {
                tfroomnumber.addItem(rs.getString(1));
            }

        }catch (Exception e){

        }
        tfroomnumber.setBounds(220,260,200,20);
        tfroomnumber.setFont(new Font("TAHOMA",Font.PLAIN,18));
        f.add(tfroomnumber);
        JLabel llbcheckin= new JLabel("Check-In-Time");
        llbcheckin.setBounds(20,300,200,20);
        llbcheckin.setFont(new Font("TAHOMA",Font.PLAIN,18));
        f.add(llbcheckin);
        Date d= new Date();
        tfcashin= new JLabel(""+d);
        tfcashin.setBounds(210,300,200,20);
        tfcashin.setFont(new Font("TAHOMA",Font.PLAIN,18));
        f.add(tfcashin);
        JLabel llbDeposit= new JLabel("Deposit");
        llbDeposit.setBounds(20,340,200,20);
        llbDeposit.setFont(new Font("TAHOMA",Font.PLAIN,18));
        f.add(llbDeposit);
        tfdeposit= new JTextField();
        tfdeposit.setBounds(220,340,200,20);
        tfdeposit.setFont(new Font("TAHOMA",Font.PLAIN,18));
        f.add( tfdeposit);
        addCustumer= new JButton("Add Customer");
        addCustumer.setBackground(Color.BLACK);
        addCustumer.setForeground(Color.WHITE);
        addCustumer.setBounds(20,380,180,20);
        f.add(addCustumer);
        back= new JButton("Back");
        back.setBackground(Color.BLACK);
        back.setForeground(Color.WHITE);
        back.setBounds(220,380,200,20);
        f.add(back);
        addCustumer.addActionListener(this);
        back.addActionListener(this);
        f.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        f.setBounds(100,20,800,600);
        f.setLayout(null);
        f.setVisible(true);
    }
    public void actionPerformed(ActionEvent ae)
    {
        if(ae.getSource()==addCustumer)
        {
            String sid= (String) id.getSelectedItem();
            String rnumber= (String) tfroomnumber.getSelectedItem();
            String name= tfname.getText();
            String idnumber= tfnumber.getText();

            String country=tfcountry.getText();
            String deposit= tfdeposit.getText();
            String checkin=tfcashin.getText();
            String gender=null;
            if(male.isSelected())
            {
                gender="Male";
            } else if (female.isSelected()) {
                gender="Female";
            }
            try{
                Conn3 c= new Conn3();

                String query="insert into customer values('"+sid+"','"+idnumber+"','"+name+"','"+rnumber+"','"+gender+"','"+country+"','"+deposit+"','"+checkin+"')";
                String query2="update room set available='Occupied' where room1='"+rnumber+"'";
                c.stmt.executeUpdate(query);
                c.stmt.executeUpdate(query2);
                JOptionPane.showMessageDialog(null,"AddCustomer Sucessfully");
                f.setVisible(false);
            }catch (Exception ex){
                System.out.println(ex);
            }
        }else{
            f.setVisible(false);new Reception();
        }
    }
    public static void main(String[] args) {
        new newCoustumer();
    }
}

