package toolBar;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class ToolBarFrame extends JFrame {
	private static final int DEAULT_WIDTH=300;
	private static final int DEAULT_HEIGHT=200;
	private JPanel panel;
	
	public ToolBarFrame() {
		setSize(DEAULT_WIDTH,DEAULT_HEIGHT);
		
		panel=new JPanel();
		add(panel,BorderLayout.CENTER);
		
		//�ȴ���������������
		//ǰ�������������ø����취���������һ����������ֱ��new Abs�ഴ��
		Action blueAction=new ColorAction("Blue",new ImageIcon("./image/blue-ball.gif"),Color.BLUE);
		Action yellowAction=new ColorAction("Yellow",new ImageIcon("./image/yellow-ball.gif"),Color.YELLOW);
		Action redAction=new ColorAction("red",new ImageIcon("./image/red-ball.gif"),Color.RED);
		Action exitAction=new AbstractAction("Exit",new ImageIcon("./image/exit.gif")) {
			public void actionPerformed(ActionEvent Action) {
				System.exit(0);
			}
		};
		exitAction.putValue(Action.SHORT_DESCRIPTION, "Exit");
		
		
		//�����䣺�ȴ���һ��JToolBarȻ��add����
		JToolBar bar=new JToolBar();
		bar.add(blueAction);
		bar.add(yellowAction);
		bar.add(redAction);
		bar.addSeparator();
		bar.add(exitAction);
		add(bar,BorderLayout.NORTH);
		
		//�����˵�����newһ���˵�Ȼ��add
		JMenu menu=new JMenu("Color");
		menu.add(yellowAction);
		menu.add(blueAction);
		menu.add(redAction);
		menu.add(exitAction);
		
		JMenuBar menuBar=new JMenuBar();
		menuBar.add(menu);
		setJMenuBar(menuBar);
}
	
	class ColorAction extends AbstractAction{
		public ColorAction(String name,Icon icon,Color c) {
			putValue(Action.NAME,name);
			putValue(Action.SMALL_ICON,icon);
			putValue(Action.SHORT_DESCRIPTION,name+" backgroud");
			putValue("Color",c);
		}
		
		public void actionPerformed(ActionEvent Action) {
			Color c=(Color) getValue("Color");
			panel.setBackground(c);
		}
	}
}
