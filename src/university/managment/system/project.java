package university.managment.system;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class project extends JFrame implements ActionListener{
    project() {
        ImageIcon icon = new ImageIcon(ClassLoader.getSystemResource("icons/jnulogo.jpg"));//Jaipur-National-University-Jaipur-1-compressed.jpg
        Image icon1 = icon.getImage().getScaledInstance(500, 500, Image.SCALE_DEFAULT);
        ImageIcon icon2 = new ImageIcon(icon1);
        JLabel image = new JLabel(icon2);
        add(image);
        getContentPane().setBackground(Color.WHITE);

        JMenuBar jb = new JMenuBar();
        jb.setBackground(new Color(18,121,131));
        setJMenuBar(jb);

        JMenu newinfo = new JMenu("NEW INFORMATION");
        newinfo.setForeground(Color.white);
        newinfo.setBounds(10,0,150,20);
        jb.add(newinfo);

        JMenuItem facaltyinfo = new JMenuItem("new faculty information");
        facaltyinfo.setBackground(Color.WHITE);
        facaltyinfo.addActionListener(this);
        newinfo.add(facaltyinfo);

        JMenuItem studentinfo = new JMenuItem("new student information");
        studentinfo.setBackground(Color.WHITE);
        studentinfo.addActionListener(this);
        newinfo.add(studentinfo);

        JMenu detail = new JMenu("VIEW DETAIL");
        detail.setForeground(Color.white);
        detail.setBounds(150,0,150,20);
        jb.add(detail);

        JMenuItem facaltydetail = new JMenuItem("faculty detail");
        facaltydetail.setBackground(Color.WHITE);
        facaltydetail.addActionListener(this);
        detail.add(facaltydetail);

        JMenuItem studentdetail = new JMenuItem("student detail");
        studentdetail.setBackground(Color.WHITE);
        studentdetail.addActionListener(this);
        detail.add(studentdetail);


        JMenu leave1 = new JMenu("LEAVE");
        leave1.setForeground(Color.white);
        leave1.setBounds(300,0,150,20);
        jb.add(leave1);

        JMenuItem facaltyleave = new JMenuItem("faculty leave");
        facaltyleave.setBackground(Color.WHITE);
        facaltyleave.addActionListener(this);
        leave1.add(facaltyleave);

        JMenuItem studentleave = new JMenuItem("student leave");
        studentleave.setBackground(Color.WHITE);
        studentleave.addActionListener(this);
        leave1.add(studentleave);


        JMenu leavedetail = new JMenu("LEAVE DETAIL");
        leavedetail.setForeground(Color.white);
        leavedetail.setBounds(450,0,150,20);
        jb.add(leavedetail);

        JMenuItem facaltyleavedetail = new JMenuItem("faculty leave detail");
        facaltyleavedetail.setBackground(Color.WHITE);
        facaltyleavedetail.addActionListener(this);
        leavedetail.add(facaltyleavedetail);

        JMenuItem studentleavedetail = new JMenuItem("student leave detail");
        studentleavedetail.setBackground(Color.WHITE);
        studentleavedetail.addActionListener(this);
        leavedetail.add(studentleavedetail);


        JMenu exam = new JMenu("EXAM");
        exam.setForeground(Color.white);
        exam.setBounds(600,0,150,20);
        jb.add(exam);

        JMenuItem examresult = new JMenuItem("exam result");
        examresult.setBackground(Color.WHITE);
        examresult.addActionListener(this);
        exam.add(examresult);

        JMenuItem entermark = new JMenuItem("marks entry");
        entermark.setBackground(Color.WHITE);
        entermark.addActionListener(this);
        exam.add(entermark);


        JMenu update = new JMenu("UPDATE");
        update.setForeground(Color.white);
        update.setBounds(750,0,150,20);
        jb.add(update);

        JMenuItem facaltyupdate = new JMenuItem("faculty detail update");
        facaltyupdate.setBackground(Color.WHITE);
        facaltyupdate.addActionListener(this);
        update.add(facaltyupdate);

        JMenuItem studentupdate = new JMenuItem("student detail update");
        studentupdate.setBackground(Color.WHITE);
        studentupdate.addActionListener(this);
        update.add(studentupdate);


        JMenu fee = new JMenu("FEE");
        fee.setForeground(Color.white);
        fee.setBounds(900,0,150,20);
        jb.add(fee);

        JMenuItem feestructure = new JMenuItem("fee structure");
        feestructure.setBackground(Color.WHITE);
        feestructure.addActionListener(this);
        fee.add(feestructure);

        JMenuItem feeform = new JMenuItem("fee form");
        feeform.setBackground(Color.WHITE);
        feeform.addActionListener(this);
        fee.add(feeform);

        JMenu utility = new JMenu("UTILITY");
        utility.setForeground(Color.white);
        utility.setBounds(1050,0,150,20);
        jb.add(utility);

        JMenuItem notepad = new JMenuItem("notepad");
        notepad.addActionListener(this);
        notepad.setBackground(Color.WHITE);
        utility.add(notepad);

        JMenuItem calc = new JMenuItem("calculater");
        calc.addActionListener(this);
        calc.setBackground(Color.WHITE);
        utility.add(calc);

        JMenu about = new JMenu("ABOUT");
        about.setForeground(Color.white);
        about.setBounds(1200,0,150,20);
        jb.setComponentOrientation(ComponentOrientation.LEFT_TO_RIGHT);
        about.setComponentOrientation(ComponentOrientation.LEFT_TO_RIGHT);
        jb.add(about);

        JMenuItem About = new JMenuItem("About");
        About.addActionListener(this);
        About.setBackground(Color.WHITE);
        about.add(About);


        JMenu exit = new JMenu("EXIT");
        exit.setForeground(Color.white);
        exit .setBounds(1200,0,150,20);
        jb.setComponentOrientation(ComponentOrientation.LEFT_TO_RIGHT);
        exit.setComponentOrientation(ComponentOrientation.LEFT_TO_RIGHT);
        jb.add(exit);

        JMenuItem logout = new JMenuItem("logout");
        logout.addActionListener(this);
        logout.setBackground(Color.WHITE);
        exit.add(logout);


        setSize(1500, 750);
        setVisible(true);
    }

    public void actionPerformed(ActionEvent at) {
        String msg = at.getActionCommand();
        if (msg.equals("logout")) {
            setVisible(false);
        } else if (msg.equals("calculater")) {
            try {
                Runtime.getRuntime().exec("calc.exe");
            } catch (Exception e) {
            }
        } else if (msg.equals("notepad")) {
            try {
                Runtime.getRuntime().exec("notepad.exe");
            } catch (Exception e) {}
        }else if(msg.equals("new faculty information")){
            new addfacality();
        } else if (msg.equals("new student information")) {
            new addstudent();
        } else if (msg.equals("faculty detail")) {
            new TeacherDetails();
        }else if (msg.equals("student detail")) {
            new studentdetails();
        }else if (msg.equals("student leave")) {
            new StudentLeave();
        }else if (msg.equals("faculty leave")) {
            new TeacherLeave();
        }else if (msg.equals("student leave detail")) {
            new StudentLeaveDetail();
        }else if (msg.equals("faculty leave detail")) {
            new TeacherLeaveDetails();
        }else if (msg.equals("exam result")) {
            new ExaminationDetails();
        } else if (msg.equals("marks entry")) {
            new EnterMarks();
        }else if (msg.equals("student detail update")) {
            new UpdateStudent();
        }else if (msg.equals("faculty detail update")) {
            new UpdateTeacher();
        }else if (msg.equals("fee structure")) {
            new FeeStructure();
        }else if (msg.equals("fee form")) {
            new StudentFeeForm();
        }else if (msg.equals("About")) {
            new About();
        }
    }
    public static void main(String[] args) {
        new project();
    }
}
