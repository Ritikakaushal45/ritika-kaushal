package university.managment.system;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Random;
import com.toedter.calendar.JDateChooser;

public class addstudent extends JFrame implements ActionListener {
    JTextField textname,ftextname,textaddress,textphone,textemail,textx,textxii,textadhar;
    JButton adds,cancel;
    JLabel labelrollno;
    JDateChooser cdob;
    Random ran=new Random();
    long first4=Math.abs((ran.nextLong()%9000L)+1000L);
    JComboBox textcourse, textbranch;
    addstudent(){
        setSize(900,650);
        setLocation(200,60);
        setLayout(null);

        JLabel heading=new JLabel("ADD STUDENT DETAIL");
        heading.setBounds(300,20,500,50);
        heading.setFont(new Font("sarif", Font.BOLD,30));
        add(heading);


        JLabel name=new JLabel("NAME:");
        name.setBounds(20,110,100,20);
        name.setFont(new Font("sarif", Font.CENTER_BASELINE,20));
        add(name);

        textname =new JTextField();
        textname.setBounds(160,110,200,20);
        add(textname);


        JLabel fname=new JLabel("FATHER'S NAME:");
        fname.setBounds(400,110,200,20);
        fname.setFont(new Font("sarif", Font.CENTER_BASELINE,20));
        add(fname);

        ftextname =new JTextField();
        ftextname.setBounds(630,110,230,20);
        add(ftextname);

        JLabel rollno=new JLabel("ROLL NO.:");
        rollno.setBounds(20,180,150,20);
        rollno.setFont(new Font("sarif", Font.CENTER_BASELINE,20));
        add(rollno);

        labelrollno=new JLabel("1533"+first4);
        labelrollno.setBounds(190,180,150,20);
        labelrollno.setFont(new Font("sarif", Font.CENTER_BASELINE,20));
        add(labelrollno);

        JLabel dob=new JLabel("DATE OF BIRTH:");
        dob.setBounds(400,180,200,20);
        dob.setFont(new Font("sarif", Font.CENTER_BASELINE,20));
        add(dob);

        cdob=new JDateChooser();
        cdob.setBounds(630,180,230,20);
        add(cdob);


        JLabel address=new JLabel("ADDRESS:");
        address.setBounds(20,260,150,20);
        address.setFont(new Font("sarif", Font.CENTER_BASELINE,20));
        add(address);

        textaddress =new JTextField();
        textaddress.setBounds(160,260,200,20);
        add(textaddress);


        JLabel phone=new JLabel("PHONE NO.:");
        phone.setBounds(400,260,200,20);
        phone.setFont(new Font("sarif", Font.CENTER_BASELINE,20));
        add(phone);

        textphone =new JTextField();
        textphone.setBounds(630,260,230,20);
        add(textphone);


        JLabel email=new JLabel("EMAIL:");
        email.setBounds(20,340,100,20);
        email.setFont(new Font("sarif", Font.CENTER_BASELINE,20));
        add(email);

        textemail =new JTextField();
        textemail.setBounds(160,340,200,20);
        add(textemail);


        JLabel x=new JLabel("PERCENTAGE X:");
        x.setBounds(400,340,200,20);
        x.setFont(new Font("sarif", Font.CENTER_BASELINE,20));
        add(x);

        textx =new JTextField();
        textx.setBounds(630,340,230,20);
        add(textx);


        JLabel xii=new JLabel("CLASS XII(%):");
        xii.setBounds(20,420,200,20);
        xii.setFont(new Font("sarif", Font.CENTER_BASELINE,20));
        add(xii);

        textxii =new JTextField();
        textxii.setBounds(160,420,200,20);
        add(textxii);

        JLabel adhar=new JLabel("ADHAR NO.:");
        adhar.setBounds(400,420,200,20);
        adhar.setFont(new Font("sarif", Font.CENTER_BASELINE,20));
        add(adhar);

        textadhar =new JTextField();
        textadhar.setBounds(630,420,230,20);
        add(textadhar);

        JLabel course=new JLabel("COURSE:");
        course.setBounds(20,500,200,20);
        course.setFont(new Font("sarif", Font.CENTER_BASELINE,20));
        add(course);

        String courses[]={"B.Tech","MBBS","BCA","B.Pharma","D.Pharma","Pharm.D","Bsc","BA","Msc","B.Com","M.Pharma","MCA","MBA"};
        textcourse=new JComboBox<String>(courses);
        textcourse.setBounds(160,500,200,20);
        add(textcourse);

        JLabel branch=new JLabel("BRANCH:");
        branch.setBounds(400,500,200,20);
        branch.setFont(new Font("sarif", Font.CENTER_BASELINE,20));
        add(branch);

        String branches[]={"computer science","biotech","food tech","micro biology","electonics","machanical","cyber security","artifical intalegent","roboticis","civil","electrical","aronotical"};
        textbranch=new JComboBox<String>(branches);
        textbranch.setBounds(630,500,230,20);
        add(textbranch);

        adds =new JButton("ADD");
        adds.setBounds(200,550,200,20);
        adds.setBackground(Color.green);
        adds.setForeground(Color.black);
        adds.setFont(new Font("tohuma",Font.CENTER_BASELINE,15));
        adds.addActionListener(this);
        add(adds);

        cancel =new JButton("CANCEL");
        cancel.setBounds(470,550,200,20);
        cancel.setBackground(Color.red);
        cancel.setForeground(Color.black);
        cancel.setFont(new Font("tohuma",Font.CENTER_BASELINE,15));
        cancel.addActionListener(this);
        add(cancel);

        setVisible(true);
    }
    public void actionPerformed(ActionEvent ae){
        if(ae.getSource()==adds){
            String NAME =textname.getText();
            String FATHER=ftextname.getText();
            String ROLLNO=labelrollno.getText();
            String DOB=((JTextField)cdob.getDateEditor().getUiComponent()).getText();
            String ADDRESS=textaddress.getText();
            String PHONE=textphone.getText();
            String EMAIL=textemail.getText();
            String X=textx.getText();
            String XII=textxii.getText();
            String ADHAR=textadhar.getText();
            String COURCE=(String) textcourse.getSelectedItem();
            String BRANCH=(String) textbranch.getSelectedItem();
            try{
                String query="insert into student value('"+NAME+"','"+FATHER+"','"+ROLLNO+"','"+DOB+"','"+ADDRESS+"','"+PHONE+"','"+EMAIL+"','"+X+"','"+XII+"','"+ADHAR+"','"+COURCE+"','"+BRANCH+"')";
                conn con=new conn();
                con.s.executeUpdate(query);
                JOptionPane.showMessageDialog(null,"student detail is added successfully");
                setVisible(false);
            }catch (Exception e){
                e.printStackTrace();
            }
        }else {
            setVisible(false);
        }


    }
    public static void main(String[] args) {
        new addstudent();
    }
}

