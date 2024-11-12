public class Fibonacci {
    public static int recursiveFibonacci(int n) {
        if (n == 0)
            return 0;
        if (n == 1)
            return 1;
        return recursiveFibonacci(n - 1) + recursiveFibonacci(n - 2);
    }

    public static int iterativeFibonacci(int n) {
        if (n == 0)
            return 0;
        if (n == 1)
            return 1;

        int fib = 0, prev1 = 0, prev2 = 1;
        for (int i = 2; i <= n; i++) {
            fib = prev1 + prev2;
            prev1 = prev2;
            prev2 = fib;
        }
        return fib;
    }

    public static void main(String[] args) {
        System.out.println(recursiveFibonacci(5));
        System.out.println(iterativeFibonacci(6));
    }
}
