import javax.swing.*;
import javax.swing.border.Border;
import javax.swing.border.LineBorder;
import javax.swing.border.TitledBorder;
import javax.swing.text.StyledEditorKit;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ShowStatsOption extends JFrame {

    JPanel pan1;
    JButton btn1,btn2,btn3,btn4;
    JLabel background;

    public ShowStatsOption()
    {
        pan1= new JPanel();
        pan1.setSize(650, 550);
        pan1.setBackground(Color.white);
        getContentPane().add(pan1);
        pan1.setLayout(null);
        pan1.setBounds(200, 65, 500, 433);
        Border b1 = new LineBorder(Color.BLACK,4,true);
        pan1.setBorder(b1);
        Border blackline = BorderFactory.createTitledBorder("Select Preference");
        pan1.setBorder(blackline);
        pan1.setBackground(Color.WHITE);
        ((TitledBorder) blackline).setTitleColor(Color.BLUE);

        btn1= new JButton("Show Books");
        btn2= new JButton("Show Students");
        btn3= new JButton("Show Issue Details");
        btn4= new JButton("Back");

        btn1.setBackground(Color.black);
        btn1.setForeground(Color.white);
        btn2.setBackground(Color.black);
        btn2.setForeground(Color.white);
        btn3.setBackground(Color.black);
        btn3.setForeground(Color.white);
        btn4.setBackground(Color.black);
        btn4.setForeground(Color.white);

        pan1.add(btn1);
        btn1.setBounds(150,100,170,30);
        pan1.add(btn2);
        btn2.setBounds(150,180,170,30);
        pan1.add(btn3);
        btn3.setBounds(150,260,170,30);
        pan1.add(btn4);
        btn4.setBounds(175,340,120,30);



        getContentPane().setBackground(Color.PINK);
        setSize(900, 600);
        setLayout(null);
        setVisible(true);
        setTitle("STATISTICS");

        ImageIcon icon = new ImageIcon("picture\\backim.jpg");
        background = new JLabel("",icon,JLabel.CENTER);
        add(background);
        background.setBounds(0,0,1000,590);

        btn1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                ViewBook vb = new ViewBook();
                vb.setVisible(true);
            }
        });

        btn2.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                ViewStudents vs = new ViewStudents();
                vs.setVisible(true);
            }
        });

        btn3.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                ViewIssueInfo vi = new ViewIssueInfo();
                vi.setVisible(true);
            }
        });

        btn4.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                DashBoard1 d1 = new DashBoard1();
                d1.setVisible(true);
                dispose();
            }
        });

    }

    public static void main(String[] args) {
        new ShowStatsOption();
    }

}
