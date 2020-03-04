package action;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class ActionFrame extends JFrame {
	
	private JPanel buttonPanel;
	private static final int DEAULT_WIDTH=600;
	private static final int DEAULT_HEIGHT=400;
		
	public ActionFrame() {
		//1���̳���JFrame�����ô�С����������
		setSize(DEAULT_WIDTH,DEAULT_HEIGHT);
		buttonPanel=new JPanel();
		
		//2������3��Action������
		Action yellowAction=new ColorAction("Yellow",new ImageIcon("yellow-ball.gif"),Color.YELLOW);
		Action blueAction=new ColorAction("Blue",new ImageIcon("blue-ball.gif"),Color.BLUE);
		Action redAction=new ColorAction("Red",new ImageIcon("red-ball.gif"),Color.RED);
		
		
		//3������3����ť���Ѱ�ť�����������
		//��֪ʶ��JButton��һ����Action������Ϊ�����Ĺ��������ܼ�ʵ�ְ�һ��������һ����ť��������
		buttonPanel.add(new JButton(yellowAction));
		buttonPanel.add(new JButton(blueAction));
		buttonPanel.add(new JButton(redAction));
		//Ȼ��λ���㴰�����
		add(buttonPanel);	//������buttonPanel��ӵ�JFrame����
		
		//---------------------------------------------------------------------------���ϰ�ť������ɣ�����ӳ�䰴��
		
		//5���õ����������WHEN_ANCESTOR_OF_FOCUSED_COMPONENT����ӳ��
		InputMap imap=buttonPanel.getInputMap(JComponent.WHEN_ANCESTOR_OF_FOCUSED_COMPONENT);
		//Ϊ��������KeyStrike���󣬲������ַ�����   �ѣ��������ַ�������ӵ�ӳ����
		imap.put(KeyStroke.getKeyStroke("ctrl Y"), "panel.yellow");
		imap.put(KeyStroke.getKeyStroke("ctrl B"), "panel.blue");
		imap.put(KeyStroke.getKeyStroke("ctrl R"), "panel.red");
		
		//6���õ���������Ķ���ӳ�䣬�ѣ��ַ���������������ӵ�ӳ����
		ActionMap amap=buttonPanel.getActionMap();
		amap.put("panel.yellow", yellowAction);
		amap.put("panel.blue", blueAction);
		amap.put("panel.red", redAction);
	}
	
	public class ColorAction extends AbstractAction {
		
		public ColorAction(String name,Icon icon,Color c) {
			//putValue()/getValue()����洢/��������������� key/value ��
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
