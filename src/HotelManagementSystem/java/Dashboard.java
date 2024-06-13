package HotelManagementSystem.java;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Dashboard implements ActionListener {
    JFrame f;
    JMenu hotel,admin;
    JMenuItem reception,addemp,addroom,adddriver;
    Dashboard()
    {
        f= new JFrame();
        f.setBounds(00,20,1366,700);
        ImageIcon i1= new ImageIcon("D:\\icons\\hotel.jpg");
        Image i2= i1.getImage().getScaledInstance(1366,700,Image.SCALE_DEFAULT);
        ImageIcon i3= new ImageIcon(i2);
        JLabel image= new JLabel(i3);
        image.setBounds(00,00,1366,700);
        JLabel heading= new JLabel("THE TAJ GROUP WELCOME YOU");
        heading.setFont(new Font("TAHOMA",Font.BOLD,46));
        heading.setBounds(200,50,800,50);
        heading.setForeground(Color.WHITE);
        image.add(heading);
        f.add(image);
        JMenuBar mb= new JMenuBar();
        f.setJMenuBar(mb);
        hotel= new JMenu("HOTEL MANAGEMENT");
        hotel.setForeground(Color.RED);
        mb.add(hotel);
        reception= new JMenuItem("RECEPTION");
        reception.setForeground(Color.cyan);
        hotel.add(reception);
        admin= new JMenu("Admin");
        admin.setForeground(Color.BLUE);
        mb.add(admin);
        addemp= new JMenuItem("ADD EMPLOYEE");

        admin.add(addemp);
        addroom= new JMenuItem("ADD ROOM");

        admin.add(addroom);
        adddriver= new JMenuItem("ADD DRIVER");
        admin.add(adddriver);
        reception.addActionListener(this);
        addemp.addActionListener(this);
        adddriver.addActionListener(this);
        addroom.addActionListener(this);


        f.setLayout(null);
        f.setVisible(true);
        while(true)
        {
            heading.setVisible(true);
            try{
                Thread.sleep(500);
            }catch (Exception e1){
                System.out.println(e1);
            }
            heading.setVisible(false);
            try{
                Thread.sleep(500);
            }catch (Exception e1){
                System.out.println(e1);
            }
        }

    }
    public void actionPerformed(ActionEvent e){
        if(e.getSource()==reception){
            new Reception();
        } else if (e.getSource()==addemp) {
            new AddEmployee();
        } else if (e.getSource()==adddriver) {
            new AddDrivers();
        } else if (e.getSource()==addroom) {
            new AddRoom();
        }
    }
    public static void main(String[] args) {
        new Dashboard();
    }
}
