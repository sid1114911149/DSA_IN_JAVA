import java.util.HashMap;
import java.util.Scanner;
public class Construct_Binary_Tree_PostOrder{
    public class Node{
        public int data;
        public Node left,right;
        public Node(int data){
            this.data=data;
            this.left=this.right=null;
        }
    }
    public class BinaryTree{
        public Node root;

        public BinaryTree() {
            this.root=null;
        }
    }
    public static int postIdx;
    public void preOrder(Node root){
        if(root==null)
            return ;
        System.out.print(root.data+" ");
        preOrder(root.left);
        preOrder(root.right);
    }
    public Node construct(int postorder[],HashMap<Integer,Integer> hp,int low,int high){
            if(low>high || postIdx<0)
                return null;
            Node root=new Node(postorder[postIdx]);
            int idx=hp.get(postorder[postIdx]);
            postIdx--;
            root.right=construct(postorder,hp,idx+1,high);
            root.left=construct(postorder,hp,low,idx-1);
            return root;
        }
    public void main(String Args[]){
        Scanner sc=new Scanner(System.in);
        int n;
        System.out.print("Enter No of Nodes:");
        n=sc.nextInt();
        int inorder[]=new int[n];
        int postorder[]=new int[n];
        System.out.println("Enter Inorder Sequence:");
        for(int i=0;i<n;i++){
            inorder[i]=sc.nextInt();
        }
        System.out.println("Enter Postorder Sequence:");
        for(int i=0;i<n;i++){
            postorder[i]=sc.nextInt();
        }
        HashMap<Integer,Integer>  hp=new HashMap<>();
        for(int i=0;i<n;i++){
            hp.put(inorder[i], i);
        }
        BinaryTree B=new BinaryTree();
        postIdx=n-1;
        B.root=construct(postorder,hp,0,n-1);
        System.out.println("Preorder Sequenec of Constructed Binary Tree is:");
        preOrder(B.root);
        sc.close();
    }
}