public class Fabonaci {

    public static void main(String[] args) {
        printFibonic(10);
    }


    static int fibonaciSimple(int n){
        if (n==0) return 0;
        if (n==1) return 1;
        return fibonaciSimple(n-1) + fibonaciSimple(n-2);
    }

    static void printFibonic(int n){
        System.out.print(0+" "+1+", ");
        int a=0;
        int b=1;
        int i=0;
        while(i<n){
            System.out.print(a+b);
            System.out.print(", ");
            int tmp=a+b;
            a=b;
            b=tmp;
            i++;
        }
    }
}
