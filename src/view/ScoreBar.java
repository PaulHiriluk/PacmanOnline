package view;

import java.awt.BorderLayout;
import java.awt.Dimension;

import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class ScoreBar extends JPanel{
	private static final long serialVersionUID = -5423518117416512133L;
	
	private JLabel gameStateLabel;
	private JLabel scoreLabel;
	private JLabel cherry;
	private Boolean haveCherry;
	
	public ScoreBar() {
		initDefaultSettings();
		initGameStateLabel();
		printGameState(0, true);
	}

	private void initDefaultSettings() {
		setLayout(new BorderLayout());
		setSize(new Dimension(200, 20));
		setPreferredSize(new Dimension(200, 20));
	}
	
	//Initials labels which contain game statistics
	private void initGameStateLabel() {
		//score label
		scoreLabel = new JLabel("Score: ");
		add(scoreLabel, BorderLayout.WEST);
		
		//game statistic: pacman life's, current level, score to next level 
		gameStateLabel = new JLabel("Status: ");
		add(gameStateLabel, BorderLayout.CENTER);
		
		//label show cherry status
		cherry = new JLabel(new ImageIcon("src/images/cherry.jpg"));
		add(cherry, BorderLayout.EAST);
	}
	
	//print all game statistic
	public void printGameState(int score, Boolean haveCherry){
		this.scoreLabel.setText("Score: " + score);
		this.cherry.setVisible(haveCherry);
	}
}
