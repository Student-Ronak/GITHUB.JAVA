package HotelManagementSystem.java;


import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


public class AddEmployee implements ActionListener {

    JFrame f;
    JTextField tfname,tfage,tfsalary,tfphone,tfemail,tfaddhar;
    JRadioButton male,female;
    JButton submit;
    JComboBox tfjob;
    AddEmployee()
    {
        f= new JFrame();
        ImageIcon i1 = new ImageIcon("D:\\icons\\manager.jpg");
        Image i2 = i1.getImage().getScaledInstance(500, 400, Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel image = new JLabel(i3);
        image.setBounds(400, 30, 500, 400);
        f.add(image);

        JLabel llbname= new JLabel("NAME");
//        llbname.setForeground(Color.WHITE);
        llbname.setFont(new Font("TAHOMA",Font.BOLD,20));
        llbname.setBounds(30,30,100,20);
        f.add(llbname);
        tfname= new JTextField();
        tfname.setFont(new Font("TAHOMA",Font.PLAIN,15));
        tfname.setBounds(150,30,200,20);
        f.add(tfname);
        JLabel llbage= new JLabel("AGE");
//        llbname.setForeground(Color.WHITE);
        llbage.setFont(new Font("TAHOMA",Font.BOLD,20));
        llbage.setBounds(30,70,100,20);
        f.add(llbage);
        tfage= new JTextField();
        tfage.setFont(new Font("TAHOMA",Font.PLAIN,15));
        tfage.setBounds(150,70,200,20);
        f.add(tfage);
        JLabel llbgender= new JLabel("GENDER");
//        llbname.setForeground(Color.WHITE);
        llbgender.setFont(new Font("TAHOMA",Font.BOLD,20));
        llbgender.setBounds(30,110,100,20);
        f.add(llbgender);
        male =new JRadioButton("MALE");
        male.setBackground(Color.black);
        male.setForeground(Color.WHITE);
        male.setBounds(150,110,90,20);
        female =new JRadioButton("MALE");
        female.setBackground(Color.black);
        female.setForeground(Color.WHITE);
        female.setBounds(250,110,90,20);
        ButtonGroup bg= new ButtonGroup();
        bg.add(male);
        bg.add(female);f.add(male);f.add(female);
//
        JLabel llbjob= new JLabel("JOB");
//        llbname.setForeground(Color.WHITE);
        llbjob.setFont(new Font("TAHOMA",Font.BOLD,20));
        llbjob.setBounds(30,150,100,20);
        f.add(llbjob);
        String [] str={"Front Desk Clerk","Porters","HouseKepping","KitchenStaff","Chef","Manager","Waiter/Waiteress","Accountant"};
        tfjob= new JComboBox<>(str);
        tfjob.setFont(new Font("TAHOMA",Font.PLAIN,15));
        tfjob.setBounds(150,150,200,20);
        f.add(tfjob);

        JLabel llbsalary= new JLabel("SALARY");
//        llbname.setForeground(Color.WHITE);
        llbsalary.setFont(new Font("TAHOMA",Font.BOLD,20));
        llbsalary.setBounds(30,190,100,20);
        f.add(llbsalary);
        tfsalary= new JTextField();
        tfsalary.setFont(new Font("TAHOMA",Font.PLAIN,15));
        tfsalary.setBounds(150,190,200,20);
        f.add(tfsalary);
        JLabel llbphone= new JLabel("PHONE");
//        llbname.setForeground(Color.WHITE);
        llbphone.setFont(new Font("TAHOMA",Font.BOLD,15));
        llbphone.setBounds(30,230,100,20);
        f.add(llbphone);
        tfphone= new JTextField();
        tfphone.setFont(new Font("TAHOMA",Font.PLAIN,15));
        tfphone.setBounds(150,230,200,20);
        f.add(tfphone);
        JLabel llbemail= new JLabel("EMAIL");
//        llbname.setForeground(Color.WHITE);
        llbemail.setFont(new Font("TAHOMA",Font.BOLD,20));
        llbemail.setBounds(30,270,100,20);
        f.add(llbemail);
        tfemail= new JTextField();
        tfemail.setFont(new Font("TAHOMA",Font.PLAIN,15));
        tfemail.setBounds(150,270,200,20);
        f.add(tfemail);
        JLabel llbaddhar= new JLabel("AADHAR");
//        llbname.setForeground(Color.WHITE);
        llbaddhar.setFont(new Font("TAHOMA",Font.BOLD,20));
        llbaddhar.setBounds(30,310,100,20);
        f.add(llbaddhar);
        tfaddhar= new JTextField();
        tfaddhar.setFont(new Font("TAHOMA",Font.PLAIN,15));
        tfaddhar.setBounds(150,310,200,20);
        f.add(tfaddhar);
        submit= new JButton("SUBMIT");
        submit.setBackground(Color.black);
        submit.setForeground(Color.WHITE);
        submit.setBounds(150,350,150,20);f.add(submit);
        submit.addActionListener(this);
        f.setBounds(210,50,900,500);
        f.getContentPane().setBackground(Color.WHITE);
        f.setLayout(null);

        f.setVisible(true);
    }
    public void actionPerformed(ActionEvent e)
    {
        String name= tfname.getText();
        String age= tfage.getText();
        String mail= tfemail.getText();
        String addhar= tfaddhar.getText();
        String phone= tfphone.getText();
        String job= (String) tfjob.getSelectedItem();
        String salary= tfsalary.getText();
        String gender=null;
        if(male.isSelected())
        {
            gender="Male";
        }else{
            gender="Female";
        }

        try{

            Conn3 c= new Conn3();
            String query="insert into employee values('"+name+"','"+age+"','"+gender+"','"+job+"','"+salary+"','"+phone+"','"+mail+"','"+addhar+"')";

            c.stmt.executeUpdate(query);
            JOptionPane.showMessageDialog(null,"employee Details add Sucessfully");
            f.setVisible(false);
        }catch (Exception ae)
        {

        }
    }
    public static void main(String[] args) {
        new AddEmployee();
    }
}

