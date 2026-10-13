
import java.util.Scanner;

public class Flatten_BST_LinkedList {

    public class Node {
        public int data;
        public Node left, right;

        public Node(int data) {
            this.data = data;
            this.left = this.right = null;
        }
    }

    public class ListNode {
        public int data;
        public ListNode prev, next;

        public ListNode(int data) {
            this.data = data;
            this.prev = this.next = null;
        }
    }

    public class BST {
        public Node root;

        public BST() {
            root = null;
        }

        public void insert(int data) {
            root = insertion(root, data);
        }

        private Node insertion(Node root, int data) {
            if (root == null) {
                return new Node(data);
            }

            if (root.data > data) {
                root.left = insertion(root.left, data);
            } else {
                root.right = insertion(root.right, data);
            }

            return root;
        }
    }

    // Stores the head and tail of the flattened list
    public class ListInfo {
        ListNode head, tail;

        public ListInfo(ListNode head, ListNode tail) {
            this.head = head;
            this.tail = tail;
        }
    }

    // Flatten BST into a doubly linked list in O(N)
    public ListInfo flattenEfficient(Node root) {
        if (root == null) {
            return new ListInfo(null, null);
        }

        ListInfo left = flattenEfficient(root.left);
        ListInfo right = flattenEfficient(root.right);

        ListNode curr = new ListNode(root.data);

        // Connect left list's tail to current node
        if (left.tail != null) {
            left.tail.next = curr;
            curr.prev = left.tail;
        }

        // Connect current node to right list's head
        if (right.head != null) {
            curr.next = right.head;
            right.head.prev = curr;
        }

        ListNode head = (left.head != null)
                ? left.head : curr;

        ListNode tail = (right.tail != null)
                ? right.tail : curr;

        return new ListInfo(head, tail);
    }

    // Print list from head to tail
    public void printForward(ListNode head) {
        ListNode curr = head;

        while (curr != null) {
            System.out.print(curr.data + " ");
            curr = curr.next;
        }

        System.out.println();
    }

    // Print list from tail to head
    public void printBackward(ListNode tail) {
        ListNode curr = tail;

        while (curr != null) {
            System.out.print(curr.data + " ");
            curr = curr.prev;
        }

        System.out.println();
    }

    public static void main(String[] Args) {
        Scanner sc = new Scanner(System.in);

        Flatten_BST_LinkedList obj =
                new Flatten_BST_LinkedList();

        BST bst = obj.new BST();

        System.out.print("Enter number of nodes: ");
        int N = sc.nextInt();

        System.out.println("Enter BST elements:");

        for (int i = 0; i < N; i++) {
            bst.insert(sc.nextInt());
        }

        ListInfo result = obj.flattenEfficient(bst.root);

        System.out.println("Doubly Linked List (Forward):");
        obj.printForward(result.head);

        System.out.println("Doubly Linked List (Backward):");
        obj.printBackward(result.tail);

        sc.close();
    }
}
