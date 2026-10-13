import java.util.*;
 public class Count_Sort{
    public static void count_sort(int arr[]){
        int Max = Arrays.stream(arr)
                        .max()
                        .getAsInt();
        int C[]=new int[Max+1];
        int N=arr.length;
        for(int i=0;i<N;i++){
            C[arr[i]]++;
        }
        for(int i=1;i<=Max;i++){
            C[i]+=C[i-1];
        }
        int newArr[]=new int [N];
        for(int i=0;i<N;i++){
            newArr[C[arr[i]]-1]=arr[i];
            C[arr[i]]--;
        }
        arr=newArr;
        System.out.print("Array After Sorting:");
        for(int i=0;i<N;i++){
            System.out.print(arr[i]+" ");
        }
    }
    public static void main(String args[]){
        Scanner S=new Scanner(System.in);
        int N;
        System.out.print("Enter Size of Array:");
        Random rand=new Random();
        N=S.nextInt();
        int arr[]=new int[N];
        for (int idx = 0; idx < arr.length; idx++) {
            arr[idx]=rand.nextInt(1000);
        }
        System.out.print("Array Before Sorting:");
        for(int i=0;i<N;i++){
            System.out.print(arr[i]+" ");
        }
        System.out.println("");
        count_sort(arr);
        S.close();
    }
 }