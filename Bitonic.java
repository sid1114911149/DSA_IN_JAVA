import java.util.Arrays;
import java.util.Scanner;
public class Bitonic{
    public static int MaxBitonicSequence(int arr[]){
        int n=arr.length;
        int Lis[]=new int[n];
        int Lds[]=new int[n];
        Arrays.fill(Lis,1);
        Arrays.fill(Lds,1);
        for(int i=1;i<n;i++){
            for(int j=0;j<i;j++){
                if(arr[j]<=arr[i]){
                    Lis[i]=Integer.max(Lis[i],Lis[j]+1);
                }
            }
        }
        for(int i=n-2;i>=0;i--){
            for(int j=n-1;j>i;j--){
                if(arr[j]<=arr[i]){
                    Lds[i]=Integer.max(Lds[i],Lds[j]+1);
                }
            }
        }
        int res=1;
        for(int i=0;i<n;i++){
            res=Integer.max(res,Lis[i]+Lds[i]-1);
        }
        return res;
    }
    public static void main(String Args[]){
        Scanner sc=new Scanner(System.in);
        int n;
        System.out.print("Enter N:");
        n=sc.nextInt();
        int arr[]=new int[n];
        for(int i=0;i<n;i++){
            arr[i]=(int)(Math.random()*1000);
        }
        System.out.println("Input Array is:"+Arrays.toString(arr));
        int res=MaxBitonicSequence(arr);
        System.out.println("Maximum Bitonic Sequence Length for given input Array is:"+res);
        sc.close();
    }
}