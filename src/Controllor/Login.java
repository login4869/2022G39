package Controllor;


import Boundary.getdata;
import Entity.Flight;
import Entity.Ticket;
import Entity.User;
import gui.NumUI;
import gui.idUI;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;



public class Login extends JFrame{
    /**
     *
     */
    private JLabel label;/*标题*/
    private String option;


    public static String[][] userlist;
    public static String[][] ticketlist;


    public Login(){
        userlist = getdata.UserRead();
        ticketlist = getdata.TicketRead();


        //设置框架
        setTitle("welcome to login system");
        setSize(1300, 700);
        //setLocation(220, 120);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setResizable(false);
        setUndecorated( true);				//隐藏标题栏

        //设置背景图片
        background = new ImageIcon("images/login.jpeg");
        backgroundCon = new JLabel(background);
        backgroundCon.setBounds(0, 0, background.getIconWidth(),background.getIconHeight());
        getLayeredPane().add(backgroundCon, new Integer(Integer.MIN_VALUE));
        JPanel jp = (JPanel)getContentPane();
        jp.setOpaque(false);

        //初始化mainPanel
        mainPanel  = new JPanel();
        mainPanel.setOpaque(false);
        mainPanel.setLayout(null);
        setContentPane(mainPanel);

        //设置标签
        label = new JLabel("Self Service Check-In System");
        label.setFont(new Font("boldface",Font.BOLD,80));
        label.setBounds(70, 0, 1300, 150);
        label.setForeground(Color.WHITE);
        label1 = new JLabel("Select Your Check-In Mode",JLabel.CENTER);
        label1.setFont(new Font("boldface",Font.BOLD,40));
        label1.setBounds(0, 100, 1300, 150);
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

        NumBut.setBounds(150, 250,1000, 50);
        IDBut.setBounds(150, 340,1000, 50);
       exitBut.setBounds(1100, 600,100, 80);
        scanBut.setBounds(150, 430,1000, 50);

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
                option="1";
            }
        });
        IDBut.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                new idUI().setVisible(true);
                option="2";
            }
        });
    }

}


