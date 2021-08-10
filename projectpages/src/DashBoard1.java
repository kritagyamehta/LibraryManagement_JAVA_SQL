import javax.swing.*;
import java.awt.*;

import javax.swing.*;
import javax.swing.border.Border;
import javax.swing.border.LineBorder;
import javax.swing.border.TitledBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.net.URI;

public class DashBoard1 extends JFrame implements ActionListener {
    JPanel panel, panel2;
    JLabel img ,img1,img2,img3,img4 ,img5,img6,background;
    JButton btn4 , btn5 ,btn6 , btn7 ,btn8,btn9 ,exit ;
    JButton btnExtra;
    JMenu MainMenu , SubMenu , SubMenu1,Mainmenu2 ;
    JMenuItem itm1 , item2 , itm3;

    JLabel ms1;
    DashBoard1(){
        panel= new JPanel();
        panel.setSize(700, 180);
        panel.setBackground(Color.pink);
        getContentPane().add(panel);
        panel.setLayout(null);
        panel.setBounds(85, 130, 700, 180);
        Border b1 = new LineBorder(Color.black,18);
        panel.setBorder(BorderFactory.createBevelBorder(0));
        TitledBorder blackline = BorderFactory.createTitledBorder("Operations");
        panel.setBorder(blackline);
        blackline.setTitleColor(Color.BLUE);

        panel2= new JPanel();
        panel2.setSize(700, 180);
        panel2.setBackground(Color.pink);
        getContentPane().add(panel2);
        panel2.setLayout(null);
        panel2.setBounds(85, 330, 700, 180);
        Border b2 = new LineBorder(Color.BLACK,4,true);
        panel2.setBorder(b1);
        TitledBorder blackline1 = BorderFactory.createTitledBorder("Action");
        panel2.setBorder(blackline1);
        blackline1.setTitleColor(Color.BLUE);

        img = new JLabel();
        img.setIcon(new ImageIcon("picture\\Book.png"));
        add(img);
        img.setBounds(200,0,230,120);

        img1 = new JLabel();
        img1.setIcon(new ImageIcon("picture\\img1.png"));
        panel.add(img1);
        img1.setBounds(100,10,230,120);

        img2 = new JLabel();
        img2.setIcon(new ImageIcon("picture\\img2.png"));
        panel.add(img2);
        img2.setBounds(320,10,230,120);

        img3 = new JLabel();
        img3.setIcon(new ImageIcon("picture\\img3.png"));
        panel.add(img3);
        img3.setBounds(540,10,230,120);

        img4 = new JLabel();
        img4.setIcon(new ImageIcon("picture\\img4.png"));
        panel2.add(img4);
        img4.setBounds(100,10,230,120);

        img5 = new JLabel();
        img5.setIcon(new ImageIcon("picture\\img5.png"));
        panel2.add(img5);
        img5.setBounds(320,10,230,120);

        img6 = new JLabel();
        img6.setIcon(new ImageIcon("picture\\img6.png"));
        panel2.add(img6);
        img6.setBounds(540,10,230,120);


        ms1 = new JLabel("Welcome to DASHBOARD");
        btn4 = new JButton("ADD/Delete BOOK");
        btn5 = new JButton("STATISTICS");
        btn6 = new JButton("ADD/Delete STUDENT");
        btn7 = new JButton("ISSUE BOOK ");
        btn8 = new JButton("RETURN BOOK");
        btn9 = new JButton("ABOUT US");
        exit = new JButton("EXIT");
        btnExtra = new JButton();

        JMenuBar menubar = new JMenuBar();
        MainMenu = new JMenu("More Option");
        SubMenu1 = new JMenu("More");
        SubMenu = new JMenu("Options");
        itm1 = new JMenuItem("Record");
        item2 = new JMenuItem("Help");
        itm3= new JMenuItem("Log-out");




        add(ms1);
        ms1.setBounds(310,25,500,60);
        ms1.setForeground(Color.BLACK);
        ms1.setFont(new Font("Verdana", Font.BOLD, 30));
        panel2.add(btn9);
        btn9.setBounds(520,130,150,30);
        btn9.setBorderPainted(false);
        btn9.setFont(new Font("Italic", Font.BOLD, 15));
        btn9.setForeground(Color.white);
        btn9.setBackground(Color.black);
        panel.add(btn4);
        btn4.setBounds(70,130,150,30);
        btn4.setBorderPainted(false);
        btn4.setFont(new Font("Italic", Font.BOLD, 13));
        btn4.setForeground(Color.white);
        btn4.setBackground(Color.black);
        panel.add(btn5);
        btn5.setBounds(300,130,150,30);
        btn5.setBorderPainted(false);
        btn5.setFont(new Font("Italic", Font.BOLD, 15));
        btn5.setForeground(Color.white);
        btn5.setBackground(Color.black);
        panel.add(btn6);
        btn6.setBounds(520,130,150,30);
        btn6.setBorderPainted(false);
        btn6.setFont(new Font("Italic", Font.BOLD, 11));
        btn6.setForeground(Color.white);
        btn6.setBackground(Color.black);
        panel2.add(btn7);
        btn7.setBounds(70,130,150,30);
        btn7.setBorderPainted(false);
        btn7.setFont(new Font("Italic", Font.BOLD, 15));
        btn7.setForeground(Color.white);
        btn7.setBackground(Color.black);
        panel2.add(btn8);
        btn8.setBounds(300,130,150,30);
        btn8.setBorderPainted(false);
        btn8.setFont(new Font("Italic", Font.BOLD, 15));
        btn8.setForeground(Color.white);
        btn8.setBackground(Color.black);
        add(btnExtra);
        btnExtra.setBounds(280,350,150,30);

        menubar.add(MainMenu);
        MainMenu.add(itm1);
        MainMenu.add(item2);
        MainMenu.add(itm3);


        itm3.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                LoginPage l1 = new LoginPage();
                l1.setVisible(true);
                dispose();
            }
        });
        item2.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                HelpPage hp = new HelpPage();
                hp.setVisible(true);
                dispose();
            }
        });
        btn9.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                AboutUs uss = new AboutUs();
                uss.setVisible(true);
                dispose();
            }
        });

        btn5.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
               ShowStatsOption so = new ShowStatsOption();
                so.setVisible(true);
                dispose();
            }
        });

        itm1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                ShowStatsOption os = new ShowStatsOption();
                os.setVisible(true);
                dispose();
            }
        });


        btn4.addActionListener(this);
        btn5.addActionListener(this);
        btn6.addActionListener(this);
        btn7.addActionListener(this);
        btn8.addActionListener(this);



        setJMenuBar(menubar);
        menubar.setBorderPainted(false);
        menubar.setBackground(Color.lightGray);
        // getContentPane().setBackground(Color.PINK);
        setTitle("DASHBOARD");
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setVisible(true);
        setLayout(null);
        setSize(900,600);
        ImageIcon icon = new ImageIcon("picture\\backim.jpg");
        background = new JLabel("",icon,JLabel.CENTER);
        add(background);
        background.setBounds(0,0,1000,590);

        ImageIcon icon1 = new ImageIcon("picture\\backim.jpg");
        background = new JLabel("",icon1,JLabel.CENTER);
        panel.add(background);
        background.setBounds(0,0,900,590);

        ImageIcon icon2 = new ImageIcon("picture\\backim.jpg");
        background = new JLabel("",icon2,JLabel.CENTER);
        panel2.add(background);
        background.setBounds(0,0,1000,590);

    }



    public static void main(String[] args)  {

        new DashBoard1();
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource()==btn4){
            AddBook Go1=new AddBook();
            Go1.setVisible(true);
            dispose();
        }
        if(e.getSource()==btn6){
            AddStudent Go2=new AddStudent();
            Go2.setVisible(true);
            dispose();
        }
        if(e.getSource()==btn7){
            IsuueBook Go3=new IsuueBook();
            Go3.setVisible(true);
            dispose();
        }
        if(e.getSource()==btn8){
            ReturnBook Go4=new ReturnBook();
            Go4.setVisible(true);
            dispose();
        }
        if(e.getSource()==Mainmenu2){
            LoginPage Go5=new LoginPage();
            Go5.setVisible(true);
            dispose();
        }


    }
}
