public class Main {
    public static void main(String[] args) {

        int num1=0, num2=1;
        int[] arr= new int[]{5,10,12,34,25,78,88};

        System.out.println(getSumArray(arr,num1,num2));
    }

    static int getSumArray(int[] array, int num1, int num2){
        int numl1=num1;
        int numl2=num2;
        int sum=numl1+numl2;
        int arraySum=array[numl1]+array[numl2];
        while(sum<array.length){

            arraySum=arraySum+array[sum];
            numl1=numl2;
            numl2=sum;
            System.out.println("index "+sum);
            sum=numl1+numl2;
        }
        return arraySum;
    }
}