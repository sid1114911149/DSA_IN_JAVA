import java.util.*;
public class number_estimation_game{
    public static void main(String args[]){
        int n=(int)(Math.random()*100);
        int a;
        Scanner sc=new Scanner(System.in);
        do{
            System.out.println("enter value between 1 to 100:");
            a=sc.nextInt();
            if(a>n){
                System.out.println("your estimation is too high");
            }
            else if(a<n){
                System.out.println("your estimation is too low");
            }
        }while(a!=n);
        System.out.println("CONGRATS you have gussed correctly");
        sc.close();
    }
}