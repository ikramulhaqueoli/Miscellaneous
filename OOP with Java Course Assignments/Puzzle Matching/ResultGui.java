import java.lang.*;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
public class ResultGui extends JFrame implements MouseListener
{
	private JLabel bg, scoreBoard, score, congrats, happy, tScore, currentLevel;
	private JPanel panel;
	private ImageIcon bgImage;
	private JButton playAgain, nextLevel, exit;
	private GameGui resSource;
	public ResultGui(GameGui gg)
	{
		super("Whoo! Whoo! You have done it!");
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setSize(1280,720);
		this.setResizable(false);

		panel = new JPanel();
		panel.setLayout(null);

		resSource = gg;

		congrats = new JLabel("Whoo! Whoo! You Have Matched Our Puzzles!");
		congrats.setBounds(275, 30, 800, 50);
		congrats.setFont(Start.angryFontSmall);
		congrats.setForeground(new Color(128,0,0));
		panel.add(congrats);

		happy = new JLabel(new ImageIcon("res/happy.png"));
		happy.setBounds(390, 55, 400, 400);
		panel.add(happy);

		score = new JLabel(""+resSource.getCurrentScore());
		score.setBounds(575, 500, 100, 70);
		score.setForeground(Color.WHITE);
		score.setFont(Start.angryFontSmall);
		panel.add(score);

		scoreBoard = new JLabel(new ImageIcon("res/winnerscore.png"));
		scoreBoard.setBounds(510, 430, 200, 146);
		panel.add(scoreBoard);

		tScore = new JLabel("");
		tScore.setBounds(470, 590, 500, 70);
		GameGui.totalScore += resSource.getCurrentScore();
		tScore.setText("Your Total Score " + GameGui.totalScore);
		tScore.setForeground(new Color(128,0,0));
		tScore.setFont(Start.angryFontSmaller);
		panel.add(tScore);

		currentLevel = new JLabel("Level " + gg.getLevel());
		currentLevel.setForeground(new Color(0,51,0));
		currentLevel.setFont(Start.angryFont);
		currentLevel.setBounds(980, 150, 250, 70);
		panel.add(currentLevel);

		playAgain = new JButton(new ImageIcon("res/playagain.png"));
		playAgain.setBounds(930, 250, 273, 75);
		playAgain.setBorderPainted(false);
		playAgain.setContentAreaFilled(false);
		playAgain.setOpaque(false);
		panel.add(playAgain);
		playAgain.addMouseListener(this);

		nextLevel = new JButton(new ImageIcon("res/nextlevel.png"));
		nextLevel.setBounds(930, 340, 273, 75);
		nextLevel.setBorderPainted(false);
		nextLevel.setContentAreaFilled(false);
		nextLevel.setOpaque(false);
		panel.add(nextLevel);
		nextLevel.addMouseListener(this);

		exit = new JButton(new ImageIcon("res/exit.png"));
		exit.setBounds(930, 430, 273, 75);
		exit.setBorderPainted(false);
		exit.setContentAreaFilled(false);
		exit.setOpaque(false);
		panel.add(exit);
		exit.addMouseListener(this);

		bgImage = new ImageIcon("res/background.jpg");
		bg = new JLabel(bgImage);
		bg.setBounds(0, 0, 1280, 720);
		panel.add(bg);

		this.add(panel);
	}
	public void mouseEntered(MouseEvent me)
	{
		if(me.getSource() == playAgain)
		{
			playAgain.setIcon(new ImageIcon("res/playagainmouseentered.png"));
		}
		else if(me.getSource() == nextLevel)
		{
			nextLevel.setIcon(new ImageIcon("res/nextlevelmouseentered.png"));
		}
		else if(me.getSource() == exit)
		{
			exit.setIcon(new ImageIcon("res/exitmouseentered.png"));
		}
	}
	public void mouseExited(MouseEvent me)
	{
		if(me.getSource() == playAgain)
		{
			playAgain.setIcon(new ImageIcon("res/playagain.png"));
		}
		else if(me.getSource() == nextLevel)
		{
			nextLevel.setIcon(new ImageIcon("res/nextlevel.png"));
		}
		else if(me.getSource() == exit)
		{
			exit.setIcon(new ImageIcon("res/exit.png"));
		}
	}
	public void mouseClicked(MouseEvent me)
	{
		if(me.getSource() == playAgain)
		{
			GameGui newgg = new GameGui(resSource.getLevel());
			newgg.setVisible(true);
			this.setVisible(false);
		}
		else if(me.getSource() == nextLevel)
		{
			GameGui newgg = new GameGui(resSource.getLevel()+1);
			newgg.setVisible(true);
			this.setVisible(false);
		}
		else if(me.getSource() == exit)
		{
			System.exit(0);
		}
	}
	public void mousePressed(MouseEvent me) {}
	public void mouseReleased(MouseEvent me) {}
}