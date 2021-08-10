import javax.swing.*;
import javax.swing.border.Border;
import javax.swing.border.LineBorder;
import javax.swing.border.TitledBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.net.URI;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.time.LocalDate;


public class HelpPage  extends JFrame implements ActionListener {
    JPanel panel;
    JLabel Top , Top1 ,Top2,Top3,background;
    JButton cal,cal1 ;
    JButton btnExtra;

    HelpPage(){
        panel= new JPanel();
        panel.setSize(700, 400);
        panel.setBackground(Color.white);
        getContentPane().add(panel);
        panel.setLayout(null);
        panel.setBounds(85, 65, 700, 400);
        Border b1 = new LineBorder(Color.black,18);
        panel.setBorder(BorderFactory.createBevelBorder(0));
        TitledBorder blackline = BorderFactory.createTitledBorder("Help");
        panel.setBorder(blackline);
        blackline.setTitleColor(Color.blue);

        Top = new JLabel("Please Mail All Your queries To The Given Email ID's Below");
        Top1 = new JLabel("- anirudhvyas1802@gamail.com");
        Top2 = new JLabel("- kritagya.mehta22@gmail.com");
        Top3 = new JLabel("- soodansh70@gmail.com");


        panel.add(Top);
        Top.setBounds(20,40,1000,30);
        Top.setFont(new Font("Serif", Font.BOLD, 25));

        panel.add(Top1);
        Top1.setBounds(130,140,1000,30);
        Top1.setFont(new Font("Serif", Font.BOLD, 25));

        panel.add(Top2);
        Top2.setBounds(130,200,1000,30);
        Top2.setFont(new Font("Serif", Font.BOLD, 25));

        panel.add(Top3);
        Top3.setBounds(130,260,1000,30);
        Top3.setFont(new Font("Serif", Font.BOLD, 25));




        btnExtra = new JButton();
        cal= new JButton("Go To Gmail");
        panel.add(cal);
        cal.addActionListener(this);
        cal.setBackground(Color.black);
        cal.setBounds(240,335,200,30);
        cal.setForeground(Color.white);

        cal1= new JButton("Back");
        panel.add(cal1);
        cal1.addActionListener(this);
        cal1.setBackground(Color.black);
        cal1.setBounds(550,360,100,30);
        cal1.setForeground(Color.white);

        add(btnExtra);
        btnExtra.setBounds(150,350,150,30);




        // getContentPane().setBackground(Color.PINK);
        setTitle("Help");
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setVisible(true);
        setLayout(null);
        setSize(900,600);
        ImageIcon icon = new ImageIcon("picture\\backim.jpg");
        background = new JLabel("",icon,JLabel.CENTER);
        add(background);
        background.setBounds(0,0,1000,590);


    }



    public static void main(String[] args)  {
        new HelpPage();
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        cal.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Desktop browser = Desktop.getDesktop();
                try {
                    browser.browse(new URI("https://mail.google.com/mail/u/0/#inbox?compose=new"));
                }
                catch (Exception ex){
                    System.out.println(ex);
                }
            }
        });
        cal1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                DashBoard1 d21 = new DashBoard1();
                d21.setVisible(true);
                dispose();
            }
        });
    }
}

