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
		
		//�����е�Ƥ��ȡ����
		UIManager.LookAndFeelInfo[] infos=UIManager.getInstalledLookAndFeels();
		for (UIManager.LookAndFeelInfo info:infos)
			makeButton(info.getName(),info.getClassName());
		
		add(buttonPanel);
		pack();
	}
	
	
	//�����취�����������й����ģ�����<-->����������
	public void makeButton(String name,String className) {
		
		//1������һ����ťname����ӵ�����
		JButton button=new JButton(name);
		buttonPanel.add(button);
		
		
		//�������ť���className�ļ�����
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
