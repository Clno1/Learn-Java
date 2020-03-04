package mouse;

import java.awt.*;
import java.awt.event.*;
import java.awt.geom.*;
import java.util.*;
import javax.swing.*;

public class MouseComponent extends JComponent{
	private static final int DEAULT_WIDTH=300;
	private static final int DEAULT_HEIGHT=200;
	
	private static final int SIDELENGTH=10;
	private ArrayList<Rectangle2D> squares;		//方块列表
	private Rectangle2D current;	//当前方块（鼠标按下的时候就更新）
	
	public MouseComponent() {
		squares=new ArrayList<>();
		current=null;
	
		addMouseListener(new MouseHandler());
		addMouseMotionListener(new MouseMotionHandler());
	}
	
	public Dimension getPreferredSize() { return new Dimension(DEAULT_WIDTH,DEAULT_HEIGHT); }	//用于首选大小
	
	//paintComponent会自动执行
	public void paintComponent(Graphics g) {
		Graphics2D g2=(Graphics2D) g;
		for (Rectangle2D r:squares)
			g2.draw(r);
	}
	
	//检索p点是否有一个小方块，有则返回该方块否则返回null
	public Rectangle2D find(Point2D p) {
		for (Rectangle2D r:squares)
			if (r.contains(p)) return r;
		return null;
	}
	
	//以p点为中心创造一个小方块，并调用repaint函数重新绘制
	public void add(Point2D p) {
		double x=p.getX();
		double y=p.getY();
		
		current=new Rectangle2D.Double(x-SIDELENGTH/2,y-SIDELENGTH/2,SIDELENGTH,SIDELENGTH);
		squares.add(current);
		repaint();
	}
	
	//接受一个方块参数s，然后把方块s去除
	public void remove(Rectangle2D s) {
		if (s==null) return;
		if (s==current) current=null;
		squares.remove(s);
		repaint();
	}
	
	
	//------------------------------------------------------------------------以下是两个类：点击类和移动类，有助于提高效率
	//MouseAdapter：没有监听鼠标移动和拖动
	//点击类：处理单击新建一个方块，双击取消一个方块功能
	private class MouseHandler extends MouseAdapter{
		//鼠标按下：如果该点没有小方块就创造一个
		public void mousePressed(MouseEvent event) {
			current=find(event.getPoint());
			if (current==null) add(event.getPoint());
		}
		//鼠标双击：如果该点已经有一个小方块就remove
		public void mouseClicked(MouseEvent event) {
			current=find(event.getPoint());
			if (current!=null && event.getClickCount()>=2) remove(current);
		}
	}
	
	//MouseMotionListener：监听鼠标移动和拖动事件
	//移动类：处理悬浮时候变化光标，鼠标拖动一个小方块
	private class MouseMotionHandler implements MouseMotionListener{
		//鼠标移动：如果鼠标悬浮在某个小方块上，光标改变
		public void mouseMoved(MouseEvent event) {
			if (find(event.getPoint())==null) setCursor(Cursor.getDefaultCursor());
			//if (current==null) setCursor(Cursor.getDefaultCursor());
			else setCursor(Cursor.getPredefinedCursor(Cursor.CROSSHAIR_CURSOR));
		}
		//鼠标拖动：拖动当前小方块
		public void mouseDragged(MouseEvent event) {
			if (current!=null) {
				int x=event.getX();
				int y=event.getY();
				
				current.setFrame(x-SIDELENGTH/2,y-SIDELENGTH/2,SIDELENGTH,SIDELENGTH);
				repaint();
			}
		}
	}
}
