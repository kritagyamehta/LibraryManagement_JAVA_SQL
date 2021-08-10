import javax.swing.*;
import javax.swing.border.TitledBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.lang.String;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.time.LocalDate;


public class IsuueBook  extends JFrame implements ActionListener {
    JPanel pan1, pan2;
    JLabel book, name1, isbn, pub, ed, price, student, name2, father, cou, branch, year, sem, page, date,background;
    JButton cal, btn1, btn2, issue, backbtn;
    JTextField datetxt, txt1, txt2, txt3, txt4, txt5, txt6, txt7, t1, t2, t3, t4, t5, t6, t7;

    public IsuueBook() {

        pan1 = new JPanel();
        pan1.setSize(450, 350);
        pan1.setBackground(Color.white);

        book = new JLabel("Book_ID");
        name1 = new JLabel("Name");
        isbn = new JLabel("ISBN");
        pub = new JLabel("Publisher");
        ed = new JLabel("Edition");
        price = new JLabel("Price");
        page = new JLabel("Pages");
        btn1 = new JButton("Search");
        btn1.setBackground(Color.black);
        btn1.setForeground(Color.white);

        txt1 = new JTextField(20);
        txt2 = new JTextField(20);
        txt3 = new JTextField(20);
        txt4 = new JTextField(20);
        txt5 = new JTextField(20);
        txt6 = new JTextField(20);
        txt7 = new JTextField(20);

        pan1.add(book);
        book.setBounds(20, 20, 100, 20);
        pan1.add(txt1);
        txt1.setBounds(80, 20, 100, 20);
        pan1.add(btn1);
        btn1.setBounds(200, 20, 100, 20);
        pan1.add(name1);
        name1.setBounds(20, 50, 100, 20);
        pan1.add(txt2);
        txt2.setBounds(80, 50, 220, 20);
        pan1.add(isbn);
        isbn.setBounds(20, 80, 100, 20);
        pan1.add(txt3);
        txt3.setBounds(80, 80, 220, 20);
        pan1.add(pub);
        pub.setBounds(20, 110, 100, 20);
        pan1.add(txt4);
        txt4.setBounds(80, 110, 220, 20);
        pan1.add(ed);
        ed.setBounds(20, 140, 100, 20);
        pan1.add(txt5);
        txt5.setBounds(80, 140, 220, 20);
        pan1.add(price);
        price.setBounds(20, 170, 100, 20);
        pan1.add(txt6);
        txt6.setBounds(80, 170, 220, 20);
        pan1.add(page);
        page.setBounds(20, 200, 100, 20);
        pan1.add(txt7);
        txt7.setBounds(80, 200, 220, 20);

        txt2.setBackground(Color.lightGray);
        txt3.setBackground(Color.LIGHT_GRAY);
        txt4.setBackground(Color.LIGHT_GRAY);
        txt5.setBackground(Color.LIGHT_GRAY);
        txt6.setBackground(Color.LIGHT_GRAY);
        txt7.setBackground(Color.LIGHT_GRAY);

        getContentPane().add(pan1);
        pan1.setLayout(null);
        pan1.setBounds(50, 100, 350, 250);
        TitledBorder title1 = BorderFactory.createTitledBorder("Issue Book");
        pan1.setBorder(title1);
        title1.setTitleColor(Color.blue);

        btn1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String ms1 = null, ms2 = null, ms3 = null, ms4 = null, ms5 = null, ms6 = null, ms7 = null;
                ms1 = txt1.getText();
                if (e.getSource() == btn1) {
                    int id = Integer.parseInt(txt1.getText());
                    try {

                        if (txt1.getText().equals("")) {
                            JOptionPane.showMessageDialog(null, "Fill all the required fields");
                        } else {
                            Connection con;
                            PreparedStatement ps;

                            Class.forName("com.mysql.jdbc.Driver");
                            con = DriverManager.getConnection("jdbc:mysql://localhost:3306/library?characterEncoding=latin1", "root", "password");

                            String q1 = "select book_name , book_isbn ,book_publisher,book_edition,book_price,book_pages from books where book_id = ?";

                            ps = con.prepareStatement(q1);
                            ps.setInt(1, id);
                            ResultSet rs = ps.executeQuery();
                            if (rs.next()) {
                                txt2.setText(rs.getString("book_name"));
                                txt3.setText(rs.getString("book_isbn"));
                                txt4.setText(rs.getString("book_publisher"));
                                txt5.setText(rs.getString("book_edition"));
                                txt6.setText(rs.getString("book_price"));
                                txt7.setText(rs.getString("book_pages"));
                            } else {
                                JOptionPane.showMessageDialog(null, "No Book Found !!!!!");
                            }
                            con.close();

                        }

                    } catch (Exception qe) {
                        System.out.println(qe);
                    }
                }
            }

        });

        /* Panel 1 ends here*/

        pan2 = new JPanel();
        pan2.setSize(550, 350);
        pan2.setBackground(Color.white);

        student = new JLabel("Student_ID");
        name2 = new JLabel("Name");
        father = new JLabel("Father's Name");
        cou = new JLabel("Course");
        branch = new JLabel("Branch");
        year = new JLabel("Year");
        sem = new JLabel("Semester");

        t1 = new JTextField(20);
        t2 = new JTextField(20);
        t3 = new JTextField(20);
        t4 = new JTextField(20);
        t5 = new JTextField(20);
        t6 = new JTextField(20);
        t7 = new JTextField(20);

        btn2 = new JButton("Search");
        btn2.setBackground(Color.black);
        btn2.setForeground(Color.white);

        pan2.add(student);
        student.setBounds(20, 20, 100, 20);
        pan2.add(t1);
        t1.setBounds(105, 20, 100, 20);
        pan2.add(btn2);
        btn2.setBounds(215, 20, 100, 20);
        pan2.add(name2);
        name2.setBounds(20, 60, 100, 20);
        pan2.add(t2);
        t2.setBounds(120, 60, 220, 20);
        pan2.add(father);
        father.setBounds(20, 90, 100, 20);
        pan2.add(t3);
        t3.setBounds(120, 90, 220, 20);
        pan2.add(cou);
        cou.setBounds(20, 120, 100, 20);
        pan2.add(t4);
        t4.setBounds(120, 120, 220, 20);
        pan2.add(branch);
        branch.setBounds(20, 150, 100, 20);
        pan2.add(t5);
        t5.setBounds(120, 150, 220, 20);
        pan2.add(year);
        year.setBounds(20, 180, 100, 20);
        pan2.add(t6);
        t6.setBounds(120, 180, 220, 20);
        pan2.add(sem);
        sem.setBounds(20, 210, 100, 20);
        pan2.add(t7);
        t7.setBounds(120, 210, 220, 20);

        t2.setBackground(Color.lightGray);
        t3.setBackground(Color.LIGHT_GRAY);
        t4.setBackground(Color.LIGHT_GRAY);
        t5.setBackground(Color.LIGHT_GRAY);
        t6.setBackground(Color.LIGHT_GRAY);
        t7.setBackground(Color.LIGHT_GRAY);


        getContentPane().add(pan2);
        pan2.setLayout(null);
        pan2.setBounds(420, 100, 380, 250);
        TitledBorder title2 = BorderFactory.createTitledBorder("Student Details");
        pan2.setBorder(title2);
        title2.setTitleColor(Color.blue);


        /* Panel 2 ends here*/


        date = new JLabel("Date of Issue");
        datetxt = new JTextField();
        cal = new JButton("ok");
        cal.setBackground(Color.black);
        cal.setForeground(Color.white);
        issue = new JButton("Issue");
        issue.setBackground(Color.black);
        issue.setForeground(Color.white);
        backbtn = new JButton("Back");
        backbtn.setBackground(Color.black);
        backbtn.setForeground(Color.white);
        backbtn.addActionListener(this);


        add(date);
        date.setBounds(250, 400, 100, 20);
        Font f = new Font("", Font.BOLD, 12);
        date.setFont(f);
        add(datetxt);
        datetxt.setBounds(350, 400, 125, 20);
        add(cal);
        cal.setBounds(500, 420, 20, 20);
        add(issue);
        issue.addActionListener(this);
        issue.setBounds(300, 430, 80, 30);
        add(backbtn);
        backbtn.setBounds(400, 430, 80, 30);
        cal.addActionListener(this);

        setSize(900, 600);
        setLayout(null);
        setVisible(true);
        setTitle("Issue Book");
        getContentPane().setBackground(Color.PINK);

        ImageIcon icon = new ImageIcon("picture\\backim.jpg");
        background = new JLabel("",icon,JLabel.CENTER);
        add(background);
        background.setBounds(0,0,1000,590);

        btn2.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String ms1 = null, ms2 = null, ms3 = null, ms4 = null, ms5 = null, ms6 = null, ms7 = null;
                ms1 = t1.getText();
                if (e.getSource() == btn2) {
                    int id = Integer.parseInt(t1.getText());
                    try {

                        if (t1.getText().equals("")) {
                            JOptionPane.showMessageDialog(null, "Fill all the required fields");
                        } else {
                            Connection con;
                            PreparedStatement ps;

                            Class.forName("com.mysql.jdbc.Driver");
                            con = DriverManager.getConnection("jdbc:mysql://localhost:3306/library?characterEncoding=latin1", "root", "password");

                            String q1 = "select student_name , fathers_name,course,branch,student_year,students_semester from students where student_id = ?";

                            ps = con.prepareStatement(q1);
                            ps.setInt(1, id);
                            ResultSet rs = ps.executeQuery();
                            if (rs.next()) {
                                t2.setText(rs.getString("student_name"));
                                t3.setText(rs.getString("fathers_name"));
                                t4.setText(rs.getString("course"));
                                t5.setText(rs.getString("branch"));
                                t6.setText(rs.getString("student_year"));
                                t7.setText(rs.getString("students_semester"));
                            } else {
                                JOptionPane.showMessageDialog(null, "No Student Found !!!!!");
                            }
                            con.close();

                        }

                    } catch (Exception qe) {
                        System.out.println(qe);
                    }
                }
            }

        });

    }

    @Override
    public void actionPerformed(ActionEvent e) {
        LocalDate date = LocalDate.now();
        if (e.getSource() == issue) {
            String ms1 = null, ms2 = null, ms3 = null, ms4=null,ms5=null,ms6=null,ms7=null,ms8=null;

            ms1 = txt1.getText();
            ms2 = t1.getText();
            ms3 = datetxt.getText();
            ms4 = txt2.getText();
            ms5 = t2.getText();
            ms6 = t4.getText();
            ms7= t5.getText();



            try {

                Class.forName("com.mysql.jdbc.Driver");
                Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/library?characterEncoding=latin1", "root", "password");
                String Str = "insert into issue_return values(?,?,?,?,?,?,?,?)";
                java.sql.PreparedStatement ps = con.prepareStatement(Str);
                ps.setString(1, ms2);
                ps.setString(2, ms1);
                ps.setString(3, ms3);
                ps.setString(4,null);
                ps.setString(5,ms4);
                ps.setString(6,ms5);
                ps.setString(7,ms6);
                ps.setString(8,ms7);



                ps.executeUpdate();
                JOptionPane.showMessageDialog(null,"Book Issued successfully");
                con.close();

            } catch (Exception ex) {
                System.out.println(ex);
                JOptionPane.showMessageDialog(null,"Book Not Available , Already issued");
            }
        }

        if (e.getSource() == cal) {
            datetxt.setText("" + date);
        }
        if (e.getSource() == backbtn) {
            DashBoard1 Go = new DashBoard1();
            Go.setVisible(true);
            dispose();
        }

    }

    public static void main (String[]args){
        new IsuueBook();
    }
}
