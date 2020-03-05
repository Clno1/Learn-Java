package comboBox;

import java.awt.*;
import javax.swing.*;


public class ComboBoxTest {
	public static void main(String[] args) {
		EventQueue.invokeLater(()->{
			JFrame frame=new ComboBox();
			frame.setTitle("ComboBox");
			frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
			frame.setVisible(true);
		});
	}
}
