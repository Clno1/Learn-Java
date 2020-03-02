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
		//Rectangle2D画一个矩形
		double leftX=100;
		double topY=100;
		double width=200;
		double height=150;
		Rectangle2D rect=new Rectangle2D.Double(leftX,topY,width,height);	//左上角点以及长宽
		g2.draw(rect);
		
		//Ellipse2D画一个椭圆，利用setFrame画矩形内接椭圆
		Ellipse2D ellipse=new Ellipse2D.Double();
		ellipse.setFrame(rect);	//内接于矩形
		g2.draw(ellipse);
		
		//Line2D画一条线段
		g2.draw(new Line2D.Double(leftX,topY,leftX+width,topY+height));	//两点
		
		//画一个圆形（圆心半径）
		double centerX=rect.getCenterX();
		double centerY=rect.getCenterY();
		double radius=150;
		
		Ellipse2D circle=new Ellipse2D.Double();
		circle.setFrameFromCenter(centerX, centerY, centerX+radius, centerY+radius);	//圆心，四个顶点的其中一个
		g2.draw(circle);
	}
	
	public Dimension getPreferredSize() { return new Dimension(DEAULT_WIDTH,DEAULT_HEIGHT); }
}
