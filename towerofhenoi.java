public class towerofhenoi {
    public static void tower(int n,String src,String help,String dest){
        if(n==1){
            System.out.println("disk "+n+" is transfered from "+src+" to "+dest);
            return;
        }
        tower(n-1,src,dest,help);
        System.out.println("disk "+n+" is transfered from "+src+" to "+dest);
        tower(n-1,help,src,dest);
    }
    public static void main(String args[]){
        int n=5;
        tower(n,"S","H","D");
    }
}
