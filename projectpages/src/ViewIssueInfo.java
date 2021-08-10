import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class ViewIssueInfo {
    JFrame f;
    JTable j;

    public ViewIssueInfo()
    {
        f = new JFrame();
        f.setTitle("JTable Example");

        j = new JTable(0,4);
        j.setBounds(30, 40, 300, 300);

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
            String sql = "Select * from issue_return";

            ResultSet rs = s.executeQuery(sql);

            while(rs.next()){
                String sid = String.valueOf(rs.getInt("student_id"));
                String bid = rs.getString("book_id");
                String IssueDate = rs.getString("issue_date");
                String BookName = rs.getString("nameofbook");
                String StuName = rs.getString("studentName");


                String tbData[] = {sid, bid , IssueDate, BookName,StuName};
                String tbData11[] = {"Student ID", "Book ID" , "Issue Date", "Book Name","Student Name"};
                DefaultTableModel tblModel = (DefaultTableModel)j.getModel();
                tblModel.setColumnIdentifiers(tbData11);
                tblModel.addRow(tbData);

            }

        }catch(Exception e){
            System.out.println("database error" + e);
        }
        f.setSize(900, 600);
        setVisible(true);
        f.setVisible(true);
        f.setTitle("CENTRAL LIBRARY : VIEW BOOKS");
        f.getContentPane().setBackground(Color.WHITE);
    }

    public static void main(String[] args)
    {
        new ViewIssueInfo();
    }


    public void setVisible(boolean b) {
    }
}

//
//    String tbData[] = {id, Name , Author, genre};
//    DefaultTableModel tblModel = (DefaultTableModel)j.getModel();
//                tblModel.setColumnIdentifiers(tbData);
//                        tblModel.addRow(tbData);{

