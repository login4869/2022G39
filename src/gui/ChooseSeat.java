package gui;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Vector;


public class ChooseSeat {
	static int a[] = new int[70];
	JFrame frame = new JFrame("Choose seat");
	JPanel leftpanel = new JPanel();
	JPanel midpanel = new JPanel();
	JPanel rightpanel = new JPanel();
	JPanel uppanel = new JPanel();
	JPanel downpanel = new JPanel();
	JPanel mainpanel = new JPanel();
	JButton bt[] = new JButton[63];
	JButton confirm = new JButton();
	JButton cancel = new JButton();
	ImageIcon whiteicon = new ImageIcon("images\\seat.jpg");
	ImageIcon redicon = new ImageIcon("images\\chosenSeat.jpg");
	ImageIcon greenicon = new ImageIcon("images\\greenSeat.jpg");
	int number, cnt;                //�������Լ���ǰѡ�˼�����λ
	String u, v;
	//	Result result;
	Vector<Integer> seat = new Vector<Integer>();

	//	public ChooseSeat( Result result,int number )
	public ChooseSeat() {
//		this.result = result;
//		this.number = number;
		cnt = 0;
//		readStatus(result.id);
		readStatus();


		leftpanel.setLayout(new GridLayout(0, 3));
		rightpanel.setLayout(new GridLayout(0, 3));
		leftpanel.setPreferredSize(new Dimension(180, 150));
		rightpanel.setPreferredSize(new Dimension(180, 150));

		midpanel.setLayout(new GridLayout(0, 1));
		JLabel aisle = new JLabel("pass", JLabel.CENTER);        //�м䲿�ֵ�����

		uppanel.setLayout(new GridLayout(0, 8));        //������8��
		uppanel.setPreferredSize(new Dimension(0, 30));
		JLabel uplabel[] = new JLabel[8];        //���� ABC DEF
		for (int i = 0; i < 8; i++) {
			if (i == 3 || i == 4) {
				uplabel[i] = new JLabel("     ", JLabel.CENTER);
				uppanel.add(uplabel[i]);
				continue;
			}

			String s = String.valueOf((char) ('A' + i));
			uplabel[i] = new JLabel(s, JLabel.CENTER);
			uplabel[i].setForeground(Color.BLUE);
			uplabel[i].setFont(new Font("����", Font.BOLD, 20));
			uppanel.add(uplabel[i]);
		}


		confirm.setText("Confirm");
		cancel.setText("Exit");            // ������������ť ȷ��  �� ����
		confirm.setForeground(Color.black);
		cancel.setForeground(Color.black);
		confirm.setFont(new Font("����", Font.BOLD, 18));
		cancel.setFont(new Font("����", Font.BOLD, 18));

		downpanel.add(confirm);
		downpanel.add(cancel);


		aisle.setFont(new Font("����", Font.PLAIN, 18));
		aisle.setForeground(Color.red);
		aisle.setBackground(Color.WHITE);
		midpanel.add(aisle);


		addbutton();
		mainpanel.setLayout(new BorderLayout());
		mainpanel.add(leftpanel, BorderLayout.WEST);
		mainpanel.add(midpanel, BorderLayout.CENTER);
		mainpanel.add(rightpanel, BorderLayout.EAST);
		mainpanel.add(uppanel, BorderLayout.NORTH);
		mainpanel.add(downpanel, BorderLayout.SOUTH);

		frame.add(mainpanel);
		frame.setVisible(true);
		frame.setSize(500, 700);
		frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		frame.setLocationRelativeTo(null);
	}

	public static void readStatus() //��ȡ�ú������λ״̬
	{
		for (int i = 1; i <= 60; i++)
			a[i] = 0;


	}

	public static void main(String[] args) {
		new ChooseSeat();
	}

	public void addbutton() {
		for (int i = 1; i <= 30; i++) {
			if (a[i] == 0)
				bt[i] = new JButton(whiteicon);        //����λ����white
			else bt[i] = new JButton(redicon);        //��ռλ����red

			bt[i].addActionListener(getlistener());
			leftpanel.add(bt[i]);
		}
		for (int i = 31; i <= 60; i++) {
			if (a[i] == 0)
				bt[i] = new JButton(whiteicon);
			else bt[i] = new JButton(redicon);

			bt[i].addActionListener(getlistener());
			rightpanel.add(bt[i]);
		}

		confirm.addActionListener(new ActionListener()    //���ȷ�� ���¼�
		{

			@Override
			public void actionPerformed(ActionEvent arg0)        //������Ϣ��д����
			{
				for (int i = 1; i <= 60; i++) {
					if (bt[i].getIcon() == whiteicon)
						a[i] = 0;
					else a[i] = 1;
				}
				if (cnt != number)
					new Tip("Something wrong!");
				else {
					return;
				}
			}
		});
		cancel.addActionListener(new ActionListener()        //������ذ�ť
		{
			@Override
			public void actionPerformed(ActionEvent arg0) {
				frame.dispose();
			}
		});
	}

	public ActionListener getlistener()            //��λ��ť�� ���֮��ı���ɫ
	{
		return new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				for (int i = 1; i <= 60; i++)
					if (e.getSource() == bt[i]) {
						//System.out.println(i);

						if (bt[i].getIcon() == whiteicon)    //֮ǰ�ǰ׵�
						{
							bt[i].setIcon(greenicon);
							seat.add(i);
							cnt++;
						} else if (bt[i].getIcon() == greenicon)    //֮ǰ���̵ģ�ȡ����ѡ��
						{
							bt[i].setIcon(whiteicon);
							seat.remove(i);
							cnt--;
						}
						break;
					}
			}
		};
	}
}
