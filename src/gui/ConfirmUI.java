package gui;

import Controllor.baggage;
import Entity.Ticket;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


public class ConfirmUI implements ActionListener {
	public static Ticket ticket;

	JFrame jf = new JFrame("Check your information");
	JPanel jp = new JPanel();
	JLabel label = new JLabel("Please scan your ID card.", SwingConstants.LEFT);
	Font f = new Font(Font.DIALOG, Font.BOLD, 15);
	JButton jb1 = new JButton("Confirm");
	JButton jb2 = new JButton("EXIT");

	public void confirm() {
		jf.setSize(400, 400);
		jf.setLocationRelativeTo(null);
		jf.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

		jp.setLayout(null);

		label.setFont(f);
		label.setBounds(0, 50, 300, 60);
		jp.add(label);


		jb1.setBounds(250, 250, 100, 30);
		jb2.setBounds(250, 300, 100, 30);
		jb1.addActionListener(this);
		jb2.addActionListener(this);
		jp.add(jb1);
		jp.add(jb2);

		jf.add(jp);

		jf.setVisible(true);
	}

	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == jb1) {
			if (NumUI.ticket.getCarryonBag() == "0" && NumUI.ticket.getCheckinBag() == "0") {
				System.out.println("you don't have baggage");
			} else {
				baggage b1 = new baggage(NumUI.ticket);
				b1.findBag();
			}
		}
		if (e.getSource() == jb2) {
			System.exit(0);
		}
	}

}
