package mouse;

import java.awt.*;
import javax.swing.*;

public class MouseFrameTest {
	public static void main(String[] args) {
		EventQueue.invokeLater(()->{
			JFrame frame=new MouseFrame();
			frame.setTitle("MouseFrame");
			frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
			frame.setVisible(true);
		});
	}
}
