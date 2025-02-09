import java.util.*;
public class subsets {
    public static void print_subsets(ArrayList<Integer> set,Integer idx){
        if(idx==0){
            System.out.println(set);
            return ;
        }
        set.add(idx);
        print_subsets(set, idx-1);
        set.remove(set.size()-1);
        print_subsets(set, idx-1);
    }
    public static void main(String args[]){
        Scanner sc=new Scanner(System.in);
        ArrayList<Integer> set=new ArrayList<>();
       print_subsets(set, 5);
        sc.close();
    }
}
