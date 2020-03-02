package draw;

import java.awt.*;
import java.awt.geom.*;
import javax.swing.*;

public class DrawTest {
	public static void main(String[] args) {
		EventQueue.invokeLater(()->{
			JFrame frame=new DrawFrame();
			frame.setTitle("DrawTest");
			frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
			frame.setVisible(true);
		});
	}
}

class DrawFrame extends JFrame
{
	public DrawFrame() {
		add(new DrawComponent());
		pack();
	}
}

class DrawComponent extends JComponent
{
	private static final int DEAULT_WIDTH=400;
	private static final int DEAULT_HEIGHT=400;
	
	public void paintComponent(Graphics g) {
		Graphics2D g2=(Graphics2D) g;
		//Rectangle2D��һ������
		double leftX=100;
		double topY=100;
		double width=200;
		double height=150;
		Rectangle2D rect=new Rectangle2D.Double(leftX,topY,width,height);	//���Ͻǵ��Լ�����
		g2.draw(rect);
		
		//Ellipse2D��һ����Բ������setFrame�������ڽ���Բ
		Ellipse2D ellipse=new Ellipse2D.Double();
		ellipse.setFrame(rect);	//�ڽ��ھ���
		g2.draw(ellipse);
		
		//Line2D��һ���߶�
		g2.draw(new Line2D.Double(leftX,topY,leftX+width,topY+height));	//����
		
		//��һ��Բ�Σ�Բ�İ뾶��
		double centerX=rect.getCenterX();
		double centerY=rect.getCenterY();
		double radius=150;
		
		Ellipse2D circle=new Ellipse2D.Double();
		circle.setFrameFromCenter(centerX, centerY, centerX+radius, centerY+radius);	//Բ�ģ��ĸ����������һ��
		g2.draw(circle);
	}
	
	public Dimension getPreferredSize() { return new Dimension(DEAULT_WIDTH,DEAULT_HEIGHT); }
}
