package comboBox;

import java.awt.*;
import javax.swing.*;

public class ComboBox extends JFrame {
	private JComboBox<String> faceCombo;
	private JLabel label;
	private static final int DEAULT_SIZE=24;
	
	public ComboBox() {
		//�ȴ���һ���ַŵ�����
		label=new JLabel("The quick brown fox jumps over the lazy dog.");
		label.setFont(new Font("Serif",Font.PLAIN,DEAULT_SIZE));
		add(label,BorderLayout.NORTH);
		
		//newһ��ComboBox��Ͽ�Ȼ��addItem���ѡ��
		faceCombo=new JComboBox<>();
		faceCombo.addItem("Serif");
		faceCombo.addItem("SansSerif");
		faceCombo.addItem("Monospaced");
		faceCombo.addItem("Dialog");
		faceCombo.addItem("DialogInput");
		//Ϊ��Ͽ���Ӽ�����
		faceCombo.addActionListener(event->
			label.setFont(new Font(faceCombo.getItemAt(faceCombo.getSelectedIndex()),Font.PLAIN,DEAULT_SIZE)));
		
		
		//Ϊ��Ͽ���ӵ������в�ֹ�ڴ����Ϸ�
		JPanel comboPanel=new JPanel();
		comboPanel.add(faceCombo);
		add(comboPanel,BorderLayout.SOUTH);
		pack();
	}
}
