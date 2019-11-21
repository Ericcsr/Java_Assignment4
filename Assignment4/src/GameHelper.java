import java.util.ArrayList;
import java.awt.*;
import javax.swing.*;

public class GameHelper {
	public static boolean Judge(Card c1,Card c2,Card c3,Card d1, Card d2, Card d3)
	{
		ArrayList<Card> player  =  new ArrayList<Card>();
		ArrayList<Card> dealer  =  new ArrayList<Card>();
		
		player.add(c1);player.add(c2);player.add(c3);
		dealer.add(d1);dealer.add(d2);dealer.add(d3);
		
		int c_spc = player.get(0).isSpecial()+player.get(1).isSpecial()+player.get(2).isSpecial();
		int d_spc = dealer.get(0).isSpecial()+dealer.get(1).isSpecial()+dealer.get(2).isSpecial();
		if(c_spc>d_spc)
		{
			return true;
		}
		else if(d_spc>c_spc)
		{
			return false;
		}
		else
		{
			int player_v = 0;
			int dealer_v = 0;
			for(int i=0;i<3;i++)
			{
				if(player.get(i).isSpecial()==0)
					player_v+=player.get(i).getValue();
				if(dealer.get(i).isSpecial()==0)
					dealer_v+=dealer.get(i).getValue();
			}
			player_v %= 10;
			dealer_v %= 10;
			if(player_v>dealer_v)
				return true;
		}
		return false;
	}
	
	public static boolean Judge(ArrayList<Card> player, ArrayList<Card> dealer)
	{
		int c_spc = player.get(0).isSpecial()+player.get(1).isSpecial()+player.get(2).isSpecial();
		int d_spc = dealer.get(0).isSpecial()+dealer.get(1).isSpecial()+dealer.get(2).isSpecial();
		if(c_spc>d_spc)
		{
			System.out.println("Your card:"+player.get(0).getValue()+" "+player.get(1).getValue()+" "+player.get(2).getValue());
			System.out.println("Dealer card:"+dealer.get(0).getValue()+" "+dealer.get(1).getValue()+" "+dealer.get(2).getValue());
			return true;
		}
		else if(d_spc>c_spc)
		{
			return false;
		}
		else
		{
			int player_v = 0;
			int dealer_v = 0;
			for(int i=0;i<3;i++)
			{
				if(player.get(i).isSpecial()==0)
					player_v+=player.get(i).getValue();
				if(dealer.get(i).isSpecial()==0)
					dealer_v+=dealer.get(i).getValue();
			}
			player_v %= 10;
			dealer_v %= 10;
			if(player_v>dealer_v)
				return true;
		}
		return false;
	}
	
	static JLabel Card2label(Card c)
	{
		ImageIcon img = c.getFront();
		JLabel label = new JLabel();
		label.setIcon(img);
		return label;
		
	}
	
	
}
