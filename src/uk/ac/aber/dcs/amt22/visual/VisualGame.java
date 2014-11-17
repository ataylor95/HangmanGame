package uk.ac.aber.dcs.amt22.visual;

import uk.ac.aber.dcs.amt22.Hangman.GameModel;



public class VisualGame extends GameModel{

	/**
	 * This method runs the visual portion of the game
	 */
	public void runVisualGame(){
		MyFrame mf = new MyFrame();
		mf.initialiseGUI();
	}
}
