public class BinarySearch {
    public static int binarySearch(int[] array, int target) {
        return binarySearchHelper(array, target, 0, array.length - 1);
    }

    private static int binarySearchHelper(int[] array, int target, int left, int right) {
        if (left > right) {
            return -1; // base case: target not found
        }
        int mid = left + (right - left) / 2;
        if (array[mid] == target) {
            return mid; // target found
        } else if (array[mid] > target) {
            return binarySearchHelper(array, target, left, mid - 1); // search left
        } else {
            return binarySearchHelper(array, target, mid + 1, right); // search right
        }
    }

    // Main method for testing the binarySearch function
    public static void main(String[] args) {
        int[] sortedArray = { 1, 3, 5, 7, 9, 11, 13, 15, 17, 19 }; // Sample sorted array

        // Test cases
        int target1 = 7;
        int target2 = 4;
        int target3 = 19;
        int target4 = 1;

        System.out.println("Index of " + target1 + ": " + binarySearch(sortedArray, target1)); // Expected: 3
        System.out.println("Index of " + target2 + ": " + binarySearch(sortedArray, target2)); // Expected: -1 (not
                                                                                               // found)
        System.out.println("Index of " + target3 + ": " + binarySearch(sortedArray, target3)); // Expected: 9
        System.out.println("Index of " + target4 + ": " + binarySearch(sortedArray, target4)); // Expected: 0
    }
}
