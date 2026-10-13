
import java.util.Arrays;
import java.util.Scanner;

public class First_Non_Negative_Missing {

    public static int solve(int Arr[]) {
        int N = Arr.length;

        for (int i = 0; i < N; i++) {

            while (Arr[i] >= 0 &&
                   Arr[i] < N &&
                   Arr[Arr[i]] != Arr[i]) {

                int temp = Arr[i];
                Arr[i] = Arr[temp];
                Arr[temp] = temp;
            }
        }

        for (int i = 0; i < N; i++) {
            if (Arr[i] != i) {
                return i;
            }
        }

        return N;
    }

    public static void main(String Args[]) {

        Scanner sc = new Scanner(System.in);

        System.out.print("Enter N:");
        int N = sc.nextInt();

        int Arr[] = new int[N];

        System.out.print("Enter array elements:");
        for (int i = 0; i < N; i++) {
            Arr[i] = sc.nextInt();
        }

        System.out.println("Given Input Array: "
                + Arrays.toString(Arr));

        System.out.println(
                "First Missing Non-Negative Integer: "
                + solve(Arr));

        sc.close();
    }
}
