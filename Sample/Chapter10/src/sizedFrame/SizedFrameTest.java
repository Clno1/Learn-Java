package sizedFrame;

import java.awt.*;
import javax.swing.*;

public class SizedFrameTest {
	public static void main(String[] args) {
		EventQueue.invokeLater(()->{
			//先new一个自己实现的窗口类
			JFrame frame=new SizedFrame();
			//设置标题，关闭方式，然后设置为可见
			frame.setTitle("SizedFrame");
			frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
			frame.setVisible(true);
		});
	}
}

//自己的框架：继承自JFrame
class SizedFrame extends JFrame
{
	public SizedFrame() {
		//通过这个Toolkit类获取屏幕大小
		Toolkit kit=Toolkit.getDefaultToolkit();
		Dimension screenSize=kit.getScreenSize();
		int screenHeight=screenSize.height;
		int screenWidth=screenSize.width;
		
		//设置这个框架类的窗口大小
		setSize(screenWidth/2,screenHeight/2);
		//设置系统自动控制框架位置（在上一窗口偏移一点）
		setLocationByPlatform(true);
		
		//设置框架的icon
		Image img=new ImageIcon("icon.gif").getImage();
		setIconImage(img);
	}
}