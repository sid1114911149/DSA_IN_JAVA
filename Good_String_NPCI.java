
import java.util.*;

public class Good_String_NPCI {

    public static long fib[];

    public static long countGood(int N) {
        if (N < 0) {
            return 0;
        }
        if (fib[N] != -1) {
            return fib[N];
        }
        long first = countGood(N - 1);
        long second = countGood(N - 2);
        fib[N] = first + second;
        return fib[N];
    }

    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter N:");
        int N = sc.nextInt();
        if (N <= 0) {
            System.out.println("No of Possible Goood Strings of Size " + N + " is:" + 0); 
        }else if (N <= 2) {
            System.out.println("No of Possible Goood Strings of Size " + N + " is:" + 2); 
        }else {
            fib = new long[N + 1];
            Arrays.fill(fib, -1);
            fib[0] = 0;
            fib[1] = 2;
            fib[2] = 2;
            long Answer = countGood(N);
            System.out.println("No of Possible Goood Strings of Size "+N+" is:"+Answer);
        }
        sc.close();
    }
}
