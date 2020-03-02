package sizedFrame;

import java.awt.*;
import javax.swing.*;

public class SizedFrameTest {
	public static void main(String[] args) {
		EventQueue.invokeLater(()->{
			//��newһ���Լ�ʵ�ֵĴ�����
			JFrame frame=new SizedFrame();
			//���ñ��⣬�رշ�ʽ��Ȼ������Ϊ�ɼ�
			frame.setTitle("SizedFrame");
			frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
			frame.setVisible(true);
		});
	}
}

//�Լ��Ŀ�ܣ��̳���JFrame
class SizedFrame extends JFrame
{
	public SizedFrame() {
		//ͨ�����Toolkit���ȡ��Ļ��С
		Toolkit kit=Toolkit.getDefaultToolkit();
		Dimension screenSize=kit.getScreenSize();
		int screenHeight=screenSize.height;
		int screenWidth=screenSize.width;
		
		//������������Ĵ��ڴ�С
		setSize(screenWidth/2,screenHeight/2);
		//����ϵͳ�Զ����ƿ��λ�ã�����һ����ƫ��һ�㣩
		setLocationByPlatform(true);
		
		//���ÿ�ܵ�icon
		Image img=new ImageIcon("icon.gif").getImage();
		setIconImage(img);
	}
}