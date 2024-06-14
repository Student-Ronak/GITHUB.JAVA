package HotelManagementSystem.java;


import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class AddRoom implements ActionListener {
    JFrame f;
    JTextField tfroomno,tfprice;
    JComboBox tfavailable,tfclean,tftype;
    JButton add,cancel;
    AddRoom()
    {
        f= new JFrame();
        JLabel heading= new JLabel("ADD ROOMS");
        heading.setBounds(100,30,200,20);
        heading.setFont(new Font("TRAHOMA",Font.BOLD,18));
        f.add(heading);
        ImageIcon i1 = new ImageIcon("D:\\icons\\room.jpg");
        Image i2 = i1.getImage().getScaledInstance(500, 400, Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel image = new JLabel(i3);
        image.setBounds(320, 30, 500, 400);
        f.add(image);

        JLabel llbroomno= new JLabel("Room Number");
        llbroomno.setBounds(20,60,120,20);
        llbroomno.setFont(new Font("TRAHOMA",Font.PLAIN,14));
        f.add(llbroomno);
        tfroomno= new JTextField();
        tfroomno.setBounds(160,60,120,20);
        tfroomno.setFont(new Font("TRAHOMA",Font.PLAIN,14));
        f.add(tfroomno);
        JLabel llbavailable= new JLabel("Available");
        llbavailable.setBounds(20,100,120,20);
        llbavailable.setFont(new Font("TRAHOMA",Font.PLAIN,14));
        f.add(llbavailable);
        String[] ava={"Available","Occupied"};
        tfavailable= new JComboBox<>(ava);
        tfavailable.setBounds(160,100,120,20);
        tfavailable.setFont(new Font("TRAHOMA",Font.PLAIN,14));
        f.add(tfavailable);

        JLabel llbclean= new JLabel("Clean Status");
        llbclean.setBounds(20,140,120,20);
        llbclean.setFont(new Font("TRAHOMA",Font.PLAIN,14));
        f.add(llbclean);
        String[] clean={"Clean","Dirty "};
        tfclean= new JComboBox<>(clean);
        tfclean.setBounds(160,140,120,20);
        tfclean.setFont(new Font("TRAHOMA",Font.PLAIN,14));
        f.add(tfclean);
        JLabel llbprice= new JLabel("Price");
        llbprice.setBounds(20,180,120,20);
        llbprice.setFont(new Font("TRAHOMA",Font.PLAIN,14));
        f.add(llbprice);
        tfprice= new JTextField();
        tfprice.setBounds(160,180,120,20);
        tfprice.setFont(new Font("TRAHOMA",Font.PLAIN,14));
        f.add(tfprice);
        JLabel llbType= new JLabel("Bed Type");
        llbType.setBounds(20,220,120,20);
        llbType.setFont(new Font("TRAHOMA",Font.PLAIN,14));
        f.add(llbType);
        String[] type={"Single Bed","Double Bed","Double + Single Bed"};
        tftype= new JComboBox<>(type);
        tftype.setBounds(160,220,120,20);
        tftype.setFont(new Font("TRAHOMA",Font.PLAIN,14));
        f.add(tftype);
        add= new JButton("Add");
        add.setBounds(20,270,120,20);
        add.setBackground(Color.black);add.setForeground(Color.WHITE);
        f.add(add);
        add.addActionListener(this);
        cancel= new JButton("Cancel");
        cancel.setBounds(160,270,120,20);
        cancel.setBackground(Color.black);cancel.setForeground(Color.WHITE);
        f.add(cancel);
        cancel.addActionListener(this);
        f.setLayout(null);
        f.setBounds(100,20,910,500);
        f.getContentPane().setBackground(Color.WHITE);
        f.setVisible(true);



    }
    public void actionPerformed(ActionEvent e)
    {
//
//          JTextField tfroomno,tfprice;
//    JComboBox tfavailable,tfclean,tftype;
        if(e.getSource()==add){
            String room= tfroomno.getText();
            String available= (String) tfavailable.getSelectedItem();
            String clean= (String) tfclean.getSelectedItem();
            String price= tfprice.getText();
            String type= (String) tftype.getSelectedItem();
            try{
                Conn3 c= new Conn3();
                String query="insert into room values('"+room+"','"+available+"','"+clean+"','"+price+"','"+type+"')";
                c.stmt.executeUpdate(query);
                JOptionPane.showMessageDialog(null,"New Room Add Sucessfully");
                f.setVisible(false);new Reception();
            }catch (Exception ae)
            {
                System.out.println(ae);
            }

        }else{
            f.setVisible(false);
        }
    }
    public static void main(String[] args) {
        new AddRoom();
    }
}
