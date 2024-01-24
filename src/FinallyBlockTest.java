public class FinallyBlockTest {

    public static void main(String[] args) {

        checkFinally(10);
    }

   static void checkFinally(int i){
        try{
            if(i==10)return ;
        }finally {
            System.out.println("finally executed");
        }
    }


}
