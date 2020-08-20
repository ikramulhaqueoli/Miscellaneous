import java.lang.*;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.*;
import java.io.File;

public class GameGui extends JFrame implements ActionListener
{
	private JLabel bg, scoreBoard, score, levelLabel;
	private JButton puzzles[];
	private JPanel panel;
	private ImageIcon bgImage, redBird, blueBird;
	private int numberOfTiles, tileNo[], currentScore, remainingTiles, difficulty, level;
	private Vector<Integer> clicked;
	private boolean vanished[];
	public static int totalScore;
	public GameGui(int level)
	{
		super("Match Now! | Match Our Puzzles");
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setSize(1270, 720);
		this.setResizable(false);

		this.level = level;
		difficulty = this.level*2;
		numberOfTiles = difficulty*2;
		clicked = new Vector<Integer>();
		vanished = new boolean[numberOfTiles];
		currentScore = numberOfTiles * 100;
		remainingTiles = numberOfTiles;

		panel = new JPanel();
		panel.setLayout(null);

		levelLabel = new JLabel("Level " + level);
		levelLabel.setBounds(545, 30, 150, 50);
		levelLabel.setFont(Start.angryFontSmall);
		panel.add(levelLabel);

		blueBird = new ImageIcon("res/bluebird.png");
		redBird = new ImageIcon("res/redBird.gif");

		score = new JLabel(""+currentScore);
		score.setBounds(585, 565, 100, 70);
		score.setForeground(Color.WHITE);
		score.setFont(Start.angryFontSmall);
		panel.add(score);

		scoreBoard = new JLabel(new ImageIcon("res/score.png"));
		scoreBoard.setBounds(530, 550, 180, 90);
		panel.add(scoreBoard);

		puzzles = new JButton[numberOfTiles];
		tileNo = new int[numberOfTiles];
		Random random = new Random();
		for(int i = 0; i < (numberOfTiles); i+=2)
		{
			tileNo[i] = tileNo[i+1] = 10*(i+1);

			int r1 = random.nextInt(1180), r2 = random.nextInt(580), r3 = random.nextInt(1180), r4 = random.nextInt(580);
			while(r1 >= 430 && r1 <= 710 && r2 >= 450 && r2 <= 640)
			{
				r1 = random.nextInt(1180); r2 = random.nextInt(580);
			}
			puzzles[i] = new JButton(blueBird);
			puzzles[i].setOpaque(false);
			puzzles[i].setContentAreaFilled(false);
			puzzles[i].setBorderPainted(false);
    		puzzles[i].setForeground(Color.BLACK);
    		puzzles[i].setFont(Start.angryFontSmaller);
			puzzles[i].setHorizontalTextPosition(SwingConstants.CENTER);
			puzzles[i].setBounds(r1, r2, 100, 100);
			panel.add(puzzles[i]);
			puzzles[i].addActionListener(this);

			while(r3 >= 430 && r3 <= 710 && r4 >= 450 && r4 <= 640)
			{
				r3 = random.nextInt(1180); r4 = random.nextInt(580);
			}
			puzzles[i+1] = new JButton(redBird);
			puzzles[i+1].setOpaque(false);
			puzzles[i+1].setContentAreaFilled(false);
			puzzles[i+1].setBorderPainted(false);
    		puzzles[i+1].setForeground(Color.BLACK);
    		puzzles[i+1].setFont(Start.angryFontSmaller);
			puzzles[i+1].setBounds(r3, r4, 120, 110);
			panel.add(puzzles[i+1]);
			puzzles[i+1].addActionListener(this);
		}

		bgImage = new ImageIcon("res/background.jpg");
		bg = new JLabel(bgImage);
		bg.setBounds(0, 0, 1280, 720);
		panel.add(bg);

		this.add(panel);
	}
	public void actionPerformed(ActionEvent ae)
	{
		for(int i = 0; i < numberOfTiles; i++)
		{
			if(ae.getSource() == puzzles[i])
			{
				if(!vanished[i])
				{
					puzzles[i].setIcon(new ImageIcon("res/transparent.png"));
					puzzles[i].setText(""+tileNo[i]);
					puzzles[i].setHorizontalTextPosition(SwingConstants.CENTER);
					puzzles[i].setBorderPainted(true);
	        		clicked.add(i);
				}
        		if(clicked.size() == 2)
        		{
        			if(tileNo[clicked.get(0)] == tileNo[clicked.get(1)] && clicked.get(0) % 2 != clicked.get(1) % 2)
        			{
        				puzzles[clicked.get(0)].setVisible(false);
        				puzzles[clicked.get(1)].setVisible(false);
        				vanished[clicked.get(0)] = true;
        				vanished[clicked.get(1)] = true;
        				remainingTiles -= 2;
        			}
        			else
        			{
        				currentScore -= 20;
        				score.setText(""+currentScore);
        				if(clicked.get(0) % 2 == 0) puzzles[clicked.get(0)].setIcon(blueBird);
        				else puzzles[clicked.get(0)].setIcon(redBird);
        				if(clicked.get(1) % 2 == 0) puzzles[clicked.get(1)].setIcon(blueBird);
        				else puzzles[clicked.get(1)].setIcon(redBird);

        				puzzles[clicked.get(0)].setBorderPainted(false);
        				puzzles[clicked.get(0)].setHorizontalTextPosition(SwingConstants.LEADING);
        				puzzles[clicked.get(0)].setText("");
        				puzzles[clicked.get(1)].setBorderPainted(false);
        				puzzles[clicked.get(1)].setHorizontalTextPosition(SwingConstants.LEADING);
        				puzzles[clicked.get(1)].setText("");
        			}
        			clicked.clear();
        			if(remainingTiles == 0)
        			{
        				ResultGui rg = new ResultGui(this);
        				rg.setVisible(true);
        				this.setVisible(false);
        			}
        		}
			}
		}
	}
	public int getCurrentScore()
	{
		return currentScore;
	}
	public int getLevel()
	{
		return level;
	}
}