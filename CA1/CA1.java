import java.io.File;
import java.io.FileNotFoundException;
import java.util.*;

public class CA1 {
    public static void main(String[] args) {
        // File paths for dictionary and text
        String dictionaryPath = "C:\\Users\\alper\\Downloads\\DataStructureLabs\\CA1\\words.txt";
        String textPath = "C:\\Users\\alper\\Downloads\\DataStructureLabs\\CA1\\Don_Quixote_by_Miguel_de_Cervantes_Saavedra.txt";

        // Load dictionary into different collections for performance analysis
        List<String> arrayList = loadDictionary(dictionaryPath, new ArrayList<>());
        List<String> linkedList = loadDictionary(dictionaryPath, new LinkedList<>());
        Set<String> hashSet = loadDictionary(dictionaryPath, new HashSet<>());
        Set<String> treeSet = loadDictionary(dictionaryPath, new TreeSet<>());

        // Load words from text file
        List<String> textWords = loadWordsFromFile(textPath);

        // Display count of misspelled and unique misspelled words
        displayMisspelledWordsCount(textWords, hashSet);

        // Print dictionary size
        System.out.println("Value of n (size of the dictionary): " + arrayList.size());

        // Generate random words and indices for performance testing
        String[] randomWords = generateRandomWords(textWords, 1000);
        int[] randomIndices = generateRandomNos(arrayList.size(), 10000);

        // Performance tests: contains() method across different collections
        System.out.println("Testing ArrayList contains():");
        measureContainsTime(arrayList, randomWords);

        System.out.println("Testing LinkedList contains():");
        measureContainsTime(linkedList, randomWords);

        System.out.println("Testing HashSet contains():");
        measureContainsTime(hashSet, randomWords);

        System.out.println("Testing TreeSet contains():");
        measureContainsTime(treeSet, randomWords);

        // Performance tests: get() method on ArrayList and LinkedList
        System.out.println("Testing ArrayList get():");
        measureGetTime(arrayList, randomIndices);

        System.out.println("Testing LinkedList get():");
        measureGetTime(linkedList, randomIndices);
    }

    // Loads the dictionary file into the specified collection type
    public static <T extends Collection<String>> T loadDictionary(String filePath, T collection) {
        try {
            Scanner scanner = new Scanner(new File(filePath));
            while (scanner.hasNextLine()) {
                collection.add(scanner.nextLine().trim());
            }
        } catch (FileNotFoundException e) {
            System.err.println("File not found: " + filePath);
            e.printStackTrace();
        }
        return collection;
    }

    // Reads words from a text file and returns them as a list of lowercase words
    // without punctuation
    public static List<String> loadWordsFromFile(String filePath) {
        List<String> words = new ArrayList<>();
        try {
            Scanner scanner = new Scanner(new File(filePath));
            while (scanner.hasNext()) {
                words.add(scanner.next().replaceAll("[^a-zA-Z]", "").toLowerCase());
            }
        } catch (FileNotFoundException e) {
            System.err.println("File not found: " + filePath);
            e.printStackTrace();
        }
        return words;
    }

    // Measures and outputs the time taken for contains() on a collection using a
    // list of random words
    public static void measureContainsTime(Collection<String> collection, String[] randomWords) {
        long startTime = System.nanoTime();

        for (String word : randomWords) {
            collection.contains(word);
        }

        long endTime = System.nanoTime();
        long duration = (endTime - startTime) / 1_000_000; // in milliseconds
        System.out.println("Time taken: " + duration + " ms");
    }

    // Measures and outputs the time taken for get() on a list using random indices
    public static void measureGetTime(List<String> list, int[] randomNos) {
        long startTime = System.nanoTime();

        for (int i : randomNos) {
            list.get(i);
        }

        long endTime = System.nanoTime();
        long duration = (endTime - startTime) / 1_000_000; // in milliseconds
        System.out.println("Time taken: " + duration + " ms");
    }

    // Generates an array of random words from a source list
    public static String[] generateRandomWords(List<String> sourceList, int numWords) {
        Random random = new Random();
        String[] randomWords = new String[numWords];

        for (int i = 0; i < numWords; i++) {
            randomWords[i] = sourceList.get(random.nextInt(sourceList.size()));
        }

        return randomWords;
    }

    // Generates an array of random indices within a specified list size
    public static int[] generateRandomNos(int listSize, int reps) {
        Random random = new Random();
        int[] randomNos = new int[reps];

        for (int i = 0; i < reps; i++) {
            randomNos[i] = random.nextInt(listSize);
        }
        return randomNos;
    }

    // Counts and displays the total and unique misspelled words based on a
    // dictionary set
    public static void displayMisspelledWordsCount(List<String> textWords, Set<String> dictionary) {
        int totalMisspelled = 0;
        Set<String> uniqueMisspelledWords = new HashSet<>();

        for (String word : textWords) {
            if (!dictionary.contains(word)) {
                totalMisspelled++;
                uniqueMisspelledWords.add(word);
            }
        }

        System.out.println("Misspelled Words: " + totalMisspelled);
        System.out.println("Unique Misspelled Words: " + uniqueMisspelledWords.size());
    }
}
