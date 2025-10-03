import java.util.Scanner;
import java.util.HashSet;
/**
 * InputReader reads typed text input from the standard text terminal. 
 * The text typed by a user is then chopped into words, and a set of words 
 * is provided.
 * 
 * @author  Michael Kölling and David J. Barnes
 * @version 7.0
 */
public class InputReader
{
    private Scanner reader;

    /**
     * Create a new InputReader that reads text from the text terminal.
     */
    public InputReader()
    {
        reader = new Scanner(System.in);
    }

    /**
     * Read a line of text from standard input (the text terminal),
     * and return it as a String.
     *
     * @return  A String typed by the user.
     */
    public HashSet<String> getInput()
    {
        // print prompt
        System.out.print("> ");         
        String inputLine = reader.nextLine().toLowerCase();
        
        HashSet<String> words = new HashSet<>();
        for(String word : inputLine.split(" ")){
            if (!words.isEmpty()){
                words.add(word);
            }
        }
        return words;
    }
}
