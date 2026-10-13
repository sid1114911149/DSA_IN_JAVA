import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;
public class Cycle_Detection_UnDirected_Graph{
    public static boolean Detect_Cycle(ArrayList<ArrayList<Integer>> Adj,int Edges[][],int V,int E){
        boolean visited[]=new boolean[V];
        Queue<Integer> q=new LinkedList<>();
        Arrays.fill(visited,false);
        for(int i=0;i<V;i++){
            if(!visited[i]){
                q.add(i);
                visited[i]=true;
                Queue<Integer> ParentQ=new LinkedList<>();
                ParentQ.add(-1);
                while(!q.isEmpty()){
                    int src=q.poll();
                    int parent=ParentQ.poll();
                    for(int nbr:Adj.get(src)){
                        if(!visited[nbr]){
                            visited[nbr]=true;
                            q.add(nbr);
                            ParentQ.add(src);
                        }else if(nbr!=parent){
                            return true;
                        }
                    }
                }
            }
        }
        return false;
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