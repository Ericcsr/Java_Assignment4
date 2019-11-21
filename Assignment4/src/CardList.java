import java.util.ArrayList;
import java.io.File;
/**
 * This list can read and init cards GUI as well as distribute and replace card.
 * 
 * @author Chen Sirui Eric
 * @version 1.0
 */

public class CardList {
	ArrayList<Card> Cards = new ArrayList<Card>();
	String backName;
	/**
	 * Initialize card Array List with filepath and name of back card image
	 * 
	 * @param backName name of back image of each card
	 * @param Filepath path where all cards image are stored
	 */
	public CardList(String backName,String Filepath)
	{
		System.out.println("Hello");
		Card.setBack(backName);
		this.backName = backName;
		int file_len;
		Card buffer_card;
		File file = new File(Filepath);
		File[] filelist = file.listFiles();
		System.out.println(filelist.length);
		if(filelist == null)
		{
			System.out.println("No Files Not Found");
		}
		file_len = filelist.length;
		for(int i=0;i<file_len;i++)
		{
			String name = filelist[i].getName();
			if(!name.equals(this.backName))
			{
				try {
				int value = Integer.parseInt(name.substring(6, name.indexOf('.')));
				buffer_card = new Card(name,value);
				this.Cards.add(buffer_card);
				}
				catch(Exception e)
				{
					System.out.println("Damaged files");
					System.out.println(name+" "+this.backName);
				}
			}
		}
		
	}
	/**
	 * Get a Card randomly without replacement
	 * 
	 * @return Random card obtained
	 */
	public Card getCard()
	{
		int index = (int)(Math.random()*Cards.size());
		System.out.println("The random number is: "+index);
		Card toret = Cards.get(index);
		Cards.remove(index);
		return toret;
	}
	/**
	 * replace one card with another card
	 * 
	 * @param replace Card to be replaced
	 * @return buf_card new Card
	 */
	public Card replaceCard(Card replace)
	{
		Card buf_card = this.getCard();
		Cards.add(replace);
		return buf_card;
	}
	/**
	 * Insert card back
	 * 
	 * @param insert Card to be insert back;
	 */
	public void insertCard(Card insert)
	{
		Cards.add(insert);
	}
}
