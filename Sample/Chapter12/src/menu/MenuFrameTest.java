package menu;

import java.awt.*;
import javax.swing.*;

public class MenuFrameTest {
	public static void main(String[] args) {
		EventQueue.invokeLater(()->{
			JFrame frame=new MenuFrame();
			frame.setTitle("MenuFrame");
			frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
			frame.setVisible(true);
		});
	}
}
