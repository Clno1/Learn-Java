package checkBox;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class CheckBoxFrame extends JFrame {
	private JLabel label;
	private JCheckBox bold;
	private JCheckBox italic;
	private static final int FONTSIZE=24;
	
	public CheckBoxFrame() {
		//显示文字，并设默认值是 加粗
		label=new JLabel("The quick brown fox jumps over the lazy dog.");
		label.setFont(new Font("Serif",Font.BOLD,FONTSIZE));
		add(label,BorderLayout.CENTER);
		
		
		//创建监听器：只要点击了就添加所有复选框的效果
		ActionListener listener=event->{
			int mode=0;
			if (bold.isSelected()) mode+=Font.BOLD;
			if (italic.isSelected()) mode+=Font.ITALIC;
			label.setFont(new Font("Serif",mode,FONTSIZE));
		};
		
		
		//创建新容器并创建两个复选框
		JPanel buttonPanel=new JPanel();
		
		bold=new JCheckBox("Blod");
		bold.addActionListener(listener);
		bold.setSelected(true);	//默认选择
		buttonPanel.add(bold);
		
		italic=new JCheckBox("Italic");
		italic.addActionListener(listener);
		buttonPanel.add(italic);
		
		add(buttonPanel,BorderLayout.SOUTH);
		pack();
	}
}
