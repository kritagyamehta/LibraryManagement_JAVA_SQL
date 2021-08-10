import javax.swing.*;
import javax.swing.border.TitledBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.time.LocalDate;


public class DeleteStudent  extends JFrame implements ActionListener {
    JPanel pan1, pan2;
    JLabel book, name1, isbn, pub, ed, price, student, name2, father, cou, branch, year, sem, background;
    JButton cal, btn1, btn2, issue, backbtn;
    JTextField datetxt, txt1, txt2, txt3, txt4, txt5, txt6, txt7, t1, t2, t3, t4, t5, t6, t7;

    public DeleteStudent() {

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
        btn2.setBounds(500, 20, 100, 20);

        pan2.add(student);
        student.setBounds(150, 20, 100, 20);
        pan2.add(t1);
        t1.setBounds(220, 20, 100, 30);
        pan2.add(btn2);
        btn2.setBounds(215, 20, 100, 20);
        pan2.add(name2);
        name2.setBounds(90, 100, 100, 20);
        pan2.add(t2);
        t2.setBounds(180, 100, 220, 30);
        pan2.add(father);
        father.setBounds(90, 140, 100, 20);
        pan2.add(t3);
        t3.setBounds(180, 140, 220, 30);
        pan2.add(cou);
        cou.setBounds(90, 180, 100, 20);
        pan2.add(t4);
        t4.setBounds(180, 180, 220, 30);
        pan2.add(branch);
        branch.setBounds(90, 220, 100, 20);
        pan2.add(t5);
        t5.setBounds(180, 220, 220, 30);
        pan2.add(year);
        year.setBounds(90, 260, 100, 20);
        pan2.add(t6);
        t6.setBounds(180, 260, 220, 30);
        pan2.add(sem);
        sem.setBounds(90, 300, 100, 20);
        pan2.add(t7);
        t7.setBounds(180, 300, 220, 30);

        t2.setBackground(Color.lightGray);
        t3.setBackground(Color.LIGHT_GRAY);
        t4.setBackground(Color.LIGHT_GRAY);
        t5.setBackground(Color.LIGHT_GRAY);
        t6.setBackground(Color.LIGHT_GRAY);
        t7.setBackground(Color.LIGHT_GRAY);

        name2.setFont(new Font("Italic", Font.BOLD, 17));
        father.setFont(new Font("Italic", Font.BOLD, 12));
        cou.setFont(new Font("Italic", Font.BOLD, 17));
        branch.setFont(new Font("Italic", Font.BOLD, 17));
        sem.setFont(new Font("Italic", Font.BOLD, 17));
        year.setFont(new Font("Italic", Font.BOLD, 17));



        getContentPane().add(pan2);
        pan2.setLayout(null);
        pan2.setBounds(200, 65, 500, 400);
        TitledBorder title2 = BorderFactory.createTitledBorder("Student Details");
        pan2.setBorder(title2);
        title2.setTitleColor(Color.blue);


        /* Panel 2 ends here*/




        cal = new JButton("ok");
        cal.setBackground(Color.black);
        cal.setForeground(Color.white);
        issue = new JButton("Delete");
        issue.setBackground(Color.black);
        issue.setForeground(Color.white);
        backbtn = new JButton("Back");
        backbtn.setBackground(Color.black);
        backbtn.setForeground(Color.white);
        backbtn.addActionListener(this);



        pan2.add(btn2);
        btn2.setBounds(340,20,100,30);
        btn2.setForeground(Color.white);

        pan2.add(issue);
        issue.addActionListener(this);
        issue.setBounds(150, 360, 80, 30);
        pan2.add(backbtn);
        backbtn.setBounds(260, 360, 80, 30);

        cal.addActionListener(this);

        setSize(900, 600);
        setLayout(null);
        setVisible(true);
        setTitle("Delete Student");
        getContentPane().setBackground(Color.PINK);

        ImageIcon icon = new ImageIcon("picture\\backim.jpg");
        background = new JLabel("",icon,JLabel.CENTER);
        add(background);
        background.setBounds(0,0,900,590);

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
            String studentid=null;
            studentid = t1.getText();
            try {

                Class.forName("com.mysql.jdbc.Driver");
                Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/library?characterEncoding=latin1", "root", "password");
                String Str = "delete from students where student_id =?";
                java.sql.PreparedStatement ps = con.prepareStatement(Str);
                ps.setString(1, studentid);

                ps.executeUpdate();
                JOptionPane.showMessageDialog(null,"student Deleted successfully");
                con.close();

            } catch (Exception ex) {
                System.out.println(ex);
                JOptionPane.showMessageDialog(null,"student Not Found");
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
        new DeleteStudent();
    }
}
