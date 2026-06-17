public class Tower_of_hanoi{
    public static void main(String[] args) {
        int n = 3;
        Toh(n,"A","B","C");
    }
    public static void Toh(int n, String src,String hlp, String des){
        if(n==0){
            return;
        }
        Toh(n-1 , src, des,hlp);
        System.out.println("Move"+n+"th form "+ des+" to "+src);
        Toh(n-1 , hlp, src, des);
    }
}