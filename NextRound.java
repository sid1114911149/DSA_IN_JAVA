
import java.util.Scanner;

public class NextRound {

    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        int n, k;
        n = sc.nextInt();
        int arr[] = new int[n];
        k = sc.nextInt();
        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }
        if (arr[0] == 0) {
            System.out.println(0);
            return;
        }
        k--;
        int val = arr[k];
        if (val > 0) {
            while (k < n && val == arr[k]) {
                k++;
            }
        }else{
            while(k>=0 && arr[k]==0)
                k--;
            k++;
        }
        System.out.println(k);
        sc.close();
    }
}
