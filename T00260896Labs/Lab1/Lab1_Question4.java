import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.*;

public class Lab1_Question4 {
    public static void main(String[] args) {
        Map<String, Set<Integer>> wordLinesMap = new HashMap<>();

        try (BufferedReader br = new BufferedReader(
                new FileReader("C:\\Users\\alper\\Downloads\\DataStructureLabs\\T00260896Labs\\Lab1\\hamlet.txt"))) {
            String line;
            int lineNumber = 0;
            while ((line = br.readLine()) != null) {
                lineNumber++;
                String[] words = line.split("\\W+");
                for (String word : words) {
                    if (!word.isEmpty()) {
                        String key = word.toLowerCase();
                        wordLinesMap.computeIfAbsent(key, k -> new HashSet<>()).add(lineNumber);
                    }
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        System.out.println("Words and their occurrences:");
        for (Map.Entry<String, Set<Integer>> entry : wordLinesMap.entrySet()) {
            System.out.println(entry.getKey() + " : " + entry.getValue());
        }

        String searchWord = "to";
        if (wordLinesMap.containsKey(searchWord)) {
            System.out.println("The word '" + searchWord + "' occurs on lines: " + wordLinesMap.get(searchWord));
        } else {
            System.out.println("The word '" + searchWord + "' does not occur in the text.");
        }
    }
}
