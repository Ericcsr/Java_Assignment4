import java.awt.Image;
import java.awt.*;
import javax.swing.*;

import javax.swing.ImageIcon;

public class Picture_open {
	public static void main(String[] args)
	{
		
		JFrame frame = new JFrame("Test frame");
		Message icon = new Message("Hello",frame);
		frame.setSize(600,600);
		frame.setVisible(true);
		icon.display();
	}
}
