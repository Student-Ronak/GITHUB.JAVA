package UNIVERSITYMANAGEMENTSYSTEM.JAVA;



import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;

public class ExamnationDetails implements ActionListener {
    JFrame f;
    JTextField serach;
    JButton submit,cancel;
    JTable table;
    ExamnationDetails()
    {
        f= new JFrame();

        f.setBounds(100,50,1000,450);
        JLabel heading=new JLabel("Check Result");
        heading.setBounds(50,10,300,25);
        heading.setFont(new Font("TAHOMA",Font.PLAIN,25));
        f.add(heading);
        serach= new JTextField();
        serach.setBounds(50,50,200,20);
        heading.setFont(new Font("TAHOMA",Font.PLAIN,19));
        f.add(serach);
        submit= new JButton("Submit");
        submit.setBounds(270,50,100,20);
        submit.setBackground(Color.BLACK);
        submit.setForeground(Color.WHITE);
        f.add(submit);
        submit.addActionListener(this);
        cancel= new JButton("Cancel");
        cancel.setBackground(Color.BLACK);
        cancel.setForeground(Color.WHITE);
        cancel.setBounds(390,50,100,20);
        f.add(cancel);
        cancel.addActionListener(this);
        table= new JTable();
        table.setFont(new Font("TAHOMA",Font.PLAIN,15));
        f.add(table);
        JScrollPane scroll= new JScrollPane(table);
        scroll.setBounds(0,100,1000,300);f.add(scroll);
        try{
            Conn2 c= new Conn2();
            ResultSet rs= c.stmt.executeQuery("select * from student");
            ResultSetMetaData rsmd=rs.getMetaData();
            DefaultTableModel model= (DefaultTableModel) table.getModel();
            int cols= rsmd.getColumnCount();
//            System.out.println(cols);
            String[]colName=new String[cols];
            for(int i=0;i<cols;i++){
                colName[i]=rsmd.getColumnName(i+1);
//                System.out.println(colName[i]);
            }
            model.setColumnIdentifiers(colName);

            while(rs.next())
            {
                String[]row={rs.getString(1),rs.getString(2),rs.getString(3),rs.getString(4),rs.getString(5),rs.getString(6),rs.getString(7),rs.getString(8),rs.getString(9),rs.getString(10),rs.getString(11)};
                model.addRow(row);

            }

        }catch (Exception e)
        {
            System.out.println(e);
        }
        table.addMouseListener(new MouseAdapter() {
            public void mouseClicked(MouseEvent me)
            {
                int row= table.getSelectedRow();
                serach.setText(table.getModel().getValueAt(row,0).toString());

            }
        });
        f.getContentPane().setBackground(Color.WHITE);
        f.setLayout(null);
        f.setVisible(true);

    }
    public void actionPerformed(ActionEvent e)
    {
        if(e.getSource()==submit)
        {
            f.setVisible(false);
            new Marks(serach.getText());

        }else{
            f.setVisible(false);
        }
    }
    public static void main(String[] args) {
        new ExamnationDetails();
    }
}

