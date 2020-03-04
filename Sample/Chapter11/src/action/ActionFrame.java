package action;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class ActionFrame extends JFrame {
	
	private JPanel buttonPanel;
	private static final int DEAULT_WIDTH=600;
	private static final int DEAULT_HEIGHT=400;
		
	public ActionFrame() {
		//1，继承自JFrame，设置大小，创建容器
		setSize(DEAULT_WIDTH,DEAULT_HEIGHT);
		buttonPanel=new JPanel();
		
		//2，创建3个Action监听器
		Action yellowAction=new ColorAction("Yellow",new ImageIcon("yellow-ball.gif"),Color.YELLOW);
		Action blueAction=new ColorAction("Blue",new ImageIcon("blue-ball.gif"),Color.BLUE);
		Action redAction=new ColorAction("Red",new ImageIcon("red-ball.gif"),Color.RED);
		
		
		//3，创建3个按钮并把按钮与监听器关联
		//新知识：JButton有一个用Action对象作为参数的构造器，能简单实现把一个动作与一个按钮关联起来
		buttonPanel.add(new JButton(yellowAction));
		buttonPanel.add(new JButton(blueAction));
		buttonPanel.add(new JButton(redAction));
		//然后定位顶层窗口组件
		add(buttonPanel);	//把容器buttonPanel添加到JFrame窗口
		
		//---------------------------------------------------------------------------以上按钮部分完成，以下映射按键
		
		//5，得到顶层组件的WHEN_ANCESTOR_OF_FOCUSED_COMPONENT输入映射
		InputMap imap=buttonPanel.getInputMap(JComponent.WHEN_ANCESTOR_OF_FOCUSED_COMPONENT);
		//为按键创建KeyStrike对象，并创建字符串；   把（按键，字符串）添加到映射中
		imap.put(KeyStroke.getKeyStroke("ctrl Y"), "panel.yellow");
		imap.put(KeyStroke.getKeyStroke("ctrl B"), "panel.blue");
		imap.put(KeyStroke.getKeyStroke("ctrl R"), "panel.red");
		
		//6，得到顶层组件的动作映射，把（字符串，监听器）添加到映射中
		ActionMap amap=buttonPanel.getActionMap();
		amap.put("panel.yellow", yellowAction);
		amap.put("panel.blue", blueAction);
		amap.put("panel.red", redAction);
	}
	
	public class ColorAction extends AbstractAction {
		
		public ColorAction(String name,Icon icon,Color c) {
			//putValue()/getValue()允许存储/检索对象中任意的 key/value 对
			putValue(Action.NAME,name);
			putValue(Action.SMALL_ICON,icon);
			putValue(Action.SHORT_DESCRIPTION,"Set panel color to"+name.toLowerCase());
			putValue("color",c);
		}
		
		public void actionPerformed(ActionEvent event) {
			Color c=(Color) getValue("color");
			buttonPanel.setBackground(c);
		}
	}
}
