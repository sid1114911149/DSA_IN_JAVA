
import java.util.*;

public class pattern1 {

    public static void main(String[] args) {
        try (Scanner sc = new Scanner(System.in)) {
            System.out.print("Enetr a Number:");
            int a = sc.nextInt();
            for (int i = 0; i < a; i++) {
                for (int j = 0; j <= i; j++) {
                    System.out.print("*");
                }
                for (int k = 0; k < 2 * (a - i - 1); k++) {
                    System.out.print(" ");
                }
                for (int j = 0; j <= i; j++) {
                    System.out.print("*");
                }
                System.out.println("");
            }
            for (int i = a - 1; i >= 0; i--) {
                for (int j = 0; j <= i; j++) {
                    System.out.print("*");
                }
                for (int k = 0; k < 2 * (a - i - 1); k++) {
                    System.out.print(" ");
                }
                for (int j = 0; j <= i; j++) {
                    System.out.print("*");
                }
                System.out.println("");
            }
        }
    }
}
