package gui;


import Entity.Ticket;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


public class CheckUI implements ActionListener {
	JFrame jf = new JFrame("Check your selections");
	JPanel jp = new JPanel();
	JLabel label1 = new JLabel("Your selections as follows:", SwingConstants.LEFT);
	Font f = new Font(Font.DIALOG, Font.BOLD, 20);
	JButton jb1 = new JButton("Cancel");
	JButton jb2 = new JButton("Menu");
	JButton jb3 = new JButton("Confirm");

	public void check() {
		Ticket ticket = new Ticket();
		jf.setSize(400, 400);
		jf.setLocationRelativeTo(null);
		jf.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

		jp.setLayout(null);

		label1.setFont(f);
		label1.setBounds(0, 0, 400, 30);
		jp.add(label1);
		System.out.println("111" + ticket.getService());
		JLabel label2 = new JLabel(ticket.getService(), SwingConstants.CENTER);
		label2.setFont(f);
		label2.setBounds(50, 150, 200, 60);
		jp.add(label2);

		jb1.setBounds(25, 320, 100, 30);
		jb2.setBounds(150, 320, 100, 30);
		jb3.setBounds(275, 320, 100, 30);
		jb1.addActionListener(this);
		jb2.addActionListener(this);
		jb3.addActionListener(this);
		jp.add(jb1);
		jp.add(jb2);
		jp.add(jb3);
		jf.add(jp);
		jf.setVisible(true);
	}

	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == jb1) {
			UI ui = new UI();
			jf.dispose();
			ui.firstframe();
		}

		if (e.getSource() == jb3) {
			UI ui = new UI();
			jf.dispose();
			ui.firstframe();
		}
	}
}
