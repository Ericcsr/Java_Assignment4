import java.awt.*;
import javax.swing.*;
/**
 * This class implement cards that have certain value as well as certain GUI components
 * 
 * @author Chen Sirui Eric
 * @version 1.0
 */

public class Card {
	private int value;
	private ImageIcon front;
	static public ImageIcon back;
	private int spc_flag = 0; // If it is special card 
	
	/**
	 * Public static function to set back picture, once set every card can use
	 * 
	 * @param fname name of picture file
	 */
	public static void setBack(String fname)
	{
		back = new ImageIcon("doc/"+fname);
		System.out.println(back);
	}
	/**
	 * Init card with name and respect value
	 * 
	 * @param fname name picture of front of card
	 * @param value value of card
	 */
	public Card(String fname,int value)
	{
		this.front = new ImageIcon("doc/"+fname);
		this.value = value;
		if(value>10)
		{
			this.spc_flag = 1;
		}
	}
	/**
	 * This return the front of card for displaying
	 * 
	 * @return front front side of the card
	 */
	public ImageIcon getFront()
	{
		return this.front;
	}
	/**
	 * This return the back of the card for displaying
	 * 
	 * @return back the back of the card
	 */
	
	public static ImageIcon getBack()
	{
		return back;
	}
	/**
	 * Check if this card belongs to special card
	 * 
	 * @return spc_flag True for special value.
	 */
	public int isSpecial()
	{
		return this.spc_flag;
	}
	/**
	 * Get value of the card
	 * 
	 * @return value The value of the card
	 */
	public int getValue()
	{
		return this.value;
	}
	
}
