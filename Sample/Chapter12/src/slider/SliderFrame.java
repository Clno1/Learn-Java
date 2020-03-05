package slider;

import java.awt.*;
import java.util.*;
import javax.swing.*;
import javax.swing.event.*;

public class SliderFrame extends JFrame {
	private JPanel sliderPanel;
	private JTextField textField;
	private ChangeListener listener;
	
	public SliderFrame() {
		//�����������������������
		sliderPanel=new JPanel();
		sliderPanel.setLayout(new GridBagLayout());
		
		//����������
		listener=event->{
			JSlider source=(JSlider) event.getSource();
			textField.setText(""+source.getValue());
		};
		
		//����ͨ�ģ������޿̶�
		JSlider slider=new JSlider();
		addSlider(slider,"Plain");
		
		//�п̶�
		slider=new JSlider();
		slider.setPaintTicks(true);
		slider.setMajorTickSpacing(20);
		slider.setMinorTickSpacing(5);
		addSlider(slider,"Ticks");
		
		//�п̶ȣ��ҹ���ճ�ڿ̶ȴ�
		slider=new JSlider();
		slider.setPaintTicks(true);
		slider.setSnapToTicks(true);	//����ճ�ڿ̶ȴ�
		slider.setMajorTickSpacing(20);
		slider.setMinorTickSpacing(5);
		addSlider(slider,"Snap to ticks");
		
		//û�г�������
		slider=new JSlider();
		slider.setPaintTicks(true);
		slider.setMajorTickSpacing(20);
		slider.setMinorTickSpacing(5);
		slider.setPaintTrack(false); 	//ȡ�����켣
		addSlider(slider,"No track");
		
		//�����̶ֿ�
		slider=new JSlider();
		slider.setPaintTicks(true);
		slider.setPaintLabels(true);	//���̶ֿ�
		slider.setMajorTickSpacing(20);
		slider.setMinorTickSpacing(5);
		addSlider(slider,"Numberic");
		
		//��ת�Ļ�������100->0
		slider=new JSlider();
		slider.setPaintTicks(true);
		slider.setMajorTickSpacing(20);
		slider.setMinorTickSpacing(5);
		slider.setInverted(true);	//Ⱦɫ����ת
		slider.setPaintLabels(true);	//���̶ֿ�
		addSlider(slider,"Inverted");
		
		//�Զ���̶����ƵĻ�����
		slider=new JSlider();
		slider.setPaintTicks(true);
		slider.setPaintLabels(true); 	//���ÿ̶ȱ��
		slider.setMajorTickSpacing(20);
		slider.setMinorTickSpacing(5);
		
		Dictionary<Integer,Component> labelTable=new Hashtable<>();
		labelTable.put(0, new JLabel("A"));
		labelTable.put(20, new JLabel("B"));
		labelTable.put(40, new JLabel("C"));
		labelTable.put(60, new JLabel("D"));
		labelTable.put(80, new JLabel("E"));
		labelTable.put(100, new JLabel("F"));
		
		slider.setLabelTable(labelTable);
		addSlider(slider,"Custom labels");
		
		
		//�������̶���Сicon
		slider=new JSlider();
		slider.setPaintTicks(true);
		slider.setPaintLabels(true); 
		slider.setSnapToTicks(true);
		slider.setMajorTickSpacing(20);
		slider.setMinorTickSpacing(20);
		
		labelTable=new Hashtable<Integer,Component>();		//������ĸ�̶ȱ��
		labelTable.put(0, new JLabel(new ImageIcon("nice.gif")));
		labelTable.put(20, new JLabel(new ImageIcon("ten.gif")));
		labelTable.put(40, new JLabel(new ImageIcon("jack.gif")));
		labelTable.put(60, new JLabel(new ImageIcon("queue.gif")));
		labelTable.put(80, new JLabel(new ImageIcon("king.gif")));
		labelTable.put(100, new JLabel(new ImageIcon("ace.gif")));
		
		slider.setLabelTable(labelTable);
		addSlider(slider,"Icon labels");	
		
		
		
		//��sliderPanel�������������ڱ������ı��������Ϸ�
		textField=new JTextField();
		add(sliderPanel,BorderLayout.NORTH);
		add(textField,BorderLayout.SOUTH);
		pack();
	}
	
	public void addSlider(JSlider s,String description) {
		s.addChangeListener(listener);
		JPanel panel=new JPanel();
		panel.add(s);
		panel.add(new JLabel(description));
		panel.setAlignmentX(Component.LEFT_ALIGNMENT);
		GridBagConstraints gbc=new GridBagConstraints();
		gbc.gridy=sliderPanel.getComponentCount();
		gbc.anchor=GridBagConstraints.WEST;
		sliderPanel.add(panel,gbc);
	}
}
