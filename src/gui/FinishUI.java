package gui;

import java.awt.Font;

import javax.swing.*;

public class FinishUI {
	JFrame jf = new JFrame("Finish");
	JPanel jp = new JPanel();
	JLabel label1 = new JLabel("Your information has been entered into the passenger list,",SwingConstants.LEFT);
	JLabel label2 = new JLabel("enjoy your trip!",SwingConstants.LEFT);
	Font f =new Font(Font.DIALOG,Font.BOLD,15);
	public void finish() {
		jf.setSize(600,400);
    	jf.setLocationRelativeTo(null);
    	jf.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
    	
    	jp.setLayout(null);
    	
    	label1.setFont(f);
		label1.setBounds(50,150,500,30);
		label2.setFont(f);
		label2.setBounds(50,190,500,30);
		jp.add(label1);
		jp.add(label2);
		
		jf.add(jp);
		jf.setVisible(true);
	}

}
