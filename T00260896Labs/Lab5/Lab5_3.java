import java.io.File;
import java.io.FileNotFoundException;
import java.util.*;

public class Lab5_3 {
    public static void main(String[] args) {

        List<String> arrList = new ArrayList<>();
        List<String> linkList = new LinkedList<>();
        Set<String> hashSet = new HashSet<>();
        Set<String> treeSet = new TreeSet<>();
        int listSize = 10000; // Adjust this value as needed

        // Populate all collections with contents from the data file
        try {
            String filename = "C:\\Users\\alper\\IdeaProjects\\MTUSep24DSC\\Labs\\Lab5\\words.txt"; // Path to your file
            File file = new File(filename);
            Scanner in = new Scanner(file);

            for (int i = 0; i < listSize && in.hasNextLine(); i++) {
                String str = in.nextLine();
                // Add str to all collections
                arrList.add(str);
                linkList.add(str);
                hashSet.add(str);
                treeSet.add(str);
            }
        } catch (FileNotFoundException e) {
            System.out.println("File not found");
            e.printStackTrace();
        }

        // Generate random words for the contains() test
        String[] randomWords = generateRandomWords(arrList, 1000); // Adjust '1000' for more or fewer tests

        // Measure and print contains() time for each data structure
        System.out.println("Testing ArrayList contains():");
        measureContainsTime(arrList, randomWords);

        System.out.println("Testing LinkedList contains():");
        measureContainsTime(linkList, randomWords);

        System.out.println("Testing HashSet contains():");
        measureContainsTime(hashSet, randomWords);

        System.out.println("Testing TreeSet contains():");
        measureContainsTime(treeSet, randomWords);
    }

    public static void measureContainsTime(Collection<String> collection, String[] randomWords) {
        long startTime = System.currentTimeMillis();

        for (String word : randomWords) {
            collection.contains(word);
        }

        long endTime = System.currentTimeMillis();
        long duration = endTime - startTime;
        System.out.println("Time taken: " + duration + " ms");
    }

    public static String[] generateRandomWords(List<String> sourceList, int numWords) {
        Random random = new Random();
        String[] randomWords = new String[numWords];

        for (int i = 0; i < numWords; i++) {
            randomWords[i] = sourceList.get(random.nextInt(sourceList.size()));
        }

        return randomWords;
    }
}
