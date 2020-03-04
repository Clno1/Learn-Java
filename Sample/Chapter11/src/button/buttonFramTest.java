package button;

import java.awt.*;
import javax.swing.*;

public class buttonFramTest {
	public static void main(String[] args) {
		EventQueue.invokeLater(()->{
			JFrame frame=new ButtonFrame();
			frame.setTitle("ButtonFrame");
			frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
			frame.setVisible(true);
		});
	}
}
