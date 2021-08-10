import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class LoginPage extends JFrame implements ActionListener {

    JLabel msg1 , msg2 , top ,top0,msg3 , img , background;
    JPasswordField  txt2;
    JTextField txt1  ;
    JButton btn1 , btn2 ,btn3,btn4;
    LoginPage(){
        img = new JLabel();
        img.setIcon(new ImageIcon("picture\\download.png"));
        add(img);
        img.setBounds(10,1,230,140);


        top = new JLabel("WELCOME!");
        top0 = new JLabel("PLEASE LOGIN");
        msg1 = new JLabel("USERNAME : ");
        msg2 = new JLabel("PASSWORD : ");
        msg3 = new JLabel("OR, Trouble In Login ?");
        txt1 = new JTextField();
        txt2 = new JPasswordField();
        btn1 = new JButton("Sign In");
        btn2 = new JButton("Clear");
        btn4 = new JButton("Sign Up");
        btn3 = new JButton("Forgot Password");

        // name.setFont(new Font("Italic", Font.BOLD, 18));
        //  name.setForeground(Color.white);
        add(top);
        top.setBounds(230,10,250,60);
        top.setForeground(Color.white);
        top.setFont(new Font("Verdana", Font.BOLD, 30));
        add(top0);
        top0.setForeground(Color.white);
        top0.setBounds(200,50,280,60);
        top0.setFont(new Font("Verdana", Font.BOLD, 30));
        add(msg1);
        msg1.setBounds(50,180,150,30);
        msg1.setForeground(Color.white);
        msg1.setFont(new Font("Verdana", Font.BOLD, 20));
        add(msg2);
        msg2.setForeground(Color.white);
        msg2.setBounds(50,260,150,30);
        msg2.setFont(new Font("Verdana", Font.BOLD, 19));
        add(txt1);
        txt1.setBounds(240,180,180,40);
        add(txt2);
        txt2.setBounds(240,260,180,40);
        add(btn1);
        btn1.setBounds(50,380,100,34);
        add(btn4);
        btn4.setBounds(185,380,100,34);
        add(btn2);
        btn2.setBounds(320,380,100,34);
        add(btn3);
        btn3.setBounds(114,480,230,34);

        txt1.setFont(new Font("Verdana", Font.BOLD, 15));
        txt2.setFont(new Font("Verdana", Font.BOLD, 15));

        btn1.addActionListener(this);
        btn2.addActionListener(this);
        btn3.addActionListener(this);
        btn4.addActionListener(this);

        btn2.setBorderPainted(false);
        btn3.setBorderPainted(false);
        btn1.setBorderPainted(false);
        btn4.setBorderPainted(false);

        btn1.setFont(new Font("Italic", Font.BOLD, 15));
        btn2.setFont(new Font("Italic", Font.BOLD, 15));
        btn3.setFont(new Font("Italic", Font.BOLD, 15));
        btn4.setFont(new Font("Italic", Font.BOLD, 15));

        btn1.setForeground(Color.black);
        btn2.setForeground(Color.black);
        btn3.setForeground(Color.black);
        btn4.setForeground(Color.black);

        btn1.setBackground(Color.lightGray);
        btn2.setBackground(Color.lightGray);
        btn3.setBackground(Color.lightGray);
        btn4.setBackground(Color.lightGray);

        add(msg3);
        msg3.setBounds(122,440,210,30);
        msg3.setForeground(Color.white);
        msg3.setFont(new Font("Verdana", Font.BOLD, 15));


        getContentPane().setBackground(Color.lightGray);
        setLayout(null);
        setTitle("LIBRARY - Login");
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setVisible(true);
        setSize(490,590);
        ImageIcon icon = new ImageIcon("picture\\is.jpg");
        background = new JLabel("",icon,JLabel.CENTER);
        add(background);
        background.setBounds(0,0,490,590);

        btn1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                try {

                    String ms1 = txt1.getText();
                    String ms2 = txt2.getText();
                    Class.forName("com.mysql.jdbc.Driver");
                    Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/library?characterEncoding=latin1","root","password");
                    String q  = "select * from login where admin_Username = '"+ms1+"' and admin_password = '"+ms2+"'";
                    PreparedStatement ps;
                    ps = con.prepareStatement(q);
                    ResultSet rs = ps.executeQuery();
                    if(rs.next()){
                        setVisible(false);
                        //new DashBoard1().setVisible(true);
                         new ProgressBar().setVisible(true);
                    }else{
                        JOptionPane.showMessageDialog(null, "Incorrect ID or Password");
                    }
                }
                catch (Exception ek){
                    System.out.println(ek);
                }



            }
        });
        btn4.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                SignUpPage s1 = new SignUpPage();
                s1.setVisible(true);
                dispose();
            }
        });
        btn3.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                ForgotPassword f1 = new ForgotPassword();
                f1.setVisible(true);
                dispose();
            }
        });
    }

    public static void main(String[] args) {
        new LoginPage();
    }


    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == btn2) {
            txt1.setText(null);
            txt2.setText(null);
        }
    }
}

