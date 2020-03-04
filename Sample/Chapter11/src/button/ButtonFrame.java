package button;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class ButtonFrame extends JFrame {
	private JPanel buttonPanel;
	private static final int DEAULT_WIDTH=300;
	private static final int DEAULT_HEIGHT=200;
	
	public ButtonFrame() {
		setSize(DEAULT_WIDTH,DEAULT_HEIGHT);	//���ÿ�ܴ�С
		
		//1������3����ť������
		JButton yellowButton=new JButton("Yellow");
		JButton blueButton=new JButton("Blue");
		JButton redButton=new JButton("Red");
		
		//2��������������3����ť���Ƶ�������
		buttonPanel=new JPanel();
		buttonPanel.add(yellowButton);
		buttonPanel.add(blueButton);
		buttonPanel.add(redButton);
		add(buttonPanel);
		
		//3������3��������
		ColorAction yellowAction=new ColorAction(Color.YELLOW);
		ColorAction blueAction=new ColorAction(Color.BLUE);
		ColorAction redAction=new ColorAction(Color.RED);
		
		
		//4����3����ť��Ӹ��Եļ�����
		yellowButton.addActionListener(yellowAction);
		blueButton.addActionListener(blueAction);
		redButton.addActionListener(redAction);
	}
	
	private class ColorAction implements ActionListener {
		private Color backgroundColor;
		
		public ColorAction(Color c) {
			this.backgroundColor=c;
		}
		
		//�������Ҫ���̳���ActionListener����ʵ��
		//���������Ҫ��������
		public void actionPerformed(ActionEvent event) {
			buttonPanel.setBackground(backgroundColor);
		}
	}
}
	