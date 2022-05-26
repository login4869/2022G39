package gui;


import Controllor.Baggage;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class BagFrame {

    JFrame bagframe = new JFrame("Baggage operation");

    JPanel p1 = new JPanel();
    JPanel p2 = new JPanel();
    JPanel p3 = new JPanel();
    JPanel p4 = new JPanel();
    JPanel p5 = new JPanel();
    JPanel card = new JPanel();


    JButton carrybtn = new JButton("Carry on Baggage");
    JButton sendbtn = new JButton("check in Baggage");
    JButton exit = new JButton("exit");
    JButton back1 = new JButton("back");
    JButton back2 = new JButton("back");

    JLabel la1 = new JLabel();
    JLabel la2 = new JLabel();
    JLabel la3 = new JLabel();
    JLabel printpass = new JLabel("This part is used to print boarding pass.");


    public BagFrame(Baggage user) {
        initFrame();
        addFactor();
        giveInfo(user);
    }



    public void initFrame(){
        bagframe.setBounds(500,100,500,700);
        card.setLayout(new CardLayout());
        bagframe.setVisible(true);
        bagframe.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        bagframe.setResizable(false);
    }


    public void addFactor(){

        p1.setLayout(new GridLayout(5, 1));
        p2.setLayout(new GridLayout(2, 1));
        p3.setLayout(new GridLayout(2, 1));
        p1.add(la1);
        p1.add(printpass);
        p1.add(carrybtn);
        p1.add(sendbtn);
        p1.add(exit);

        p2.add(la2);
        p2.add(back1);

        p3.add(la3);
        p3.add(back2);

        bagframe.add(card);

        card.add(p1, "mainpage");
        card.add(p2, "carrypage");
        card.add(p3, "checkpage");

        CardLayout showcard=(CardLayout)(card.getLayout());
        showcard.show(card, "mainpage");

    }

    public void giveInfo(Baggage user) {

        int carry = 0;
        int check = 0;

        if (user.isHaveCarry()) {
            carry++;
        }
        if (user.isHaveCheck()) {
            check++;
        }

        if (carry == 1 && check == 1) {
            la1.setText("You are a customer who has booked carry on Baggage and checked Baggage services.");
            la2.setText("You have " + user.getCarryBag() + " carry on Baggage.");
            la3.setText("You need to go to " + user.getCheckBag() + " to send you Baggage.");
        } else if (carry == 1) {
            la1.setText("You are a customer who has booked carry on Baggage service.");
            sendbtn.setEnabled(false);
            sendbtn.setText("no check in Baggage");
            la2.setText("You have " + user.getCarryBag() + " carry on Baggage.");
        } else if (check == 1) {
            la1.setText("You are a customer who has booked checked Baggage service.");
            carrybtn.setEnabled(false);
            carrybtn.setText("no carry on Baggage");
            la3.setText("You need to go to " + user.getCheckBag() + " to send you Baggage.");
        } else {
            la1.setText("wrong.");
        }

        setExit();
        setCarrybtn();
        setSendbtn();
        setBack1();
        setBack2();

    }


    public void setExit(){
        //implement a listener to exit button to stop the program
        exit.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.exit(0);
            }
        });
    }

    public void setCarrybtn(){

        carrybtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                CardLayout showcard=(CardLayout)(card.getLayout());
                showcard.show(card, "carrypage");
            }
        });

    }

    public void setSendbtn(){

        sendbtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                CardLayout showcard=(CardLayout)(card.getLayout());
                showcard.show(card, "checkpage");
            }
        });

    }

    public void setBack1(){

        back1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                CardLayout showcard=(CardLayout)(card.getLayout());
                showcard.show(card, "mainpage");
            }
        });

    }

    public void setBack2(){

        back2.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                CardLayout showcard=(CardLayout)(card.getLayout());
                showcard.show(card, "mainpage");
            }
        });

    }


}
