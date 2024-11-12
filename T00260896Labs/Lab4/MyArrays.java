public class MyArrays {
    public static int sum(int[] values) {
        return sumHelper(values, values.length - 1);
    }

    private static int sumHelper(int[] values, int index) {
        if (index < 0) {
            System.out.println("Base case reached; returning 0");
            return 0; // base case
        } else {
            System.out.println("Adding values[" + index + "] = " + values[index]);
            int result = values[index] + sumHelper(values, index - 1); // recursive case
            System.out.println("Partial sum up to index " + index + ": " + result);
            return result;
        }
    }

    // Adding a main method for testing purposes
    public static void main(String[] args) {
        int[] values = { 1, 2, 3, 4, 5 }; // Test array

        // Calculate the sum using the sum method
        int result = sum(values);

        // Print the result
        System.out.println("Sum of array elements: " + result);
    }
}
