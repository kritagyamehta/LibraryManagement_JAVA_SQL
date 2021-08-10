
import javax.swing.*;
import javax.swing.border.Border;
import javax.swing.border.LineBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import javax.swing.border.TitledBorder;

public class AddBook  extends JFrame {

    JPanel pan1;
    JLabel stuid,name1,fname,course,bran,yr,sem,background;
    JButton btn1,btn2,btndelete;
    JTextField txt1,txt2,txt3,txt4,txt5,txt6;
    JComboBox cbedition;

    public AddBook ()
    {
        pan1= new JPanel();
        pan1.setSize(650, 550);
        pan1.setBackground(Color.white);
        getContentPane().add(pan1);
        pan1.setLayout(null);
        pan1.setBounds(200, 65, 500, 433);
        Border b1 = new LineBorder(Color.BLACK,4,true);
        pan1.setBorder(b1);
        Border blackline = BorderFactory.createTitledBorder("Book Detail");
        pan1.setBorder(blackline);
        pan1.setBackground(Color.WHITE);
        ((TitledBorder) blackline).setTitleColor(Color.BLUE);

        stuid= new JLabel("Book Id");
        name1= new JLabel("Name");
        fname= new JLabel("ISBN");
        course= new JLabel("Publisher");
        bran= new JLabel("Edition");
        yr= new JLabel("Price");
        sem= new JLabel("Pages");
        btn1= new JButton("ADD");
        btn2= new JButton("BACK");
        btndelete = new JButton("Go To Delete");
        btn1.setBackground(Color.black);
        btn1.setForeground(Color.white);
        btn2.setBackground(Color.black);
        btn2.setForeground(Color.white);

        txt1= new JTextField(20);
        txt2= new JTextField(20);
        txt3= new JTextField(20);
        txt4= new JTextField(20);
        txt5= new JTextField(20);
        txt6= new JTextField(20);

        String edition[] = {"1","2","3","4","5","6","7","8","9","10"} ;
        cbedition = new JComboBox(edition);

        pan1.add(stuid);
        pan1.add(txt1);
        txt1.setBounds(150, 50, 200, 30);

        pan1.add(name1);
        pan1.add(txt2);
        txt2.setBounds(150, 90, 200, 30);

        pan1.add(fname);
        pan1.add(txt3);
        txt3.setBounds(150, 130, 200, 30);

        pan1.add(course);
        pan1.add(txt4);
        txt4.setBounds(150,170,200,30);

        pan1.add(bran);
        pan1.add(cbedition);
        cbedition.setBounds(150,210,200,30);

        pan1.add(yr);
        pan1.add(txt5);
        txt5.setBounds(150,250,200,30);

        pan1.add(sem);
        sem.setBounds(20, 290, 100, 30);
        pan1.add(txt6);
        txt6.setBounds(150,290,200,30);

        stuid.setForeground(Color.black);
        stuid.setBounds(35,50,150,30);
        stuid.setFont(new Font("Verdana", Font.BOLD, 15));
        name1.setForeground(Color.black);
        name1.setBounds(35,90,150,30);
        name1.setFont(new Font("Verdana", Font.BOLD, 15));
        fname.setForeground(Color.black);
        fname.setBounds(35,130,150,30);
        fname.setFont(new Font("Verdana", Font.BOLD, 15));
        course.setForeground(Color.black);
        course.setBounds(35,170,150,30);
        course.setFont(new Font("Verdana", Font.BOLD, 15));
        bran.setForeground(Color.black);
        bran.setBounds(35,210,150,30);
        bran.setFont(new Font("Verdana", Font.BOLD, 15));
        yr.setForeground(Color.black);
        yr.setBounds(35,250,150,30);
        yr.setFont(new Font("Verdana", Font.BOLD, 15));
        sem.setForeground(Color.black);
        sem.setBounds(35,290,150,30);
        sem.setFont(new Font("Verdana", Font.BOLD, 15));

        txt1.setBackground(Color.LIGHT_GRAY);
        txt2.setBackground(Color.lightGray);
        txt3.setBackground(Color.LIGHT_GRAY);
        txt4.setBackground(Color.LIGHT_GRAY);
        txt5.setBackground(Color.LIGHT_GRAY);
        txt6.setBackground(Color.LIGHT_GRAY);

        pan1.add(btn1);
        btn1.setBounds(150,340,80,30);
        pan1.add(btn2);
        btn2.setBounds(270,340,80,30);
        pan1.add(btndelete);
        btndelete.setBounds(190,390,120,30);
        btndelete.setBackground(Color.BLACK);
        btndelete.setForeground(Color.WHITE);

        getContentPane().setBackground(Color.PINK);
        setSize(900, 600);
        setLayout(null);
        setVisible(true);
        setTitle("Add Books");

        ImageIcon icon = new ImageIcon("picture\\backim.jpg");
        background = new JLabel("",icon,JLabel.CENTER);
        add(background);
        background.setBounds(0,0,1000,590);

        btn1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String ms1 = null, ms2=null, ms3=null, ms4=null, ms5=null,ms6 = null, ms7=null;

                ms1 = txt1.getText();
                ms2 = txt2.getText();
                ms3 =  txt3.getText();
                ms4 = txt4.getText();
                ms5 =cbedition.getSelectedItem().toString();
                ms6 = txt5.getText();
                ms7 =  txt6.getText();

                JOptionPane.showMessageDialog(null,"Book Added successfully");
                try {

                    Class.forName("com.mysql.jdbc.Driver");
                    Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/library?characterEncoding=latin1","root","password");
                    String Str = "insert into books values(?,?,?,?,?,?,?)";
                    java.sql.PreparedStatement ps = con.prepareStatement(Str);
                    ps.setString(1,ms1);
                    ps.setString(2,ms2);
                    ps.setString(3,ms3);
                    ps.setString(4,ms4);
                    ps.setString(5,ms5);
                    ps.setString(6,ms6);
                    ps.setString(7,ms7);

                    ps.executeUpdate();
                    con.close();
                    JOptionPane.showMessageDialog(null,"Book Added successfully");

                }
                catch (Exception ex){
                    System.out.println(ex);
                }


            }
        });

        btn2.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                DashBoard1 Go=new DashBoard1();
                Go.setVisible(true);
                dispose();
            }
        });
        btndelete.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                DeleteBook b4 = new DeleteBook();
                b4.setVisible(true);
                dispose();
            }
        });

    }

    public static void main(String[] args) {
        new AddBook ();
    }


}
