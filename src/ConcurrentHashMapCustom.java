import java.io.File;
import java.io.PrintWriter;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.*;
import java.util.concurrent.ConcurrentHashMap;
import java.util.stream.Stream;

public class ConcurrentHashMapCustom {

    static void fileIterate(){
        try{
            System.out.println("before "+(Runtime.getRuntime().freeMemory()/10241024));
            Stream<String> lines=Files.lines(Path.of("C:\\Users\\praka\\tmp\\hello.csv"));
            System.out.println("after "+(Runtime.getRuntime().freeMemory()/10241024));
            System.out.println(lines.count());

        }catch (Exception ex){
            System.out.println("Error "+ex);
        }
    }

    public static void main(String[] args) {
        //fileIterate();

        System.out.println(-87>>2);
    }

    public static void oldFileMethod() {


        Map<String, String> map = new ConcurrentHashMap<>();
        Collections.synchronizedMap(map);
        File file=new File("C:\\Users\\praka\\tmp\\hello1.csv");
        //file.delete();
      //  file=new File("C:\\Users\\praka\\tmp\\hello.csv");
        Random random=new Random();
        try(PrintWriter fw=new PrintWriter(file)){
            fw.write("attr1, attr2, attr3, attr4 \n");
            int rowsTowrite=10000000;
            for(int i=0;i<rowsTowrite;i++){
                String data=String.join(", ", String.valueOf(random.nextInt(1000)),String.valueOf(random.nextInt(1000)),String.valueOf(random.nextInt(1000)),String.valueOf(random.nextInt(1000)));
                fw.write(data);
                fw.write("\n");
            }


        }catch (Exception ex){

        }
        List<String> list= Arrays.asList(new String[]{ String.valueOf(random.nextInt(1000)),String.valueOf(random.nextInt(1000)),String.valueOf(random.nextInt(1000)),String.valueOf(random.nextInt(1000))});
        try{
            System.out.println("before "+Runtime.getRuntime().freeMemory());
            Stream<String> lines=Files.lines(Path.of("C:\\Users\\praka\\tmp\\hello.csv"));
            System.out.println("after "+Runtime.getRuntime().freeMemory());
            System.out.println(lines.count());

        }catch (Exception ex){
            System.out.println("Error "+ex);
        }


//        try (Stream<String> lines = Files.lines(Path.of("./File.txt"))) {
//
//        }catch (Exception ex){
//            System.out.println("unhandled Exception");
//        }
//
        }
}
