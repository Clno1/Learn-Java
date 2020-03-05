package text;

import java.awt.*;
import javax.swing.*;

public class ComponentFrame extends JFrame {
	public static final int TEXTAREA_ROWS=8;
	public static final int TEXTAREA_COLUMNS=20;
	
	public ComponentFrame()
	{
		//����һ���ı����������
		JTextField textField=new JTextField();
		JPasswordField passwordField=new JPasswordField();
		
		JPanel northPanel=new JPanel();
		northPanel.setLayout(new GridLayout(2,2));
		northPanel.add(new JLabel("User name",SwingConstants.LEFT));
		northPanel.add(textField);
		northPanel.add(new JLabel("Password",SwingConstants.LEFT));
		northPanel.add(passwordField);
		
		add(northPanel,BorderLayout.NORTH);
		
		
		//����һ���ı�������Ϊ��ָ����С
		JTextArea textArea=new JTextArea(TEXTAREA_ROWS,TEXTAREA_COLUMNS);
		JScrollPane scrollPane=new JScrollPane(textArea);
		
		add(scrollPane,BorderLayout.CENTER);
		
		
		//ͨ��textField.getText()��passwordField.getPassword()���������������
		//���������ݲ鵽�ı���textArea����Թ�����
		JPanel southPanel=new JPanel();
		
		JButton insertButton=new JButton("Insert");
		southPanel.add(insertButton);
		insertButton.addActionListener(event->
			textArea.append("User name:"+textField.getText()+"\n"+"Password:"+new  String(passwordField.getPassword())+"\n"));
		
		add(southPanel,BorderLayout.SOUTH);
		pack();
	}
}
