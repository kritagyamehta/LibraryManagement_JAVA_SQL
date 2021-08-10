import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;



public class ViewStudents {
    JFrame f;
    JTable j;

    public ViewStudents()
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
            String sql = "Select * from students";

            ResultSet rs = s.executeQuery(sql);

            while(rs.next()){
                String id = String.valueOf(rs.getInt("student_id"));
                String Name = rs.getString("student_name");
                String Course = rs.getString("course");
                String Branch = rs.getString("branch");
                String Semester = rs.getString("students_semester");


                String tbData[] = {id, Name , Course, Branch,Semester};
                String tbData11[] = {"Student ID", "Name" , "Course", "Branch","Semester"};
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
        new ViewStudents();
    }


    public void setVisible(boolean b) {
    }
}

//
//    String tbData[] = {id, Name , Author, genre};
//    DefaultTableModel tblModel = (DefaultTableModel)j.getModel();
//                tblModel.setColumnIdentifiers(tbData);
//                        tblModel.addRow(tbData);{

