import java.util.Arrays;
import java.util.Scanner;
public class Count_Inversions{
    public static int Merge(int Arr[],int low,int high){
        int mid=(low+high)>>1;
        int left_size=mid-low+1;
        int right_size=high-mid;
        int left_Arr[]=new int[left_size];
        int right_Arr[]=new int[right_size];
        for(int i=0;i<left_size;i++){
            left_Arr[i]=Arr[low+i];
        }
        for(int i=0;i<right_size;i++){
            right_Arr[i]=Arr[mid+i+1];
        }
        int Count=0;
        int left_idx=0;
        int right_idx=0;
        int main_idx=low;
        while(left_idx<left_size && right_idx<right_size){
            if(left_Arr[left_idx]>right_Arr[right_idx]){
                Count+=(left_size-left_idx);
                Arr[main_idx++]=right_Arr[right_idx++];
            }else{
                Arr[main_idx++]=left_Arr[left_idx++];
            }
        }
        while(left_idx<left_size){
            Arr[main_idx++]=left_Arr[left_idx++];
        }
        while(right_idx<right_size){
            Arr[main_idx++]=right_Arr[right_idx++];
        }
        return Count;
    }
    public static int Divide(int Arr[],int low,int high){
        if(low>=high)
            return 0;
        int mid=low+(high-low)/2;
        int left=Divide(Arr,low,mid);
        int right=Divide(Arr,mid+1,high);
        int merge=Merge(Arr,low,high);
        return left+merge+right;
    }
    public static void main(String Args[]){
        Scanner sc=new Scanner(System.in);
        int N;
        System.out.print("Enter Size of The Array:");
        N=sc.nextInt();
        int Arr[]=new int[N];
        for(int i=0;i<N;i++){
            Arr[i]=(int)(Math.random()*1000);
        }
        System.out.println("Input Array is:"+Arrays.toString(Arr));
        System.out.println("Total No of Conversions is:"+Divide(Arr, 0, N-1));
        sc.close();
    }
}