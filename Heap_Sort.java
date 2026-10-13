import java.util.Arrays;
import java.util.Scanner;
public class Heap_Sort{
    public static final int Max=10;
    public static class Heap{
        public int heap[];
        public int Size;
        public Heap(){
            this.heap=new int[Max];
            this.Size=0;
        }
        public void insert(int data){
            if(Size==0){
                heap[Size++]=data;
                return ;
            }
            heap[Size++]=data;
            int child=Size;
            int parent=(child-1)/2;
            while(parent>=0 && heap[parent]<heap[child]){
                int temp=heap[parent];
                heap[parent]=heap[child];
                heap[child]=temp;
                child=parent;
                parent=(child-1)/2;
            }
            return ;
        }
        public void heapify(int MaxIdx){
            int parent=0;
            int left_child=2*parent+1;
            int right_child=2*parent+2;
            while(right_child<MaxIdx){
                int MaxValue=Integer.max(heap[parent],Integer.max(heap[left_child],heap[right_child]));
                if(MaxValue==heap[parent])  
                    return ;
                else if(MaxValue==heap[left_child]){
                    int temp=heap[parent];
                    heap[parent]=heap[left_child];
                    heap[left_child]=temp;
                    parent=left_child;
                }else{
                    int temp=heap[parent];
                    heap[parent]=heap[right_child];
                    heap[right_child]=temp;
                    parent=right_child;
                }
                left_child=2*parent+1;
                right_child=2*parent+2;
            }
        }
        public void heapSort(){
            if(Size<=1){
                System.out.println("Heap is Already Sorted..");
                return ;
            }
            int idx=Size-1;
            while(idx>0){
                int temp=heap[0];
                heap[0]=heap[idx];
                heap[idx]=temp;
                idx--;
                heapify(idx);
            }
        }
    }

    public static void main(String Args[]){
        Scanner sc=new Scanner(System.in);
        int N;
        System.out.println("Enter Size of the Heap:");
        N=sc.nextInt();
        Heap H=new Heap();
        for(int i=0;i<N;i++){
            H.insert((int)(Math.random()*1000));
        }
        System.out.println("Heap Before Sorting..."+Arrays.toString(H.heap));
        H.heapSort();
        System.out.println("Heap After Sorting..."+Arrays.toString(H.heap));
        sc.close();
    }
}