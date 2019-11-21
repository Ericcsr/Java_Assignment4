import javax.swing.*;
import java.awt.*;


public class readIcon extends Panel{
	public void paintComponent(Graphics g)
	{
		Image image = Toolkit.getDefaultToolkit().getImage("exclamation.png");
		boolean val = g.drawImage(image,3,4,this); // Add the picture to the frame
		System.out.println(val);
		System.out.println("Alive");
	}
}
