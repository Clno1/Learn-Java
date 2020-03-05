package radioButton;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class RadioButtonFrame extends JFrame {
	private JPanel buttonPanel;
	private ButtonGroup group;
	private JLabel label;
	private  static final int DEAULT_SIZE=36;
	
	public RadioButtonFrame() {
		//先创建一行字并设定默认大小为36
		label=new JLabel("The quick brown fox jumps over the lazy dogs");
		label.setFont(new Font("Serif",Font.PLAIN,DEAULT_SIZE));
		add(label,BorderLayout.CENTER);
		
		//创造容器然后一个个创造按钮
		buttonPanel=new JPanel();
		group=new ButtonGroup();
		
		addRadioButton("Small",8);
		addRadioButton("Medium",12);
		addRadioButton("Large",18);
		addRadioButton("Extra large",36);
		
		add(buttonPanel,BorderLayout.SOUTH);
		pack();
	}
	
	
	//辅助方法：批量创造单选框按钮
	public void addRadioButton(String name,int size) {
		boolean selected=false;
		if (name=="Extra large") selected=true;
		JRadioButton button=new JRadioButton(name,selected);
		group.add(button);
		buttonPanel.add(button);
		
		ActionListener listener=event->label.setFont(new Font("Serif",Font.PLAIN,size));
		
		button.addActionListener(listener);
	}
}
