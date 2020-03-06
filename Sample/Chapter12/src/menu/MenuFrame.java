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
		
		//创建File菜单
		JMenu fileMenu=new JMenu("File");
		
		fileMenu.add(new TestAction("New"));
		
		JMenuItem openItem=fileMenu.add(new TestAction("Open"));
		openItem.setAccelerator(KeyStroke.getKeyStroke("ctrl O"));		//设置加速键：即按下直接打开
		
		fileMenu.addSeparator();	//分割线
		
		saveAction=new TestAction("Save");
		JMenuItem saveItem=fileMenu.add(saveAction);
		saveItem.setAccelerator(KeyStroke.getKeyStroke("ctrl S"));
		
		saveAsAction=new TestAction("Save As");
		fileMenu.add(saveAsAction);
		
		fileMenu.addSeparator();
		
		fileMenu.add(new AbstractAction("Exit") {	//上面都是通过TestAction(继承自AbstractAction)类，这里直接new Abs类也可以
			public void actionPerformed(ActionEvent event) {
				System.exit(0);
			}
		});
		
		readonlyItem();
		
		
		//以下是创建菜单单选框
		ButtonGroup group=new ButtonGroup();
		
		JRadioButtonMenuItem insertItem=new JRadioButtonMenuItem("Insert");
		insertItem.setSelected(true);
		JRadioButtonMenuItem overtypeItem=new JRadioButtonMenuItem("Overtype");
		
		group.add(insertItem);
		group.add(overtypeItem);
		
		
		//创建Edit菜单
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
		
		
		//创建嵌套菜单
		JMenu optionMenu=new JMenu("Options");
		
		optionMenu.add(readonlyItem);
		optionMenu.addSeparator();
		optionMenu.add(insertItem);
		optionMenu.add(overtypeItem);
		
		editMenu.addSeparator();
		editMenu.add(optionMenu);	//只要上一级菜单add本级菜单即可嵌套
		
		
		//创建Help菜单
		JMenu helpMenu=new JMenu("Help");
		helpMenu.setMnemonic('H');		//设置快捷键，打开菜单之后按下即可打开
		
		JMenuItem indexItem=new JMenuItem("Index");
		indexItem.setMnemonic('I');
		helpMenu.add(indexItem);
		
		Action aboutAction=new TestAction("About");
		aboutAction.putValue(Action.MNEMONIC_KEY,new Integer('A'));
		helpMenu.add(aboutAction);
		
		
		//弹出菜单
		popup=new JPopupMenu();
		popup.add(cutAction);
		popup.add(copyAction);
		popup.add(pasteAction);
		
		//Finally把菜单放到菜单栏。以及创建容器,把工具
		JMenuBar menuBar=new JMenuBar();
		setJMenuBar(menuBar);
		menuBar.add(fileMenu);
		menuBar.add(editMenu);
		menuBar.add(helpMenu);
		
		JPanel panel=new JPanel();
		panel.setComponentPopupMenu(popup);		//右键弹出菜单
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
