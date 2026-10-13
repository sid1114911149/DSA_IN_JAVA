import java.util.Stack;
class Largest_Rectangle_Histogram {
    public static int getMaxArea(int arr[]) {

        int n = arr.length;
        Stack<Integer> S = new Stack<>();
        int maxArea = 0;

        for (int i = 0; i <= n; i++) {

            int currHeight = (i == n) ? 0 : arr[i];

            while (!S.isEmpty() && currHeight < arr[S.peek()]) {

                int height = arr[S.pop()];

                int width;
                if (S.isEmpty()) {
                    width = i;
                } else {
                    width = i - S.peek() - 1;
                }

                maxArea = Math.max(maxArea, height * width);
            }

            S.push(i);
        }

        return maxArea;
    }
}