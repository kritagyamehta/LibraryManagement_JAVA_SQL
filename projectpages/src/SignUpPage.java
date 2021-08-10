import javax.swing.*;
import javax.swing.border.Border;
import javax.swing.border.LineBorder;
import javax.swing.border.TitledBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class SignUpPage  extends JFrame {
    JPanel pan1;
    JLabel user,pass,mobno ,background;
    JButton btn1,btn2;
    JTextField txt1,txt2,txt3;

    public SignUpPage()
    {
        pan1= new JPanel();
        pan1.setSize(650, 550);
        pan1.setBackground(Color.white);
        getContentPane().add(pan1);
        pan1.setLayout(null);
        pan1.setBounds(43, 65, 400, 400);
        Border b1 = new LineBorder(Color.BLACK,4,true);
        pan1.setBorder(b1);
        Border blackline = BorderFactory.createTitledBorder("SignUp-Details");
        pan1.setBorder(blackline);
        pan1.setBackground(Color.WHITE);
        ((TitledBorder) blackline).setTitleColor(Color.BLUE);

        ImageIcon icon = new ImageIcon("picture\\backim.jpg");
        background = new JLabel("",icon,JLabel.CENTER);
        add(background);
        background.setBounds(0,0,1000,590);

        user = new JLabel("Set Username*");
        pass = new JLabel("Set Password*");
        mobno = new JLabel("Set Mobile Number*");

        txt1= new JTextField(20);
        txt2= new JTextField(20);
        txt3= new JTextField(20);

        btn1 = new JButton("Add ");
        btn2 = new JButton("Back");

        pan1.add(user);
        pan1.add(txt1);
        txt1.setBounds(200, 50, 170, 30);

        pan1.add(pass);
        pan1.add(txt2);
        txt2.setBounds(200, 130, 170, 30);

        pan1.add(mobno);
        pan1.add(txt3);
        txt3.setBounds(200, 210, 170, 30);

        user.setForeground(Color.black);
        user.setBounds(35,50,150,30);
        user.setFont(new Font("Verdana", Font.BOLD, 15));
        pass.setForeground(Color.black);
        pass.setBounds(35,130,150,30);
        pass.setFont(new Font("Verdana", Font.BOLD, 15));
        mobno.setForeground(Color.black);
        mobno.setBounds(35,210,200,30);
        mobno.setFont(new Font("Verdana", Font.BOLD, 13));

        txt1.setBackground(Color.LIGHT_GRAY);
        txt2.setBackground(Color.lightGray);
        txt3.setBackground(Color.LIGHT_GRAY);

        pan1.add(btn1);
        btn1.setBounds(80,340,90,30);
        pan1.add(btn2);
        btn2.setBounds(200,340,90,30);

        btn1.setBackground(Color.black);
        btn1.setForeground(Color.white);
        btn2.setBackground(Color.black);
        btn2.setForeground(Color.white);
        btn1.setForeground(Color.WHITE);
        btn2.setForeground(Color.white);
        btn2.setBorderPainted(false);
        btn1.setBorderPainted(false);

        getContentPane().setBackground(Color.PINK);
        setSize(490,590);
        setLayout(null);
        setVisible(true);
        setTitle("Sign Up");


        btn1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String ms1,ms2,ms3;
                ms1 = txt1.getText();
                ms2=txt2.getText();
                ms3=txt3.getText();

                JOptionPane.showMessageDialog(null,"registered successfully");
                try {

                    Class.forName("com.mysql.jdbc.Driver");
                    Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/library?characterEncoding=latin1","root","password");
                    String Str = "insert into login values(?,?,?)";
                    java.sql.PreparedStatement ps = con.prepareStatement(Str);
                    ps.setString(1,ms1);
                    ps.setString(2,ms2);
                    ps.setString(3,ms3);


                    ps.executeUpdate();
                    con.close();

                }
                catch (Exception ex){
                    System.out.println(ex);
                }


            }
        });

        btn2.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                LoginPage l5 = new LoginPage();
                l5.setVisible(true);
                dispose();
            }
        });

    }

    public static void main(String[] args) {
        new SignUpPage();
    }
}
