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
		
		//结束程序
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
			//匿名函数类:只创建这个类的一个对象
			public void actionPerformed(ActionEvent event) {
				System.out.println("SeTest：At the tone,the time is "+new Date());
				if (beep) Toolkit.getDefaultToolkit().beep();
			}
		};
		
		Timer t=new Timer(interval,listener);	//用内部类对象构成一个Timer对象
		t.start();	//启动Timer的start方法
	}

}