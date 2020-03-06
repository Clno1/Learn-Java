package toolBar;

import java.awt.*;
import javax.swing.*;

public class ToolBarFrameTest {
	public static void main(String[] args) {
		EventQueue.invokeLater(()->{
			JFrame frame=new ToolBarFrame();
			frame.setTitle("ToolBarFrame");
			frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
			frame.setVisible(true);
		});
	}
}
