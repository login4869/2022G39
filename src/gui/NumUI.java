package gui;

import Controllor.Check;

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
import javax.swing.JPasswordField;
import javax.swing.JTextField;

import Entity.Flight;
import Entity.Ticket;
import Entity.User;


public class NumUI extends JFrame {

    /**
     *
     */
    private static final long serialVersionUID = 1L;
    private JPanel mainPanel;				/*主面板*/
    private JTextField resNumField;
    private JButton exitBut;
    private JButton ConfirBut;
    private ImageIcon background;				/*背景图片*/
    private JLabel backgroundCon;				/*背景图片容器*/
    private JLabel label1;
    private JLabel label;
    private JLabel label3;/*标题*/
    private String inputNumber;

    public static User user;
    public static Flight flight;
    public static Ticket ticket;

    public NumUI(){

        //设置框架
        setTitle("input resNum");
        setSize(600, 400);
        //setLocation(220, 120);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setResizable(false);
        setUndecorated( true);				//隐藏标题栏

        //设置背景图片
        background = new ImageIcon("images/background-login.png");
        backgroundCon = new JLabel(background);
        backgroundCon.setBounds(0, 0, background.getIconWidth(),background.getIconHeight());
        getLayeredPane().add(backgroundCon, new Integer(Integer.MIN_VALUE));
        JPanel jp = (JPanel)getContentPane();
        jp.setOpaque(false);

        //初始化mainPanel
        mainPanel  = new JPanel();
        mainPanel.setBackground(Color.gray);
        mainPanel.setLayout(null);
        setContentPane(mainPanel);

        //设置标签
        label1 = new JLabel("number:");
        label = new JLabel("input your reservation number",JLabel.CENTER);
        label.setFont(new Font("bold",Font.BOLD,32));
        label1.setFont(new Font("bold",Font.BOLD , 16));
        label3 = new JLabel();
        label3.setFont(new Font("bold",Font.BOLD , 16));
        label3.setForeground(Color.black);
        label3.setBounds(250, 240, 200, 30);
        mainPanel.add(label3);
        label.setForeground(Color.black);
        label1.setForeground(Color.black);
        label.setBounds(0, 0, 600, 150);
        label1.setBounds(164, 140, 80, 30);
        mainPanel.add(label1);
        mainPanel.add(label);

        //设置TextField
        resNumField = new JTextField();
        resNumField.setBounds(230, 140, 200, 30);
        resNumField.setForeground(Color.black);
        mainPanel.add(resNumField);

        //设置按钮位置
        ConfirBut = new JButton("confirm");
        exitBut = new JButton("exit");
        ConfirBut.setBounds(110, 280,120, 36);
        exitBut.setBounds(350, 280,120, 36);
        mainPanel.add(ConfirBut);
        mainPanel.add(exitBut);

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
        ConfirBut.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                ticket = Check.reservationCheck(resNumField.getText());;
                if (ticket.getFlightNum() == null) {
                    //System.out.println("wrong number");
                    resNumField.setText(null);
                    label3.setText("wrong number");
                }
                else {
                    user = Check.IDCheck(ticket.getUserID());
                    label3.setText("correct!");
                    view();
                }
            }
        });
    }
    private void view(){
        System.out.println("your user num is " + user.getID());
        System.out.println("your given name is " + user.getGivenName());
        System.out.println("your surname is " + user.getSurname());
        System.out.println("your reservation number is " + ticket.getReservationNum());
        System.out.println("your flight number is " + ticket.getFlightNum());
        System.out.println("your seat is " + ticket.getSeat());
        System.out.println("your service is " + ticket.getService());
        System.out.println("your meal is " + ticket.getMeal());
        System.out.println("your special seat is " + ticket.getSseat());

    }
}

