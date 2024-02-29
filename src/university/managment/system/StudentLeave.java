package university.managment.system;
import javax.swing.*;
import java.awt.*;
import java.sql.*;
import com.toedter.calendar.JDateChooser;
import java.awt.event.*;

public class StudentLeave extends JFrame implements ActionListener {
    Choice crollno,cname, ctime;
    JDateChooser dcdate;
    JButton submit, cancel,b1;

    StudentLeave() {

        setSize(500, 550);
        setLocation(420, 100);
        setLayout(null);

        getContentPane().setBackground(Color.WHITE);

        JLabel heading = new JLabel("Apply Leave (Student)");
        heading.setBounds(110, 0, 300, 50);
        heading.setFont(new Font("Times New Roman", Font.BOLD, 30));
        add(heading);

        JLabel lblrollno = new JLabel("Search by Roll Number");
        lblrollno.setBounds(80, 70, 300, 20);
        lblrollno.setFont(new Font("Calibre", Font.BOLD, 20));
        add(lblrollno);

        crollno = new Choice();
        crollno.setBounds(150, 160, 200, 25);
        add(crollno);

        b1 = new JButton("Search");
        b1.addActionListener(this);
        b1.setFont(new Font("Tahoma", Font.BOLD, 12));
        b1.setBounds(250, 110, 150, 25);
        b1.setBackground(Color.BLACK);
        b1.setForeground(Color.WHITE);
        add(b1);

        cname = new Choice();
        cname.setBounds(40, 110, 200, 25);
        add(cname);


        try {
            conn c = new conn();
            ResultSet rs = c.s.executeQuery( "select * from student");
            while(rs.next()) {
                cname.add(rs.getString("name"));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        JLabel lbldate = new JLabel("Date:-");
        lbldate.setBounds(80, 220, 300, 20);
        lbldate.setFont(new Font("Calibre", Font.BOLD, 20));
        add(lbldate);

        dcdate = new JDateChooser();
        dcdate.setBounds(150, 260, 200, 25);
        add(dcdate);

        JLabel lbltime = new JLabel("Time Duration:-");
        lbltime.setBounds(80, 320, 300, 20);
        lbltime.setFont(new Font("Calibre", Font.BOLD, 20));
        add(lbltime);

        ctime = new Choice();
        ctime.setBounds(150, 360, 200, 20);
        ctime.add("Full Day");
        ctime.add("Half Day");
        add(ctime);

        submit = new JButton("Submit");
        submit.setBounds(140, 440, 100, 25);
        submit.setBackground(Color.BLACK);
        submit.setForeground(Color.WHITE);
        submit.addActionListener(this);
        submit.setFont(new Font("Times New Roman", Font.BOLD, 15));
        add(submit);

        cancel = new JButton("Cancel");
        cancel.setBounds(280, 440, 100, 25);
        cancel.setBackground(Color.BLACK);
        cancel.setForeground(Color.WHITE);
        cancel.addActionListener(this);
        cancel.setFont(new Font("Times New Roman", Font.BOLD, 15));
        add(cancel);

        setVisible(true);
    }

    public void actionPerformed(ActionEvent ae) {
        if (ae.getSource() == submit) {
            String rollno = crollno.getSelectedItem();
            String date = ((JTextField) dcdate.getDateEditor().getUiComponent()).getText();
            String duration = ctime.getSelectedItem();
            String name=cname.getSelectedItem();

            String query = "insert into studentleave values('"+rollno+"', '"+date+"', '"+duration+"','"+name+"')";

            try {
                conn c = new conn();
                c.s.executeUpdate(query);
                JOptionPane.showMessageDialog(null, "Leave Confirmed");
                setVisible(false);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }else if(ae.getSource() == b1){
            conn c = new conn();
            ResultSet rs = null;
            try {
                rs = c.s.executeQuery("select * from student where name = '"+cname.getSelectedItem()+"'");
                while (rs.next()) {
                    crollno.add(rs.getString("rollno"));

                }
            } catch (SQLException e) {
                throw new RuntimeException(e);
            }



        }else {
            setVisible(false);
        }
    }

    public static void main(String[] args) {
        new StudentLeave();
    }
}
