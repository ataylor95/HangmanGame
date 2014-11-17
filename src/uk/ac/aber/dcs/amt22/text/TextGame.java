package uk.ac.aber.dcs.amt22.text;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import uk.ac.aber.dcs.amt22.Hangman.GameModel;

public class TextGame extends GameModel {

	/**
	 * This method runs the text portion of the game
	 */
	public void runTextGame() {
		String inputGuess = null;
		this.loadFromTextFile();
		this.getHidden();
		while (this.winConditions()) {
			System.out.println("\nEnter a letter guess or a word guess: ");
			BufferedReader br = new BufferedReader(new InputStreamReader(
					System.in));
			try {
				inputGuess = br.readLine(); // get input from the user
			} catch (IOException e) {
				e.printStackTrace();
			}
			switch (inputGuess.length()) { 
			case 1: //if the length is 1, or a char
				this.tryThis(inputGuess.charAt(0));
				printStatus();
				break;
			default: //all other inputs are treated as words
				this.tryWord(inputGuess);
				printStatus();
				break;
			}
		}
	}

	/**
	 * This method is for printing the guesses left, the correct guesses and all guesses
	 */
	private void printStatus() { 
		System.out.println("You have " + this.guessLeft()
				+ " guesses left");
		System.out.println("You have correctly guessed: "
				+ this.getVisible());
		System.out.println("You have so far guessed: "
				+ this.getLetters());
			}
}
