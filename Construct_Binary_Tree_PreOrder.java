import java.util.HashMap;
import java.util.Scanner;
public class Construct_Binary_Tree_PreOrder{
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
    public void postOrder(Node root){
        if(root==null)
            return ;
        postOrder(root.left);
        postOrder(root.right);
        System.out.print(root.data+" ");
    }
    public int preIdx=0;
    public Node construct(int preorder[],HashMap<Integer,Integer> hp,int low,int high){
        if(low>high || preIdx>=preorder.length)
            return null;
        Node root=new Node(preorder[preIdx]);
        int idx=hp.get(preorder[preIdx++]);
        root.left=construct(preorder,hp,low,idx-1);
        root.right=construct(preorder, hp, idx+1, high);
        return root;
    }
    public void main(String Args[]){
        Scanner sc=new Scanner(System.in);
        int n;
        System.out.print("Enter No of Nodes:");
        n=sc.nextInt();
        int inorder[]=new int[n];
        int preorder[]=new int[n];
        System.out.println("Enter Inorder Sequence:");
        for(int i=0;i<n;i++){
            inorder[i]=sc.nextInt();
        }
        System.out.println("Enter Preorder Sequence:");
        for(int i=0;i<n;i++){
            preorder[i]=sc.nextInt();
        }
        HashMap<Integer,Integer> hp=new HashMap<>();
        for(int i=0;i<n;i++){
            hp.put(inorder[i],i);
        }
        BinaryTree B=new BinaryTree();
        B.root=construct(preorder,hp,0,n-1);
        System.out.print("Preorder Sequenec of Constructed Binary Tree is:");
        postOrder(B.root);
        sc.close();
    }
}