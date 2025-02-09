import java.util.*;
public class maze_route {
    public static int count=0;
    public static void find_route(int pr,int pc,int dr,int dc){
        if(pr >dr || pc > dc){
            return ;
        }
        if(pr==dr && pc ==dc){
            count++;
            return ;
        }
        find_route(pr+1, pc, dr, dc);
        find_route(pr, pc+1, dr, dc);
    }
    public static void main(String args[]){
        Scanner sc=new Scanner(System.in);
        find_route(0, 0, 5, 5);
        System.out.println("Total no of ways the maze can be solved is :"+count);
        sc.close();
    }
}
