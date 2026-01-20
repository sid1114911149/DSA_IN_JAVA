import java.util.Scanner;
public class WaterMelon{
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        int input=sc.nextInt();
        if(input%2==0 && input>2){
            System.out.println("YES");
        }else{
            System.out.println("NO");
        }
        sc.close();
    }
}