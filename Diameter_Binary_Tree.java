
public class Diameter_Binary_Tree {

    // Node class
    public class Node {
        int data;
        Node left, right;

        public Node(int data) {
            this.data = data;
            this.left = null;
            this.right = null;
        }
    }

    // Binary Tree class
    public class Binary_Tree {
        Node root;

        public Binary_Tree() {
            root = null;
        }
    }

    // Stores the maximum diameter
    public int Ans = 0;

    // Calculates height and updates diameter
    public int Cal_Diameter(Node root) {
        if (root == null)
            return 0;

        int l = Cal_Diameter(root.left);
        int r = Cal_Diameter(root.right);

        // Diameter passing through the current node
        Ans = Math.max(Ans, l + r + 1);

        // Return height of the current subtree
        return Math.max(l, r) + 1;
    }

    public static void main(String Args[]) {

        Diameter_Binary_Tree obj = new Diameter_Binary_Tree();
        Binary_Tree tree = obj.new Binary_Tree();

        /*
                 1
                / \
               2   3
              / \
             4   5
        */

        // Creating the example tree
        tree.root = obj.new Node(1);
        tree.root.left = obj.new Node(2);
        tree.root.right = obj.new Node(3);
        tree.root.left.left = obj.new Node(4);
        tree.root.left.right = obj.new Node(5);

        // Calculate diameter
        obj.Cal_Diameter(tree.root);

        System.out.println("Diameter of Binary Tree = " + obj.Ans);
    }
}
