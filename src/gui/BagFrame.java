package gui;


import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import Controllor.baggage;
import Controllor.Login;

public class BagFrame {

    JFrame bagframe = new JFrame("baggage operation");

    JPanel p1 = new JPanel();
    JPanel p2 = new JPanel();
    JPanel p3 = new JPanel();
    JPanel p4 = new JPanel();
    JPanel p5 = new JPanel();
    JPanel card = new JPanel();


    JButton carrybtn = new JButton("Carry on baggage");
    JButton sendbtn = new JButton("check in baggage");
    JButton exit = new JButton("exit");
    JButton back1 = new JButton("back");
    JButton back2 = new JButton("back");

    JLabel la1 = new JLabel();
    JLabel la2= new JLabel();
    JLabel la3 = new JLabel();
    JLabel printpass = new JLabel("This part is used to print boarding pass.");


    public BagFrame(baggage user){
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

    public void giveInfo(baggage user){

        int carry=0;
        int check=0;

        if(user.isHavecarry()){ carry++; }
        if(user.isHavecheck()){ check++; }

        if(carry==1&&check==1){
            la1.setText("You are a customer who has booked carry on baggage and checked baggage services.");
            la2.setText("You have " + user.getCarrybag() + " carry on baggage.");
            la3.setText("You need to go to " + user.getCheckbag() + " to send you baggage.");
        }else if(carry==1){
            la1.setText("You are a customer who has booked carry on baggage service.");
            sendbtn.setEnabled(false);
            sendbtn.setText("no check in baggage");
            la2.setText("You have " + user.getCarrybag() + " carry on baggage.");
        }else if(check==1){
            la1.setText("You are a customer who has booked checked baggage service.");
            carrybtn.setEnabled(false);
            carrybtn.setText("no carry on baggage");
            la3.setText("You need to go to " + user.getCheckbag() + " to send you baggage.");
        }else{
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
