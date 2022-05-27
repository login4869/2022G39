package Controllor;


import Boundary.GetData;
import Entity.Flight;
import Entity.Ticket;
import Entity.User;
import gui.IdUI;
import gui.NumUI;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;



public class Login extends JFrame{
    /**
     *
     */
    private static final long serialVersionUID = 1L;
    private JPanel mainPanel;				/*主面板*/
    private JButton IDBut;
    private JButton exitBut;
    private JButton NumBut;
    private JButton scanBut;
    private ImageIcon background;                /*背景图片*/
    public static String[][] userList;
    private JLabel label1;
    private JLabel label;/*标题*/
    private String option;

    public static User user;
    public static Flight flight;
    public static Ticket ticket;
    public static String[][] ticketList;
    public static String[][] flightList;
    private JLabel backgroundCon;                /*背景图片容器*/


    public Login() {
        userList = GetData.UserRead();
        ticketList = GetData.TicketRead();
        flightList = GetData.FlightRead();


        //设置框架
        setTitle("welcome to login system");
        setSize(1600, 900);
        //setLocation(220, 120);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setResizable(false);
        setUndecorated(true);                //隐藏标题栏

        //设置背景图片
        background = new ImageIcon("images/login2.jpeg");
        backgroundCon = new JLabel(background);
        backgroundCon.setBounds(0, 0, background.getIconWidth(),background.getIconHeight());
        getLayeredPane().add(backgroundCon, new Integer(Integer.MIN_VALUE));
        JPanel jp = (JPanel)getContentPane();
        jp.setOpaque(false);

        //初始化mainPanel
        mainPanel  = new JPanel();
        mainPanel.setSize(1600,900);
        mainPanel.setOpaque(false);
        mainPanel.setLayout(null);
        setContentPane(mainPanel);

        //设置标签
        label = new JLabel("Self Service Check-In System",JLabel.CENTER);
        label.setFont(new Font("boldface",Font.BOLD,80));
        label.setBounds(150, 0, 1300, 150);
        label.setForeground(Color.WHITE);
        label1 = new JLabel("Select Your Check-In Mode",JLabel.CENTER);
        label1.setFont(new Font("boldface",Font.BOLD,40));
        label1.setBounds(150, 100, 1300, 150);
        label1.setForeground(Color.red);
        mainPanel.add(label);
        mainPanel.add(label1);


        //设置按钮位置
        NumBut = new JButton("input your reservation number");
        IDBut = new JButton("input your ID and Surname");
        exitBut = new JButton("exit");
        scanBut = new JButton("scan your ID card");

        NumBut.setFont(new Font("boldface",Font.BOLD,40));
        IDBut.setFont(new Font("boldface",Font.BOLD,40));
        exitBut.setFont(new Font("boldface",Font.BOLD,30));
        scanBut.setFont(new Font("boldface",Font.BOLD,40));

        NumBut.setBounds(300, 270,1000, 80);
        IDBut.setBounds(300, 390,1000, 80);
       exitBut.setBounds(1200, 700,150, 90);
        scanBut.setBounds(300, 510,1000, 80);

        mainPanel.add(NumBut);
        mainPanel.add(IDBut);
        mainPanel.add(exitBut);
        mainPanel.add(scanBut);

        NumBut.setFocusPainted(false);
        IDBut.setFocusPainted(false);
        scanBut.setFocusPainted(false);
        exitBut.setFocusPainted(false);

        //按钮交互
        exitBut.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                dispose();
            }
        });
        exitBut.addKeyListener(new KeyAdapter() {
            @Override
            public void keyTyped(KeyEvent e) {
                if(e.getKeyChar() == KeyEvent.VK_ENTER){
                    dispose();
                }
            }
        });
        NumBut.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                new NumUI().setVisible(true);
                dispose();
                option="1";
            }
        });
        IDBut.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                new IdUI().setVisible(true);
                dispose();
                option = "2";
            }
        });
    }

}


