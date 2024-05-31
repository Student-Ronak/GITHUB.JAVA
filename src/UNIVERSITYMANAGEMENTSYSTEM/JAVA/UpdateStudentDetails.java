package UNIVERSITYMANAGEMENTSYSTEM.JAVA;

//package UniversityManagementSystem.java;
//
//public class UpdateStudentDetails {
//}


import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.sql.ResultSet;
import java.util.Random;

public class UpdateStudentDetails implements ActionListener {
    JFrame f;
    JTextField tfphone,tfaddress,tfemailaddress,tfcourse,tfbranch;
    //    JComboBox tfcourse,tfbranch;
    JLabel tfroll,tfname,tffname,tfdob,tfclassX,tfclassXII,tfaddhar;
    Random ran =new Random();
    JComboBox rollno;
    int roll= ran.nextInt(999999);
    JButton submit,cancel;
    UpdateStudentDetails()
    {
        f= new JFrame();
        f.setBounds(100,100,900,700);
        JLabel heading=new JLabel("Update Student Details");
        heading.setBounds(50,10,300,25);
        heading.setFont(new Font("TAHOMA",Font.ITALIC,25));
        f.add(heading);
        JLabel llbsearch= new JLabel("Search by Roll No");
        llbsearch.setBounds(20,40,150,20);
        f.add(llbsearch);
        rollno= new JComboBox<>();
        rollno.setBounds(190,40,100,20);
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




        JLabel llbname=new JLabel("Name");
        llbname.setFont(new Font("TAHOMA",Font.BOLD,20));
        llbname.setBounds(50,70,150,20);
        f.add(llbname);
        tfname= new JLabel();
        tfname.setBounds(250,70,150,20);
        f.add(tfname);
        JLabel llbfname=new JLabel("Father Name");
        llbfname.setFont(new Font("TAHOMA",Font.BOLD,20));
        llbfname.setBounds(420,70,150,20);
        f.add(llbfname);
        tffname= new JLabel();
        tffname.setBounds(620,70,150,20);
        f.add(tffname);
        JLabel llbroll=new JLabel("Roll No");
        llbroll.setFont(new Font("TAHOMA",Font.BOLD,20));
        llbroll.setBounds(50,120,150,20);
        f.add(llbroll);
        tfroll= new JLabel();
//        tfroll.setText(String.valueOf(roll));
        tfroll.setBounds(250,120,150,20);
        f.add(  tfroll);
        JLabel llbdob=new JLabel("Date of Birth");
        llbdob.setFont(new Font("TAHOMA",Font.BOLD,20));
        llbdob.setBounds(420,120,150,20);
        f.add(llbdob);
        tfdob= new JLabel();
        tfdob.setBounds(620,120,150,20);
        f.add(tfdob);
        JLabel llbAddress=new JLabel("Address");
        llbAddress.setFont(new Font("TAHOMA",Font.BOLD,20));
        llbAddress.setBounds(50,170,150,20);
        f.add(llbAddress);
        tfaddress= new JTextField();
        tfaddress.setBounds(250,170,150,20);
        f.add(  tfaddress);
        JLabel llbPhone=new JLabel("Phone");
        llbPhone.setFont(new Font("TAHOMA",Font.BOLD,20));
        llbPhone.setBounds(420,170,150,20);
        f.add(llbPhone);
        tfphone= new JTextField();
        tfphone.setBounds(620,170,150,20);
        f.add(tfphone);
        JLabel llbemailAddress=new JLabel("Email ID");
        llbemailAddress.setFont(new Font("TAHOMA",Font.BOLD,20));
        llbemailAddress.setBounds(50,220,150,20);
        f.add(llbemailAddress);
        tfemailaddress= new JTextField();
        tfemailaddress.setBounds(250,220,150,20);
        f.add(  tfemailaddress);
        JLabel llbclassX=new JLabel("ClassX(%)");
        llbclassX.setFont(new Font("TAHOMA",Font.BOLD,20));
        llbclassX.setBounds(420,220,150,20);
        f.add(llbclassX);
        tfclassX= new JLabel();
        tfclassX.setBounds(620,220,150,20);
        f.add(tfclassX);
        JLabel llbClassXII=new JLabel("ClassXII(%)");
        llbClassXII.setFont(new Font("TAHOMA",Font.BOLD,20));
        llbClassXII.setBounds(50,270,150,20);
        f.add(llbClassXII);
        tfclassXII= new JLabel();
        tfclassXII.setBounds(250,270,150,20);
        f.add(  tfclassXII);
        JLabel llbaddhar=new JLabel("Addhar No");
        llbaddhar.setFont(new Font("TAHOMA",Font.BOLD,20));
        llbaddhar.setBounds(420,270,150,20);
        f.add(llbaddhar);
        tfaddhar= new JLabel();
        tfaddhar.setBounds(620,270,150,20);
        f.add(tfaddhar);
        JLabel Course=new JLabel("Course");
        Course.setFont(new Font("TAHOMA",Font.BOLD,20));
        Course.setBounds(50,320,150,20);
        f.add(Course);
//        String[] course={"BTECH","BBA","BCA","MCA","BSC","MSC","MBA","MSC","MTECH"};
        tfcourse= new JTextField();
        tfcourse.setBounds(250,320,150,20);
        f.add( tfcourse );
        JLabel branch =new JLabel("Branch");
        branch.setFont(new Font("TAHOMA",Font.BOLD,20));
        branch.setBounds(420,320,150,20);
        f.add(branch);
//        String []branch1={"Computer Science","Mechanical ","Civil","IT"};
        tfbranch= new JTextField();
        tfbranch.setBounds(620,320,150,20);
        f.add( tfbranch );
        try {
            Conn2 c= new Conn2();
            String query="select * from student where rollNo='"+rollno.getSelectedItem()+"'";
            ResultSet rs=c.stmt.executeQuery(query);
            while (rs.next())
            {   tfroll.setText(rs.getString(1));
                tfname.setText(rs.getString(2));
                tffname.setText(rs.getString(3));
                tfdob.setText(rs.getString(4));
                tfaddress.setText(rs.getString(5));
                tfphone.setText(rs.getString(6));
                tfemailaddress.setText(rs.getString(7));
                tfclassX.setText(rs.getString(8));
                tfclassXII.setText(rs.getString(9));
                tfaddhar.setText(rs.getString(10));
                tfcourse.setText(rs.getString(11));
                tfbranch.setText(rs.getString(12));
            }
        }catch (Exception b)
        {
            System.out.println("problem in button");
        }
        rollno.addItemListener(new ItemListener() {
            @Override
            public void itemStateChanged(ItemEvent ie) {
                try {
                    Conn2 c= new Conn2();
                    String query="select * from student where rollNo='"+rollno.getSelectedItem()+"'";
                    ResultSet rs=c.stmt.executeQuery(query);
                    while (rs.next())
                    {   tfroll.setText(rs.getString(1));
                        tfname.setText(rs.getString(2));
                        tffname.setText(rs.getString(3));
                        tfdob.setText(rs.getString(4));
                        tfaddress.setText(rs.getString(5));
                        tfphone.setText(rs.getString(6));
                        tfemailaddress.setText(rs.getString(7));
                        tfclassX.setText(rs.getString(8));
                        tfclassXII.setText(rs.getString(9));
                        tfaddhar.setText(rs.getString(10));
                        tfcourse.setText(rs.getString(11));
                        tfbranch.setText(rs.getString(12));
                    }
                }catch (Exception b)
                {
                    System.out.println("problem in button");
                }
            }
        });
        submit= new JButton("Update");
        submit.setBounds(150,380,100,20);
        submit.setBackground(Color.BLACK);
        submit.setForeground(Color.WHITE);
        f.add(submit);
        cancel= new JButton("Cancel");
        cancel.setBackground(Color.BLACK);
        cancel.setForeground(Color.WHITE);
        cancel.setBounds(320,380,100,20);
        f.add(cancel);
        cancel.addActionListener(this);
        submit.addActionListener(this);
//f.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        f.setLayout(null);
        f.getContentPane().setBackground(Color.WHITE);
        f.setVisible(true);



    }
    public void actionPerformed(ActionEvent e)
    {
        if(e.getSource()==submit)
        {
//       JTextField tfname,tffname,tfdob,tfphone,tfaddress,tfemailaddress,tfclassX,tfaddhar,tfclassXII;
//   JComboBox tfcourse,tfbranch;
//   JLabel tfroll;
//
//
//

            String address= tfaddress.getText();
            String email=tfemailaddress.getText();
            String phone= tfphone.getText();

            String course=  tfcourse.getText();

            String branch= tfbranch.getText();
//
            String roll=tfroll.getText();

            String query="update student set address='"+address+"',phone='"+phone+"',email='"+email+"',course='"+course+"',branch='"+branch+"'where rollNo= '"+roll+"'";
            try{
                Conn2 c= new Conn2();
                c.stmt.executeUpdate(query);


                JOptionPane.showMessageDialog(null,"Student details Update  Sucessfully");

            }catch (Exception ex)
            {
                System.out.println(ex);
            }


        }else {
            f.setVisible(false);
            new Home();
        }
    }

    public static void main(String[] args) {
        new UpdateStudentDetails();
    }
}
