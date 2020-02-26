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
		
		//结束程序
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
		Timer t=new Timer(interval,listener);	//用内部类对象构成一个Timer对象
		t.start();	//启动Timer的start方法
	}
	
	//内部类
	public class TimePrinter implements ActionListener
	{
		public void actionPerformed(ActionEvent event) {
			System.out.println("At the tone,the time is "+new Date());
			if (beep) Toolkit.getDefaultToolkit().beep();
		}
	}
}
