import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
import java.sql.*;

public class ProgressBar extends JFrame implements Runnable {

    private JPanel contentPane;
    JLabel background,img;
    int s;
    Thread th;
    JProgressBar progressBar;

    public static void main(String[] args) {
        new ProgressBar().setVisible(true);
    }

    public void setUploading() {
        setVisible(false);
        th.start();
    }

    public void run() {
        try {
            for (int i = 0; i < 200; i++) {
                s = s + 1;
                int m = progressBar.getMaximum();
                int v = progressBar.getValue();
                if (v < m) {
                    progressBar.setValue(progressBar.getValue() + 1);
                } else {
                    i = 201;
                    setVisible(false);
                    new DashBoard1().setVisible(true);
                }
                Thread.sleep(50);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public ProgressBar() {

        super("Loading");

        th = new Thread((Runnable) this);

        setBounds(600, 300, 900, 550);



        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        img = new JLabel();
        img.setIcon(new ImageIcon("picture\\topimage.png"));
        add(img);
        img.setBounds(380,0,230,160);


        JLabel lbllibraryManagement = new JLabel("Welcome To the Library");
        add(lbllibraryManagement);
        lbllibraryManagement.setForeground(Color.black);
        lbllibraryManagement.setFont(new Font("Trebuchet MS", Font.BOLD, 35));
        lbllibraryManagement.setBounds(240, 170, 500, 60);


        JLabel lbllibraryManagement1 = new JLabel("Loading Dashboard Please wait");
        add(lbllibraryManagement1);
        lbllibraryManagement1.setForeground(Color.black);
        lbllibraryManagement1.setFont(new Font("Trebuchet MS", Font.BOLD, 35));
        lbllibraryManagement1.setBounds(190, 280, 600, 60);


        JLabel lb = new JLabel();
        lb.setBounds(0,0,0,0);
        add(lb);

        progressBar = new JProgressBar();
        progressBar.setFont(new Font("Tahoma", Font.BOLD, 12));
        progressBar.setStringPainted(true);
        progressBar.setBounds(20, 450, 850, 25);
        add(progressBar);
        progressBar.setBackground(Color.white);
        progressBar.setForeground(Color.black);






        ImageIcon icon1 = new ImageIcon("picture\\backim.jpg");
        background = new JLabel("",icon1,JLabel.CENTER);
        add(background);
        background.setBounds(0,0,900,590);
        setUploading();

        Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();
        this.setLocation(dim.width/2-this.getSize().width/2, dim.height/2-this.getSize().height/2);
    }
}