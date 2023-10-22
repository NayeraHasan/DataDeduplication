import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;

/**
 * This class performs deduplication on a list of Voter records.
 */
public class VoterDeduplication {
    private ArrayList<Voter> originalVoters; // the original list of originalVoters
    private ArrayList<Voter> deduplicateVoters; // the deduplicate list of originalVoters

    /**
     * Constructor that reads a CSV file of voter records and creates an ArrayList of Voter objects.
     * @param fileName The name of the CSV file to read.
     */
    public VoterDeduplication(String fileName) {
        // read CSV file into an ArrayList of strings
        ArrayList<String> lines = new ArrayList<>();
        try (BufferedReader reader = new BufferedReader(new FileReader(fileName))) {
            String eachline = reader.readLine(); // read the first eachline of the file
            while (eachline != null) { // while there are more lines in the file
                lines.add(eachline); // add the eachline to the ArrayList of strings
                eachline = reader.readLine(); // read the next eachline of the file
            }
        } catch (IOException e) { // if there is an IOException, print an error message and return
            System.err.println("Error reading file: " + e.getMessage());
            return;
        }
        // read the list into an ArrayList of Voter objects
        originalVoters = new ArrayList<>();
        for (String line : lines) { // for each line in the ArrayList of strings
            String[] fields = line.split(","); // split the line into an array of strings based on commas
            String lastName = fields[3].trim(); // get the last name from the fields array
            String firstName = fields[4].trim(); // get the first name from the fields array
            String middleName = fields[5].trim(); // get the middle name from the fields array
            String birthdate = fields[7].trim(); // get the birthdate from the fields array
            originalVoters.add(new Voter(firstName, middleName, lastName, birthdate)); // create a new Voter object with the extracted data and add it to the ArrayList of Voter objects
        }
    }

    /**
     * method that deduplicates the list of voters using the all-pairs algorithm.
     */
    public void allPairsDeduplication() {
        deduplicateVoters = new ArrayList<>(); // create a new ArrayList for the deduplicated voters
        for (int i = 0; i < originalVoters.size(); i++) { // for each voter in the original list
            boolean isDuplicate = false; // set the isDuplicate flag to false
            for (int j = i + 1; j < originalVoters.size(); j++) { // for each remaining voter in the original list
                if (originalVoters.get(i).compareTo(originalVoters.get(j)) == 0) { // compare the current voter to the remaining voters
                    isDuplicate = true; // if they are equal, set the isDuplicate flag to true
                    break; // exit the loop
                }
            }
            if (!isDuplicate) { // if the current voter is not a duplicate
                deduplicateVoters.add(originalVoters.get(i)); // add it to the deduplicated list
            }
        }
    }

    /**
     * Method that deduplicates the list of voters using the sort-and-remove algorithm.
     */


    public void sortAndRemoveDeduplication() {
        ArrayList<Voter> deduplicateVoters = new ArrayList<Voter>(); // use a HashSet to remove duplicates and create a new ArrayList from the unique elements
        // ArrayList<Voter> deduplicateVoters1 = new ArrayList<>(originalVoters); // use a HashSet to remove duplicates and create a new ArrayList from the unique elements
        Collections.sort(originalVoters); // sort the original list
        Voter  storedvaraiable = originalVoters.get(0);
        for (Voter voter: originalVoters) { // Iterate over the sorted originalVoters list and add each unique voter to the deduplicateVoters list
            if (voter.compareTo(storedvaraiable) == 1) { // A voter is considered unique if it is not equal to the previous voter in the sorted list
                deduplicateVoters.add(voter);
            }
            storedvaraiable = voter;
        }
    }


    /**
     * method that deduplicates the list of voters using a HashMap.
     */
    public void hashMapDeduplication() {
    // Initialize the deduplicateVoters list and the HashMap map
        deduplicateVoters = new ArrayList<>();
        HashMap<String, Integer> map = new HashMap<>();
        for (Voter voter : originalVoters) { // Iterate over the originalVoters list and put each voter in the map
            String voterKey = voter.toString(); // with their string representation as the key and the count as the value
            if (map.containsKey(voterKey)) { // If the voter is already in the map, increment the count
                map.put(voterKey, map.get(voterKey) + 1);
            } else { // If the voter is not in the map, add it to the deduplicateVoters list and set the count to 1
                map.put(voterKey, 1);
                deduplicateVoters.add(voter);
            }
        }
    }
    /**
     * Returns the deduplicated list of voters.
     * @return The deduplicated list of voters.
     */
    public ArrayList<Voter> getDeduplicateVoters() {
        return deduplicateVoters; // returns the deduplicated list of voters
    }

    public ArrayList<Voter> getOriginalVoters() {
       // originalVoters = originalVoters -1 ;
        return   originalVoters;// returns the original list of voters
    }



}
