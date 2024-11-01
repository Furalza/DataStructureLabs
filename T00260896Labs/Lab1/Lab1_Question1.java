import java.util.LinkedList;
import java.util.ListIterator;

public class Lab1_Question1 {
    public static void main(String[] args) {
        LinkedList<String> names = new LinkedList<>();

        names.add("Kay");
        names.add("Jay");
        names.add("May");
        names.add("Fay");

        ListIterator<String> iterator = names.listIterator();
        while (iterator.hasNext()) {
            if (iterator.next().equals("May")) {
                iterator.add("Ray");
                break;
            }
        }

        names.remove("Jay");

        System.out.println("Names from the beginning:");
        iterator = names.listIterator();
        while (iterator.hasNext()) {
            System.out.println(iterator.next());
        }

        System.out.println("Names from the end:");
        iterator = names.listIterator(names.size());
        while (iterator.hasPrevious()) {
            System.out.println(iterator.previous());
        }

        names.add("Kay");
        System.out.println("All names with duplicates allowed:");
        iterator = names.listIterator();
        while (iterator.hasNext()) {
            System.out.println(iterator.next());
        }
    }
}
