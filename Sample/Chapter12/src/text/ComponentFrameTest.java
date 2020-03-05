package text;

import java.awt.*;
import javax.swing.JFrame;


public class ComponentFrameTest {
	public static void main(String[] args) {
		EventQueue.invokeLater(()->{
			JFrame frame=new ComponentFrame();
			frame.setTitle("ComponentFrame");
			frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
			frame.setVisible(true);
		});
	}
}
