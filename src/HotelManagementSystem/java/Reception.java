package HotelManagementSystem.java;




import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Reception implements ActionListener {
    JFrame f;
    JButton newCoustumer,room,department,allEmployee,coustumerInfo,managerInfo,checkOut,updateStaus,updateRoomStaus,pickUp,serachRoom,logOut;
    Reception()
    {
        f= new JFrame();
        newCoustumer= new JButton("New Coustumer Form");
        newCoustumer.setBounds(10,20,200,20);
        newCoustumer .setBackground(Color.BLACK);
        newCoustumer.setForeground(Color.WHITE);
        f.add(newCoustumer);
        room= new JButton("Rooms");
        room.setBounds(10,60,200,20);
        room .setBackground(Color.BLACK);
        room.setForeground(Color.WHITE);
        f.add(room);
        department= new JButton("Department");
        department.setBounds(10,100,200,20);
        department .setBackground(Color.BLACK);
        department.setForeground(Color.WHITE);
        f.add( department);
        allEmployee= new JButton("All Employee");
        allEmployee.setBounds(10,140,200,20);
        allEmployee.setBackground(Color.BLACK);
        allEmployee.setForeground(Color.WHITE);
        f.add(allEmployee);
        coustumerInfo= new JButton("Costumer Info");
        coustumerInfo.setBounds(10,180,200,20);
        coustumerInfo.setBackground(Color.BLACK);
        coustumerInfo.setForeground(Color.WHITE);
        f.add( coustumerInfo);
        managerInfo= new JButton("Manager Info");
        managerInfo.setBounds(10,220,200,20);
        managerInfo.setBackground(Color.BLACK);
        managerInfo.setForeground(Color.WHITE);
        f.add( managerInfo);
        checkOut= new JButton("Check OUT");
        checkOut.setBounds(10,260,200,20);
        checkOut.setBackground(Color.BLACK);
        checkOut.setForeground(Color.WHITE);
        f.add(checkOut);
        updateStaus= new JButton("Update Status");
        updateStaus.setBounds(10,300,200,20);
        updateStaus.setBackground(Color.BLACK);
        updateStaus.setForeground(Color.WHITE);
        f.add(updateStaus);
        updateRoomStaus= new JButton("Update Room Status");
        updateRoomStaus.setBounds(10,340,200,20);
        updateRoomStaus.setBackground(Color.BLACK);
        updateRoomStaus.setForeground(Color.WHITE);
        f.add(updateRoomStaus);
        pickUp= new JButton("PickUp Services");
        pickUp.setBounds(10,380,200,20);
        pickUp.setBackground(Color.BLACK);
        pickUp.setForeground(Color.WHITE);
        f.add(pickUp);
        serachRoom= new JButton("Serach Room");
        serachRoom.setBounds(10,420,200,20);
        serachRoom.setBackground(Color.BLACK);
        serachRoom.setForeground(Color.WHITE);
        f.add(serachRoom);
        logOut= new JButton("Log Out");
        logOut.setFont(new Font("TAHOMA",Font.PLAIN,16));
        logOut.setBounds(10,460,200,20);
        logOut.setBackground(Color.BLACK);
        logOut.setForeground(Color.WHITE);
        f.add( logOut);
        ImageIcon i1= new ImageIcon("D:\\icons\\reception.jpg");
        Image i2= i1.getImage().getScaledInstance(600,600,Image.SCALE_DEFAULT);
        ImageIcon i3= new ImageIcon(i2);
        JLabel image= new JLabel(i3);
        image.setBounds(300,00,600,600);
        f.add(image);

        newCoustumer.addActionListener(this);department.addActionListener(this);allEmployee.addActionListener(this);coustumerInfo.addActionListener(this);
        room.addActionListener(this);managerInfo.addActionListener(this);checkOut.addActionListener(this);updateStaus.addActionListener(this);
        updateRoomStaus.addActionListener(this);pickUp.addActionListener(this);checkOut.addActionListener(this);logOut.addActionListener(this);
        f.setBounds(200,50,800,620);
        f.getContentPane().setBackground(Color.WHITE);
        f.setLayout(null);
        f.setVisible(true);
    }
    public void actionPerformed(ActionEvent e)
    {
//JButton newCoustumer,room,department,allEmployee,coustumerInfo,managerInfo,checkOut,updateStaus,updateRoomStaus,pickUp,serachRoom,logOut;
//
        if(e.getSource()==newCoustumer)
        {

            new  newCoustumer();f.setVisible(false);
        } else if (e.getSource()==room) {

            new Room(); f.setVisible(false);
        } else if (e.getSource()==department) {
            f.setVisible(false);
            new Department();
        } else if (e.getSource()==allEmployee) {
            f.setVisible(false);new EmployeeInfo();
        } else if (e.getSource()==coustumerInfo) {
            f.setVisible(false);new CustomerInfo();
        } else if (e.getSource()==managerInfo) {
            f.setVisible(false);new ManagerInfo();
        } else if (e.getSource()==updateStaus) {
            f.setVisible(false);  new UpdateCheck();
        } else if (e.getSource()==updateRoomStaus) {
            f.setVisible(false);  new UpdateRoom();
        } else if (e.getSource()==pickUp) {
            f.setVisible(false);   new pickup();
        } else if (e.getSource()==checkOut) {
            f.setVisible(false);   new CheckOut();
        } else if (e.getSource()==logOut) {
            f.setVisible(false); System.exit(0);
        }
    }
    public static void main(String[] args) {
        new Reception();
    }
}
