import java.lang.*;
import javax.swing.*;
import java.awt.*;
public class GameStart extends JFrame
{
	private JLabel starting, progress;
	private JPanel panel;
	private ImageIcon start, loading;
	public GameStart()
	{
		super("Match Our Puzzles");
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setSize(1280,720);
		this.setResizable(false);

		panel = new JPanel();
		panel.setLayout(null);

		loading = new ImageIcon("res/loading.gif");
		progress = new JLabel(loading);
		progress.setBounds(500, 450, 256,256);
		panel.add(progress);

		start = new ImageIcon("res/start.jpg");
		starting = new JLabel(start);
		starting.setBounds(0, 0, 1280, 720);
		panel.add(starting);

		this.add(panel);
	}
}