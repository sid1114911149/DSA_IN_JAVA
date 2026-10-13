import java.util.*;
public class MathWorks_Interview_DSA{
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        System.out.print("Enter Input Binary String:");
        String str=sc.next();
        System.out.print("Enter K:");
        int K=sc.nextInt();
        PriorityQueue<Integer> p=new PriorityQueue<>(Collections.reverseOrder());
        int N=str.length();
        int Prefix[]=new int[N];
        for(int i=0;i<N;i++){
            char c=str.charAt(i);
            if(c=='0'){
                Prefix[i]=0;
                continue ;
            }
            if(i==0){
                Prefix[i]=1;
            }else{
                Prefix[i]=Prefix[i-1]+1;
            }
        }
        int i=0;
        while(i<N){
            int j=i;
            if(Prefix[j]==0){
                i++;
                continue;
            }
            while(j<N && Prefix[j]>0){
                j++;
            }
            j--;
            p.add(Prefix[j]);
            i=j+1;
        }
        int Size=Math.min(p.size(),K+1);
        int Ans=0;
        while(Size>0){
            Ans+=p.peek();
            p.poll();
            Size--;
        }
        System.out.print("Length of Largest Substring after Performing at Most "+K+" substring reversals is "+Ans);
        sc.close();
    }
}