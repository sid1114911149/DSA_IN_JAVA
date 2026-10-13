import java.util.HashMap;
import java.util.Scanner;
import java.util.Stack;
public class Balanced_Parantheses{
    public static boolean solve(String str){
        Stack<Character> st=new Stack<>();
        HashMap<Character,Character> hp=new HashMap<>();
        hp.put(')','(');
        hp.put('}','{');
        hp.put(']','[');
        for(char c:str.toCharArray()){
            if(c=='(' || c=='{' || c=='['){
                st.push(c);
            }else if(hp.containsKey(c)){
                if(st.empty())
                    return false;
                if(st.peek()==hp.get(c)){
                    st.pop();
                }else{
                    return false;
                }
            }
        }
        return st.empty();
    }
    public static void main(String Args[]){
        Scanner sc=new Scanner(System.in);
        System.out.print("Enter Input :");
        String str=sc.next();
        if(solve(str)){
            System.out.println("Given input String "+str+" is Balanced");
        }else{
            System.out.println("Given input String "+str+" is NOT Balanced");
        }
        sc.close();
    }
}   