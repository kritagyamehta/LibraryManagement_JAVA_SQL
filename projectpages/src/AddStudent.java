import javax.swing.*;
import javax.swing.border.Border;
import javax.swing.border.LineBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import javax.swing.border.TitledBorder;

public class AddStudent  extends JFrame implements ActionListener {
    public int variable;
    JPanel pan1;
    JLabel stuid, name1, fname, course, bran, yr, sem,background;
    JButton btn1, btn2,btndelete;
    JTextField txt1, txt2, txt3, txt4, txt5, txt6, txt7;
    JComboBox cbcourse, cbbnch, cbyear, cbsemm;


    public AddStudent() {
        pan1 = new JPanel();
        pan1.setSize(650, 550);
        pan1.setBackground(Color.white);
        getContentPane().add(pan1);
        pan1.setLayout(null);
        pan1.setBounds(200, 65, 500, 433);
        Border b1 = new LineBorder(Color.BLACK, 4, true);
        pan1.setBorder(b1);
        Border blackline = BorderFactory.createTitledBorder("Add Students");
        pan1.setBorder(blackline);
        pan1.setBackground(Color.WHITE);
        ((TitledBorder) blackline).setTitleColor(Color.BLUE);

        stuid = new JLabel("Student's ID");
        name1 = new JLabel("Name");
        fname = new JLabel("Father's Name");
        course = new JLabel("Course");
        bran = new JLabel("Branch");
        yr = new JLabel("Year");
        sem = new JLabel("Semester");
        btn1 = new JButton("ADD");
        btn2 = new JButton("BACK");
        btndelete = new JButton("Go To Delete");
        btn1.setBackground(Color.black);
        btn1.setForeground(Color.white);
        btn2.setBackground(Color.black);
        btn2.setForeground(Color.white);

        txt1 = new JTextField(20);
        txt2 = new JTextField(20);
        txt3 = new JTextField(20);
        txt4 = new JTextField(20);
        txt5 = new JTextField(20);
        txt6 = new JTextField(20);
        txt7 = new JTextField(20);

        String core[] = {"B.Tech", "B.Sc", "M.Tech", "M.Sc", "BBA", "MBA"};
        cbcourse = new JComboBox(core);
        String bnch[] = {"CSE", "ME", "EC", "IT", "CIVIL", "AE"};
        cbbnch = new JComboBox(bnch);
        String year[] = {"FIRST", "SECOND", "THIRD", "FOURTH"};
        cbyear = new JComboBox(year);
        String semm[] = {"1", "2", "3", "4", "5", "6", "7", "8"};
        cbsemm = new JComboBox(semm);

        pan1.add(stuid);
        pan1.add(txt1);
        txt1.setBounds(180, 50, 200, 30);

        pan1.add(name1);
        pan1.add(txt2);
        txt2.setBounds(180, 90, 200, 30);

        pan1.add(fname);
        pan1.add(txt3);
        txt3.setBounds(180, 130, 200, 30);

        pan1.add(course);
        pan1.add(cbcourse);
        cbcourse.setBounds(180, 170, 200, 30);

        pan1.add(bran);
        pan1.add(cbbnch);
        cbbnch.setBounds(180, 210, 200, 30);

        pan1.add(yr);
        pan1.add(cbyear);
        cbyear.setBounds(180, 250, 200, 30);

        pan1.add(sem);
        pan1.add(cbsemm);
        cbsemm.setBounds(180, 290, 200, 30);

        stuid.setForeground(Color.black);
        stuid.setBounds(35, 50, 150, 30);
        stuid.setFont(new Font("Verdana", Font.BOLD, 15));
        name1.setForeground(Color.black);
        name1.setBounds(35, 90, 150, 30);
        name1.setFont(new Font("Verdana", Font.BOLD, 15));
        fname.setForeground(Color.black);
        fname.setBounds(35, 130, 150, 30);
        fname.setFont(new Font("Verdana", Font.BOLD, 15));
        course.setForeground(Color.black);
        course.setBounds(35, 170, 150, 30);
        course.setFont(new Font("Verdana", Font.BOLD, 15));
        bran.setForeground(Color.black);
        bran.setBounds(35, 210, 150, 30);
        bran.setFont(new Font("Verdana", Font.BOLD, 15));
        yr.setForeground(Color.black);
        yr.setBounds(35, 250, 150, 30);
        yr.setFont(new Font("Verdana", Font.BOLD, 15));
        sem.setForeground(Color.black);
        sem.setBounds(35, 290, 150, 30);
        sem.setFont(new Font("Verdana", Font.BOLD, 15));

        txt1.setBackground(Color.LIGHT_GRAY);
        txt2.setBackground(Color.lightGray);
        txt3.setBackground(Color.LIGHT_GRAY);

        pan1.add(btn1);
        btn1.setBounds(180, 330, 80, 30);
        pan1.add(btn2);
        btn2.addActionListener(this);
        btn2.setBounds(300, 330, 80, 30);
        pan1.add(btndelete);
        btndelete.setBounds(220,390,120,30);
        btndelete.setBackground(Color.BLACK);
        btndelete.setForeground(Color.WHITE);

        //getContentPane().setBackground(Color.PINK);
        setSize(900, 600);
        setLayout(null);
        setVisible(true);
        setTitle("Add Students");
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
                ms4 = cbcourse.getSelectedItem().toString();
                ms5 = cbbnch.getSelectedItem().toString();
                ms6 = cbyear.getSelectedItem().toString();
                ms7 =  cbsemm.getSelectedItem().toString();

                JOptionPane.showMessageDialog(null,"Student Added successfully");
                try {

                    Class.forName("com.mysql.jdbc.Driver");
                    Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/library?characterEncoding=latin1","root","password");
                    String Str = "insert into students values(?,?,?,?,?,?,?)";
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
                DeleteStudent d4 = new DeleteStudent();
                d4.setVisible(true);
                dispose();
            }
        });

    }

    public static void main(String[] args) {
        new AddStudent();
    }

    @Override
    public void actionPerformed(ActionEvent e) {

    }
}
