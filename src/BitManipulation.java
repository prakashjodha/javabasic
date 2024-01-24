public class BitManipulation {

    public static void main(String[] args) {
      //  playBitMani();
        printBinaryString(8);
    }

    static void printBinaryString(int number){
        int mask=1;
        int counter=0;
        StringBuilder sb=new StringBuilder();
        while(number>0){
            int num=number&mask;
            sb.append(num);
            number=number>>1;
        }
        System.out.println(sb.reverse());
    }

    static void playBitMani(){
        int i=10;
        int num=20;
        System.out.println(Integer.bitCount(8));
        System.out.println(Integer.toBinaryString((1<<i)-1));

    }

    static void playBitMani2(){
        int i=10;
        int num=20;
        System.out.println(Integer.bitCount(7));
        System.out.println(Integer.toBinaryString((1<<i)-1));

    }
}
