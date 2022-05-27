package gui;


import Controllor.Check;
import Controllor.Login;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.util.ArrayList;
import java.util.List;


public class IdUI extends JFrame {


    /**
     *
     */
    private static final long serialVersionUID = 1L;
    private JPanel mainPanel;                /*主面板*/
    private JTextField idField;
    private JTextField surField;
    private JButton exitBut;
        private JButton ConfirBut;
        public JButton ticketBut0;
        public JButton ticketBut1;
        public JButton ticketBut2;
        public JButton ticketBut3;
        private ImageIcon background;                /*背景图片*/
        private JLabel backgroundCon;                /*背景图片容器*/
        private JLabel label1;
        private JLabel label2;
        private JLabel label3;
        private JLabel label;
        private JLabel haveTicket;
        private JLabel selectTicket;
        private String inputNumber;
        private JLabel miss;
        public List<Integer> getnum = new ArrayList<Integer>();

        public IdUI() {

            setSize(1600, 900);
            //setLocation(220, 120);
            setLocationRelativeTo(null);
            setDefaultCloseOperation(EXIT_ON_CLOSE);
            setResizable(false);
            setUndecorated(true);                //隐藏标题栏

            //设置背景图片
            background = new ImageIcon("images/login1.jpeg");
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
            label1 = new JLabel("ID number:");
            label2 = new JLabel("surname:");
            miss= new JLabel(new ImageIcon("images/miss.png"));
            miss.setBounds(1300, 600, 140, 500);
            haveTicket = new JLabel();
            selectTicket = new JLabel();
            label = new JLabel("input your ID number and Surname ", JLabel.CENTER);
            label.setFont(new Font("bold", Font.BOLD, 66));
            label1.setFont(new Font("bold", Font.BOLD, 40));
            label2.setFont(new Font("bold", Font.BOLD, 40));
            haveTicket.setFont(new Font("bold", Font.BOLD, 40));
            selectTicket.setFont(new Font("bold", Font.BOLD, 40));
            label.setForeground(Color.black);
            label1.setForeground(Color.black);
            label2.setForeground(Color.black);
            haveTicket.setForeground(Color.red);
            selectTicket.setForeground(Color.red);
            label.setBounds(0, 0, 1200, 150);
            label1.setBounds(70, 180, 400, 50);
            label2.setBounds(80, 300, 400, 50);
            haveTicket.setBounds(900, 120, 400, 50);
            selectTicket.setBounds(900, 180, 800, 50);
            mainPanel.add(label1);
            mainPanel.add(label2);
            mainPanel.add(label);
            label3 = new JLabel();
            label3.setFont(new Font("bold", Font.BOLD, 50));
            label3.setForeground(Color.red);
            label3.setBounds(250, 400, 600, 60);
            mainPanel.add(label3);
            mainPanel.add(haveTicket);
            mainPanel.add(selectTicket);
            mainPanel.add(miss);
            miss.setVisible(false);

            //设置TextField
            idField = new JTextField();
            idField.setBounds(280, 180, 500, 70);
            idField.setFont(new Font("bold", Font.BOLD, 60));
            idField.setForeground(Color.black);
            mainPanel.add(idField);
            surField = new JTextField();
            surField.setBounds(280, 300, 500, 70);
            surField.setFont(new Font("bold", Font.BOLD, 60));
            surField.setForeground(Color.black);
            mainPanel.add(surField);

            //设置按钮位置
            ConfirBut = new JButton("confirm");
            exitBut = new JButton("exit");
            ticketBut0 = new JButton();
            ticketBut1 = new JButton();
            ticketBut2 = new JButton();
            ticketBut3 = new JButton();
            ticketBut0.setBounds(1000, 260, 500, 50);
            ticketBut0.setFont(new Font("bold", Font.BOLD, 40));
            ticketBut1.setBounds(1000, 360, 500, 50);
            ticketBut1.setFont(new Font("bold", Font.BOLD, 40));
            ticketBut2.setBounds(1000, 460, 500, 50);
            ticketBut2.setFont(new Font("bold", Font.BOLD, 40));
            ticketBut3.setBounds(1000, 560, 500, 50);
            ticketBut3.setFont(new Font("bold", Font.BOLD, 40));
            ConfirBut.setBounds(200, 650, 200, 50);
            exitBut.setBounds(450, 650, 200, 50);
            ConfirBut.setFont(new Font("bold", Font.BOLD, 40));
            exitBut.setFont(new Font("bold", Font.BOLD, 40));
            ticketBut0.setVisible(false);
            ticketBut1.setVisible(false);
            ticketBut2.setVisible(false);
            ticketBut3.setVisible(false);
            mainPanel.add(ConfirBut);
            mainPanel.add(exitBut);
            mainPanel.add(ticketBut0);
            mainPanel.add(ticketBut1);
            mainPanel.add(ticketBut2);
            mainPanel.add(ticketBut3);


            //按钮交互
            exitBut.addActionListener(new ActionListener() {
                public void actionPerformed(ActionEvent e) {
                    new Login().setVisible(true);
                    dispose();
                }
            });
            exitBut.addKeyListener(new KeyAdapter() {
                @Override
                public void keyTyped(KeyEvent e) {
                    if (e.getKeyChar() == KeyEvent.VK_ENTER) {
                        new Login().setVisible(true);
                        dispose();
                    }
                }
            });
            ConfirBut.addActionListener(new ActionListener() {
                public void actionPerformed(ActionEvent e) {
                    tickerChoose(idField.getText());
                }
            });
            ticketBut0.addActionListener(new ActionListener() {
                public void actionPerformed(ActionEvent e) {
                    Login.ticket = Check.reservationCheck(Login.ticketList[getnum.get(0)][0]);
                    Login.user = Check.userCheck(Login.ticket.getUserID());
                    Login.flight = Check.flightCheck(Login.ticket.getFlightNum());
                    UI ui = new UI();
                    ui.firstframe();
                    dispose();

                }
            });
            ticketBut1.addActionListener(new ActionListener() {
                public void actionPerformed(ActionEvent e) {
                    Login.ticket = Check.reservationCheck(Login.ticketList[getnum.get(1)][0]);
                    Login.user = Check.userCheck(Login.ticket.getUserID());
                    Login.flight = Check.flightCheck(Login.ticket.getFlightNum());
                    UI ui = new UI();
                    ui.firstframe();
                    dispose();
                }
            });
            ticketBut2.addActionListener(new ActionListener() {
                public void actionPerformed(ActionEvent e) {
                    Login.ticket = Check.reservationCheck(Login.ticketList[getnum.get(2)][0]);
                    Login.user = Check.userCheck(Login.ticket.getUserID());
                    Login.flight = Check.flightCheck(Login.ticket.getFlightNum());
                    UI ui = new UI();
                    ui.firstframe();
                    dispose();

                }
            });
            ticketBut3.addActionListener(new ActionListener() {
                public void actionPerformed(ActionEvent e) {
                    Login.ticket = Check.reservationCheck(Login.ticketList[getnum.get(3)][0]);
                    Login.user = Check.userCheck(Login.ticket.getUserID());
                    Login.flight = Check.flightCheck(Login.ticket.getFlightNum());
                    UI ui = new UI();
                    ui.firstframe();
                    dispose();

                }
            });

        }

        public void tickerChoose(String userid) {
            int checknum = 0;
            int ticketnum = 0;
            int len = Login.ticketList.length;
            for (; checknum < len; checknum++) {
                if (userid.equals(Login.ticketList[checknum][1])) {
                    getnum.add(checknum);
                    ticketnum++;
                }
            }
            if (ticketnum == 0) {
                label3.setText("wrong number!");
                idField.setText(null);
            }
            if (ticketnum != 0) {
                miss.setVisible(true);
                haveTicket.setText("You have " + ticketnum + " ticket:");
                if (ticketnum == 1) {
                    label3.setText("correct!");
                    ticketBut0.setVisible(true);
                    ticketBut0.setText(1 + ": " + Login.ticketList[getnum.get(0)][0] + "," + Login.ticketList[getnum.get(0)][2]);
                }
                if (ticketnum == 2) {
                    label3.setText("correct!");
                    ticketBut0.setVisible(true);
                    ticketBut0.setText(1 + ": " + Login.ticketList[getnum.get(0)][0] + "," + Login.ticketList[getnum.get(0)][2]);
                    ticketBut1.setVisible(true);
                    ticketBut1.setText(2 + ": " + Login.ticketList[getnum.get(1)][0] + "," + Login.ticketList[getnum.get(1)][2]);
                }
                if (ticketnum == 3) {
                    label3.setText("correct!");
                    ticketBut0.setVisible(true);
                    ticketBut0.setText(1 + ": " + Login.ticketList[getnum.get(0)][0] + "," + Login.ticketList[getnum.get(0)][2]);
                    ticketBut1.setVisible(true);
                    ticketBut1.setText(2 + ": " + Login.ticketList[getnum.get(1)][0] + "," + Login.ticketList[getnum.get(1)][2]);
                    ticketBut2.setVisible(true);
                    ticketBut2.setText(3 + ": " + Login.ticketList[getnum.get(2)][0] + "," + Login.ticketList[getnum.get(2)][2]);
                }
                if (ticketnum == 4) {
                    label3.setText("correct!");
                    ticketBut0.setVisible(true);
                    ticketBut0.setText(1 + ": " + Login.ticketList[getnum.get(0)][0] + "," + Login.ticketList[getnum.get(0)][2]);
                    ticketBut1.setVisible(true);
                    ticketBut1.setText(2 + ": " + Login.ticketList[getnum.get(1)][0] + "," + Login.ticketList[getnum.get(1)][2]);
                    ticketBut2.setVisible(true);
                    ticketBut2.setText(3 + ": " + Login.ticketList[getnum.get(2)][0] + "," + Login.ticketList[getnum.get(2)][2]);
                    ticketBut3.setVisible(true);
                    ticketBut3.setText(4 + ": " + Login.ticketList[getnum.get(3)][0] + "," + Login.ticketList[getnum.get(3)][2]);
                }
                selectTicket.setText("Which one you want to choose.");
            }

        }
    }


