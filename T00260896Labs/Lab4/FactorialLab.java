public class FactorialLab {
    public static int factorial(int n) {
        if (n == 1 || n == 0) // base case
            return 1;
        else {
            int result = n * factorial(n - 1);
            return result;
        }
    }

    public static void main(String[] args) {
        // Call the factorial method here
        System.out.println(factorial(5));
        System.out.println(factorial(8));
    }
}
