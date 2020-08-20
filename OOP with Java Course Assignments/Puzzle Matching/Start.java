import java.lang.*;
import java.awt.*;
import java.io.File;
public class Start
{
	static public Font angryFontBig, angryFont, angryFontSmall, angryFontSmaller, angryFontSmallest;
	public static void main(String []args)
	{
		GameStart gs = new GameStart();
		gs.setVisible(true);

		try
		{
		    Thread.sleep(3000);
		    File fontFile = new File("res/angrybirds-regular.ttf");
			Font importedFont;
			try
			{
				importedFont = Font.createFont(Font.TRUETYPE_FONT, fontFile);
				angryFontBig = importedFont.deriveFont(70f);
				angryFont = importedFont.deriveFont(55f);
				angryFontSmall = importedFont.deriveFont(40f);
				angryFontSmaller = importedFont.deriveFont(30f);
				angryFontSmallest = importedFont.deriveFont(20f);
			}
			catch(Exception exception)
			{
				angryFontBig = new Font("Arial", Font.BOLD, 70);
				angryFont = new Font("Arial", Font.BOLD, 55);
				angryFontSmall = new Font("Arial", Font.BOLD, 40);
				angryFontSmaller = new Font("Arial", Font.BOLD, 30);
				angryFontSmallest = new Font("Arial", Font.BOLD, 20);
			}
		}
		catch(InterruptedException ex)
		{
		    Thread.currentThread().interrupt();
		}

		gs.setVisible(false);
		GameGui gg = new GameGui(1000);
		gg.setVisible(true);
	}
}