public class ThreadInterrupt {

    public static void main(String[] args) throws InterruptedException{
        interruptTesting();
    }

    public static void interruptTesting() throws InterruptedException{
        Thread.currentThread().interrupt();
        System.out.println("Interupption happened");
        Thread.sleep(5000);
        for(int i=0;;i++){
            System.out.println("inside loop"+i);
            if(i==20) break;

        }
        if(Thread.interrupted()){
            throw new InterruptedException("interruted");
        }
    }
}
