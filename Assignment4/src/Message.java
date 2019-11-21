import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
/**
 * This class create message Pop up with customize text content.
 * 
 * @author Chen Sirui Eric
 * @version 1.0
 * 
 */
public class Message {
	String[] message = new String[6];
	int counter = 0;
	int longest = 0;
	JButton button;
	JDialog dialog;
	JFrame frame;
	UserActionListener actioner;
	/**
	 * Constructor init the Message with first message and frame to hold it
	 * 
	 * @param msg first message
	 * @param frame frame to hold the dialog message
	 */
	public Message(String msg,JFrame frame)
	{
		this.message[0] = msg;
		longest = msg.length();
		this.frame = frame;
		this.counter = 1;
		button = new JButton("OK");
		button.addActionListener(new ButtonClick());
	}
	
	/**
	 * Add more messages at most 3 msgs
	 * @param msg new message to be add
	 */
	public void AddMessage(String msg)
	{
		if(counter<6)
		{
			this.message[counter] = msg;
			if(msg.length()>longest)
			{
				longest = msg.length();
			}
			this.counter++;
		}
		else
			System.out.println("Out of Range");
	}
	/**
	 * Display the Message dialog.
	 */
	public void display()
	{
		int shifter;
		if(longest>20)
			shifter = (longest-10)*5;
		else
			shifter = 0;
		dialog = new JDialog(this.frame,"Message");
		
	
		button.setBounds(100+shifter, 40+20*counter, 100, 30);
		
		Icon icon = new Icon();
		icon.setBounds(20, 50, 30, 30);
		JPanel panel = new JPanel();
		panel.setLayout(new BoxLayout(panel,3));
		JLabel label;
		for(int i=0;i<counter;i++)
		{
			label = new JLabel(this.message[i],JLabel.CENTER);
			panel.add(label);
			System.out.println(this.message[i]);
			
		}
		panel.setBounds(90, 20, 120+shifter, 20*counter);
		dialog.setSize(300+ shifter,110+20*counter);
		dialog.add(panel);
		dialog.add(button);
		dialog.add(icon);
		dialog.setVisible(true);
	
	}
	
	private class Icon extends JPanel
	{
		public void paintComponent(Graphics g)
		{
			Image image = new ImageIcon("exclamation.png").getImage(); // Read image from file
			Boolean b = g.drawImage(image,20,40,40,40,this); // Add the picture to the frame
			System.out.println(b);
		}
	}
	
	private class TestIcon extends JPanel
	{
		public void paintComponent(Graphics g)
		{
			g.setColor(Color.ORANGE);
			g.fillOval(20,50,20,20);
			System.out.println("hello");
		}
	}
	
	
	private class ButtonClick extends UserActionListener
	{

		@Override
		public void actionPerformed(ActionEvent e) {
			// TODO Auto-generated method stub
			dialog.setVisible(false);
		}
		
	}
	
	public void attachListener(UserActionListener l)
	{
		this.actioner = l;
		button.addActionListener(l);
	}
	
	public static void main(String[] args)
	{
		JFrame testframe = new JFrame("Test");
		Message msg = new Message("This is a test!",testframe);
		msg.AddMessage("New Test");
		msg.AddMessage("Helloworld");
		msg.AddMessage("New Message is coming.");
		msg.AddMessage("This is a test message.");
		testframe.setSize(300,300);
		testframe.setVisible(true);
		msg.display();
	}
	
}
