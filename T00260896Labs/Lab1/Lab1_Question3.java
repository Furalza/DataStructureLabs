import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Iterator;
import java.util.TreeSet;

public class Lab1_Question3 {
    public static void main(String[] args) {
        TreeSet<String> uniqueWords = new TreeSet<>();

        try (BufferedReader br = new BufferedReader(
                new FileReader("C:\\Users\\alper\\Downloads\\DataStructureLabs\\T00260896Labs\\Lab1\\hamlet.txt"))) {
            String line;
            while ((line = br.readLine()) != null) {
                String[] words = line.split("\\W+");
                for (String word : words) {
                    if (!word.isEmpty()) {
                        uniqueWords.add(word.toLowerCase());
                    }
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        System.out.println("Unique words in the file:");
        Iterator<String> iterator = uniqueWords.iterator();
        while (iterator.hasNext()) {
            System.out.println(iterator.next());
        }
        System.out.println("Total unique words: " + uniqueWords.size());
    }
}
