import javax.swing.*;
import javax.swing.border.Border;
import javax.swing.border.LineBorder;
import javax.swing.border.TitledBorder;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class ViewBook extends JFrame {

    JTable j;
    JFrame f;
    JMenu MainMenu;
    JMenuItem itm1;



    public ViewBook()
    {
        f = new JFrame();
        f.setTitle("JTable Example");

        j = new JTable(0,4);
        j.setBounds(30, 100, 300, 300);

        j.setFont(new Font("arial",Font.BOLD,16));
        f.setFont(new Font("Arial",Font.BOLD,16));

        JScrollPane sp = new JScrollPane(j);
        f.add(sp);

        j.getTableHeader().setFont(new Font("Segoe UI",Font.BOLD,18));
        j.setBackground(Color.LIGHT_GRAY);
        j.getTableHeader().setBackground(Color.PINK);
        j.setRowHeight(25);

        Connection con;
        Statement s;
        try{
            Class.forName("com.mysql.jdbc.Driver");
            con = DriverManager.getConnection("jdbc:mysql://localhost:3306/library?characterEncoding=latin1","root","password");
            s =con.createStatement();
            String sql = "Select * from books";

            ResultSet rs = s.executeQuery(sql);

            while(rs.next()){
                String id = String.valueOf(rs.getInt("book_id"));
                String Name = rs.getString("book_name");
                String Publisher = rs.getString("book_publisher");
                String Edition = rs.getString("book_edition");


                String tbData[] = {id, Name , Publisher, Edition};
                String tbData11[] = {"Book ID", "Name" , "Publisher", "Edition"};
                DefaultTableModel tblModel = (DefaultTableModel)j.getModel();
                tblModel.setColumnIdentifiers(tbData11);
                tblModel.addRow(tbData);

            }

        }catch(Exception e){
            System.out.println("database error" + e);
        }
        f.setSize(900, 600);
        f.setVisible(true);
        f.setTitle("CENTRAL LIBRARY : VIEW BOOKS");
        f.getContentPane().setBackground(Color.WHITE);
    }

    public static void main(String[] args)
    {
        new ViewBook();
    }


    public void setVisible(boolean b) {
    }
}

//
//    String tbData[] = {id, Name , Author, genre};
//    DefaultTableModel tblModel = (DefaultTableModel)j.getModel();
//                tblModel.setColumnIdentifiers(tbData);
//                        tblModel.addRow(tbData);