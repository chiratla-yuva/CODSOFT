import java.util.*;

public class NumberGame
{
	public static void main(String[] args) {
	    // Create Scanner and Random objects for input and random number generation
		Scanner sc = new Scanner(System.in);
		Random random = new Random();
		// Control loop for multiple rounds
		boolean playAgain = true;
		while(playAgain){
		    // Generate a random number between 1 and 100
		    int generated_number = random.nextInt(100) + 1;
		    int max_attempts = 10; // Maximum number of attempts allowed
		    int attempts = 0; // Counter for attempts
		    int score = 0; // Score calculation
		    boolean guessedCorrectly = false; // Flag to check if user guessed correctly
		    // Welcome message and instructions
		    System.out.println("\nWelcome to the Number Guessing Game!");
		    System.out.println("I have selected a number between 1 and 100.");
		    System.out.println("You have maximum 10 attempts. Try to guess it!");
		    // Start guessing loop
		    while(attempts < max_attempts){
    		    System.out.print("Enter your Guess: ");
    		    int guess = sc.nextInt(); // Read user input
    		    attempts++; // Increment attempt count
    		    // Check if guess is correct
    		    if( guess == generated_number ){
    		        System.out.println("Correct! You guessed the number");
    		        guessedCorrectly = true;
    		        score = 100 - (attempts * 10); // Score decreases with more attempts
    		        break; // Exit the loop if the user guesses correctly
    		    } 
    		    // Check if guess is too high
    		    else if ( guess > generated_number ){
    		        System.out.println("Too high! Try again");
    		    } 
    		    // Check if guess is too low
    		    else {
    		        System.out.println("Too low! Try again");
    		    }
    		}
    		// If user didn't guess correctly within allowed attempts
    		if(!guessedCorrectly){
    		    System.out.println("\nYou've used all attempts! The correct number was " + generated_number + ".");
    		}
    		// Display the score (if guessed correctly)
    		System.out.println("Your score: " + (guessedCorrectly ? score : 0));
    		// Ask if the user wants to play again
    		System.out.print("Do you want to play again? (yes/no): ");
		    String response = sc.next();
    		// If the user types "no", end the game
    		if(response.equalsIgnoreCase("Yes")){
    		    playAgain = false;
    		    System.out.println("\nThanks for playing! Goodbye!");
    		}
		}
		// Close the scanner to avoid memory leak
		sc.close();
	}
}
