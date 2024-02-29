package university.managment.system;

import javax.swing.*;
import java.awt.*;

public class splash extends JFrame implements Runnable{
    splash()
    {
        ImageIcon icon=new ImageIcon(ClassLoader.getSystemResource("jnu.png"));
        Image icon1=icon.getImage().getScaledInstance(1150,350,Image.SCALE_DEFAULT);
        ImageIcon icon2=new ImageIcon(icon1);
        JLabel image =new JLabel(icon2);
        add(image);

        Thread t=new Thread(this);
        t.start();
        setVisible(true);
        int x=1;
        for (int i=5;i<=500;i+=4,x+=1) {
            setLocation(400-(i+x)/2,450- (i+x)/2);//80,100
            setSize(2*i+160, i-90);//1200,450
            try{
                Thread.sleep(10);
            }catch (Exception e){}
        }
    }
    public void run(){
        try {
            Thread.sleep(7000);
            setVisible(false);
            //loginclass
            //new login();
        }catch (Exception e){}
        new login();
    }
    public static void main(String[] args) {
        new splash();
    }
}

