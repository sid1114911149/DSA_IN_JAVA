import java.util.Arrays;
import java.util.Scanner;
public class Bellman_Ford{
    public static int [] solve(int Edges[][],int V,int src){
        int ans[]=new int[V];
        int E=Edges.length;
        for(int i=0;i<V;i++){
            ans[i]=Integer.MAX_VALUE;
        }
        ans[src]=0;
        for(int i=0;i<V-1;i++){
            for(int j=0;j<E;j++){
                if(ans[Edges[j][0]]!=Integer.MAX_VALUE){
                    ans[Edges[j][1]]=Integer.min(ans[Edges[j][1]],ans[Edges[j][0]]+Edges[j][2]);
                }
            }
        }
        return ans;
    }
    public static void main(String Args[]){
        Scanner sc=new Scanner(System.in);
        int V,E;
        System.out.print("Enter No of Vertcices and Edges:");
        V=sc.nextInt();
        E=sc.nextInt();
        int Edges[][]=new int[E][3];
        System.out.println("Enter Egdes in the format (src dest dist):"); 
        for(int i=0;i<E;i++){
            Edges[i][0]=sc.nextInt();
            Edges[i][1]=sc.nextInt();
            Edges[i][2]=sc.nextInt();
        }
        int src;
        System.out.print("Enter Source:");
        src=sc.nextInt();
        int Ans[]=solve(Edges,V,src);
        System.out.println(Arrays.toString(Ans));
        sc.close();
    }
}