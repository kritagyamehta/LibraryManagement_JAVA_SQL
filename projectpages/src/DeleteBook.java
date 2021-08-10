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


public class DeleteBook  extends JFrame implements ActionListener {
    JPanel pan1;
    JLabel book, name1, isbn, pub, ed, price, page, background;
    JButton  btn1, issue, backbtn;
    JTextField  txt1, txt2, txt3, txt4, txt5, txt6, txt7;

    public DeleteBook() {

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
        book.setBounds(150, 20, 100, 20);
        pan1.add(txt1);
        txt1.setBounds(220, 20, 100, 30);
        pan1.add(btn1);
        btn1.setBounds(360, 20, 100, 20);
        pan1.add(name1);
        name1.setBounds(90, 100, 100, 20);
        name1.setFont(new Font("Italic", Font.BOLD, 17));
        pan1.add(txt2);
        txt2.setBounds(180, 100, 220, 30);
        pan1.add(isbn);
        isbn.setBounds(90, 140, 100, 20);
        isbn.setFont(new Font("Italic", Font.BOLD, 17));
        pan1.add(txt3);
        txt3.setBounds(180, 140, 220, 30);
        pan1.add(pub);
        pub.setFont(new Font("Italic", Font.BOLD, 17));
        pub.setBounds(90, 180, 100, 20);
        pan1.add(txt4);
        txt4.setBounds(180, 180, 220, 30);
        pan1.add(ed);
        ed.setFont(new Font("Italic", Font.BOLD, 17));
        ed.setBounds(90, 220, 100, 20);
        pan1.add(txt5);
        txt5.setBounds(180, 220, 220, 30);
        pan1.add(price);
        price.setFont(new Font("Italic", Font.BOLD, 17));
        price.setBounds(90, 260, 100, 20);
        pan1.add(txt6);
        txt6.setBounds(180, 260, 220, 30);
        pan1.add(page);
        page.setFont(new Font("Italic", Font.BOLD, 17));
        page.setBounds(90, 300, 100, 20);
        pan1.add(txt7);
        txt7.setBounds(180, 300, 220, 30);

        txt2.setBackground(Color.lightGray);
        txt3.setBackground(Color.LIGHT_GRAY);
        txt4.setBackground(Color.LIGHT_GRAY);
        txt5.setBackground(Color.LIGHT_GRAY);
        txt6.setBackground(Color.LIGHT_GRAY);
        txt7.setBackground(Color.LIGHT_GRAY);

        getContentPane().add(pan1);
        pan1.setLayout(null);
        pan1.setBounds(200, 65, 500, 400);
        TitledBorder title1 = BorderFactory.createTitledBorder("Book detail");
        pan1.setBorder(title1);
        title1.setTitleColor(Color.blue);

        ImageIcon icon = new ImageIcon("picture\\backim.jpg");
        background = new JLabel("",icon,JLabel.CENTER);
        add(background);
        background.setBounds(0,0,900,590);

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






        issue = new JButton("Delete");
        pan1.add(issue);
        issue.setBackground(Color.black);
        issue.setForeground(Color.white);
        backbtn = new JButton("Back");
        pan1.add(backbtn);
        backbtn.setBackground(Color.black);
        backbtn.setForeground(Color.white);
        backbtn.addActionListener(this);



        pan1.add(issue);
        issue.addActionListener(this);
        issue.setBounds(150, 360, 80, 30);
        pan1.add(backbtn);
        backbtn.setBounds(260, 360, 80, 30);


        setSize(900, 600);
        setLayout(null);
        setVisible(true);
        setTitle("Delete Book");
        getContentPane().setBackground(Color.PINK);


    }

    @Override
    public void actionPerformed(ActionEvent e) {
        LocalDate date = LocalDate.now();
        if (e.getSource() == issue) {
            String bookid=null;
            bookid = txt1.getText();
            try {

                Class.forName("com.mysql.jdbc.Driver");
                Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/library?characterEncoding=latin1", "root", "password");
                String Str = "delete from books where book_id =?";
                java.sql.PreparedStatement ps = con.prepareStatement(Str);
                ps.setString(1, bookid);

                ps.executeUpdate();
                JOptionPane.showMessageDialog(null,"Book Deleted successfully");
                con.close();

            } catch (Exception ex) {
                System.out.println(ex);
                JOptionPane.showMessageDialog(null,"Book Not Found");
            }
        }



        if (e.getSource() == backbtn) {
            DashBoard1 Go = new DashBoard1();
            Go.setVisible(true);
            dispose();
        }

    }

    public static void main (String[]args){
        new DeleteBook();
    }
}
