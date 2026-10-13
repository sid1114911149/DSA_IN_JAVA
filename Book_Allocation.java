import java.util.Arrays;
import java.util.Scanner;
public class Book_Allocation{
    public static boolean isPossible(int pages[],int k,long  target){
        int count=0;
        int n=pages.length;
        long curr=0;
        for(int i=0;i<n;i++){
            if(pages[i]>target)
                return false;
            curr+=pages[i];
            if(curr>=target){
                count++;
                curr=0;
            }
        }
        return count<=k;
    } 
    public static long findMinPages(int pages[],int k){
        long high=Arrays.stream(pages).sum();
        long low=Arrays.stream(pages).max().getAsInt();
        long ans=-1;
        while(low<=high){
            long mid=(low+high)>>1;
            if(isPossible(pages, k, mid)){
                ans=mid;
                high=mid-1;
            }else{
                low=mid+1;
            }
        }
        return ans;
    }
    public static void main(String Args[]){
        Scanner sc=new Scanner(System.in);
        int n;
        System.out.print("Enter N:");
        n=sc.nextInt();
        int pages[]=new int[n];
        for(int i=0;i<n;i++){
            pages[i]=(int)(Math.random()*1000);
        }
        int k;
        System.out.print("Enter K:");
        k=sc.nextInt();
        long res=findMinPages(pages,k);
        System.out.println("The Pages Array is:"+Arrays.toString(pages));
        System.out.println("Minimum No of Maximum pages allocated to each student is:"+res);
        sc.close();
    } 
}