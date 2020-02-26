package InnerClass;

import java.awt.*;
import java.awt.event.*;
import java.util.*;
import javax.swing.*;
import javax.swing.Timer;

public class AnonymousInnerClass {
	public static void main(String args[]) {
		TalkingClock2 clock=new TalkingClock2(2000,true);
		clock.test();
		
		//��������
		JOptionPane.showMessageDialog(null, "Quit progame?");
		System.exit(0);
	}
}

class TalkingClock2
{
	private int interval;
	private boolean beep;
	
	public TalkingClock2(int interval,boolean beep) {
		this.interval=interval;
		this.beep=beep;
	}
	
	public void test() {
		ActionListener listener=new ActionListener() {
			//����������:ֻ����������һ������
			public void actionPerformed(ActionEvent event) {
				System.out.println("SeTest��At the tone,the time is "+new Date());
				if (beep) Toolkit.getDefaultToolkit().beep();
			}
		};
		
		Timer t=new Timer(interval,listener);	//���ڲ�����󹹳�һ��Timer����
		t.start();	//����Timer��start����
	}

}