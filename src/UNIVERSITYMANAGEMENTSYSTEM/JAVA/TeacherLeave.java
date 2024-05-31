package UNIVERSITYMANAGEMENTSYSTEM.JAVA;




import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.*;
//ResultSet;

public class TeacherLeave implements ActionListener
{
    JFrame f= new JFrame();
    JComboBox rollno,cTime;
    JTextField tfdate;
    JButton submit,cancel;
    TeacherLeave()
    {
        f.setLayout(null);
        JLabel heading= new JLabel("Applied Leave Teacher");
        heading.setBounds(20,20,400,25);
        heading.setFont(new Font("TAHOMA",Font.BOLD,25));

        f.add(heading);
        JLabel llbsearch= new JLabel("Search by Employee Id");
        llbsearch.setBounds(50,55,150,20);
        f.add(llbsearch);
        rollno= new JComboBox<>();
        rollno.setBounds(50,85,150,20);
        f.add(rollno);
        try{
            Conn2 c= new Conn2();
            ResultSet rs= c.stmt.executeQuery("select * from teacher");


            while (rs.next())
            {
                rollno.addItem(rs.getString(1));
            }
        }catch (Exception e)
        {
            System.out.println(e);
        }
        JLabel llbdate= new JLabel("Date");
        llbdate.setBounds(40,120,200,25);
        llbdate.setFont(new Font("TAHOMA",Font.BOLD,25));

        f.add(llbdate);
        tfdate= new JTextField();
        tfdate.setBounds(40,150,200,25);
//        tfdate.setFont(new Font("TAHOMA",Font.BOLD,25));

        f.add(tfdate);
        JLabel llbTime= new JLabel("Time");
        llbTime.setBounds(40,200,200,25);
        llbTime.setFont(new Font("TAHOMA",Font.BOLD,25));

        f.add(llbTime);
        String []Time={"Full Time","Half Day"};
        cTime= new JComboBox<>(Time);
        cTime.setBounds(40,230,200,25);
        f.add(cTime);
        submit= new JButton("Submit");
        submit.setBounds(50,270,100,20);
        submit.setBackground(Color.BLACK);
        submit.setForeground(Color.BLUE);
        f.add(submit);
        cancel= new JButton("Cancel");
        cancel.setBackground(Color.BLACK);
        cancel.setForeground(Color.WHITE);
        cancel.setBounds(200,270,100,20);
        f.add(cancel);
        submit.addActionListener(this);
        f.setBounds(100,50,500,550);
        f.getContentPane().setBackground(Color.WHITE);
        f.setVisible(true);
    }
    public void actionPerformed(ActionEvent ae)
    {
        if(ae.getSource()==submit)
        {
            String rollNo= (String) rollno.getSelectedItem();
            String date= tfdate.getText();
            String duration= (String) cTime.getSelectedItem();
            String query="insert into teacherLeave values('"+rollNo+"','"+date+"','"+duration+"')";
            try{
                Conn2 c= new Conn2();
                c.stmt.executeUpdate(query);
                JOptionPane.showMessageDialog(null,"Leave Confirmation");
                f.setVisible(false);
                new  Home();
            }catch (Exception e)
            {
                System.out.println(e);
            }

        }else{
            f.setVisible(false);
            new Home();
        }
    }
    public static void main(String[] args) {
        new TeacherLeave();
    }
}



