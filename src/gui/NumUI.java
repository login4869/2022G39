package gui;

import Controllor.Check;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

import javax.swing.*;

import Controllor.Login;

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


    public NumUI(){

        setSize(1600, 900);
        //setLocation(220, 120);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setResizable(false);
        setUndecorated(true);                //隐藏标题栏

        //设置背景图片
        background = new ImageIcon("images/login3.jpeg");
        backgroundCon = new JLabel(background);
        backgroundCon.setBounds(0, 0, background.getIconWidth(), background.getIconHeight());
        getLayeredPane().add(backgroundCon, new Integer(Integer.MIN_VALUE));
        JPanel jp = (JPanel) getContentPane();
        jp.setOpaque(false);

        //初始化mainPanel
        mainPanel = new JPanel();
        mainPanel.setSize(1600, 900);
        mainPanel.setOpaque(false);
        mainPanel.setLayout(null);
        setContentPane(mainPanel);

        //设置标签
        label1 = new JLabel("here:");
        label = new JLabel("input your reservation number");
        label.setFont(new Font("bold",Font.BOLD,80));
        label1.setFont(new Font("bold",Font.BOLD , 80));
        label3 = new JLabel("");
        label3.setFont(new Font("bold",Font.BOLD , 80));
        label3.setForeground(Color.red);
        label3.setBounds(900, 500, 800, 120);
        mainPanel.add(label3);
        label.setForeground(Color.black);
        label1.setForeground(Color.black);
        label.setBounds(250, 0, 1200, 150);
        label1.setBounds(100, 150, 1000, 80);
        mainPanel.add(label1);
        mainPanel.add(label);

        //设置TextField
        resNumField = new JTextField();
        resNumField.setBounds(50, 350, 700, 80);
        resNumField.setFont(new Font("bold",Font.BOLD , 80));
        resNumField.setForeground(Color.black);
        //resNumField.setBorder(BorderFactory.createLineBorder(Color.red));
        //resNumField.setOpaque(false);
        mainPanel.add(resNumField);

        //设置按钮位置
        ConfirBut = new JButton("confirm");
        exitBut = new JButton("exit");
        ConfirBut.setBounds(800, 700,340, 120);
        exitBut.setBounds(1300, 700,240, 120);
        ConfirBut.setFont(new Font("bold",Font.BOLD , 70));
        exitBut.setFont(new Font("bold",Font.BOLD , 70));

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
                Login.ticket = Check.reservationCheck(resNumField.getText());
                if (Login.ticket.getFlightNum() == null) {
                    //System.out.println("wrong number");
                    resNumField.setText(null);
                    label3.setText("wrong number!");
                }
                else {
                    Login.user=Check.userCheck(Login.ticket.getUserID());
                    Login.flight=Check.flightCheck(Login.ticket.getFlightNum());
                    label3.setText("correct!");
                    UI ui = new UI();
                    ui.firstframe();
                }
            }
        });
    }
}

