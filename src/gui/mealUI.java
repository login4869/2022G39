package gui;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class mealUI implements ActionListener{
	JFrame jf = new JFrame("Meal Type");
	JPanel jp = new JPanel();
	JLabel label= new JLabel("Meal Type",SwingConstants.CENTER);
	Font f =new Font(Font.DIALOG,Font.BOLD,20);
	JButton jb1 = new JButton("Standard");
	JButton jb2 = new JButton("Vegetarian");
	JButton jb3 = new JButton("Halal");
	JButton jb4 = new JButton("Cancel");
	JButton jb5 = new JButton("Menu");
	JButton jb6 = new JButton("Confirm");
	public void secondframe() {
		jf.setSize(800,500);
    	jf.setLocationRelativeTo(null);
    	jf.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
    	
    	jp.setLayout(null);
    	
    	label.setFont(f);
		label.setBounds(300,20,200,60);
		jp.add(label);
		
		jb1.setBounds(250,100,300,60);
		jb2.setBounds(250,200,300,60);
		jb3.setBounds(250,300,300,60);
		jb4.setBounds(50,400,100,30);
		jb5.setBounds(350,400,100,30);
		jb6.setBounds(650,400,100,30);
		jb1.addActionListener(this);
		jb2.addActionListener(this);
		jb3.addActionListener(this);
		jb4.addActionListener(this);
		jb5.addActionListener(this);
		jb6.addActionListener(this);
		
		jp.add(jb1);
		jp.add(jb2);
		jp.add(jb3);
		jp.add(jb4);
		jp.add(jb5);//return to main menu
		jp.add(jb6);
		
		jf.add(jp);
	   	
    	jf.setVisible(true);
	}
	
	public void actionPerformed(ActionEvent e) {
		Ticket ticket = new Ticket();
    	if(e.getSource()==jb1) {
    		ticket.setService("standrad");
    		System.out.println(ticket.getService());
    	}
    	if(e.getSource()==jb2) {
    		ticket.setService("Vegetarian");
    		System.out.println(ticket.getService());
    	}
    	if(e.getSource()==jb3) {
    		ticket.setService("Halal");
    		System.out.println(ticket.getService());
    	}
    	if(e.getSource()==jb4) {
    		UI ui = new UI();
    		jf.dispose();
    		ui.firstframe();
    	}
    	if(e.getSource()==jb6) {
    		UI ui = new UI();
    		jf.dispose();
    		ui.firstframe();
    	}
    }

}
