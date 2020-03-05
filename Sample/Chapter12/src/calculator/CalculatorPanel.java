package calculator;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

//容器CalculatorPanel
public class CalculatorPanel extends JPanel{
	private JButton display;
	private JPanel panel;
	private double result;
	private String lastCommand;
	private boolean start;
	
	public CalculatorPanel() {
		setLayout(new BorderLayout());	//为容器设置（边框）布局管理器
		
		result=0;
		lastCommand="=";
		start=true;
		
		//新建一个按钮并置于计算器上方
		display=new JButton("0");
		display.setEnabled(false);
		add(display,BorderLayout.NORTH);	//把display按钮添加于（边框）布局管理器北方
		
		ActionListener insert=new InsertAction();
		ActionListener command=new CommandAction();
		
		//再new一个容器来存放数字符号按钮小方格
		panel=new JPanel();
		panel.setLayout(new GridLayout(4,4));
		
		//以下是按顺序从上到下从左到右添加Button
		addButton("7",insert);
		addButton("8",insert);
		addButton("9",insert);
		addButton("/",command);
		
		addButton("4",insert);
		addButton("5",insert);
		addButton("6",insert);
		addButton("*",command);
		
		addButton("1",insert);
		addButton("2",insert);
		addButton("3",insert);
		addButton("-",command);
		
		addButton("0",insert);
		addButton(".",insert);
		addButton("=",command);
		addButton("+",command);
		
		add(panel,BorderLayout.CENTER);
	}
	
	//添加按钮方法：new一个Button-->为这个Button设置监听-->把这个Button放到容器
	private void addButton(String label,ActionListener listener) {
		JButton button=new JButton(label);
		button.addActionListener(listener);
		panel.add(button);
	}
	
	//监听插入数字函数：
	private class InsertAction implements ActionListener {
		public void actionPerformed(ActionEvent event) {
			String input=event.getActionCommand();
			if (start) {
				display.setText("");
				start=false;
			}
			display.setText(display.getText()+input);
		}
	}
	
	//监听运算符号函数：
	private class CommandAction implements ActionListener {
		public void actionPerformed(ActionEvent event) {
			String command=event.getActionCommand();
			if (start) {
				if (command.equals("-")) {
					display.setText(command);
					start=false;
				} else lastCommand=command;
			} else {
				calculate(Double.parseDouble(display.getText()));
				lastCommand=command;
				start=true;
			}
		}
	}
	
	public void calculate(double x) {
		if (lastCommand.equals("+")) result+=x;
		else if (lastCommand.equals("-")) result-=x;
		else if (lastCommand.equals("*")) result*=x;
		else if (lastCommand.equals("/")) result/=x;
		else if (lastCommand.equals("=")) result=x;
		display.setText(""+result);
	}
}
