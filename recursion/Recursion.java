public class Recursion {
    public static void main(String[] args) {
        Recursion r = new Recursion();
        System.out.println(r.fact(6));
        System.out.println(r.fib(5));
        System.out.println(r.fibIter(5));
        System.out.println(r.hailLen(5));
        System.out.println(r.longestHail(5));
    }

    public int fact(int n) {
        if (n == 0) {
            return 1;
        }
        else {
            return n * fact(n-1);
        }
    }

    public int fib(int n) {
        if (n == 0) {
            return 0;
        }
        else if (n == 1) {
            return 1;
        }
        else {
            return fib(n-1) + fib(n-2);
        }
    }

    public int fibHelper(int prev1, int prev2, int left) {
        if (left > 0) {
            return fibHelper(prev1+prev2, prev1, left-1);
        }
        else {
            return prev1;
        }
    }

    public int fibIter(int n) {
        return fibHelper(0, 1, n);
    }

    public int hail(int n) {
        if (n == 1) {
            return n;
        }
        else if (n % 2 == 0) {
            System.out.print(n + " ");
            return hail(n/2);
        }
        else {
            System.out.print(n + " ");
            return hail(3*n+1);
        }
    }

    public int hailLen(int n) {
        if (n == 1) {
            return n;
        }
        else if (n % 2 == 0) {
            return 1 + hailLen(n/2);
        }
        else {
            return 1 + hailLen(3*n+1);
        }
    }

    public int longestHail(int n) {
        if (n == 1) {
            return n;
        }
        if (hailLen(n) > hailLen(longestHail(n-1))) {
            return n;
        }
        else {
            return longestHail(n-1);
        }
    }
}
