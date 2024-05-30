package UNIVERSITYMANAGEMENTSYSTEM.JAVA;



import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;

public class EnterMarks implements ActionListener {
    JFrame f;
    JComboBox rollno,sem;
    JTextField ISub, IISub, IIISub, IVSub, VSub,IMark,IIMark,IIIMark,IVMark,VMark;
    JButton submit,cancel;
    EnterMarks()
    {
        f= new JFrame();
        f.setBounds(100,50,1000,450);

        f.setLayout(null);
        ImageIcon i1 = new ImageIcon("D:\\icons\\university.jpg");
        Image i2 = i1.getImage().getScaledInstance(400, 300, Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel image = new JLabel(i3);
        image.setBounds(500, 30, 400, 300);
        f.add(image);

        JLabel heading=new JLabel("Enter Marks of Student");
        heading.setBounds(50,5,300,25);
        heading.setFont(new Font("TAHOMA",Font.ITALIC,25));
        f.add(heading);
        JLabel llbsearch= new JLabel("Search Roll Number");
        llbsearch.setBounds(30,40,200,18);
        llbsearch.setFont(new Font("TAHOMA",Font.BOLD,20));
        f.add(llbsearch);
        rollno= new JComboBox<>();
        rollno.setBounds(250,40,100,20);
        f.add(rollno);
        try{
            Conn2 c= new Conn2();
            ResultSet rs= c.stmt.executeQuery("select * from student");
            while (rs.next())
            {
                rollno.addItem(rs.getString(1));
            }
        }catch (Exception e)
        {
            System.out.println(e);
        }
        JLabel llbSemSearch= new JLabel("Select Semester");
        llbSemSearch.setBounds(30,80,200,20);
        llbSemSearch.setFont(new Font("TAHOMA",Font.BOLD,20));
        f.add(llbSemSearch);
        String[] selectSem={"1st Semester","IInd Semester","IIIrd Semester","IVth Semester","Vth Semester","VIth Semester"};
        sem= new JComboBox<>(selectSem);
        sem.setBounds(250,80,100,20);
        f.add(sem);
        JLabel llbsubject= new JLabel("Enter Subject");
        llbsubject.setBounds(30,110,200,20);
        llbsubject.setFont(new Font("TAHOMA",Font.BOLD,20));
        f.add(llbsubject);
        JLabel llbMark= new JLabel("Enter Mark");
        llbMark.setBounds(230,110,200,20);
        f.add(llbMark);
        llbMark.setFont(new Font("TAHOMA",Font.BOLD,20));
        ISub= new JTextField();
        ISub.setBounds(30,150,150,20);
        f.add(ISub);
        IISub= new JTextField();
        IISub.setBounds(30,190,150,20);
        f.add(IISub);
        IIISub= new JTextField();
        IIISub.setBounds(30,230,150,20);
        f.add(IIISub);
        IVSub= new JTextField();
        IVSub.setBounds(30,270,150,20);
        f.add(IVSub);
        VSub= new JTextField();
        VSub.setBounds(30,310,150,20);
        f.add(VSub);

        IMark= new JTextField();
        IMark.setBounds(200,150,150,20);
        f.add(IMark);
        IIMark= new JTextField();
        IIMark.setBounds(200,190,150,20);
        f.add(IIMark);
        IIIMark= new JTextField();
        IIIMark.setBounds(200,230,150,20);
        f.add(IIIMark);
        IVMark= new JTextField();
        IVMark.setBounds(200,270,150,20)    ;
        f.add(IVMark);
        VMark= new JTextField();
        VMark.setBounds(200,310,150,20);
        f.add(VMark);
        submit= new JButton("SUBMIT");
        submit.setBounds(80,350,100,20);
        submit.setBackground(Color.BLACK);
        submit.setForeground(Color.WHITE);
        f.add(submit);
        cancel= new JButton("CANCEL");
        cancel.setBackground(Color.BLACK);
        cancel.setForeground(Color.WHITE);
        cancel.setBounds(200,350,100,20);
        f.add(cancel);
        cancel.addActionListener(this);
        submit.addActionListener(this);
        f.getContentPane().setBackground(Color.WHITE);
        f.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        f.setVisible(true);
    }
    public void actionPerformed(ActionEvent e)
    {
        if(e.getSource()==submit)
        {
            try{
                Conn2 c= new Conn2();
                String query1="insert into subject values('"+rollno.getSelectedItem()+"','"+sem.getSelectedItem()+"','"+ISub.getText()+"','"+IISub.getText()+"','"+IIISub.getText()+"','"+IVSub.getText()+"','"+VSub.getText()+"')";
                String query2="insert into marks values('"+rollno.getSelectedItem()+"','"+sem.getSelectedItem()+"','"+IMark.getText()+"','"+IIMark.getText()+"','"+IIIMark.getText()+"','"+IVMark.getText()+"','"+VMark.getText()+"')";
                c.stmt.executeUpdate(query1);
                c.stmt.executeUpdate(query2);
                JOptionPane.showMessageDialog(null,"Marks inserted Sucessfully");
                f.setVisible(false);
                new Home();
            }catch(Exception e1)
            {
                System.out.println(e1);
            }
        }else {
            f.setVisible(false);
            new Home();
        }
    }
    public static void main(String[] args) {
        new EnterMarks();
    }
}

