package university.managment.system;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;

public class login extends JFrame implements ActionListener {
    JButton login,cancel;
    JButton b2,b3;
    JTextField textpass;
    JTextField text;
    login()
    {
        getContentPane().setBackground(Color.WHITE);
        setLayout(null);

        JLabel username =new JLabel("username");
        username.setBounds(200,130,150,45);
        add(username);

        text =new JTextField();
        text.setBounds(200,160,150,25);
        add(text);

        JLabel password =new JLabel("passward");
        password.setBounds(200,180,150,45);
        add(password);

        textpass =new JPasswordField();
        textpass.setBounds(200,210,150,25);
        add(textpass);

        login =new JButton("login");
        login.setBounds(100,270,150,20);
        login.setBackground(Color.BLACK);
        login.setForeground(Color.WHITE);
        login.setFont(new Font("tohuma",Font.CENTER_BASELINE,15));
        login.addActionListener(this);
        add(login);

        cancel =new JButton("cancel");
        cancel.setBounds(320, 310, 150, 20);
        cancel.setBackground(Color.BLACK);
        cancel.setForeground(Color.WHITE);
        cancel.setFont(new Font("tohuma",Font.CENTER_BASELINE,15));
        cancel.addActionListener(this);
        add(cancel);

        b2 = new JButton("SignUp");
        b2.addActionListener(this);

        b2.setForeground(Color.WHITE);
        b2.setBackground(Color.BLACK);
        b2.setBounds(320,270,150,20);
        add(b2);

        b3 = new JButton("Forgot Password");
        b3.addActionListener(this);

        b3.setForeground(Color.WHITE);
        b3.setBackground(Color.BLACK);
        b3.setBounds(100, 310, 150, 20);
        add(b3);

        ImageIcon icon=new ImageIcon(ClassLoader.getSystemResource("jnulogo3.jpg.jpeg"));
        Image icon1=icon.getImage().getScaledInstance(140,140,Image.SCALE_SMOOTH);
        ImageIcon icon2=new ImageIcon(icon1);
        JLabel image =new JLabel(icon2);
        image.setBounds(200,0,140,140);
        add(image);


        setSize(600,400);
        setLocation(350,150);
        setVisible(true);
    }
    public void actionPerformed(ActionEvent at){
        if(at.getSource()==login)
        {
            String username=text.getText();
            String password=textpass.getText();
            //mysql statment
            String query="select * from login where username='"+username+"'and password='"+password+"'";

            try {
                conn c=new conn();
                //execute query
                ResultSet rs=c.s.executeQuery(query);
                if(rs.next()){
                    setVisible(false);
                    new project();
                }else{
                    JOptionPane.showMessageDialog(null,"INVALID USERNAME OR PASSWORD");
                    setVisible(false);
                    //close connection
                }c.s.close();
            }catch (Exception e){e.printStackTrace();}



        }
        else if(at.getSource()==cancel)
        {
            setVisible(false);
        }else if(at.getSource() == b2){
            setVisible(false);
            SignUp su = new SignUp();
            su.setVisible(true);
        }else if(at.getSource() == b3){
            setVisible(false);
            ForgotPassword forgot = new ForgotPassword();
            forgot.setVisible(true);
        }
    }
    public static void main(String[] args) {
        new login();
    }
}
