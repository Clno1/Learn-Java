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
	private ArrayList<Rectangle2D> squares;		//�����б�
	private Rectangle2D current;	//��ǰ���飨��갴�µ�ʱ��͸��£�
	
	public MouseComponent() {
		squares=new ArrayList<>();
		current=null;
	
		addMouseListener(new MouseHandler());
		addMouseMotionListener(new MouseMotionHandler());
	}
	
	public Dimension getPreferredSize() { return new Dimension(DEAULT_WIDTH,DEAULT_HEIGHT); }	//������ѡ��С
	
	//paintComponent���Զ�ִ��
	public void paintComponent(Graphics g) {
		Graphics2D g2=(Graphics2D) g;
		for (Rectangle2D r:squares)
			g2.draw(r);
	}
	
	//����p���Ƿ���һ��С���飬���򷵻ظ÷�����򷵻�null
	public Rectangle2D find(Point2D p) {
		for (Rectangle2D r:squares)
			if (r.contains(p)) return r;
		return null;
	}
	
	//��p��Ϊ���Ĵ���һ��С���飬������repaint�������»���
	public void add(Point2D p) {
		double x=p.getX();
		double y=p.getY();
		
		current=new Rectangle2D.Double(x-SIDELENGTH/2,y-SIDELENGTH/2,SIDELENGTH,SIDELENGTH);
		squares.add(current);
		repaint();
	}
	
	//����һ���������s��Ȼ��ѷ���sȥ��
	public void remove(Rectangle2D s) {
		if (s==null) return;
		if (s==current) current=null;
		squares.remove(s);
		repaint();
	}
	
	
	//------------------------------------------------------------------------�����������ࣺ�������ƶ��࣬���������Ч��
	//MouseAdapter��û�м�������ƶ����϶�
	//����ࣺ�������½�һ�����飬˫��ȡ��һ�����鹦��
	private class MouseHandler extends MouseAdapter{
		//��갴�£�����õ�û��С����ʹ���һ��
		public void mousePressed(MouseEvent event) {
			current=find(event.getPoint());
			if (current==null) add(event.getPoint());
		}
		//���˫��������õ��Ѿ���һ��С�����remove
		public void mouseClicked(MouseEvent event) {
			current=find(event.getPoint());
			if (current!=null && event.getClickCount()>=2) remove(current);
		}
	}
	
	//MouseMotionListener����������ƶ����϶��¼�
	//�ƶ��ࣺ��������ʱ��仯��꣬����϶�һ��С����
	private class MouseMotionHandler implements MouseMotionListener{
		//����ƶ���������������ĳ��С�����ϣ����ı�
		public void mouseMoved(MouseEvent event) {
			if (find(event.getPoint())==null) setCursor(Cursor.getDefaultCursor());
			//if (current==null) setCursor(Cursor.getDefaultCursor());
			else setCursor(Cursor.getPredefinedCursor(Cursor.CROSSHAIR_CURSOR));
		}
		//����϶����϶���ǰС����
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
