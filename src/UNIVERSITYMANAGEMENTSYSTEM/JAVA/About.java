package UNIVERSITYMANAGEMENTSYSTEM.JAVA;


import javax.swing.*;
import java.awt.*;

public class About {
    JFrame f;
    About()
    {
        f= new JFrame();

        ImageIcon i1 = new ImageIcon("D:\\icons\\university.jpg");
        Image i2 = i1.getImage().getScaledInstance(310, 200, Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel image = new JLabel(i3);
        image.setBounds(380, 50, 300, 200);
        f.add(image);
        JLabel heading= new JLabel("<html> University <br> Management System </html>");
        heading.setBounds(50,20,400,70);
        heading.setFont(new Font("TAHOMA",Font.BOLD,30));
        f.add(heading);
        JLabel llbname=new JLabel("Developed By Ronak Jain");
        llbname.setFont(new Font("TAHOMA",Font.BOLD,24));
        llbname.setBounds(50,250,350,25);
        f.add(llbname);
        JLabel llbrollNo=new JLabel("ROLL NUMBER 22200060");
        llbrollNo.setFont(new Font("TAHOMA",Font.BOLD,24));
        llbrollNo.setBounds(50,290,350,25);
        f.add(llbrollNo);
        JLabel llbContact =new JLabel("contact with Softtechno Insitiute");
        llbContact.setFont(new Font("TAHOMA",Font.PLAIN,24));
        llbContact.setBounds(50,330,350,25);
        f.add(llbContact);
        f.getContentPane().setBackground(Color.WHITE);
        f.setLayout(null);
        f.setBounds(100,100,700,500);
        f.setVisible(true);
    }
    public static void main(String[] args) {
        new About();
    }
}
