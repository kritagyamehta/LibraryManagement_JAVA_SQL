import javax.swing.*;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.net.URI;



public class AboutUs extends JFrame implements ActionListener {
    JLabel Aboutus,admin1img,adminimg2,adminimg3 ,name1,name2,name3,email1,email2,email3,num1,num2,num3 ,imgmail1,background;
    JButton btn4 , btn5 ,btn6,cal ;
    JButton btnExtra,btnback ,btn1 , btn2 , btn3;


    JLabel ms1;
    AboutUs(){
        num1 = new JLabel("9424481700");
        num1.setBounds(110,360,450,30);
        num1.setFont(new Font("Verdana", Font.BOLD, 15));
        num2 = new JLabel("9174683184");
        num2.setBounds(370,360,450,30);
        num2.setFont(new Font("Verdana", Font.BOLD, 15));
        num3 = new JLabel("7987975126");
        num3.setBounds(650,360,450,30);
        num3.setFont(new Font("Verdana", Font.BOLD, 15));
        email1 = new JLabel("anirudhvyas1802@gmail.com");
        email1.setBounds(60,330,450,30);
        email1.setFont(new Font("Verdana", Font.BOLD, 13));
        email2 = new JLabel("kritagya.mehta22@gmail.com");
        email2.setBounds(320,330,450,30);
        email2.setFont(new Font("Verdana", Font.BOLD, 13));
        email3 = new JLabel("soodansh70@gmail.com");
        email3.setBounds(600,330,450,30);
        email3.setFont(new Font("Verdana", Font.BOLD, 13));
        name1 = new JLabel("Anirudh Vyas");
        name1.setBounds(80,300,450,30);
        name1.setFont(new Font("Verdana", Font.BOLD, 23));
        name2 = new JLabel("Kritagya Mehta");
        name2.setBounds(330,300,450,30);
        name2.setFont(new Font("Verdana", Font.BOLD, 23));
        name3 = new JLabel("Ansh Sood");
        name3.setBounds(630,300,450,30);
        name3.setFont(new Font("Verdana", Font.BOLD, 23));

        Aboutus= new JLabel("CREATORS");
        Aboutus.setBounds(350,10,450,30);
        Aboutus.setFont(new Font("Verdana", Font.BOLD, 30));

        admin1img = new JLabel();
        admin1img.setIcon(new ImageIcon("picture\\admin1.png"));
        add(admin1img);
        admin1img.setBounds(70,80,200,200);

        admin1img = new JLabel();
        admin1img.setIcon(new ImageIcon("picture\\admin2.png"));
        add(admin1img);
        admin1img.setBounds(330,80,200,200);

        admin1img = new JLabel();
        admin1img.setIcon(new ImageIcon("picture\\admin3.png"));
        add(admin1img);
        admin1img.setBounds(590,80,200,200);


        imgmail1 = new JLabel();
        add(imgmail1);
        imgmail1.setIcon(new ImageIcon("picture\\call.png"));
        imgmail1.setBounds(80,360,450,30);



        imgmail1 = new JLabel();
        add(imgmail1);
        imgmail1.setIcon(new ImageIcon("picture\\call.png"));
        imgmail1.setBounds(340,360,450,30);


        imgmail1 = new JLabel();
        add(imgmail1);
        imgmail1.setIcon(new ImageIcon("picture\\call.png"));
        imgmail1.setBounds(620,360,450,30);

        btn1 =new  JButton("Go!");
        btn2 =new  JButton("Go!");
        btn3 =new  JButton("Go!");


        add(btn1);
        btn1.setBounds(140,400,60,30);
        imgmail1 = new JLabel();
        add(imgmail1);
        imgmail1.setIcon(new ImageIcon("picture\\link.png"));
        imgmail1.setBounds(110,400,60,30);

        add(btn2);
        btn2.setBounds(400,400,60,30);
        imgmail1 = new JLabel();
        add(imgmail1);
        imgmail1.setIcon(new ImageIcon("picture\\link.png"));
        imgmail1.setBounds(370,400,60,30);

        add(btn3);
        btn3.setBounds(680,400,60,30);
        imgmail1 = new JLabel();
        add(imgmail1);
        imgmail1.setIcon(new ImageIcon("picture\\link.png"));
        imgmail1.setBounds(650,400,60,30);


        btn1.setBackground(Color.black);
        btn1.setForeground(Color.white);
        btn1.setBorderPainted(false);
        btn2.setBackground(Color.black);
        btn2.setForeground(Color.white);
        btn2.setBorderPainted(false);
        btn3.setBackground(Color.black);
        btn3.setForeground(Color.white);
        btn3.setBorderPainted(false);

        add(Aboutus);
        add(name1);
        add(name2);
        add(name3);
        add(email1);
        add(email2);
        add(email3);
        add(num1);
        add(num2);
        add(num3);



        btnExtra = new JButton();



        cal= new JButton("Back");
        add(cal);
        cal.addActionListener(this);
        cal.setBackground(Color.black);
        cal.setBounds(650,490,100,30);
        cal.setForeground(Color.white);
        ImageIcon icon = new ImageIcon("picture\\backim.jpg");
        background = new JLabel("",icon,JLabel.CENTER);
        add(background);
        background.setBounds(0,0,1000,590);

        add(btnExtra);
        btnExtra.setBounds(150,350,150,30);

        btn1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Desktop browser = Desktop.getDesktop();
                try {
                    browser.browse(new URI("https://www.linkedin.com/in/anirudh-vyas-5ba835177/"));
                }
                catch (Exception ex){
                    System.out.println(ex);
                }
            }
        });
        btn2.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Desktop browser = Desktop.getDesktop();
                try {
                    browser.browse(new URI("https://www.linkedin.com/in/kritagya-mehta-7464861b9/"));
                }
                catch (Exception ex){
                    System.out.println(ex);
                }
            }
        });
        btn3.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Desktop browser = Desktop.getDesktop();
                try {
                    browser.browse(new URI("https://www.linkedin.com/in/ansh-sood-a36755201/"));
                }
                catch (Exception ex){
                    System.out.println(ex);
                }
            }
        });

        cal.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                DashBoard1 d21 = new DashBoard1();
                d21.setVisible(true);
                dispose();
            }
        });


        getContentPane().setBackground(Color.PINK);
        setTitle("About Us");
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setVisible(true);
        setLayout(null);
        setSize(900,600);


    }



    public static void main(String[] args)  {
        new AboutUs();
    }

    @Override
    public void actionPerformed(ActionEvent e) {




    }
}
