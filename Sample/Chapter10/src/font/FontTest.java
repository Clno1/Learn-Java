package font;

import java.awt.*;
import java.awt.font.*;
import java.awt.geom.*;
import javax.swing.*;

public class FontTest {
	public static void main(String[] args) {
		EventQueue.invokeLater(()->{
			JFrame frame=new FontFrame();
			frame.setTitle("FontTest");
			frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
			frame.setVisible(true);
		});
	}
}

class FontFrame extends JFrame
{
	public FontFrame()
	{
		add(new FontComponent());
		pack();
	}
}

class FontComponent extends JComponent
{
	private static final int DEAULT_WIDTH=300;
	private static final int DEAULT_HEIGHT=200;
	
	public void paintComponent(Graphics g) {
		Graphics2D g2=(Graphics2D) g;
		
		String message="Hello World!";
		
		Font f=new Font("Serif",Font.BOLD,36);
		g2.setFont(f);
		
		//先绘制出这段字符串
		//getStringBounds会返回包围字符串的矩形（x轴是最左端，y轴是下基线）
		FontRenderContext context=g2.getFontRenderContext();
		Rectangle2D bounds=f.getStringBounds(message, context);
		
		double x=(getWidth()-bounds.getWidth())/2;
		double y=(getHeight()-bounds.getHeight())/2;
		
		double ascent=-bounds.getY();	//上坡度
		double baseY=y+ascent;	//下基线减去上坡度得到字体最上端
		
		g2.drawString(message, (int)x, (int)baseY );
		
		//设置以下绘制颜色
		g2.setPaint(Color.BLUE);
		
		//画出基准线
		g2.draw(new Line2D.Double(x,baseY,x+bounds.getWidth(),baseY));
		
		//画出包围矩形
		Rectangle2D rect=new Rectangle2D.Double(x,y,bounds.getWidth(),bounds.getHeight());
		
		g2.draw(rect);
	}
	
	public Dimension getPreferredSize() { return new Dimension(DEAULT_WIDTH,DEAULT_HEIGHT); }
}