import java.util.*;

public class Binary_search_tree {
    class Node {
        int data;
        Node right, left;

        Node(int data) {
            this.data = data;
            this.right = null;
            this.left = null;
        }
    }

    public Node insert(Node temp, int data) {
        if (temp == null) {
            return new Node(data);
        }
        if (data < temp.data) {
            temp.left = insert(temp.left, data);
        } else if (data > temp.data) {
            temp.right = insert(temp.right, data);
        }
        return temp;
    }
    public void inorder(Node temp) {
        if (temp == null) return;
        inorder(temp.left);
        System.out.print(temp.data + " ");
        inorder(temp.right);
    }

    public void preorder(Node temp) {
        if (temp == null) return;
        System.out.print(temp.data + " ");
        preorder(temp.left);
        preorder(temp.right);
    }

    public void postorder(Node temp) {
        if (temp == null) return;
        postorder(temp.left);
        postorder(temp.right);
        System.out.print(temp.data + " ");
    }
    public Node succ(Node temp) {
        temp = temp.right;
        while (temp != null && temp.left != null) {
            temp = temp.left;
        }
        return temp;
    }
    public Node delete(Node temp, int data) {
        if (temp == null) {
            return null;
        }
        if (data < temp.data) {
            temp.left = delete(temp.left, data);
        } else if (data > temp.data) {
            temp.right = delete(temp.right, data);
        } else {
        
            if (temp.left == null) {
                return temp.right;
            } else if (temp.right == null) {
                return temp.left;
            }
            Node succNode = succ(temp);
            temp.data = succNode.data;
            temp.right = delete(temp.right, succNode.data);
        }
        return temp;
    }
    public static void main(String args[]) {
        try (Scanner sc = new Scanner(System.in)) {
            Binary_search_tree B = new Binary_search_tree();
            Node head = null;
            int ch, n;
            do {
                System.out.print("ENTER \n1.INSERTION\n2.DELETION\n3.PREORDER TRAVERSAL\n4.INORDER TRAVERSAL\n5.POSTORDER TRAVERSAL\n6.EXITING:");
                ch = sc.nextInt();
                switch (ch) {
                    case 1 -> {
                        System.out.print("Enter value to be inserted: ");
                        n = sc.nextInt();
                        head = B.insert(head, n);
                    }
                    case 2 -> {
                        System.out.print("Enter value to be deleted: ");
                        n = sc.nextInt();
                        head = B.delete(head, n);
                    }
                    case 3 -> {
                        System.out.print("PREORDER TRAVERSAL: ");
                        B.preorder(head);
                        System.out.println();
                    }
                    case 4 -> {
                        System.out.print("INORDER TRAVERSAL: ");
                        B.inorder(head);
                        System.out.println();
                    }
                    case 5 -> {
                        System.out.print("POSTORDER TRAVERSAL: ");
                        B.postorder(head);
                        System.out.println();
                    }
                    case 6 -> System.out.println("EXITING...");
                    default -> System.out.println("No Command Found..");
                }
            } while (ch != 6);
        }
    }
}
