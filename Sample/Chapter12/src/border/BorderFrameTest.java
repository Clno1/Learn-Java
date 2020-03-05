package border;

import java.awt.*;
import javax.swing.*;


public class BorderFrameTest {
	public static void main(String[] args) {
		EventQueue.invokeLater(()->{
			JFrame frame=new BorderFrame();
			frame.setTitle("BorderFrame");
			frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
			frame.setVisible(true);
		});
	}
}
