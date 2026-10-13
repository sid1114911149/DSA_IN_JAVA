
import java.util.Scanner;

public class Height_Balanced_BST {

    public static class Node {
        public int data;
        public Node left, right;

        public Node(int data) {
            this.data = data;
            this.left = this.right = null;
        }
    }

    // Right Rotation
    public static Node RightRotate(Node root) {
        Node temp = root.left;
        root.left = temp.right;
        temp.right = root;
        return temp;
    }

    // Left Rotation
    public static Node LeftRotate(Node root) {
        Node temp = root.right;
        root.right = temp.left;
        temp.left = root;
        return temp;
    }

    // Calculate Height
    public static int CalHeight(Node root) {
        if (root == null)
            return 0;

        int l = CalHeight(root.left);
        int r = CalHeight(root.right);

        return Math.max(l, r) + 1;
    }

    // Calculate Balance Factor
    public static int CalBF(Node root) {
        if (root == null)
            return 0;

        return CalHeight(root.left) - CalHeight(root.right);
    }

    // Insertion in AVL Tree
    public static Node insertion(Node root, int data) {

        if (root == null)
            return new Node(data);

        if (data < root.data) {
            root.left = insertion(root.left, data);
        } else if (data > root.data) {
            root.right = insertion(root.right, data);
        } else {
            return root; // Ignore duplicate values
        }

        int bf = CalBF(root);

        // LL Case
        if (bf > 1 && data < root.left.data) {
            return RightRotate(root);
        }

        // LR Case
        if (bf > 1 && data > root.left.data) {
            root.left = LeftRotate(root.left);
            return RightRotate(root);
        }

        // RR Case
        if (bf < -1 && data > root.right.data) {
            return LeftRotate(root);
        }

        // RL Case
        if (bf < -1 && data < root.right.data) {
            root.right = RightRotate(root.right);
            return LeftRotate(root);
        }

        return root;
    }

    // Find Inorder Successor
    public static Node getSuc(Node root) {
        Node temp = root.right;

        while (temp != null && temp.left != null) {
            temp = temp.left;
        }

        return temp;
    }

    // Deletion from AVL Tree
    public static Node Deletion(Node root, int data) {

        if (root == null)
            return null;

        if (data < root.data) {
            root.left = Deletion(root.left, data);
        } else if (data > root.data) {
            root.right = Deletion(root.right, data);
        } else {

            // Case 1: No child
            if (root.left == null && root.right == null) {
                return null;
            }

            // Case 2: Only right child
            else if (root.left == null) {
                return root.right;
            }

            // Case 3: Only left child
            else if (root.right == null) {
                return root.left;
            }

            // Case 4: Two children
            else {
                Node succ = getSuc(root);
                root.data = succ.data;
                root.right = Deletion(root.right, succ.data);
            }
        }

        // Recalculate balance factor
        int bf = CalBF(root);

        // Left Heavy
        if (bf > 1) {
            int leftBF = CalBF(root.left);

            // LL Case
            if (leftBF >= 0) {
                return RightRotate(root);
            }

            // LR Case
            root.left = LeftRotate(root.left);
            return RightRotate(root);
        }

        // Right Heavy
        if (bf < -1) {
            int rightBF = CalBF(root.right);

            // RR Case
            if (rightBF <= 0) {
                return LeftRotate(root);
            }

            // RL Case
            root.right = RightRotate(root.right);
            return LeftRotate(root);
        }

        return root;
    }

    // Binary Search Tree Wrapper
    public static class BST {
        public Node root;

        public BST() {
            root = null;
            System.out.println("New AVL Tree created successfully.");
        }

        public void insert(int data) {
            root = insertion(root, data);
        }

        public void Delete(int data) {
            root = Deletion(root, data);
        }

        public void inorder(Node root) {
            if (root == null)
                return;

            inorder(root.left);
            System.out.print(root.data + " ");
            inorder(root.right);
        }

        public void display() {
            inorder(root);
            System.out.println();
        }
    }

    public static void main(String Args[]) {

        Scanner sc = new Scanner(System.in);

        BST B = new BST();

        System.out.print("Enter number of nodes to insert: ");
        int N = sc.nextInt();

        System.out.println("Enter node values:");

        for (int i = 0; i < N; i++) {
            B.insert(sc.nextInt());
        }

        System.out.print("Inorder Traversal: ");
        B.display();

        System.out.print("Enter value to be deleted: ");
        int value = sc.nextInt();

        B.Delete(value);

        System.out.print("After Deletion: ");
        B.display();

        sc.close();
    }
}
