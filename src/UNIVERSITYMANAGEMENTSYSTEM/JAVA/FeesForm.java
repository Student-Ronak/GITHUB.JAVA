package UNIVERSITYMANAGEMENTSYSTEM.JAVA;


import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.sql.ResultSet;

public class FeesForm  implements ActionListener {
    JFrame f;
    JComboBox rollno,tfcourse,tfbranch,sem;
    JLabel tfname,tffname,tfpay;
    JButton update ,pay,back;
    FeesForm()
    {
        f= new JFrame();
        ImageIcon i1 = new ImageIcon("D:\\icons\\university.jpg");
        Image i2 = i1.getImage().getScaledInstance(300, 400, Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel image = new JLabel(i3);
        image.setBounds(380, 50, 300, 400);
        f.add(image);
        JLabel heading = new JLabel("FEES FORM");
        heading.setBounds(50,20,250,30);
        heading.setFont(new Font("TAHOMA",Font.BOLD,25));
        f.add(heading);
        JLabel llbsearch= new JLabel("Select Roll No");
        llbsearch.setBounds(50,60,150,20);
        llbsearch.setFont(new Font("TAHOMA",Font.BOLD,19));
        f.add(llbsearch);
        rollno= new JComboBox<>();
        rollno.setBounds(250,60,100,20);
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
        llbname.setBounds(50,90,150,20);
        f.add(llbname);
        tfname= new JLabel();
        tfname.setBounds(250,90,150,20);
        f.add(tfname);
        JLabel llbfname=new JLabel("Father Name");
        llbfname.setFont(new Font("TAHOMA",Font.BOLD,20));
        llbfname.setBounds(50,120,150,20);
        f.add(llbfname);
        tffname= new JLabel();
        tffname.setBounds(250,120,150,20);
        f.add(tffname);
        JLabel Course=new JLabel("Course");
        Course.setFont(new Font("TAHOMA",Font.BOLD,20));
        Course.setBounds(50,150,150,20);
        f.add(Course);
        String[] course={"BTECH","BBA","BCA","MCA","BSC","MSC","MBA","MSC","MTECH"};
        tfcourse= new JComboBox<>(course);
        tfcourse.setBounds(250,150,100,20);
        f.add( tfcourse );
        JLabel branch =new JLabel("Branch");
        branch.setFont(new Font("TAHOMA",Font.BOLD,20));
        branch.setBounds(50,180,150,20);
        f.add(branch);
        String []branch1={"Computer Science","Mechanical ","Civil","IT"};
        tfbranch= new JComboBox<>(branch1);
        tfbranch.setBounds(250,180,100,20);
        f.add( tfbranch );
        JLabel llbSemSearch= new JLabel("Select Semester");
        llbSemSearch.setBounds(50,210,180,20);
        llbSemSearch.setFont(new Font("TAHOMA",Font.BOLD,18));
        f.add(llbSemSearch);
        String[] selectSem={" semester1","semester2","semester3","semester4","semester5","semester6","semester7","semester8"};
        sem= new JComboBox<>(selectSem);
        sem.setBounds(250,210,100,20);
        f.add(sem);
        JLabel Total =new JLabel("Total Payable");
        Total.setFont(new Font("TAHOMA",Font.BOLD,20));
        Total.setBounds(50,240,150,20);
        f.add(Total);
        tfpay =new JLabel();
        tfpay.setFont(new Font("TAHOMA",Font.BOLD,20));
        tfpay.setBounds(250,240,150,20);
        f.add(tfpay);
        try {
            Conn2 c= new Conn2();
            String query="select * from student where rollNo='"+rollno.getSelectedItem()+"'";
            ResultSet rs=c.stmt.executeQuery(query);
            while (rs.next())
            {
                tfname.setText(rs.getString(2));
                tffname.setText(rs.getString(3));

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
                    {
                        tfname.setText(rs.getString(2));
                        tffname.setText(rs.getString(3));

                    }
                }catch (Exception b)
                {
                    System.out.println("problem in button"+b);
                }
            }
        });
        update= new JButton("Submit");
        update.setBounds(40,280,100,20);
        update.setBackground(Color.BLACK);
        update.setForeground(Color.WHITE);
        f.add(update);
        pay= new JButton("Pay Form");
        pay.setBounds(150,280,100,20);
        pay.setBackground(Color.BLACK);
        pay.setForeground(Color.WHITE);
        f.add(pay);
        back = new JButton("Cancel");
        back.setBackground(Color.BLACK);
        back.setForeground(Color.WHITE);
        back.setBounds(260,280,100,20);
        f.add(back);

        back.addActionListener(this);
        update.addActionListener(this);
        pay.addActionListener(this);
        f.setLayout(null);
        f.getContentPane().setBackground(Color.WHITE);
        f.setBounds(100,50,800,500);
        f.setVisible(true);
    }
    public void actionPerformed(ActionEvent ae)
    {
        if(ae.getSource()==update){
            String degree= (String) tfcourse.getSelectedItem();
            int semester= Integer.parseInt(String.valueOf(sem.getSelectedIndex()));
            try{
                Conn2 c= new Conn2();
                ResultSet rs= c.stmt.executeQuery("select * from feestructure where course='"+degree+"'");
                while(rs.next())
                {
                    tfpay.setText(rs.getString(semester+1));
                }
            }catch (Exception e2)
            {
                System.out.println(e2);
            }
        } else if (ae.getSource()==pay) {
            String rollNo= (String) rollno.getSelectedItem();
            String degree= (String) tfcourse.getSelectedItem();
            String semester= (String) sem.getSelectedItem();
            String branch= (String) tfbranch.getSelectedItem();
            String total = tfpay.getText();
            try{
                Conn2 c= new Conn2();
                c.stmt.executeUpdate("insert into collegefee values('"+rollNo+"','"+degree+"','"+semester+"','"+branch+"','"+total+"')");
                JOptionPane.showMessageDialog(null,"College Fees Submitted");
                f.setVisible(false);
            }catch (Exception e2)
            {
                System.out.println(e2);
            }

        }
    }
    public static void main(String[] args) {
        new FeesForm();
    }
}
