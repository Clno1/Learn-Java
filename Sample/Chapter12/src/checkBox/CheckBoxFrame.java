package checkBox;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class CheckBoxFrame extends JFrame {
	private JLabel label;
	private JCheckBox bold;
	private JCheckBox italic;
	private static final int FONTSIZE=24;
	
	public CheckBoxFrame() {
		//��ʾ���֣�����Ĭ��ֵ�� �Ӵ�
		label=new JLabel("The quick brown fox jumps over the lazy dog.");
		label.setFont(new Font("Serif",Font.BOLD,FONTSIZE));
		add(label,BorderLayout.CENTER);
		
		
		//������������ֻҪ����˾�������и�ѡ���Ч��
		ActionListener listener=event->{
			int mode=0;
			if (bold.isSelected()) mode+=Font.BOLD;
			if (italic.isSelected()) mode+=Font.ITALIC;
			label.setFont(new Font("Serif",mode,FONTSIZE));
		};
		
		
		//����������������������ѡ��
		JPanel buttonPanel=new JPanel();
		
		bold=new JCheckBox("Blod");
		bold.addActionListener(listener);
		bold.setSelected(true);	//Ĭ��ѡ��
		buttonPanel.add(bold);
		
		italic=new JCheckBox("Italic");
		italic.addActionListener(listener);
		buttonPanel.add(italic);
		
		add(buttonPanel,BorderLayout.SOUTH);
		pack();
	}
}
