package button;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class ButtonFrame extends JFrame {
	private JPanel buttonPanel;
	private static final int DEAULT_WIDTH=300;
	private static final int DEAULT_HEIGHT=200;
	
	public ButtonFrame() {
		setSize(DEAULT_WIDTH,DEAULT_HEIGHT);	//设置框架大小
		
		//1，创建3个按钮并起名
		JButton yellowButton=new JButton("Yellow");
		JButton blueButton=new JButton("Blue");
		JButton redButton=new JButton("Red");
		
		//2，创建容器并把3个按钮绘制到容器中
		buttonPanel=new JPanel();
		buttonPanel.add(yellowButton);
		buttonPanel.add(blueButton);
		buttonPanel.add(redButton);
		add(buttonPanel);
		
		//3，创建3个监听器
		ColorAction yellowAction=new ColorAction(Color.YELLOW);
		ColorAction blueAction=new ColorAction(Color.BLUE);
		ColorAction redAction=new ColorAction(Color.RED);
		
		
		//4，把3个按钮添加各自的监听器
		yellowButton.addActionListener(yellowAction);
		blueButton.addActionListener(blueAction);
		redButton.addActionListener(redAction);
	}
	
	private class ColorAction implements ActionListener {
		private Color backgroundColor;
		
		public ColorAction(Color c) {
			this.backgroundColor=c;
		}
		
		//这个很重要，继承自ActionListener必须实现
		//处理监听后要做的事情
		public void actionPerformed(ActionEvent event) {
			buttonPanel.setBackground(backgroundColor);
		}
	}
}
	