public class PowerFunction {

    public static void main(String[] args) {
        System.out.println(getPower(2,10));
    }

    static long getPower(int number, int power){
        long powerNum=1;
        for(int i=0;i<power;i++){
            powerNum*=number;
        }
        return powerNum;
    }
}
