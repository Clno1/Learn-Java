package menu;

import java.awt.event.*;
import javax.swing.*;

public class MenuFrame extends JFrame {
	private static final int DEAULT_WIDTH=300;
	private static final int DEAULT_HEIGHT=200;
	private Action saveAction;
	private Action saveAsAction;
	private JCheckBoxMenuItem readonlyItem;
	private JPopupMenu popup;
	
	public MenuFrame() {
		setSize(DEAULT_WIDTH,DEAULT_HEIGHT);
		
		//����File�˵�
		JMenu fileMenu=new JMenu("File");
		
		fileMenu.add(new TestAction("New"));
		
		JMenuItem openItem=fileMenu.add(new TestAction("Open"));
		openItem.setAccelerator(KeyStroke.getKeyStroke("ctrl O"));		//���ü��ټ���������ֱ�Ӵ�
		
		fileMenu.addSeparator();	//�ָ���
		
		saveAction=new TestAction("Save");
		JMenuItem saveItem=fileMenu.add(saveAction);
		saveItem.setAccelerator(KeyStroke.getKeyStroke("ctrl S"));
		
		saveAsAction=new TestAction("Save As");
		fileMenu.add(saveAsAction);
		
		fileMenu.addSeparator();
		
		fileMenu.add(new AbstractAction("Exit") {	//���涼��ͨ��TestAction(�̳���AbstractAction)�࣬����ֱ��new Abs��Ҳ����
			public void actionPerformed(ActionEvent event) {
				System.exit(0);
			}
		});
		
		readonlyItem();
		
		
		//�����Ǵ����˵���ѡ��
		ButtonGroup group=new ButtonGroup();
		
		JRadioButtonMenuItem insertItem=new JRadioButtonMenuItem("Insert");
		insertItem.setSelected(true);
		JRadioButtonMenuItem overtypeItem=new JRadioButtonMenuItem("Overtype");
		
		group.add(insertItem);
		group.add(overtypeItem);
		
		
		//����Edit�˵�
		Action cutAction=new TestAction("Cut");
		cutAction.putValue(Action.SMALL_ICON, new ImageIcon("cut.gif"));
		Action copyAction=new TestAction("Copy");
		copyAction.putValue(Action.SMALL_ICON, new ImageIcon("copy.gif"));
		Action pasteAction=new TestAction("Paste");
		pasteAction.putValue(Action.SMALL_ICON, new ImageIcon("paste.gif"));
		
		JMenu editMenu=new JMenu("Edit");
		editMenu.add(cutAction);
		editMenu.add(copyAction);
		editMenu.add(pasteAction);
		
		
		//����Ƕ�ײ˵�
		JMenu optionMenu=new JMenu("Options");
		
		optionMenu.add(readonlyItem);
		optionMenu.addSeparator();
		optionMenu.add(insertItem);
		optionMenu.add(overtypeItem);
		
		editMenu.addSeparator();
		editMenu.add(optionMenu);	//ֻҪ��һ���˵�add�����˵�����Ƕ��
		
		
		//����Help�˵�
		JMenu helpMenu=new JMenu("Help");
		helpMenu.setMnemonic('H');		//���ÿ�ݼ����򿪲˵�֮���¼��ɴ�
		
		JMenuItem indexItem=new JMenuItem("Index");
		indexItem.setMnemonic('I');
		helpMenu.add(indexItem);
		
		Action aboutAction=new TestAction("About");
		aboutAction.putValue(Action.MNEMONIC_KEY,new Integer('A'));
		helpMenu.add(aboutAction);
		
		
		//�����˵�
		popup=new JPopupMenu();
		popup.add(cutAction);
		popup.add(copyAction);
		popup.add(pasteAction);
		
		//Finally�Ѳ˵��ŵ��˵������Լ���������,�ѹ���
		JMenuBar menuBar=new JMenuBar();
		setJMenuBar(menuBar);
		menuBar.add(fileMenu);
		menuBar.add(editMenu);
		menuBar.add(helpMenu);
		
		JPanel panel=new JPanel();
		panel.setComponentPopupMenu(popup);		//�Ҽ������˵�
		add(panel);
	}
	
	private void readonlyItem() {
		//
		readonlyItem=new JCheckBoxMenuItem("Read-only");
		readonlyItem.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent ecent) {
				boolean saveOk=!readonlyItem.isSelected();
				saveAction.setEnabled(saveOk);
				saveAsAction.setEnabled(saveOk);
			}
		});
	}
	
	class TestAction extends AbstractAction {
		public TestAction(String name) {
			super(name);
		}
		public void actionPerformed(ActionEvent event) {
			System.out.println(getValue(Action.NAME)+" is selected.");
		}
	}
}
