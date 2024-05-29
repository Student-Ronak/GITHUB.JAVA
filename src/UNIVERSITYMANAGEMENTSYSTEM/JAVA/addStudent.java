package UNIVERSITYMANAGEMENTSYSTEM.JAVA;



import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Random;

public class addStudent implements ActionListener {
    JFrame f;
    JTextField tfname,tffname,tfdob,tfphone,tfaddress,tfemailaddress,tfclassX,tfaddhar,tfclassXII;
    JComboBox tfcourse,tfbranch;
    JLabel tfroll;
    Random ran =new Random();
    int roll= ran.nextInt(999999);
    JButton submit,cancel;
    addStudent()
    {
        f= new JFrame();
        f.setBounds(100,20,900,600);
        JLabel heading=new JLabel("New Student Details");
        heading.setBounds(100,20,300,30);
        heading.setFont(new Font("TAHOMA",Font.BOLD,25));
        f.add(heading);
        JLabel llbname=new JLabel("Name");
        llbname.setFont(new Font("TAHOMA",Font.BOLD,20));
        llbname.setBounds(50,70,150,20);
        f.add(llbname);
        tfname= new JTextField();
        tfname.setBounds(250,70,150,20);
        f.add(tfname);
        JLabel llbfname=new JLabel("Father Name");
        llbfname.setFont(new Font("TAHOMA",Font.BOLD,20));
        llbfname.setBounds(420,70,150,20);
        f.add(llbfname);
        tffname= new JTextField();
        tffname.setBounds(620,70,150,20);
        f.add(tffname);
        JLabel llbroll=new JLabel("Roll No");
        llbroll.setFont(new Font("TAHOMA",Font.BOLD,20));
        llbroll.setBounds(50,120,150,20);
        f.add(llbroll);
        tfroll= new JLabel(""+roll);
//        tfroll.setText(String.valueOf(roll));
        tfroll.setBounds(250,120,150,20);
        f.add(  tfroll);
        JLabel llbdob=new JLabel("Date of Birth");
        llbdob.setFont(new Font("TAHOMA",Font.BOLD,20));
        llbdob.setBounds(420,120,150,20);
        f.add(llbdob);
        tfdob= new JTextField();
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
        tfclassX= new JTextField();
        tfclassX.setBounds(620,220,150,20);
        f.add(tfclassX);
        JLabel llbClassXII=new JLabel("ClassXII(%)");
        llbClassXII.setFont(new Font("TAHOMA",Font.BOLD,20));
        llbClassXII.setBounds(50,270,150,20);
        f.add(llbClassXII);
        tfclassXII= new JTextField();
        tfclassXII.setBounds(250,270,150,20);
        f.add(  tfclassXII);
        JLabel llbaddhar=new JLabel("Addhar No");
        llbaddhar.setFont(new Font("TAHOMA",Font.BOLD,20));
        llbaddhar.setBounds(420,270,150,20);
        f.add(llbaddhar);
        tfaddhar= new JTextField();
        tfaddhar.setBounds(620,270,150,20);
        f.add(tfaddhar);
        JLabel Course=new JLabel("Course");
        Course.setFont(new Font("TAHOMA",Font.BOLD,20));
        Course.setBounds(50,320,150,20);
        f.add(Course);
        String[] course={"BTECH","BBA","BCA","MCA","BSC","MSC","MBA","MSC","MTECH"};
        tfcourse= new JComboBox<>(course);
        tfcourse.setBounds(250,320,150,20);
        f.add( tfcourse );
        JLabel branch =new JLabel("Branch");
        branch.setFont(new Font("TAHOMA",Font.BOLD,20));
        branch.setBounds(420,320,150,20);
        f.add(branch);
        String []branch1={"Computer Science","Mechanical ","Civil","IT"};
        tfbranch= new JComboBox<>(branch1);
        tfbranch.setBounds(620,320,150,20);
        f.add( tfbranch );
        submit= new JButton("Submit");
        submit.setBounds(150,380,100,20);
        submit.setBackground(Color.BLACK);
        submit.setForeground(Color.BLUE);
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


            String name=tfname.getText();String fname=tffname.getText();String dob=tfdob.getText();

            String address= tfaddress.getText();String email=tfemailaddress.getText();String phone= tfphone.getText();String addhar=tfaddhar.getText();
            String course= (String) tfcourse.getSelectedItem();

            String branch= (String) tfbranch.getSelectedItem();String classX=tfclassX.getText();String classXII=tfclassXII.getText();
            String roll=tfroll.getText();

            String query="insert into student values('"+roll+"','"+name+"','"+fname+"','"+dob+"','"+address+"','"+phone+"','"+email+"','"+classX+"','"+classXII+"','"+addhar+"','"+course+"','"+branch+"')";
            try{
                Conn2 c= new Conn2();
                c.stmt.executeUpdate(query);


                JOptionPane.showMessageDialog(null,"Student details add Sucessfully");

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
        new addStudent();
    }
}
