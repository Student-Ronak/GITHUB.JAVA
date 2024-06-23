package ElectricityBillingSystem.java;



import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;

public class Project implements ActionListener {
    JFrame f= new JFrame();

    JMenu master,info,user,report,utility,exit;
    JMenuItem newCoustumer,CoustumerDetail,depositDetail,calculateBill,updateInformation,veiwInformation,payBill,billDetailes,generateBill,notepad,calculator,exitI;
    String type,meter;
    Project(String type,String meter)
    {
        this.type= type;
        this.meter= meter;
        f.setLayout(null);
        f.setVisible(true);
        f.setExtendedState(JFrame.MAXIMIZED_BOTH);
        ImageIcon i1= new ImageIcon("D:\\icons\\images.jpg");
        Image i2= i1.getImage().getScaledInstance(1360,768,Image.SCALE_DEFAULT);
        ImageIcon i3= new ImageIcon(i2);
        JLabel image= new JLabel(i3);
        image.setBounds(0,0,1360,767);
        f.add(image);
        JMenuBar mb= new JMenuBar();
        f.setJMenuBar(mb);
        master= new JMenu("Master");
        master.setForeground(Color.BLUE);

        newCoustumer= new JMenuItem("New Coustumer");
        newCoustumer.setFont(new Font("monospace",Font.PLAIN,12));
        newCoustumer.setBackground(Color.WHITE);
        ImageIcon i8= new ImageIcon("F:\\R.png");
        Image image0= i8.getImage().getScaledInstance(10,10,Image.SCALE_DEFAULT);
        ImageIcon i9 =new ImageIcon(image0);
        newCoustumer.setIcon(i9);
        newCoustumer.setMnemonic('D');
        newCoustumer.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_D, ActionEvent.CTRL_MASK));
        master.add(newCoustumer);
        newCoustumer.addActionListener(this);
        CoustumerDetail= new JMenuItem("Coustumer Details");
        CoustumerDetail.setFont(new Font("monospace",Font.PLAIN,12));
        CoustumerDetail.setBackground(Color.WHITE);
        ImageIcon i6= new ImageIcon("F:\\R.png");
        Image image1= i6.getImage().getScaledInstance(10,10,Image.SCALE_DEFAULT);
        ImageIcon i7 =new ImageIcon(image1);
        CoustumerDetail.setIcon(i7);
        CoustumerDetail.setMnemonic('M');
        CoustumerDetail.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_M, ActionEvent.CTRL_MASK));
        master.add(CoustumerDetail);
        CoustumerDetail.addActionListener(this);
        depositDetail= new JMenuItem("Deposits Details");
        depositDetail.setFont(new Font("monospace",Font.PLAIN,12));
        depositDetail.setBackground(Color.WHITE);
        ImageIcon i4= new ImageIcon("F:\\R.png");
        Image image2= i4.getImage().getScaledInstance(10,10,Image.SCALE_DEFAULT);
        ImageIcon i5 =new ImageIcon(image2);
        depositDetail.setIcon(i5);
        depositDetail.setMnemonic('F');
        depositDetail.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_F, ActionEvent.CTRL_MASK));
        master.add(depositDetail);
        depositDetail.addActionListener(this);
        calculateBill= new JMenuItem("Calculate Bill");
        calculateBill.setFont(new Font("monospace",Font.PLAIN,12));
        calculateBill.setBackground(Color.WHITE);
        ImageIcon i10= new ImageIcon("F:\\R.png");
        Image image3= i10.getImage().getScaledInstance(10,10,Image.SCALE_DEFAULT);
        ImageIcon i11 =new ImageIcon(image3);
        calculateBill.setIcon(i11);
        calculateBill.setMnemonic('B');
        calculateBill.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_B, ActionEvent.CTRL_MASK));
        calculateBill.addActionListener(this);
        master.add(calculateBill);
        info= new JMenu("Information");
        info.setForeground(Color.RED);

        updateInformation= new JMenuItem("Update Information");
        updateInformation.setFont(new Font("monospace",Font.PLAIN,12));
        updateInformation.setBackground(Color.WHITE);
        ImageIcon i12= new ImageIcon("F:\\R.png");
        Image image4= i12.getImage().getScaledInstance(50,50,Image.SCALE_DEFAULT);
        ImageIcon i13 =new ImageIcon(image4);
        updateInformation.setIcon(i13);
        updateInformation.setMnemonic('U');
        updateInformation.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_U, ActionEvent.CTRL_MASK));
        info.add(updateInformation);
        veiwInformation= new JMenuItem("View Information");
        veiwInformation.setFont(new Font("monospace",Font.PLAIN,12));
        veiwInformation.setBackground(Color.WHITE);
        ImageIcon i14= new ImageIcon("F:\\R.png");
        Image image5= i14.getImage().getScaledInstance(10,10,Image.SCALE_DEFAULT);
        ImageIcon i15 =new ImageIcon(image5);
        veiwInformation.setIcon(i15);
        veiwInformation.setMnemonic('I');
        veiwInformation.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_I, ActionEvent.CTRL_MASK));
        info.add(veiwInformation);
        updateInformation= new JMenuItem("Update Information");
        updateInformation.setFont(new Font("monospace",Font.PLAIN,12));
        updateInformation.setBackground(Color.WHITE);
        ImageIcon i16= new ImageIcon("F:\\R.png");
        Image image6= i16.getImage().getScaledInstance(10,10,Image.SCALE_DEFAULT);
        ImageIcon i17 =new ImageIcon(image6);
        updateInformation.setIcon(i17);
        updateInformation.setMnemonic('U');
        updateInformation.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_U, ActionEvent.CTRL_MASK));
        info.add(updateInformation);
        veiwInformation= new JMenuItem("View Information");
        veiwInformation.setFont(new Font("monospace",Font.PLAIN,12));
        veiwInformation.setBackground(Color.WHITE);
        ImageIcon i18= new ImageIcon("F:\\R.png");
        Image image7= i18.getImage().getScaledInstance(50,50,Image.SCALE_DEFAULT);
        ImageIcon i19 =new ImageIcon(image7);
        veiwInformation.setIcon(i19);
        veiwInformation.setMnemonic('I');
        veiwInformation.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_I, ActionEvent.CTRL_MASK));
        info.add(veiwInformation);
        user= new JMenu("User");
        user.setForeground(Color.BLUE);

        payBill= new JMenuItem("Pay Bill");
        payBill.setFont(new Font("monospace",Font.PLAIN,12));
        payBill.setBackground(Color.WHITE);
        ImageIcon i20= new ImageIcon("F:\\R.png");
        Image image8= i20.getImage().getScaledInstance(10,10,Image.SCALE_DEFAULT);
        ImageIcon i21 =new ImageIcon(image8);
        payBill.setIcon(i21);
        payBill.setMnemonic('P');
        payBill.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_P, ActionEvent.CTRL_MASK));
        user.add(payBill);
        billDetailes= new JMenuItem("Bill Details");
        billDetailes.setFont(new Font("monospace",Font.PLAIN,12));
        billDetailes.setBackground(Color.WHITE);
        ImageIcon i22= new ImageIcon("F:\\R.png");
        Image image9= i22.getImage().getScaledInstance(10,10,Image.SCALE_DEFAULT);
        ImageIcon i23 =new ImageIcon(image9);
        billDetailes.setIcon(i23);
        billDetailes.setMnemonic('I');
        billDetailes.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_I, ActionEvent.CTRL_MASK));
        user.add(billDetailes);
        report= new JMenu("Report");
        report.setForeground(Color.RED);

        generateBill= new JMenuItem("Generate Bill");
        generateBill.setFont(new Font("monospace",Font.PLAIN,12));
        generateBill.setBackground(Color.WHITE);
        ImageIcon i24= new ImageIcon("F:\\R.png");
        Image image10= i24.getImage().getScaledInstance(10,10,Image.SCALE_DEFAULT);
        ImageIcon i25 =new ImageIcon(image10);
        generateBill.setIcon(i25);
        generateBill.setMnemonic('G');
        generateBill.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_G, ActionEvent.CTRL_MASK));
        report.add(generateBill);
        utility= new JMenu("Utility");
        utility.setForeground(Color.BLUE);
        mb.add(utility);
        notepad= new JMenuItem("Notepad");
        notepad.setFont(new Font("monospace",Font.PLAIN,12));
        notepad.setBackground(Color.WHITE);
        ImageIcon i26= new ImageIcon("F:\\R.png");
        Image image11= i26.getImage().getScaledInstance(10,10,Image.SCALE_DEFAULT);
        ImageIcon i27 =new ImageIcon(image11);
        notepad.setIcon(i27);
        notepad.setMnemonic('N');
        notepad.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_N, ActionEvent.CTRL_MASK));
        utility.add( notepad);
        calculator= new JMenuItem("Calculator");
        calculator.setFont(new Font("monospace",Font.PLAIN,12));
        calculator.setBackground(Color.WHITE);
        ImageIcon i28= new ImageIcon("F:\\R.png");
        Image image12= i28.getImage().getScaledInstance(10,10,Image.SCALE_DEFAULT);
        ImageIcon i29 =new ImageIcon(image12);
        calculator.setIcon(i29);
        calculator.setMnemonic('C');
        calculator.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_C, ActionEvent.CTRL_MASK));
        utility.add( calculator);
        exit= new JMenu("Exit");
        exit.setForeground(Color.BLUE);

        exitI= new JMenuItem("Exit");
        exitI.setFont(new Font("monospace",Font.PLAIN,12));
        exitI.setBackground(Color.WHITE);
        ImageIcon i30= new ImageIcon("F:\\R.png");
        Image image13= i30.getImage().getScaledInstance(10,10,Image.SCALE_DEFAULT);
        ImageIcon i31 =new ImageIcon(image13);
        exitI.setIcon(i31);
        exitI.setMnemonic('W');
        exitI.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_W, ActionEvent.CTRL_MASK));
        exit.add(exitI);
        veiwInformation.addActionListener(this);
        updateInformation.addActionListener(this);
        calculator.addActionListener(this);
        notepad.addActionListener(this);
        billDetailes.addActionListener(this);
        if(type.equals("Admin")){
            mb.add(master);
        }else{
            mb.add(info); mb.add(report);mb.add(user);
        }
        mb.add(exit);mb.add(utility);



        f.setLayout(new FlowLayout());
        f.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
    }
    public void actionPerformed(ActionEvent e)
    {// newCoustumer,CoustumerDetail,depositDetail
        if(e.getSource()==calculateBill)
        {
            new CalculateBill();
        } else if (e.getSource()==newCoustumer) {
            new newCoustumer();
        } else if (e.getSource()==CoustumerDetail) {
            new CustumerDetails();
        } else if (e.getSource()==depositDetail) {
            new DepositDetails();
        } else if (e.getSource()== veiwInformation) {
            new VeiwInformation(meter);
        } else if (e.getSource()==updateInformation) {
            new UpdateInformation(meter);
        }else if (e.getSource()==billDetailes) {
            new BillDetails(meter);
        }else if(e.getSource()==notepad)
        {
            try{

                Runtime.getRuntime().exec("notepad.exe");
            }catch(Exception e1)
            {
                System.out.println(e1);
            }
        }else if(e.getSource()==calculator)
        {
            try{

                Runtime.getRuntime().exec("calc.exe");
            }catch(Exception e1)
            {
                System.out.println(e1);
            }
        }

    }
    public static void main(String[] args) {
        new Project(" "," ");
    }
}

