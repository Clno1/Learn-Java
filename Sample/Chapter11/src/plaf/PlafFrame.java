package plaf;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.SwingUtilities;
import javax.swing.UIManager;

public class PlafFrame extends JFrame{
	private JPanel buttonPanel;
	
	public PlafFrame() {
		buttonPanel=new JPanel();
		
		//把所有的皮肤取出来
		UIManager.LookAndFeelInfo[] infos=UIManager.getInstalledLookAndFeels();
		for (UIManager.LookAndFeelInfo info:infos)
			makeButton(info.getName(),info.getClassName());
		
		add(buttonPanel);
		pack();
	}
	
	
	//辅助办法：批量创造有关联的（动作<-->监听器）对
	public void makeButton(String name,String className) {
		
		//1，创造一个按钮name并添加到画布
		JButton button=new JButton(name);
		buttonPanel.add(button);
		
		
		//把这个按钮添加className的监听器
		button.addActionListener(event->{
			try {
				UIManager.setLookAndFeel(className);
				SwingUtilities.updateComponentTreeUI(this);
				pack();
			} catch(Exception e) {
				e.printStackTrace();
			}
		});
	}
}
