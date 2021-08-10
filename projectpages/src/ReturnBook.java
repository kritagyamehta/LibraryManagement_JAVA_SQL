import javax.swing.*;
import javax.swing.border.Border;
import javax.swing.border.LineBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.time.LocalDate;
import javax.swing.border.TitledBorder;

public class ReturnBook extends JFrame implements ActionListener {
    JPanel panel;
    JLabel bookid ,student , book , name, course , branch , doi , dor,background;
    JButton btn4 , btn5 ,btn6,cal ;
    JButton btnExtra;
    JTextField  txt1,txt2,txt3,txt4,txt5,txt6,txt7,datetxt;

    JLabel ms1;
    ReturnBook(){
        panel= new JPanel();
        panel.setSize(700, 400);
        panel.setBackground(Color.white);
        getContentPane().add(panel);
        panel.setLayout(null);
        panel.setBounds(85, 65, 700, 400);
        Border b1 = new LineBorder(Color.black,18);
        panel.setBorder(BorderFactory.createBevelBorder(0));
        TitledBorder blackline = BorderFactory.createTitledBorder("Return-Panel");
        panel.setBorder(blackline);
        blackline.setTitleColor(Color.blue);




        btn4 = new JButton("SEARCH");
        btn5 = new JButton("RETURN");
        btn6 = new JButton("BACK");
        bookid= new JLabel("Book_ID");
        book= new JLabel("Book");
        student= new JLabel("Student_ID");
        course= new JLabel("Course");
        name= new JLabel("Name");
        branch= new JLabel("Branch");
        doi= new JLabel("Date Of Issue");
        dor= new JLabel("Date Of Return");
        btnExtra = new JButton();
        txt1= new JTextField(20);
        txt2= new JTextField(20);
        txt3= new JTextField(20);
        txt4= new JTextField(20);
        txt5= new JTextField(20);
        txt6= new JTextField(20);
        txt7= new JTextField(20);

        panel.add(btn4);
        btn4.setBounds(580,40,100,28);
        btn4.setBorderPainted(false);
        btn4.setFont(new Font("Italic", Font.BOLD, 13));
        btn4.setForeground(Color.white);
        btn4.setBackground(Color.black);
        panel.add(btn5);
        btn5.setBounds(450,270,150,30);
        btn5.setBorderPainted(false);
        btn5.setFont(new Font("Italic", Font.BOLD, 15));
        btn5.setForeground(Color.white);
        btn5.setBackground(Color.black);
        panel.add(btn6);
        btn6.addActionListener(this);
        btn6.setBounds(450,330,150,30);
        btn6.setBorderPainted(false);
        btn6.setFont(new Font("Italic", Font.BOLD, 15));
        btn6.setForeground(Color.white);
        btn6.setBackground(Color.black);

        panel.add(bookid);
        bookid.setForeground(Color.black);
        bookid.setBounds(35,40,150,30);
        bookid.setFont(new Font("Verdana", Font.BOLD, 15));
        panel.add(txt1);
        txt1.setBounds(125,40,160,30);

        panel.add(student);
        student.setForeground(Color.black);
        student.setBounds(300,40,150,30);
        student.setFont(new Font("Verdana", Font.BOLD, 15));
        panel.add(txt2);
        txt2.setBounds(410,40,160,30);

        panel.add(book);
        book.setForeground(Color.black);
        book.setBounds(35,120,150,30);
        book.setFont(new Font("Verdana", Font.BOLD, 15));
        panel.add(txt3);
        txt3.setBackground(Color.lightGray);
        txt3.setBounds(125,123,190,25);

        panel.add(name);
        name.setForeground(Color.black);
        name.setBounds(335,120,150,30);
        name.setFont(new Font("Verdana", Font.BOLD, 15));
        panel.add(txt4);
        txt4.setBackground(Color.lightGray);
        txt4.setBounds(410,123,190,25);

        panel.add(course);
        course.setForeground(Color.black);
        course.setBounds(35,180,150,30);
        course.setFont(new Font("Verdana", Font.BOLD, 15));
        panel.add(txt5);
        txt5.setBackground(Color.lightGray);
        txt5.setBounds(125,183,190,25);

        panel.add(branch);
        branch.setForeground(Color.black);
        branch.setBounds(335,180,150,30);
        branch.setFont(new Font("Verdana", Font.BOLD, 15));
        panel.add(txt6);
        txt6.setBackground(Color.lightGray);
        txt6.setBounds(410,183,190,25);

        panel.add(doi);
        doi.setForeground(Color.black);
        doi.setBounds(35,270,150,30);
        doi.setFont(new Font("Verdana", Font.BOLD, 15));
        panel.add(txt7);
        txt7.setBackground(Color.lightGray);
        txt7.setBounds(200,273,190,25);

        panel.add(dor);
        dor.setForeground(Color.black);
        dor.setBounds(35,330,150,30);
        dor.setFont(new Font("Verdana", Font.BOLD, 15));

        datetxt= new JTextField();

        cal= new JButton("ok");
        panel.add(cal);
        cal.addActionListener(this);
        cal.setBackground(Color.black);
        cal.setBounds(400,335,15,25);
        cal.setForeground(Color.white);

        panel.add(datetxt);
        datetxt.setBounds(200,335,190,25);
        datetxt.setBackground(Color.lightGray);


        add(btnExtra);
        btnExtra.setBounds(150,350,150,30);




        getContentPane().setBackground(Color.PINK);
        setTitle("Return Book");
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setVisible(true);
        setLayout(null);
        setSize(900,600);
        ImageIcon icon = new ImageIcon("picture\\backim.jpg");
        background = new JLabel("",icon,JLabel.CENTER);
        add(background);
        background.setBounds(0,0,1000,590);
        btn4.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String ms1 = null, ms2 = null;
                ms1 = txt1.getText();
                ms2 = txt2.getText();
                if (e.getSource() == btn4) {
                    int id = Integer.parseInt(txt1.getText());
                    int id1 = Integer.parseInt(txt2.getText());
                    try {

                        if (txt1.getText().equals("")||txt2.getText().equals("")) {
                            JOptionPane.showMessageDialog(null, "Fill all the required fields");
                        } else {
                            Connection con;
                            PreparedStatement ps;

                            Class.forName("com.mysql.jdbc.Driver");
                            con = DriverManager.getConnection("jdbc:mysql://localhost:3306/library?characterEncoding=latin1", "root", "password");

                            String q1 = "select nameofbook , studentName , studentCourse ,studentbranch , issue_date from issue_return where book_id=? and student_id = ? ";

                            ps = con.prepareStatement(q1);
                            ps.setInt(1, id);
                            ps.setInt(2,id1);
                            ResultSet rs = ps.executeQuery();
                            if (rs.next()) {
                                txt3.setText(rs.getString("nameofbook"));
                                txt4.setText(rs.getString("studentName"));
                                txt5.setText(rs.getString("studentCourse"));
                                txt6.setText(rs.getString("studentbranch"));
                                txt7.setText(rs.getString("issue_date"));

                            } else {
                                JOptionPane.showMessageDialog(null, "No Data Found !!!!!");
                            }
                            con.close();

                        }

                    } catch (Exception qe) {
                        System.out.println(qe);
                    }
                }
            }

        });

        btn5.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                String ms1 = null,ms2=null,ms3=null;

                ms1 = datetxt.getText();
                ms2 = txt1.getText();
                ms3 =txt2.getText();
                JOptionPane.showMessageDialog(null,"Book Returned successfully");



                try {

                    Class.forName("com.mysql.jdbc.Driver");
                    Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/library?characterEncoding=latin1", "root", "password");
                    String Str = "delete from issue_return where book_id= ? and student_id=?";
                    java.sql.PreparedStatement ps = con.prepareStatement(Str);


                    ps.setString(1, ms2);
                    ps.setString(2, ms3);

                    ps.executeUpdate();
                    con.close();

                } catch (Exception ex) {
                    System.out.println(ex);
                }
            }

        });



    }



    public static void main(String[] args)  {
        new ReturnBook();
    }

    @Override
    public void actionPerformed(ActionEvent e) {


        LocalDate date = LocalDate.now();


        if (e.getSource()==cal){
            datetxt.setText(""+date);
        }
        if(e.getSource()==btn6){
            DashBoard1 Go=new DashBoard1();
            Go.setVisible(true);
            dispose();
        }


    }
}

