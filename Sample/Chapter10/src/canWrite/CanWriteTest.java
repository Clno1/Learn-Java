package canWrite;

import java.awt.*;
import javax.swing.*;

public class CanWriteTest {
	public static void main(String[] args) {
		EventQueue.invokeLater(()->{
			//先new一个自己实现的窗口类
			JFrame frame=new CanWrite();
			//设置标题，关闭方式，然后设置为可见
			frame.setTitle("SizedFrame");
			frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
			frame.setVisible(true);
		});
	}
}

//一个窗口
class CanWrite extends JFrame
{
	public CanWrite() {
		//在本框架下加一个组件来绘制
		add(new CanWriteComponent());
		
		//框架有一个或多个组件就可以不setSized，直接pack得到的是组件的首选大小
		pack();
	}
}

//一个组件来显示信息
class CanWriteComponent extends JComponent
{
	public static final int MESSAGE_X=75;
	public static final int MESSAGE_Y=100;
	
	private static final int DEAULT_WIDTH=300;
	private static final int DEAULT_HEIGHT=200;
	
	//覆盖：绘制自己的组件
	public void paintComponent(Graphics g) {
		g.drawString("This is my first Swing Progarm", MESSAGE_X, MESSAGE_Y);
	}
	
	//覆盖：返回组件首选大小
	public Dimension getPreferredSize() {
		return new Dimension(DEAULT_WIDTH,DEAULT_HEIGHT);
	}
}
