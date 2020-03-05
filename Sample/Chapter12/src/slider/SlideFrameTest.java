package slider;

import java.awt.*;
import javax.swing.*;


public class SlideFrameTest {
	public static void main(String[] args) {
		EventQueue.invokeLater(()->{
			JFrame frame=new SliderFrame();
			frame.setTitle("SliderFrame");
			frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
			frame.setVisible(true);
		});
	}
}
