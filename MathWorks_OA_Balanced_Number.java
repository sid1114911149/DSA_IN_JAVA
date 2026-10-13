import java.util.*;
public class MathWorks_OA_Balanced_Number{
    public static void main(String args[]){
        Scanner sc= new Scanner(System.in);
        System.out.print("Enter Value of N:");
        int N=sc.nextInt();
        int nums[]=new int[N];
        if(N==1){
            System.out.println("Binary Balanced string for given permutation Array is:1");
            return ;
        }
        System.out.print("Enter values of Array:");
        for(int i=0;i<N;i++){
            nums[i]=sc.nextInt();
        }
        int idxArray[]=new int[N+1];
        for(int i=0;i<N;i++){
            idxArray[nums[i]]=i;
        }
        int MinLeft=idxArray[1];
        int MaxRight=idxArray[1];
        StringBuilder Ans=new StringBuilder("1");
        for(int i=2;i<N;i++){
            MinLeft=Math.min(MinLeft,idxArray[i]);
            MaxRight=Math.max(MaxRight,idxArray[i]);
            int size=MaxRight-MinLeft+1;
            if(size==i){
                Ans.append('1');
            }else{
                Ans.append('0');
            }
        }
        Ans.append(1);
        System.out.println("Binary Balanced String if given permutation Array is:"+Ans);
        sc.close();
    }
}