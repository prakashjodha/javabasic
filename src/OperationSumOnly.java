public class OperationSumOnly {

    public static void main(String[] args) {
        System.out.println(getNegation(-1));
        System.out.println(doSubTraction(-10,4));
        System.out.println(doMultiplication(4,4));
        System.out.println(doDivision(2,2));
    }

    static int doSubTraction(int a, int b){
        return a+getNegation(b);
    }

    static int abs(int a){
        if(a<0)return getNegation(a);
        else return a;
    }

    static int doDivision(int a, int b) throws ArithmeticException{
        if(b==0) throw new ArithmeticException("Divide by Zero.");
        int divisor=0;
        int absA=abs(a);
        int absB=abs(b);
        while(a>=b){
            b+=b;
            divisor++;
        }
        if((a<0 && b<0)||(a>0||b>0))
        return divisor;
        else return getNegation(divisor);
    }

    static int doMultiplication(int a, int b){
        int product=0;
        while(a>0){
            product+=b;
            a--;
        }
        return product;
    }

    static int getNegation(int a){
        int neg=0;
        int newsign=a<0?1:-1;
        while(a!=0){
            neg+=newsign;
            a+=newsign;
        }
        return neg;
    }
}
