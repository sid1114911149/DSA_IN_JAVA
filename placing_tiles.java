import java.util.*;
public class placing_tiles {
    public static int count=0;
    public static int find_ways(int n,int m){
        if(n<m){
            return 1;
        }
        if(n==m){
            return 2;
        }
        return find_ways(n-m,m)+find_ways(n-1,m);
    }
    public static void main(String args[]){
        Scanner sc=new Scanner(System.in);
        System.out.println("Total bno of ways  of placing the tiles is: "+ find_ways(4,2));
        sc.close();
    }
}
