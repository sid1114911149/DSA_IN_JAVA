import java.util.Arrays;
import java.util.Scanner;
public class Aggressive_Cows{
    public static boolean possible(int stalls[],int K,int target){
        int N=stalls.length;
        int left=0;
        int count=1;
        for(int right=0;right<N;right++){
            if((stalls[right]-stalls[left])>=target){
                count++;
                left=right;
            }
        }
        return count>=K;
    }
    public static int solve(int stalls[],int K){
        int N=stalls.length;
        int low=Integer.MAX_VALUE;
        for(int i=1;i<N;i++){
            low=Integer.min(low, stalls[i]-stalls[i-1]);
        }
        int high=stalls[N-1]-stalls[0];
        int Ans=-1;
        while(low<high){
            int mid=(low+high)>>1;
            if(possible(stalls, K, mid)){
                Ans=mid;
                low=mid+1;
            }else{
                high=mid;
            }
        }
        return Ans;
    }
    public static void main(String Args[]){
        Scanner sc=new Scanner(System.in);
        System.out.print("Enter N:");
        int N=sc.nextInt();
        int stalls[]=new int[N];
        System.out.print("Enter K:");
        int K=sc.nextInt();
        for(int i=0;i<N;i++){
            stalls[i]=sc.nextInt();
        }
        Arrays.sort(stalls);
        int result=solve(stalls,K);
        if(result==-1){
            System.out.println("Not Possible");
        }else{
            System.out.println("Maximum possible minimum distance between cows is:"+result);
        }
        sc.close();
    }
}