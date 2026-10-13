import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;
public class Cycle_Detection_Directed_Kahn_Algorithm{
    public static boolean Detect_Cycle(ArrayList<ArrayList<Integer>> Adj,int Edges[][],int V,int E){
        int indegree[]=new int[V];
        Arrays.fill(indegree, 0);
        for(int i=0;i<E;i++){
            indegree[Edges[i][1]]++;
        }
        Queue<Integer> q=new LinkedList<>();
        int Count=0;
        for(int i=0;i<V;i++){
            if(indegree[i]==0){
                Count++;
                q.add(i);
            }
        }
        while(!q.isEmpty()){
            int src=q.poll();
            for(int i=0;i<Adj.get(src).size();i++){
                if(indegree[Adj.get(src).get(i)]==0)
                    continue ;
                indegree[Adj.get(src).get(i)]--;
                if(indegree[Adj.get(src).get(i)]==0){
                    Count++;
                    q.add(Adj.get(src).get(i));
                }
            }
        }
        return Count!=V;
    }
    public static void main(String Args[]){
        Scanner sc=new Scanner(System.in);
        int V,E;
        System.out.print("Enter No of Vertices(V) and Edges(E):");
        V=sc.nextInt();
        E=sc.nextInt();
        int Edges[][]=new int[E][2];
        System.out.print("Enter Edges in the Format( src,dest):");
        for(int i=0;i<E;i++){
            Edges[i][0]=sc.nextInt();
            Edges[i][1]=sc.nextInt();
        }
        ArrayList<ArrayList<Integer>> Adj=new ArrayList<>();
        for(int i=0;i<V;i++){
            Adj.add(new ArrayList<>());
        }
        for(int i=0;i<E;i++){
            Adj.get(Edges[i][0]).add(Edges[i][1]);
        }
        if(Detect_Cycle(Adj,Edges,V,E)){
            System.out.println("Cycle detected in the Given Graph");
        }else{
            System.out.println("Cycle is NOT detected in the Given Graph");
        }
        sc.close();
    }
}