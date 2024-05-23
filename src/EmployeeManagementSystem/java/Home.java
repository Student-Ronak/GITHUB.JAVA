package EmployeeManagementSystem.java;



import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
//ActionListener;

public class Home implements ActionListener {
    JFrame f= new JFrame();
    JButton addemp,view,update ,remove;
    Home()
    {
        f.setBounds(100,20,1120,670);
        ImageIcon i1= new ImageIcon("D:\\icons\\Home.jpg");
        Image i2= i1.getImage().getScaledInstance(1120,670,Image.SCALE_DEFAULT);
        ImageIcon i3= new ImageIcon(i2);
        JLabel image= new JLabel(i3);
        image.setBounds(00,00,1120,670);
        f.add(image);
        JLabel heading= new JLabel("EMPLOYEE MANAGEMENT SYSTEM");
        heading.setFont(new Font("RALWEY",Font.BOLD,20));
        heading.setBounds(650,30,350,20);
        heading.setForeground(Color.WHITE);
        image.add(heading);
        addemp= new JButton("Add Employee");
        addemp.setBounds(650,70,150,20);
        image.add(addemp);
        view= new JButton("View Employee");
        view.setBounds(820,70,150,20);
        image.add(view);
        update= new JButton("UPDATE Employee ");
        update.setBounds(650,130,150,20);
        image.add(update);
        remove= new JButton("Remove Employee");
        remove.setBounds(820,130,150,20);
        image.add(remove);
        addemp.addActionListener(this);
        update.addActionListener(this);
        remove.addActionListener(this);
        view.addActionListener(this);


        f.setVisible(true);
        f.setLayout(null);
        f.getContentPane().setBackground(Color.WHITE);
    }
    public void actionPerformed(ActionEvent e)
    {
        if(e.getSource()==addemp)
        {
            f.setVisible(false);
            new AddEmployee();
        } else if (e.getSource()==update) {
            f.setVisible(false);
            new Veiw();
        } else if (e.getSource()==remove) {
            new RemoveEmp();
        } else if (e.getSource()==view) {
            f.setVisible(false);
            new Veiw();
        }
    }
    public static void main(String[] args) {
        new Home();
    }
}
