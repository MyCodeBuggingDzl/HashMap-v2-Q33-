import java.util.ArrayList;
import java.util.Random;
import java.util.*;
import java.util.HashSet;
import java.util.HashMap;
/**
 * The responder class represents a response generator object. It is used
 * to generate an automatic response. This is the second version of this 
 * class. This time, we generate some random behavior by randomly selecting 
 * a phrase from a predefined list of responses.
 * 
 * @author   Michael Kölling and David J. Barnes
 * @version 7.2
 */
public class Responder
{
    private Random randomGenerator;
    private ArrayList<String> responses;
    private HashMap<String, String> responsesMap;
    
    /**
     * Construct a Responder
     */
    public Responder()
    {
        randomGenerator = new Random();
        responses = new ArrayList<>();
        fillResponses();
        responsesMap = new HashMap<>();
        fillResponsesMap();
    }
    
    /**
     * Generate a response.
     * 
     * @return  A string that should be displayed as the response
     */
    public String generateResponse(HashSet<String> words)
    {
        // Pick a random number for the index in the default response 
        // list. The number will be between 0 (inclusive) and the size
        // of the list (exclusive).
        ArrayList<String> matches = new ArrayList<>();
        for(String word : words) {
         String response = responsesMap.get(words);
         if (responsesMap.containsKey(word)) {
             matches.add(responsesMap.get(word));
         }
        }
        if (!matches.isEmpty()){
            return matches.get(randomGenerator.nextInt(matches.size()));
        }
        
        if (words.contains("why")) return "why does it happens?";
        if (words.contains("how")) return "How does it happens?";
        if (words.contains("who")) return "Who did it";
        if (words.contains("what")) return "What did you think will happenned";
        
        return pickDefaultResponse();
    }
    
    private String pickDefaultResponse()
    {
        int index = randomGenerator.nextInt(responses.size());
        String response = responses.remove(index);
        responses.add(response);
        return response;
    }

    /**
     * Build up a list of default responses from which we can pick one
     * if we don't know what else to say.
     */
    private void fillResponses()
    {
        responses.add("That sounds odd. Could you describe this in more detail?");
        responses.add("""
                      No other customer has ever complained about this before.
                      What is your system configuration?
                      """);
        responses.add("I need a bit more information on that.");
        responses.add("Have you checked that you do not have a dll conflict?");
        responses.add("That is covered in the manual. Have you read the manual?");
        responses.add("""
                      Your description is a bit wishy-washy. Have you got an expert
                      there with you who could describe this more precisely?
                      """);
        responses.add("That's not a bug, it's a feature!");
        responses.add("Could you elaborate on that?");
        responses.add("Have you tried running the app on your phone?");
        responses.add("I just checked StackOverflow - they don't know either.");
    }
    
    public void fillResponsesMap()
    {
        responsesMap.put("Unplug", "Have you tried unplugging then plugging it again?");
        responsesMap.put("Internet", "No connection");
        responsesMap.put("Bug", "Your file contains bugs");
        responsesMap.put("Virus", "Your device contains virus");
        responsesMap.put("Update", "Your device isn't up to date");
        responsesMap.put("wifi", "No connection");
        responsesMap.put("internet", "No connection");
        responsesMap.put("connection", "No connection");

    }
}

