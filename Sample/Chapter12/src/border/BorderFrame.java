package border;

import java.awt.*;
import javax.swing.*;
import javax.swing.border.*;

public class BorderFrame extends JFrame{
	private JPanel demoPanel;
	private JPanel buttonPanel;
	private ButtonGroup group;
	
	
	public BorderFrame() {
		demoPanel=new JPanel();
		buttonPanel=new JPanel();
		group=new ButtonGroup();
		
		addRadioButton("Lowered bevel",BorderFactory.createLoweredBevelBorder());
		addRadioButton("Raise bevel",BorderFactory.createRaisedBevelBorder());
		
		
		Border etched=BorderFactory.createEtchedBorder();
		Border titled=BorderFactory.createTitledBorder(etched,"Border types");
		
		setLayout(new GridLayout(2,1));
		add(buttonPanel);
		add(demoPanel);
		pack();
	}
	
	//辅助方法：都是把按钮加到buttonPanel里，然后修改demoPanel的边框样式
	public void addRadioButton(String buttonName,Border b) {
		JRadioButton button=new JRadioButton(buttonName);
		button.addActionListener(event->demoPanel.setBorder(b));
		group.add(button);
		buttonPanel.add(button);
	}
}
