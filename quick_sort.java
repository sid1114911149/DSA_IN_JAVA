import java.util.*;
public class quick_sort {
    public static int sort(int arr[],int l,int h){
        int mid=l+(h-l)/2;
        int pivot=arr[l];
        int i=l,j=h,temp;
        while(i<j){
            while(i<=h-1 && arr[i] <= pivot)
                i++;
            while(j>=l+1 && arr[j] >= pivot)    
                j--;
            if(i<j){
                temp=arr[i];
                arr[i]=arr[j];
                arr[j]=temp;
            }
        }
        temp=arr[l];
        arr[l]=arr[j];
        arr[j]=temp;
        return j;
    }
    public static void divide(int arr[],int l,int h){
        if(l<h){
            int j=sort(arr,l,h);
            divide(arr,l,j-1);
            divide(arr,j+1,h);
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
