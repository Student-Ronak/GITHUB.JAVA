package UNIVERSITYMANAGEMENTSYSTEM.JAVA;


import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;

public class Marks implements ActionListener {
    String rollNo;
    JFrame f;
    JButton cancel;
    Marks(String rollNo)
    {
        this.rollNo= rollNo;
        f= new JFrame();
        JLabel heading= new JLabel("Aligarh Maglayatan University");
        heading.setBounds(100,15,400,25);
        heading.setFont(new Font("TAHOMA",Font.BOLD,20));
        f.add(heading);
        JLabel SubHeading= new JLabel("Result Of Examination 2023");
        SubHeading.setBounds(100,60,400,25);
        SubHeading.setFont(new Font("TAHOMA",Font.BOLD,20));
        f.add(SubHeading);

        JLabel llbrollno= new JLabel("Roll Number "+rollNo);
        llbrollno.setBounds(100,95,400,25);
        llbrollno.setFont(new Font("TAHOMA",Font.PLAIN,20));
        f.add(llbrollno);
        JLabel llbSemester= new JLabel("m");
        llbSemester.setBounds(100,130,400,25);
        llbSemester.setFont(new Font("TAHOMA",Font.PLAIN,20));
        f.add(llbSemester);
        JLabel sub1= new JLabel();
        sub1.setBounds(100,170,500,20);
        sub1.setFont(new Font("TAHOMA",Font.PLAIN,16));
        f.add(sub1);
        JLabel sub2= new JLabel();
        sub2.setBounds(100,200,500,20);
        sub2.setFont(new Font("TAHOMA",Font.PLAIN,16));
        f.add(sub2);
        JLabel sub3= new JLabel();
        sub3.setBounds(100,230,500,20);
        sub3.setFont(new Font("TAHOMA",Font.PLAIN,16));
        f.add(sub3);
        JLabel sub4= new JLabel();
        sub4.setBounds(100,260,500,20);
        sub4.setFont(new Font("TAHOMA",Font.PLAIN,16));
        f.add(sub4);
        JLabel sub5= new JLabel();
        sub5.setBounds(100,290,500,20);
        sub5.setFont(new Font("TAHOMA",Font.PLAIN,16));
        f.add(sub5);

        try{
            Conn2 c= new Conn2();
            ResultSet rs1= c.stmt.executeQuery("select * from subject where rollNo='"+rollNo+"'");
            while(rs1.next())
            {
                llbSemester.setText("Semester "+rs1.getString(2));
                sub1.setText(rs1.getString(3));
                sub2.setText(rs1.getString(4));
                sub3.setText(rs1.getString(5));
                sub4.setText(rs1.getString(6));
                sub5.setText(rs1.getString(7));

            }
            rs1= c.stmt.executeQuery("select * from marks where rollNo='"+rollNo+"'");
            while(rs1.next())
            {

                sub1.setText(sub1.getText()+"-----------------"+rs1.getString(3));
                sub2.setText(sub2.getText()+"-------------------"+rs1.getString(4));
                sub3.setText(sub3.getText()+"-------------------"+rs1.getString(5));
                sub4.setText(sub4.getText()+"-------------------"+rs1.getString(6));
                sub5.setText(sub5.getText()+"-------------------"+rs1.getString(7));

            }
        }catch (Exception sube)
        {
            System.out.println(sube);
        }
        cancel= new JButton("Cancel");
        cancel.setBackground(Color.BLACK);
        cancel.setForeground(Color.WHITE);
        cancel.setBounds(200,320,100,25);
        f.add(cancel);
        cancel.addActionListener(this);



        f.setLayout(null);
        f.getContentPane().setBackground(Color.WHITE);
        f.setBounds(100,50,500,600);f.setVisible(true);

    }
    public void actionPerformed(ActionEvent ae)
    {
        f.setVisible(false);

    }
    public static void main(String[] args) {
        new Marks(" ");
    }
}
