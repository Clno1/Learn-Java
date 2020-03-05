package checkBox;

import java.awt.*;
import javax.swing.*;

public class CheckBoxTest {
	public static void main(String[] args) {
		EventQueue.invokeLater(()->{
			JFrame frame=new CheckBoxFrame();
			frame.setTitle("CheckBoxFrame");
			frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
			frame.setVisible(true);
		});
	}
}
