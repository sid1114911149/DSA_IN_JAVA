import java.util.*;
public class party_pairs {
    public static int find_ways(int n){
        if(n==0){
            return 0;
        }else if(n==1){
            return 1;
        }else if(n==2){
            return 2;
        }
        return find_ways(n-1)+(n-1)*find_ways(n-2);
    }
    public static void main(String args[]){
        Scanner sc=new Scanner(System.in);
        System.out.println(find_ways(3));
        sc.close();
    }
}
