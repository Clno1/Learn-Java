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
		//创建容器，在容器创造格子
		sliderPanel=new JPanel();
		sliderPanel.setLayout(new GridBagLayout());
		
		//公共监听器
		listener=event->{
			JSlider source=(JSlider) event.getSource();
			textField.setText(""+source.getValue());
		};
		
		//最普通的，甚至无刻度
		JSlider slider=new JSlider();
		addSlider(slider,"Plain");
		
		//有刻度
		slider=new JSlider();
		slider.setPaintTicks(true);
		slider.setMajorTickSpacing(20);
		slider.setMinorTickSpacing(5);
		addSlider(slider,"Ticks");
		
		//有刻度，且光标会粘在刻度处
		slider=new JSlider();
		slider.setPaintTicks(true);
		slider.setSnapToTicks(true);	//令光标粘在刻度处
		slider.setMajorTickSpacing(20);
		slider.setMinorTickSpacing(5);
		addSlider(slider,"Snap to ticks");
		
		//没有长度条了
		slider=new JSlider();
		slider.setPaintTicks(true);
		slider.setMajorTickSpacing(20);
		slider.setMinorTickSpacing(5);
		slider.setPaintTrack(false); 	//取消条轨迹
		addSlider(slider,"No track");
		
		//有数字刻度
		slider=new JSlider();
		slider.setPaintTicks(true);
		slider.setPaintLabels(true);	//数字刻度
		slider.setMajorTickSpacing(20);
		slider.setMinorTickSpacing(5);
		addSlider(slider,"Numberic");
		
		//反转的滑动条，100->0
		slider=new JSlider();
		slider.setPaintTicks(true);
		slider.setMajorTickSpacing(20);
		slider.setMinorTickSpacing(5);
		slider.setInverted(true);	//染色区域反转
		slider.setPaintLabels(true);	//数字刻度
		addSlider(slider,"Inverted");
		
		//自定义刻度名称的滑动条
		slider=new JSlider();
		slider.setPaintTicks(true);
		slider.setPaintLabels(true); 	//设置刻度标记
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
		
		
		//滑动条刻度是小icon
		slider=new JSlider();
		slider.setPaintTicks(true);
		slider.setPaintLabels(true); 
		slider.setSnapToTicks(true);
		slider.setMajorTickSpacing(20);
		slider.setMinorTickSpacing(20);
		
		labelTable=new Hashtable<Integer,Component>();		//设置字母刻度标记
		labelTable.put(0, new JLabel(new ImageIcon("nice.gif")));
		labelTable.put(20, new JLabel(new ImageIcon("ten.gif")));
		labelTable.put(40, new JLabel(new ImageIcon("jack.gif")));
		labelTable.put(60, new JLabel(new ImageIcon("queue.gif")));
		labelTable.put(80, new JLabel(new ImageIcon("king.gif")));
		labelTable.put(100, new JLabel(new ImageIcon("ace.gif")));
		
		slider.setLabelTable(labelTable);
		addSlider(slider,"Icon labels");	
		
		
		
		//把sliderPanel滑动条容器置于北方，文本区置于南方
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
