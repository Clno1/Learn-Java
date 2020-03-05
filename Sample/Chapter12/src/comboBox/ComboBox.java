package comboBox;

import java.awt.*;
import javax.swing.*;

public class ComboBox extends JFrame {
	private JComboBox<String> faceCombo;
	private JLabel label;
	private static final int DEAULT_SIZE=24;
	
	public ComboBox() {
		//先创建一行字放到顶端
		label=new JLabel("The quick brown fox jumps over the lazy dog.");
		label.setFont(new Font("Serif",Font.PLAIN,DEAULT_SIZE));
		add(label,BorderLayout.NORTH);
		
		//new一个ComboBox组合框，然后addItem添加选项
		faceCombo=new JComboBox<>();
		faceCombo.addItem("Serif");
		faceCombo.addItem("SansSerif");
		faceCombo.addItem("Monospaced");
		faceCombo.addItem("Dialog");
		faceCombo.addItem("DialogInput");
		//为组合框添加监听器
		faceCombo.addActionListener(event->
			label.setFont(new Font(faceCombo.getItemAt(faceCombo.getSelectedIndex()),Font.PLAIN,DEAULT_SIZE)));
		
		
		//为组合框添加到容器中并止于窗口南方
		JPanel comboPanel=new JPanel();
		comboPanel.add(faceCombo);
		add(comboPanel,BorderLayout.SOUTH);
		pack();
	}
}
