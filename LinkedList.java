import java.util.Scanner;
public class LinkedList {

    class Node {
        int data;
        Node next;

        Node(int data) {
            this.data = data;
            this.next = null;
        }
    }

    Node head = null;
    int size=0;
    public void insert_back(int data) {
        Node newNode = new Node(data);
        size++;
        if (head == null) {
            head = newNode;
            return;
        }

        Node temp = head;
        while (temp.next != null) {
            temp = temp.next;
        }
        temp.next = newNode;
    }
    public void insert_front(int data){
        size++;
        if(head==null){
            head=new Node(data);
        }else{
            Node temp=new Node(data);
            temp.next=head;
            head=temp;
        }
    }
    public void insert(int k,int data){
        if(k<=0 || k>size){
            return ;
        }
        if(k==1){
            insert_front(data);
        }else if(k==size){
            insert_back(data);
        }else{
            Node temp=head;
            for(int i=1;i<k-1;i++){
                temp=temp.next;
            }
            Node temp2=new Node(data);
            temp2.next=temp.next;
            temp.next=temp2;
        }
    }
    public void delete_front(){
        if(head==null){
            return ;
        }else{
            head=head.next;
        }
        size--;
    }
    public void delete_back(){
        if(head==null){
            return ;
        }else{
            Node temp=head;
            if(temp.next==null){
                head=head.next;
            }else{
                while(temp.next.next!=null){
                    temp=temp.next;
                }
                temp.next=null;
            }
        }
        size--;
    }
    public void delete(int k){
        if(k>size){
            System.out.println("Entered position is Invalid..");
            return ;
        }
        if(k==1){
            delete_front();
        }else if(k==size){
            delete_back();
        }else{
            Node temp=head;
            for(int i=1;i<k;i++){
                temp=temp.next;
            }
            temp.next=temp.next.next;
            size--;
        }
        return ;
    }
    public void reverse(){
        if(head==null){
            return ;
        }
        Node next=null,prev=null,curr=head;
        while(curr!=null){
            next=curr.next;
            curr.next=prev;
            prev=curr;
            curr=next;
        }
        head=prev;
    }
    public void print() {
        if (head == null) {
            System.out.println("Linked List is Empty");
            return;
        }

        Node temp = head;
        while (temp != null) {
            System.out.print(temp.data + " ");
            temp = temp.next;
        }
        System.out.println();
    }

    public static void main(String[] args) {
        LinkedList l = new LinkedList();
        Scanner sc=new Scanner(System.in);
        int op,in,k;
        do { 
            System.out.print("ENTER\n1.insert at front\n2.insert at end\n3.insert at position k\n4.deletion at front\n5.deletion at end\n6.deletion at position k\n7.print List\n\n8.Reversing the List\n9.Exit..:");
            op=sc.nextInt();
            switch(op){
                case 1:
                    System.out.print("Enter Data:");
                    in=sc.nextInt();
                    l.insert_front(in);
                    break;
                case 2:
                    System.out.print("Enter Data:");
                    in=sc.nextInt();
                    l.insert_back(in);
                    break;
                case 3:
                    System.out.print("Enter Data and position(based on 1-indexed):");
                    in=sc.nextInt();
                    k=sc.nextInt();
                    l.insert(k,in);
                    break;
                case 4:
                    l.delete_front();
                    break;
                case 5:
                    l.delete_back();
                    break;
                case 6:
                    System.out.print("Enter position(based on 1-indexed):");
                    k=sc.nextInt();
                    l.delete(k);
                    break;
                case 7:
                    l.print();
                    break;
                case 8:
                    l.reverse();
                    break;
                case 9:
                    System.out.println("Exiting..");
                    break;
                default:
                    System.out.println("Invalid Option Entered...");
                    break;
            }
        } while (op!=9);
        sc.close();
    }
}
