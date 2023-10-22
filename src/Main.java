import java.io.FileNotFoundException;
/**
 * This class provides a demonstration of how the {@code VoterDeduplication} class can be used
 * to deduplicate a list of voters using three different methods:
 * 1. All pairs method
 * 2. Sort and remove method
 * 3. Hash map method
 */
public class Main {
  /**
   * The main method to execute the deduplication process.
   * @param args Command line arguments. Expects the first argument to be the file name containing voter data.
   * @throws FileNotFoundException If the provided file name is not found.
   */
  public static void main(String[] args) throws FileNotFoundException {
    String fileName = args[0];
    VoterDeduplication deduplication = new VoterDeduplication(fileName);

    // Deduplicate using the all pairs method and measure its execution time
    long startAllPairs = System.currentTimeMillis();
    deduplication.allPairsDeduplication();
    long finishAllPairs = System.currentTimeMillis();
    displayDeduplicationResults("all pairs method", deduplication);
    System.out.println("Execution time (ms): " + (finishAllPairs - startAllPairs));

    // Deduplicate using the sort and remove method and measure its execution time
    long startSortAndRemove = System.currentTimeMillis();
    deduplication.sortAndRemoveDeduplication();
    long finishSortAndRemove = System.currentTimeMillis();
    displayDeduplicationResults("sort and remove method", deduplication);
    System.out.println("Execution time (ms): " + (finishSortAndRemove - startSortAndRemove));

    // Deduplicate using the hash map method and measure its execution time
    long startHashMap = System.currentTimeMillis();
    deduplication.hashMapDeduplication();
    long finishHashMap = System.currentTimeMillis();
    displayDeduplicationResults("hash map method", deduplication);
    System.out.println("Execution time (ms): " + (finishHashMap - startHashMap));
  }

  /**
   * Displays the deduplication results for a given method.
   * @param methodName      The name of the deduplication method used.
   * @param deduplication   The VoterDeduplication instance containing the results.
   */
  private static void displayDeduplicationResults(String methodName, VoterDeduplication deduplication) {
    System.out.println("Deduplicated using " + methodName + ":");
    System.out.println("Original voters count: " + (deduplication.getOriginalVoters().size() - 1));
    System.out.println("Deduplicated voters count: " + (deduplication.getDeduplicateVoters().size() - 1));
    System.out.println("Number of duplicates removed: " + (deduplication.getOriginalVoters().size() - deduplication.getDeduplicateVoters().size()));
  }
}
