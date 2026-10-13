import java.util.*;
import java.util.Stack;
class Next_Greater_Element {
    public ArrayList<Integer> nextLargerElement(int[] arr) {
        int N = arr.length;

        ArrayList<Integer> Ans = new ArrayList<>(Collections.nCopies(N, -1));
        Stack<Integer> S = new Stack<>();

        for (int i = N - 1; i >= 0; i--) {

            while (!S.isEmpty() && S.peek() <= arr[i]) {
                S.pop();
            }

            if (!S.isEmpty()) {
                Ans.set(i, S.peek());
            }

            S.push(arr[i]);
        }

        return Ans;
    }
}