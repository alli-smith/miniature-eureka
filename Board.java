/*
 * Activity 2.5.2
 *
 * A Board class the PhraseSolverGame
 */
import java.util.Scanner;
import java.io.File;

public class  Board
{
  private String phrase = "";
  private String solvedPhrase = "";
  private int currentLetterValue; 

  /* your code here - constructor(s) */ 
  public Board ()
  {
    phrase = loadPhrase();
    setLetterValue();
  }
  /* your code here - accessor(s) */
  public String getPhrase()
  {
    return phrase;
  }

  public String getSolvedPhrase()
  {
    return solvedPhrase;
  }

  public int getLetterValue()
  {
    return currentLetterValue;
  }

  /* ---------- provided code, do not modify ---------- */
  public void setLetterValue()
  {
    int randomInt = (int) ((Math.random() * 10) + 1) * 100;    
    currentLetterValue = randomInt;
  }

  public boolean isSolved(String guess)
  {
    if (phrase.equals(guess))
    {
      return true;
    }
    return false;
  }

  private String loadPhrase()
  {
    String tempPhrase = "";
    
    int numOfLines = 0;
    try 
    {
      Scanner sc = new Scanner(new File("phrases.txt"));
      while (sc.hasNextLine())
      {
        tempPhrase = sc.nextLine().trim();
        numOfLines++;
      }
    } catch(Exception e) { System.out.println("Error reading or parsing phrases.txt"); }
    
		int randomInt = (int) ((Math.random() * numOfLines) + 1);
    
    try 
    {
      int count = 0;
      Scanner sc = new Scanner(new File("phrases.txt"));
      while (sc.hasNextLine())
      {
        count++;
        String temp = sc.nextLine().trim();
        if (count == randomInt)
        {
          tempPhrase = temp;
        }
      }
    } catch (Exception e) { System.out.println("Error reading or parsing phrases.txt"); }
    
    for (int i = 0; i < tempPhrase.length(); i++)
    {
      if (tempPhrase.substring(i, i + 1).equals(" "))
      {
        solvedPhrase += "  ";
      }  
      else
      {
        solvedPhrase += "_ ";
      }
    }  
    
    return tempPhrase;
  }  

  /* Description: This method will take the user's guess of letter,  
  * and store a new variable, newSolvedPhrase
  * 
  * Precondition: parameter is a String called guess, that is taken
  * from user input, and there is already a String variable called
  * solvedPhrase that can be added to newSolvedPhrase.
  * 
  * Postcondition: boolean variable found letter will be returned,
  * and the variable solvedPhrase will be updated.
  */
  public boolean guessLetter(String guess)
  {
    // initiate variables to determine if the letter was guessed correctly, and the new solved phrase
    boolean foundLetter = false;
    String newSolvedPhrase = "";
    
    // for loop to repeat the entire length of the string, incrementing by 1
    for (int i = 0; i < phrase.length(); i++)
    {
      // check each letter of the String phrase to see if it equals the guessed letter
      if (phrase.substring(i, i + 1).equals(guess))
      {
        // if the letter is guessed correctly, the newSolvedPhrase variable is updated to include the guess and a space
        newSolvedPhrase += guess + " ";
        //  if the letter is guessed correctly, the boolean foundLetter will be changed to true
        foundLetter = true;
      }
      // if the letter being checked does not equal the guessed letter, this will execute
      else
      {
        // makes a substring of either the "_" or letter, and adds it to the newSolvedPhrase
        newSolvedPhrase += solvedPhrase.substring(i * 2, i * 2 + 1) + " ";  
      }
    }
    // update solvedPhrase to equal newSolvedPhrase
    solvedPhrase = newSolvedPhrase;
    // return the boolean foundLetter, which says whether the guessed letter was any of the letters in the String phrase
    return foundLetter;
  } 
} 