package HotelManagementSystem.java;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class AddDrivers implements ActionListener {
    JFrame f;
    JTextField tfname,tfage,tfcar,tfModel,tfLocation;
    JComboBox tfgender,tfavailableDriver;
    JButton add,cancel;
    AddDrivers()
    {
        f= new JFrame();
        JLabel heading= new JLabel("ADD DRIVERS");
        heading.setBounds(100,30,200,20);
        heading.setFont(new Font("TRAHOMA",Font.BOLD,18));
        f.add(heading);
        ImageIcon i1 = new ImageIcon("D:\\icons\\driver.jpg");
        Image i2 = i1.getImage().getScaledInstance(500, 400, Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel image = new JLabel(i3);
        image.setBounds(320, 30, 500, 400);
        f.add(image);

        JLabel llbroomno= new JLabel("Name");
        llbroomno.setBounds(20,60,120,20);
        llbroomno.setFont(new Font("TRAHOMA",Font.PLAIN,14));
        f.add(llbroomno);
        tfname= new JTextField();
        tfname.setBounds(160,60,120,20);
        tfname.setFont(new Font("TRAHOMA",Font.PLAIN,14));
        f.add(tfname);
        JLabel llbavailable= new JLabel("Age");
        llbavailable.setBounds(20,100,120,20);
        llbavailable.setFont(new Font("TRAHOMA",Font.PLAIN,14));
        f.add(llbavailable);

        tfage= new JTextField();
        tfage.setBounds(160,100,120,20);
        tfage.setFont(new Font("TRAHOMA",Font.PLAIN,14));
        f.add(tfage);

        JLabel llbclean= new JLabel("Gender");
        llbclean.setBounds(20,140,120,20);
        llbclean.setFont(new Font("TRAHOMA",Font.PLAIN,14));
        f.add(llbclean);
        String[] clean={"Male","Female"};
        tfgender= new JComboBox<>(clean);
        tfgender.setBounds(160,140,120,20);
        tfgender.setFont(new Font("TRAHOMA",Font.PLAIN,14));
        f.add(tfgender);


        JLabel llbprice= new JLabel("Car Company");
        llbprice.setBounds(20,180,120,20);
        llbprice.setFont(new Font("TRAHOMA",Font.PLAIN,14));
        f.add(llbprice);
        tfcar= new JTextField();
        tfcar.setBounds(160,180,120,20);
        tfcar.setFont(new Font("TRAHOMA",Font.PLAIN,14));
        f.add(tfcar);
        JLabel llbType= new JLabel("Car Model");
        llbType.setBounds(20,220,120,20);
        llbType.setFont(new Font("TRAHOMA",Font.PLAIN,14));
        f.add(llbType);
        tfModel= new JTextField();
        tfModel.setBounds(160,220,120,20);
        tfModel.setFont(new Font("TRAHOMA",Font.PLAIN,14));
        f.add(tfModel);
        JLabel llbdriveravilabel=new JLabel("Avialable");
        llbdriveravilabel.setBounds(20,260,120,20);
        llbdriveravilabel.setFont(new Font("TRAHOMA",Font.PLAIN,14));
        f.add(llbdriveravilabel);
        String[] driver={"Available","UnAvailable"};
        tfavailableDriver= new JComboBox(driver);
        tfavailableDriver.setBounds(160,260,120,20);
        tfavailableDriver.setFont(new Font("TRAHOMA",Font.PLAIN,14));
        f.add(tfavailableDriver);
        JLabel llbLocation= new JLabel("Location");
        llbLocation.setBounds(20,300,120,20);
        llbLocation.setFont(new Font("TRAHOMA",Font.PLAIN,14));
        f.add(llbLocation);
        tfLocation= new JTextField();
        tfLocation.setBounds(160,300,120,20);
        tfLocation.setFont(new Font("TRAHOMA",Font.PLAIN,14));
        f.add(tfLocation);

        add= new JButton("Add");
        add.setBounds(20,340,120,20);
        add.setBackground(Color.black);add.setForeground(Color.WHITE);
        f.add(add);
        add.addActionListener(this);
        cancel= new JButton("Cancel");
        cancel.setBounds(160,340,120,20);
        cancel.setBackground(Color.black);cancel.setForeground(Color.WHITE);
        f.add(cancel);
        cancel.addActionListener(this);
        f.setLayout(null);
        f.setBounds(100,20,1000,500);
        f.getContentPane().setBackground(Color.WHITE);
        f.setVisible(true);



    }
    public void actionPerformed(ActionEvent e)
    {
//-----------------------------------------
//            JTextField tfname,tfage,tfcar,tfModel,tfLocation;
//    JComboBox tfavailable,tftype,tfgender,tfavailableDriver;
//    JButton add,cancel;
        if(e.getSource()==add){
            String name= tfname.getText();
            String age= tfage.getText();
            String gender= (String) tfgender.getSelectedItem();
            String car= tfcar.getText();
            String model= tfModel.getText();
//
            String Location= tfLocation.getText();
            String driverAvialable= (String) tfavailableDriver.getSelectedItem();

            try{
                Conn3 c= new Conn3();
                String query="insert into driver values('"+name+"','"+age+"','"+gender+"','"+car+"','"+model+"','"+Location+"','"+driverAvialable+"')";
                c.stmt.executeUpdate(query);
                JOptionPane.showMessageDialog(null,"New Driver Add Sucessfully");
                f.setVisible(false);
            }catch (Exception ae)
            {
                System.out.println(ae);
            }

        }else{
            f.setVisible(false);
        }
    }
    public static void main(String[] args) {
        new AddDrivers();
    }
}
