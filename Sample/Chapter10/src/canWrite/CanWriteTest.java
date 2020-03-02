package canWrite;

import java.awt.*;
import javax.swing.*;

public class CanWriteTest {
	public static void main(String[] args) {
		EventQueue.invokeLater(()->{
			//��newһ���Լ�ʵ�ֵĴ�����
			JFrame frame=new CanWrite();
			//���ñ��⣬�رշ�ʽ��Ȼ������Ϊ�ɼ�
			frame.setTitle("SizedFrame");
			frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
			frame.setVisible(true);
		});
	}
}

//һ������
class CanWrite extends JFrame
{
	public CanWrite() {
		//�ڱ�����¼�һ�����������
		add(new CanWriteComponent());
		
		//�����һ����������Ϳ��Բ�setSized��ֱ��pack�õ������������ѡ��С
		pack();
	}
}

//һ���������ʾ��Ϣ
class CanWriteComponent extends JComponent
{
	public static final int MESSAGE_X=75;
	public static final int MESSAGE_Y=100;
	
	private static final int DEAULT_WIDTH=300;
	private static final int DEAULT_HEIGHT=200;
	
	//���ǣ������Լ������
	public void paintComponent(Graphics g) {
		g.drawString("This is my first Swing Progarm", MESSAGE_X, MESSAGE_Y);
	}
	
	//���ǣ����������ѡ��С
	public Dimension getPreferredSize() {
		return new Dimension(DEAULT_WIDTH,DEAULT_HEIGHT);
	}
}
