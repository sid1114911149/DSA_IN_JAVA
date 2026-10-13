
import java.util.ArrayList;
import java.util.PriorityQueue;
import java.util.Scanner;

public class Median_Using_Heaps {

    public static class Median {

        // Max-heap: smaller half
        PriorityQueue<Integer> maxPq =
            new PriorityQueue<>((a, b) -> Integer.compare(b, a));

        // Min-heap: larger half
        PriorityQueue<Integer> minPq =
            new PriorityQueue<>((a, b) -> Integer.compare(a, b));

        public Median() {
            System.out.println("New Median Class is created successfully");
        }

        public void addElement(int value) {

            if (maxPq.isEmpty() || value <= maxPq.peek()) {
                maxPq.add(value);
            } else {
                minPq.add(value);
            }

            // Balance the heaps
            if (maxPq.size() > minPq.size() + 1) {
                minPq.add(maxPq.poll());
            } else if (minPq.size() > maxPq.size()) {
                maxPq.add(minPq.poll());
            }
        }

        public double find_median() {

            if (maxPq.isEmpty()) {
                return -1;
            }

            if (maxPq.size() == minPq.size()) {
                return ((double) maxPq.peek() + minPq.peek()) / 2.0;
            }

            return maxPq.peek();
        }
    }

    public static void main(String Args[]) {

        Scanner sc = new Scanner(System.in);

        System.out.print("Enter N: ");
        int N = sc.nextInt();

        Median M = new Median();
        ArrayList<Integer> Arr = new ArrayList<>();

        for (int i = 0; i < N; i++) {

            int value = (int)(Math.random() * 1000);

            Arr.add(value);
            M.addElement(value);

            System.out.println("Array Elements So far: " + Arr);
            System.out.println("Median of given elements: " + M.find_median());
        }

        sc.close();
    }
}
