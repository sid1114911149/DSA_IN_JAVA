import java.util.*;
public class insertion_sort {
    public static void main(String args[]){
        Scanner sc=new Scanner(System.in);
        System.out.print("Enter the size of the arrayy:");
        int n=sc.nextInt();
        int arr[]=new int[n];
        System.out.println("Enter Elements:");
        for(int i=0;i<n;i++){
            arr[i]=sc.nextInt();
        }
        for(int i=1;i<n;i++){
            int j=i-1,pivot=arr[i];
            while(j>=0 && arr[j]>pivot){
                arr[j+1]=arr[j];
                j--;
            }
            arr[j+1]=pivot;
        }
        System.out.println("Elements After Sorting:");
        for(int i=0;i<n;i++){
            System.out.print(arr[i]+" ");
        }
        sc.close();
    }
}
