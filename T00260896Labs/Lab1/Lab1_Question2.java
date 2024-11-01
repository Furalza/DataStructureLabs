import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;
import java.util.TreeSet;

public class Lab1_Question2 {
    public static void main(String[] args) {
        String[] namesArray = { "Kay", "Jay", "May", "Fay" };

        Set<String> hashSet = new HashSet<>();
        for (String name : namesArray) {
            hashSet.add(name);
        }
        hashSet.add("Kay");
        System.out.println("HashSet contents:");
        Iterator<String> hashIterator = hashSet.iterator();
        while (hashIterator.hasNext()) {
            System.out.println(hashIterator.next());
        }

        Set<String> treeSet = new TreeSet<>();
        for (String name : namesArray) {
            treeSet.add(name);
        }
        treeSet.add("Kay");
        System.out.println("TreeSet contents:");
        Iterator<String> treeIterator = treeSet.iterator();
        while (treeIterator.hasNext()) {
            System.out.println(treeIterator.next());
        }

        System.out.println("Notice that HashSet does not guarantee any order while TreeSet sorts the elements.");
    }
}
