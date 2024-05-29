package UNIVERSITYMANAGEMENTSYSTEM.JAVA;



import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Home implements ActionListener {
    JFrame f;
    JMenu newInformation,viewDetails,applyLeave,leaveDetails,examination,updateDetails,feeDetails,utility,about,exit;
    JMenuItem facultyInfo,  studentInfo,facultyDetail,studentDetail,facultyLeave,studentLeave,facultyLeavedetail,studentLeavedetail,enterMarks,examDetail,updateFacultyDetail,updateStudentDetail,feeStructure,feeForm,notepad,calci,Exit;
    Home() {
        f = new JFrame();
        f.setLayout(null);

        f.setExtendedState(JFrame.MAXIMIZED_BOTH);
        ImageIcon i1 = new ImageIcon("D:\\icons\\university.jpg");
        Image i2 = i1.getImage().getScaledInstance(1360, 768, Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel image = new JLabel(i3);
        image.setBounds(0, 0, 1360, 767);
        f.add(image);
        JMenuBar mb = new JMenuBar();
        f.setJMenuBar(mb);
        newInformation = new JMenu("New Information");
        newInformation.setForeground(Color.BLUE);
        facultyInfo= new JMenuItem("Faculty Information");
        facultyInfo.setBackground(Color.WHITE);
        newInformation.add(facultyInfo);

        studentInfo= new JMenuItem("Student Information");
        studentInfo .setBackground(Color.WHITE);
        newInformation.add(studentInfo);

//        details



        viewDetails = new JMenu("View Details");
        facultyDetail= new JMenuItem("Faculty Details");
        facultyDetail.setBackground(Color.WHITE);
        viewDetails.add(facultyDetail);
        studentDetail= new JMenuItem("Student Details");
        studentDetail .setBackground(Color.WHITE);
        viewDetails.add(studentDetail);
        viewDetails.setBackground(Color.red);

//        leave

        applyLeave = new JMenu("Apply Leave");
        facultyLeave= new JMenuItem("Faculty Leave");
        facultyLeave.setBackground(Color.WHITE);
        applyLeave.add(facultyLeave);
        studentLeave= new JMenuItem("Student Leave");
        studentLeave .setBackground(Color.WHITE);
        applyLeave.add(studentLeave);


//        leave details
        leaveDetails = new JMenu("Leave Details");
        facultyLeavedetail= new JMenuItem("Faculty Leave Details ");
        facultyLeavedetail.setBackground(Color.WHITE);
        leaveDetails.add(facultyLeavedetail);
        studentLeavedetail= new JMenuItem("Student Leave Details");
        studentLeavedetail .setBackground(Color.WHITE);
        leaveDetails.add(studentLeavedetail);
//        examination

        examination = new JMenu("Examination");
        examDetail= new JMenuItem("Examination Results ");
        examDetail.setBackground(Color.WHITE);
        examination.add(examDetail);
        enterMarks= new JMenuItem("Enter Marks");
        enterMarks .setBackground(Color.WHITE);
        examination.add(enterMarks);

//

        updateDetails = new JMenu("Update Details");
        updateFacultyDetail= new JMenuItem(" Update Faculty Details");
        updateFacultyDetail.setBackground(Color.WHITE);
        updateDetails.add( updateFacultyDetail);
        updateStudentDetail= new JMenuItem(" Update Student Details");
        updateStudentDetail .setBackground(Color.WHITE);
        updateDetails.add( updateStudentDetail);
//        fee


        feeDetails = new JMenu("Fees Details");
        feeStructure= new JMenuItem("Fees Structure");
        feeStructure.setBackground(Color.WHITE);
        feeDetails.add( feeStructure);
        feeForm= new JMenuItem("Fees Form");
        feeForm .setBackground(Color.WHITE);
        feeDetails.add(  feeForm);



        utility = new JMenu("Utility");
        notepad= new JMenuItem(" Notepad");
        notepad.setBackground(Color.WHITE);
        utility.add(  notepad);
        calci= new JMenuItem("Calculator");
        calci .setBackground(Color.WHITE);
        utility.add(calci);

        about = new JMenu("About");


        exit = new JMenu("Exit");
        Exit= new JMenuItem(" Exit");
        Exit.setBackground(Color.WHITE);
        exit.add(  Exit);
        Exit.addActionListener(this);
        notepad.addActionListener(this);
        calci.addActionListener(this);
        mb.add(newInformation);
        mb.add(viewDetails);
        mb.add(applyLeave);
        mb.add(leaveDetails);
        mb.add(examination);
        mb.add(updateDetails);
        mb.add(feeDetails);
        mb.add(utility);
        mb.add(about);
        mb.add(exit);
//        JMenuItem facultyInfo,  studentInfo,facultyDetail,studentDetail,facultyLeave,studentLeave,facultyLeavedetail,
//        studentLeavedetail,enterMarks,examDetail,updateFacultyDetail,updateStudentDetail,feeStructure,feeForm,notepad,calci,Exit;
        studentInfo.addActionListener(this);
        facultyInfo.addActionListener(this);
        studentDetail.addActionListener(this);
        facultyDetail.addActionListener(this);
        studentLeave.addActionListener(this);
        facultyLeave.addActionListener(this);
        studentLeavedetail.addActionListener(this);
        facultyLeavedetail.addActionListener(this);
        facultyLeavedetail.addActionListener(this);
        updateStudentDetail.addActionListener(this);
        enterMarks.addActionListener(this);feeStructure.addActionListener(this);feeForm.addActionListener(this);
        examination.addActionListener(this);
        about.addActionListener(this);
        f.setJMenuBar(mb);
        f.setVisible(true);
        f.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
    }
    public void actionPerformed(ActionEvent e)
    {
//        String msg=e.getActionCommand();
        if(e.getSource()==Exit){
            f.setVisible(false);
        } else if (e.getSource()==notepad) {
            try{
                Runtime.getRuntime().exec("Notepad.exe");
            }catch (Exception ae)
            {
                System.out.println(ae);
            }
        } else if (e.getSource()==calci) {
            try{
                Runtime.getRuntime().exec("calc.exe");
            }catch (Exception ae)
            {
                System.out.println(ae);
            }
        } else if (e.getSource()==studentInfo) {
            f.setVisible(true);
            new addStudent();
        } else if (e.getSource()==facultyInfo) {
            f.setVisible(true); new AddTeacher();

        } else if (e.getSource()==studentDetail) {
            f.setVisible(true); new StudentDetails();
        } else if (e.getSource()==facultyDetail) {
            f.setVisible(true); new TeacherDetails();
        } else if (e.getSource()==facultyLeave) {
            new TeacherLeave(); f.setVisible(true);

        } else if (e.getSource()==studentLeave) {
            new StudentLeave(); f.setVisible(true);
        } else if (e.getSource()==facultyLeavedetail) {
            new TeacherLeaveDetails(); f.setVisible(true);
        } else if (e.getSource()==studentLeavedetail) {
            new StudentLeaveDetails(); f.setVisible(true);
        } else if (e.getSource()==enterMarks) {
            new EnterMarks(); f.setVisible(true);
        } else if (e.getSource()==about) {
            new About(); f.setVisible(true);
        }else if (e.getSource()==examDetail)
        {
            new ExamnationDetails(); f.setVisible(true);
        } else if (e.getSource()==feeStructure) {
            new FeesStructure(); f.setVisible(true);
        } else if (e.getSource()==feeForm) {
            new FeesForm(); f.setVisible(true);
        }

    }

    public static void main(String[] args) {
        new Home();
    }
}
