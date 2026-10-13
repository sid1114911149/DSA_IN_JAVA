import java.util.Arrays;
import java.util.Scanner;
public class Floyd_Warshall{
    public static int [][] find_distance(int Edges[][],int V,int E){
        int result[][]=new int[V][V];
        for(int i=0;i<V;i++){
            Arrays.fill(result[i],Integer.MAX_VALUE);
            result[i][i]=0;
        }
        for(int i=0;i<E;i++){
            int u=Edges[i][0];
            int v=Edges[i][1];
            int dist=Edges[i][2];
            result[u][v]=dist;
            result[v][u]=dist;

        }
        for(int i=0;i<V;i++){
            for(int j=0;j<V;j++){
                for(int k=0;k<V;k++){
                    if(result[i][j]!=Integer.MAX_VALUE && result[j][k]!=Integer.MAX_VALUE){
                        result[i][k]=Math.min(result[i][k],result[i][j]+result[j][k]);
                    }
                }
            }
        }
        return result;
    }
    public static void main(String Args[]){
        Scanner sc=new Scanner(System.in);
        int V,E;
        System.out.println("Enter No of vertices and Edges After Entering Above Enter Edges:");
        V=sc.nextInt();
        E=sc.nextInt();
        int Edges[][]=new int[E][3];
        for(int i=0;i<E;i++){
            Edges[i][0]=sc.nextInt();
            Edges[i][1]=sc.nextInt();
            Edges[i][2]=sc.nextInt();
        }
        int result[][]=find_distance(Edges,V,E);
        for(int i=0;i<V;i++){
            System.out.println(Arrays.toString(result[i])+"  ");
        }
        sc.close();
    }
}