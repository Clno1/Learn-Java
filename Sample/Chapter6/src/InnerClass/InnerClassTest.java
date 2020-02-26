package InnerClass;

import java.awt.*;
import java.awt.event.*;
import java.util.*;
import javax.swing.*;
import javax.swing.Timer;

public class InnerClassTest {
	public static void main(String args[]) {
		TalkingClock clock=new TalkingClock(1000,true);
		clock.test();
		
		//��������
		JOptionPane.showMessageDialog(null, "Quit progame?");
		System.exit(0);
	}
}

class TalkingClock
{
	private int interval;
	private boolean beep;
	
	public TalkingClock(int interval,boolean beep) {
		this.interval=interval;
		this.beep=beep;
	}
	
	public void test() {
		ActionListener listener=new TimePrinter();
		Timer t=new Timer(interval,listener);	//���ڲ�����󹹳�һ��Timer����
		t.start();	//����Timer��start����
	}
	
	//�ڲ���
	public class TimePrinter implements ActionListener
	{
		public void actionPerformed(ActionEvent event) {
			System.out.println("At the tone,the time is "+new Date());
			if (beep) Toolkit.getDefaultToolkit().beep();
		}
	}
}
