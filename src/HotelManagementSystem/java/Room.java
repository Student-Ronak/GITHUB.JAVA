package HotelManagementSystem.java;



import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;

public class Room implements ActionListener {
    JFrame f;
    JTable table;
    JButton back;
    Room(){
        f= new JFrame();
        f.setLayout(null);
        ImageIcon i1= new ImageIcon("D:\\icons\\room.jpg");
        Image i2= i1.getImage().getScaledInstance(600,600,Image.SCALE_DEFAULT);
        ImageIcon i3= new ImageIcon(i2);
        JLabel image= new JLabel(i3);
        image.setBounds(500,00,600,600);
        f.add(image);
        JLabel llbroom= new JLabel("Room Number");
        llbroom.setBounds(0,10,100,20);
        f.add(llbroom);
        JLabel llbavailable= new JLabel("Availablity");
        llbavailable.setBounds(102,10,100,20);
        f.add(llbavailable);
        JLabel llbclean= new JLabel("Status");
        llbclean.setBounds(202,10,100,20);
        f.add( llbclean);
        JLabel llb4= new JLabel("Price");
        llb4.setBounds(302,10,100,20);
        f.add( llb4);
        JLabel llb5= new JLabel("Bed");
        llb5.setBounds(402,10,100,20);
        f.add( llb5);


        table= new JTable();
        table.setBounds(0,40,480,400);
        f.add(table);
//JScrollPane scroll = new JScrollPane(table);
//        scroll.setBounds(480,20,20,400);
//        f.add(scroll);
        try{
            Conn3 c= new Conn3();
            String query="select * from room";
            ResultSet rs= c.stmt.executeQuery(query);
            ResultSetMetaData rsmd=rs.getMetaData();
            DefaultTableModel model= (DefaultTableModel) table.getModel();
            int cols= rsmd.getColumnCount();
            String[]colName=new String[cols];
            for(int i=0;i<cols;i++){
                colName[i]=rsmd.getColumnName(i+1);

            }
            model.setColumnIdentifiers(colName);

            while(rs.next())
            {
                String[]row={rs.getString(1),rs.getString(2),rs.getString(3),rs.getString(4),rs.getString(5)};
                model.addRow(row);

            }
        }catch (Exception ex)
        {
            System.out.println(ex);
        }
        back= new JButton("Back");
        back.setBackground(Color.BLACK);
        back.setForeground(Color.WHITE);
        back.setBounds(200,500,100,20);
        f.add(back);
        back.addActionListener(this);
//JScrollBar scroll = new JScrollBar(t);
//        scroll.setBounds(480,20,20,400);
//        f.add(scroll);



        f.setBounds(0,50,1200,600);
        f.getContentPane().setBackground(Color.WHITE);

        f.setVisible(true);

    }
    public void actionPerformed(ActionEvent e)
    {
        f.setVisible(false);
        new Reception();
    }
    public static void main(String[] args) {
        new Room();
    }
}
