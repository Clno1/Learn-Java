package calculator;

import java.awt.*;
import javax.swing.*;

public class CalculatorTest {
	public static void main(String[] args) {
		EventQueue.invokeLater(()->{
			JPanel calc=new CalculatorPanel();
			
			JFrame frame=new JFrame();
			frame.setTitle("It's a calculator");
			frame.setSize(300, 200);
			frame.add(calc);
			frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
			frame.setVisible(true);
		});
	}
}
