package uk.ac.aber.dcs.amt22.visual;
import java.awt.BorderLayout;

import javax.swing.*;

import uk.ac.aber.dcs.amt22.Hangman.GameModel;

public class MyFrame extends JFrame{
	
	private GameModel game;
	private JTextField letterBox, wordBox;
	private JLabel guessesLabel, VisibleLabel;
	private PicturePanel Container_Picture;
	
	/**
	 * primary graphics panel
	 */
	public void initialiseGUI(){
		this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		this.setTitle("Pirate Themed Hangman Game");
		this.setResizable(false); //Want to keep it same size because of image size
		this.setSize(820, 460);
		this.setVisible(true);
		
		JButton wordButton = new JButton("Word");
		JButton letterButton = new JButton("Letter");
		
		//the three panels for my buttons, text fields and labels
		//JPanel 
		this.add(new PicturePanel(),BorderLayout.CENTER);
		
	}
}
