import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.ArrayList;
// TODO: Modofied the layout of the each panel.
// TODO: cast Icon to Image;
public class Mainframe {
	static JFrame frame;
	// Whenever the operation is on value or judgement level this will be related
	private Card[] mycard 	  = new Card[3];
	private Card[] dealercard = new Card[3];
	private int first_flag = 0;
	private int start_flag = 0;
	
	private CardList cardlist;
	private JLabel prompt;
	// TODO: Add 6 Global label such that it can be used to contain picture
	// Whenever the operation is related to GUI features this will be related.
	JPanel test_panel = new JPanel();
	
	private JPanel mypanel = new JPanel();
	private JPanel dealerpanel = new JPanel();
	private JPanel mainpanel = new JPanel();
	private JPanel buttonContainer;
	private JPanel input;
	private JPanel operation;
	private JMenuBar menubar;
	
	ArrayList<JLabel> mylabels = new ArrayList<JLabel>();
	ArrayList<JLabel> dealerlabels = new ArrayList<JLabel>();
	private int[] buttonflag = {0,0,0};
	
	private JTextField betfield;
	private int moneybank = 100;
	private int betvalue;
	public static void main(String[] args)
	{
		Mainframe mainframe = new Mainframe();
		mainframe.go();
		//mainframe.test();
	}
	public void test()
	{
		JFrame test_frame = new JFrame();
		cardlist = new CardList("card_back.gif","doc");
		ImageIcon img = Card.getBack();
		
		
		
		JLabel test = new JLabel();
		JButton testbutton = new JButton();
		testbutton.addActionListener(new testListener());
		test.setIcon(mycard[1].getFront());
		test_panel.add(test);
		test_panel.add(testbutton);
		test_frame.add(test_panel);
		test_frame.setSize(500,500);
		test_frame.setVisible(true);
		
	}
	
	class testListener implements ActionListener
	{
		public void actionPerformed(ActionEvent e)
		{
			test_panel.repaint();
		}
	}
	public void go()
	{
		cardlist  = new CardList("card_back.gif","doc"); // Implement cards that it can read from file
		frame = new JFrame("A Simple Card Game");
		frame.setBackground(Color.GREEN);
		frame.getContentPane().setBackground(Color.GREEN);
		
		// Add main panel
		//JPanel mainpanel = new JPanel();
		mainpanel.setLayout(new GridLayout(5,1)); // Vertically 5 horizontally one
		mainpanel.setBackground(Color.GREEN);
		
		//cardpanel.setLayout(new BoxLayout(cardpanel,1));
		//cardpanel.setBackground(Color.GREEN);
		//mypanel.setLayout(new FlowLayout());
		//mypanel.setBackground(Color.GREEN);
		//dealerpanel.setLayout(new FlowLayout());
		//dealerpanel.setBackground(Color.GREEN);
		//cardpanel.setLayout(new BoxLayout(cardpanel,1));
		//cardpanel.add(dealerpanel);
		//cardpanel.add(mypanel);
		mainpanel.add(dealerpanel);
		mainpanel.add(mypanel);
		
		for(int i=0;i<3;i++)
		{
			this.mycard[i] = cardlist.getCard();
			this.dealercard[i] = cardlist.getCard();
		}
		
		menubar = new JMenuBar();
		JMenu ctrl_menu  = new JMenu("Control");
		JMenuItem menuItem = new JMenuItem("Exit");
		menuItem.addActionListener(new ExitListener());
		ctrl_menu.add(menuItem);
		menuItem = new JMenuItem("Restart");
		menuItem.addActionListener(new RestartListener());
		ctrl_menu.add(menuItem);
		menubar.add(ctrl_menu);
		JMenu help_menu = new JMenu("Help");
		menuItem = new JMenuItem("Rules");
		menuItem.addActionListener(new RulesListener());
		help_menu.add(menuItem);
		menubar.add(help_menu);
		buttonContainer = new JPanel();
		//buttonContainer.setLayout();
		buttonContainer.setBackground(Color.GREEN);
		JButton cardbutton = new JButton("Replace Card 1");
		cardbutton.setBackground(Color.GREEN);
		cardbutton.addActionListener(new Card1Listener());
		// TODO: Add action Listener
		buttonContainer.add(cardbutton);
		cardbutton = new JButton("Replace Card 2");
		cardbutton.setBackground(Color.GREEN);
		cardbutton.addActionListener(new Card2Listener());
		buttonContainer.add(cardbutton);
		// TODO: Add action Listener
		cardbutton = new JButton("Replace Card 3");
		cardbutton.setBackground(Color.GREEN);
		cardbutton.addActionListener(new Card3Listener());
		buttonContainer.add(cardbutton);
		//JPanel service = new JPanel();
		//service.setLayout(new BorderLayout());
		mainpanel.add(buttonContainer); // Add to main function
		//operation.setLayout();
		input = new JPanel();
		input.setPreferredSize(new Dimension(500,140));
		//input.setLayout(new BoxLayout(input,0));
		JLabel head = new JLabel("Bet:$");
		betfield = new JTextField(20);
		JButton start = new JButton("Start");
		start.addActionListener(new StartListener());
		JButton result= new JButton("Result");
		result.addActionListener(new ResultListener());
		// TODO: Add action listeners
		input.add(head);
		input.add(betfield);
		input.add(start);
		input.add(result);
		
		mainpanel.add(input);
		//service.add(operation,BorderLayout.CENTER);
		operation = new JPanel();
		prompt = new JLabel("Please place Your bet!The amount of money you have:$"+this.moneybank,JLabel.CENTER);
		prompt.setSize(500, 200);
		prompt.setPreferredSize(new Dimension(500,80));
		operation.add(prompt);
		mainpanel.add(operation);
		frame.setJMenuBar(menubar);
		displayBack();
		frame.add(mainpanel);
		
		frame.setSize(500,600);
		frame.setVisible(true);
		//int state = 0;
		
		
		
	}
	
	class ExitListener implements ActionListener
	{
		@Override
		public void actionPerformed(ActionEvent e) {
			// TODO Auto-generated method stub
			System.exit(0);
		}
	}
	
	class RulesListener implements ActionListener
	{
		public void actionPerformed(ActionEvent e)
		{
			Message msg = new Message("Rules to determine winner:",frame);
			msg.AddMessage("Rule1: The one with more special cards wins.");
			msg.AddMessage("Rule2: If both have same number of special ");
			msg.AddMessage("cards,add the face values of the other card(s)");
			msg.AddMessage("and take the remainder after dividing the sum ");
			msg.AddMessage("by 10.The one with a bigger remainder wins(ACE=1)");
			msg.display();
		}
	}
	
	class RestartListener implements ActionListener
	{
		public void actionPerformed(ActionEvent e)
		{
			
			for(int i=0;i<3;i++)
			{
				Card buf = mycard[i];
				mycard[i] = cardlist.getCard();
				cardlist.insertCard(buf);
				
			}
			for(int i=0;i<3;i++)
			{
				Card buf = dealercard[i];
				dealercard[i] = cardlist.getCard();
				cardlist.insertCard(buf);
			}
			Message msg = new Message("Game Has been restarted",frame);
			msg.display();
			moneybank = 100;
			prompt.setText("Please place Your bet!The amount of money you have:$"+moneybank);
			displayBack();
			//cardpanel.repaint();
			frame.repaint();
			buttonflag[0] = 0;
			buttonflag[1] = 0;
			buttonflag[2] = 0;
			first_flag = 0;
		}
		
	}
	
	class StartListener implements ActionListener
	{
		public void actionPerformed(ActionEvent e)
		{
			float value = 0;
			try
			{
				String s = betfield.getText();
				value = Integer.parseInt(s);
				if(value<=0 || value-(int)value!=0)
				{
					Message msg = new Message("WARNING: The bet you place must be a positive integer.",frame);
					msg.display();
					return;
				}
			}
			catch(Exception except)
			{
				Message msg = new Message("WARNING: The bet you place must be a positive integer.",frame);
				msg.display();
				return;
			}
			first_flag = 0;
			betvalue = (int)value;
			prompt.setText("Your current bet is :$"+betvalue+" Amount of money you have:$"+moneybank);
			displayFront(0);
			mypanel.repaint();
			first_flag++;
			start_flag = 1;
		}
		
	}
	
	class Card1Listener implements ActionListener
	{
		public void actionPerformed(ActionEvent e)
		{
			if(first_flag<=2 && buttonflag[0]==0 && start_flag ==1)
			{
				buttonflag[0]=1;
				Card buffer = cardlist.getCard();
				cardlist.insertCard(mycard[0]);
				mycard[0] = buffer;
				prompt.setText("Your current bet is :$"+betvalue+" Amount of money you have:$"+moneybank);
				displayFront(0);
				//cardpanel.repaint();
				//mypanel.repaint();
				mypanel.setVisible(true);
				first_flag++;
			}
			//TODO: Implement disable logic
		}
	}
	
	class Card2Listener implements ActionListener
	{
		public void actionPerformed(ActionEvent e)
		{
			if(first_flag<=2 && buttonflag[1]==0 && start_flag ==1)
			{
				buttonflag[1]=1;
				cardlist.insertCard(mycard[1]);
				mycard[1] = cardlist.getCard();
				prompt.setText("Your current bet is :$"+betvalue+" Amount of money you have:$"+moneybank);
				displayFront(0);
				//cardpanel.repaint();
				mypanel.repaint();
				mypanel.setVisible(true);
				first_flag++;
			}
		}
	}
	
	class Card3Listener implements ActionListener
	{
		public void actionPerformed(ActionEvent e)
		{
			if(first_flag <= 2 && buttonflag[2]==0 && start_flag ==1)
			{
				buttonflag[2]=1;
				cardlist.insertCard(mycard[2]);
				mycard[2] = cardlist.getCard();
				prompt.setText("Your current bet is :$"+betvalue+" Amount of money you have:$"+moneybank);
				displayFront(0);
				//cardpanel.repaint();
				//frame.repaint();
				mypanel.getIgnoreRepaint();
				mypanel.setVisible(true);
				first_flag++;
			}
		}
	}
	
	class ResultListener implements ActionListener
	{
		public void actionPerformed(ActionEvent e)
		{
			if(start_flag==1)
			{
			ArrayList<Card> myc = new ArrayList<Card>();
			ArrayList<Card> dlc = new ArrayList<Card>();
			for(int i=0;i<3;i++)
			{
				myc.add(mycard[i]);
				dlc.add(dealercard[i]);
			}
			boolean result  = GameHelper.Judge(myc, dlc);
			if(result == true)
			{
				Message msg = new Message("Congratulation You win this round!",frame);
				msg.attachListener(new refreshGame());
				msg.display();
				moneybank += betvalue;
				prompt.setText("Please place Your bet!The amount of money you have:$"+moneybank);
			}
			
			else
			{
				moneybank -= betvalue;
				if(moneybank<=0)
				{
					Message msg = new Message("Game Over!",frame);
					msg.AddMessage("You have lost all your money,");
					msg.AddMessage("Please start a new round!");
					msg.attachListener(new refreshGame());
					msg.display();
					prompt.setText("Please place Your bet!The amount of money you have:$"+moneybank);
				}
				else
				{
					Message msg = new Message("Sorry! The dealer win this round!",frame);
					prompt.setText("Please place Your bet!The amount of money you have:$"+moneybank);
					msg.attachListener(new refreshGame());
					msg.display();
				}
			}
			displayFront(1);
			
			//cardpanel.repaint();
			frame.repaint();
			buttonflag[0] = 0;
			buttonflag[1] = 0;
			buttonflag[2] = 0;
			start_flag=0;
		}
		}
	}
	
	private void displayBack()
	{
		JPanel buffer1 = new JPanel();
		JPanel buffer2 = new JPanel();
		buffer1.setBackground(Color.GREEN);
		buffer2.setBackground(Color.GREEN);
		ImageIcon img = Card.getBack();
		JLabel label ;
		// TODO: Resize the label.chongxing
		for(int i=0;i<3;i++)
		{
			label = new JLabel();
			label.setIcon(img);
			buffer1.add(label);
			label = new JLabel();
			label.setIcon(img);
			buffer2.add(label);
		}
		mypanel = buffer1;
		dealerpanel = buffer2;
		this.addAllcomponents();
		frame.setSize(500,600);
		
	}
	
	private void displayFront(int flag)
	{
		JPanel buffer1 = new JPanel();
		JPanel buffer2 = new JPanel();
		buffer1.setBackground(Color.GREEN);
		buffer2.setBackground(Color.GREEN);
		for(int i=0;i<3;i++)
		{
			buffer1.add(GameHelper.Card2label(mycard[i]));
			//System.out.println(mycard[i]);
			if(flag ==1)
				buffer2.add(GameHelper.Card2label(dealercard[i]));
		}
		mypanel = buffer1;
		if(flag == 1)
			dealerpanel = buffer2;
		mainpanel.repaint();
		this.addAllcomponents();
		frame.setSize(500,600);
	}
	class refreshGame extends UserActionListener
	{
		public void actionPerformed(ActionEvent e)
		{
			for(int i=0;i<3;i++)
			{
				Card buf = mycard[i];
				mycard[i] = cardlist.getCard();
				cardlist.insertCard(buf);
				
			}
			for(int i=0;i<3;i++)
			{
				Card buf = dealercard[i];
				dealercard[i] = cardlist.getCard();
				cardlist.insertCard(buf);
			}
			displayBack();
			frame.repaint();
		}
	}
	private void addAllcomponents()
	{
		//frame.removeAll();
		mainpanel.removeAll();
		mainpanel.add(dealerpanel);
		mainpanel.add(mypanel);
		mainpanel.add(buttonContainer);
		mainpanel.add(input);
		mainpanel.add(operation);
		mainpanel.repaint();
		frame.setJMenuBar(menubar);
		frame.add(mainpanel);
		frame.setSize(500,600);
		frame.setVisible(true);
	}
}
