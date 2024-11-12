import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class FileHandling {
    public static void main(String[] args) {
        // Adjust the file path accordingly
        String fileName = "C:\\Users\\alper\\Downloads\\DataStructureLabs\\T00260896Labs\\Lab1\\hamlet.txt";

        try {
            Scanner in = new Scanner(new File(fileName));
            int lineNumber = 1;
            while (in.hasNextLine()) {
                Scanner lineParser = new Scanner(in.nextLine());
                // Use any characters other than a-z, A-Z, 0-9 as delimiters
                lineParser.useDelimiter("[^A-Za-z0-9]+");
                while (lineParser.hasNext()) {
                    String word = lineParser.next();
                    System.out.println("'" + word + "' " + lineNumber);
                }
                lineNumber++; // Increment line number after processing each line
                lineParser.close(); // Close lineParser after each line, not `in`
            }
            in.close(); // Close the file scanner after processing all lines
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }
}
