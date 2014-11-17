package uk.ac.aber.dcs.amt22.Hangman;


import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

public abstract class GameModel implements GameModelInterface {

	private ArrayList<String> words = new ArrayList<String>(); //list of words
	private String wordToGuess; //the word the user needs to guess
	private String guessedChars; //all characters that are guessed
	private int guessesLeft; //number of guesses user has left

	public GameModel() {
		this.guessedChars = "";
		this.guessesLeft = 10;
	}

	public String getVisible() {
		char[] out = new char[wordToGuess.length()];
		for (int i = 0; i < wordToGuess.length(); i++) {
			out[i] = '*'; //set all characters to *
			for (int j = 0; j < guessedChars.length(); j++) {
				if (wordToGuess.charAt(i) == guessedChars.charAt(j)) {
					out[i] = wordToGuess.charAt(i); 
					//if both characters are the same, it changes the * to the letter
				}
			}
			if (!Character.isLetter(wordToGuess.charAt(i))){
				out[i] = wordToGuess.charAt(i); //prints punctuation
			}
		}
		return String.copyValueOf(out); //copying array into string to return
	}

	public String getHidden() {
		int x = new Random().nextInt(words.size()); // get a random number
													// between 1 and
		// the total number of entries in
		// the list
		wordToGuess = words.get(x);
		return wordToGuess;
	}

	public int guessLeft() {
		if (guessesLeft < 0) { // Makes it so you cannot have negative guesses
			guessesLeft = 0;
		}
		return guessesLeft;
	}

	public String getLetters() {
		return guessedChars;
	}

	public boolean tryThis(char letter) {
		if (isGuessedAlready(letter)){ //making sure we re not repeating a letter
			return false;
		}
		guessedChars += letter; //add the guess to the list of characters
		for (int i = 0; i < wordToGuess.length(); i++) {
			if (letter == wordToGuess.charAt(i)) {
				return true;
			}
		}
		guessesLeft--; //subtract 1 guess
		return false;
	}

	public boolean tryWord(String guess) {
		if (guess.equals(wordToGuess)) {
			guessedChars += guess; //add word to guessed characters
			return true;
		}
		guessesLeft -= 5; //if you fail, subtract 5 guesses
		return false;
	}

	/**
	 * This method loads the words and phrases from the text file
	 */
	public void loadFromTextFile() {
		Scanner wordsLoad = null;
		wordsLoad = new Scanner(new InputStreamReader(this.getClass()
				.getClassLoader().getResourceAsStream("res/piratewords.txt")));
		int noWords = wordsLoad.nextInt();//get number of entries in the file
		wordsLoad.nextLine(); //move to next line
		for (int i = 0; i < noWords; i++) {
			words.add(wordsLoad.nextLine()); //add each word/phrase to the array list
		}
		wordsLoad.close(); //close the file
	}

	/**
	 * This method to see if word guessed is correct
	 * @return true or false if word has been guessed
	 */
	private boolean isWordGuessed() {
		for (int i = 0; i < wordToGuess.length(); i++) { //cycle through letters in the word to guess
			boolean isLetterMatched = false;
			char c = wordToGuess.charAt(i);
			for (int j = 0; j < guessedChars.length(); j++) { //cycle through letters in guessed characters
				if (c == guessedChars.charAt(j)) {
					isLetterMatched = true; //if every characters matches, return true
				}
			}
			if (isLetterMatched == false) { // if a single no match found, returns false
				return false;
			}
		}
		return true;
	}
	
	/**
	 * This method is for identifying letters the user has already guessed
	 * @param letter, characters input by user
	 * @return boolean, whether or not the letter has been guessed already
	 */
	private boolean isGuessedAlready(char letter){
		for (int i = 0; i < guessedChars.length(); i++) {
			if (letter == guessedChars.charAt(i)) {
				return true;
			}
		}
		return false;		
	}

	/**
	 * This method evaluates if the player has won or not and returns a boolean
	 * While true, execution will stay in the loop
	 * @return if you've won or not
	 */
	public boolean winConditions() {
		if (this.guessLeft() <= 0) {
			System.out.println("YOU LOSE"); // run out of guesses
			return false;
		} else if (this.getVisible().equals(wordToGuess)) { // match a letter
			System.out.println("YOU WIN");
			return false;
		} else if (this.isWordGuessed() == true) { // match a word
			System.out.println("YOU WIN");
			return false;
		}
		return true;
	}
}
