package gui;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class UI implements ActionListener {
    JFrame jf = new JFrame("Service Selection");
    JPanel jp = new JPanel();
    JLabel label = new JLabel("Service Selection", SwingConstants.CENTER);
    Font f = new Font(Font.DIALOG, Font.BOLD, 20);
    JButton jb1 = new JButton("General seating location");
    JButton jb2 = new JButton("Meal type");
    JButton jb3 = new JButton("Extra space seating location(extra cost)");
    JButton jb4 = new JButton("Customised menus(extra cost)");
    JButton jb5 = new JButton("Check my selection");
    JButton jb6 = new JButton("Cancel my selected");
    JButton jb7 = new JButton("Cancel");
    JButton jb8 = new JButton("Menu");
    JButton jb9 = new JButton("Confirm");

    public void firstframe() {

        jf.setSize(800, 800);
        jf.setLocationRelativeTo(null);
        jf.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

        //ImageIcon background = new ImageIcon("images/bg.png");
        //JLabel backgroundCon = new JLabel(background);
        //backgroundCon.setBounds(0, 0, background.getIconWidth(),background.getIconHeight());
        //jf.getLayeredPane().add(backgroundCon, new Integer(Integer.MIN_VALUE));
        //JPanel jp1 = (JPanel)jf.getContentPane();
        //jp1.setOpaque(false);

        jp.setLayout(null);


        label.setFont(f);
        label.setBounds(300, 20, 200, 60);
        jp.add(label);


        jb1.setBounds(250, 100, 300, 60);
        jb2.setBounds(250, 200, 300, 60);
        jb3.setBounds(250, 300, 300, 60);
        jb4.setBounds(250, 400, 300, 60);
        jb5.setBounds(250, 500, 300, 60);
        jb6.setBounds(250, 600, 300, 60);
        jb7.setBounds(50, 700, 100, 30);
        jb8.setBounds(350, 700, 100, 30);
        jb9.setBounds(650, 700, 100, 30);
        jb1.addActionListener(this);
        jb2.addActionListener(this);
        jb4.addActionListener(this);
        jb5.addActionListener(this);
        jb7.addActionListener(this);//return to last frame
        jb8.addActionListener(this);//return to main menu
        jb9.addActionListener(this);//go to next frame

        jp.add(jb1);
        jp.add(jb2);
        jp.add(jb3);
        jp.add(jb4);
        jp.add(jb5);
        jp.add(jb6);
        jp.add(jb7);
        jp.add(jb8);
        jp.add(jb9);

        jf.add(jp);

        jf.setVisible(true);
    }

    public void actionPerformed(ActionEvent e) {
        Ticket ticket = new Ticket();
        if (e.getSource() == jb2) {
            mealUI meal = new mealUI();
            jf.dispose();
            meal.secondframe();
        }
        if (e.getSource() == jb4) {
            CustomisedUI cus = new CustomisedUI();
            jf.dispose();
            cus.thirdframe();
        }
        if (e.getSource() == jb5) {
            CheckUI check = new CheckUI();
            jf.dispose();
            check.check();
        }
        if (e.getSource() == jb6) {
            ticket.setService(null);
        }
        if (e.getSource() == jb9) {
            ConfirmUI confirm = new ConfirmUI();
            confirm.confirm();
        }
        if (e.getSource() == jb1) {
            new ChooseSeat();
        }
    }
}
