package action;

import java.awt.*;
import javax.swing.JFrame;

public class ActionFrameTest {
	public static void main(String[] args) {
		EventQueue.invokeLater(()->{
			JFrame frame=new ActionFrame();
			frame.setTitle("ActionFrame");
			frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
			frame.setVisible(true);
		});
	}
}
