import java.util.*;
public class merge_sort {
    public static void merge(int arr[],int l,int h,int mid){
        int lsize=mid-l+1,rsize=h-mid;
        int larr[]=new int[lsize];
        int rarr[]=new int[rsize];
        for(int i=0;i<lsize;i++){
            larr[i]=arr[l+i];
        }
        for(int i=0;i<rsize;i++){
            rarr[i]=arr[mid+1+i];
        }
        for(int i=l,j=0,k=0;i<=h;i++){
            if(( j<lsize && larr[j]<rarr[k] ) || k>=rsize){
                arr[i]=larr[j];
                j++;
            }
            else{
                arr[i]=rarr[k];
                k++;
            }
        }
    }
    public static void divide(int arr[],int l,int h){
        if(l<h){
            int mid=l+(h-l)/2;
            divide(arr,l,mid);
            divide(arr,mid+1,h);
            merge(arr,l,h,mid);
        }
    }
    public static void main(String args[]){
        Scanner sc=new Scanner(System.in);
        // System.out.print("Ente the size of the Array:");
        // int n=sc.nextInt();
        int arr[]={986,45,65,246,1};
        int n=5;
        // System.out.print("Enter elements:");
        // for(int i=0;i<n;i++){
        //     arr[i]=sc.nextInt();
        // }
        divide(arr,0,n-1);
        System.out.println("Elements After sorting:");
        for(int i=0;i<n;i++){
            System.out.print(arr[i]+" ");
        }
        sc.close();
    }
}
