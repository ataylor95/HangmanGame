package uk.ac.aber.dcs.amt22.Hangman;
import java.io.*;

import uk.ac.aber.dcs.amt22.text.TextGame;
import uk.ac.aber.dcs.amt22.visual.VisualGame;

public class PirateApp {

	/**
	 * Main method for application
	 * 
	 * @param args
	 */
	public static void main(String[] args) {
		char choice = 'X';
		//char choice2 = 'N';
		boolean x = true;
		System.out.println("Welcome to Hangman! \n");
		System.out.println("Enter T for text based game");
		System.out.println("Enter V for visual game");
		System.out.println("Enter any other character to exit \n");
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		try {
			choice = (char) br.read(); // get input from the user
		} catch (IOException e) {
			e.printStackTrace();
		}
		choice = Character.toUpperCase(choice);
		switch (choice) {
		case 'T':
			TextGame tg = new TextGame();
			tg.runTextGame();
			break;
		case 'V':
			VisualGame vg = new VisualGame();
			vg.runVisualGame();
			break;
		default:
			System.out.println("Exiting");
			break;
		}
	}
}
