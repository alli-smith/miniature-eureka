/*
 * Activity 2.5.2
 *
 *  The PhraseSolver class the PhraseSolverGame
 */
import java.util.Scanner;
  
public class PhraseSolver
{
  /* your code here - attributes */
  private Player player1;
  private Player player2;
  private Board game;

  /* your code here - constructor(s) */ 
  public PhraseSolver () {
    player1 = new Player();
    player2 = new Player();
    game = new Board();
  }

  public void play()
  {
    boolean solved = false;
    int currentPlayer = 1;
    String guess;

    Scanner sc = new Scanner(System.in);
    
    boolean correct = true;
    while (!solved) 
    {
      System.out.println(" ");
      correct = true;
      // Set the current player
      if (currentPlayer == 1)
      {
        currentPlayer = 2;
        System.out.println("It is now " + player2.getName() + "'s turn");
      }
      else
      {
        currentPlayer = 1;
        System.out.println("It is now " + player1.getName() + "'s turn");
      }
      while (correct == true)
      {
        // Set letter value
        game.setLetterValue();
        // Prompt the current player for a guess.
        System.out.println(game.getSolvedPhrase());
        System.out.println("The current letter value is: " + game.getLetterValue());
        System.out.println("Enter your guess: ");
        guess = sc.nextLine();
        // Check to see if the letter is in the phrase.
        if (game.guessLetter(guess) == true)
        {
          correct = true;
          System.out.println(" ");
          if (currentPlayer == 1)
          {
            player1.addToPoints(game.getLetterValue());
            System.out.println("Good job, " + player1.getName() + "! Your new phrase is:");
          }
          else
          {
            player2.addToPoints(game.getLetterValue());
            System.out.println("Good job, " + player2.getName() + "! Your new phrase is:");
          }
        }
        // Check to see if the phrase is solved.
        else if (game.getPhrase().equals(guess))
        {
          // Stop the game if the phrase is solved.
          solved = true;
          correct = false;
          System.out.println("You guessed the whole phrase as: " + guess + ", and it was correct!");
          if (currentPlayer == 1)
          {
            player1.addToPoints(1000);
          }
          else
          {
            player2.addToPoints(1000);
          }
        }
        else
        {
          correct = false;
          System.out.println("Incorrect. Next player");
        }
        if (game.getSolvedPhrase().indexOf("_") == -1) {
          solved = true;
          break;
        }
      }
    }
    System.out.println(" ");
    System.out.println("Congrats, you guessed the phrase!");
    System.out.println("The phrase was: " + game.getPhrase());
    System.out.println(player1.getName() + " Points: " + player1.getPoints());
    System.out.println(player2.getName() + " Points: " + player2.getPoints());
    if (player1.getPoints() > player2.getPoints())
    {
      System.out.println(player1.getName() + " won!");
    }
    else if (player1.getPoints() < player2.getPoints())
    {
      System.out.println(player2.getName() + " won!");
    }
    else
    {
      System.out.println("Tie!");
    } 
  }
}