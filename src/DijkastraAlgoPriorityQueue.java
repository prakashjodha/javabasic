import java.util.Arrays;
import java.util.List;
import java.util.PriorityQueue;

public class DijkastraAlgoPriorityQueue {

    public static void main(String[] args) {

        PriorityQueue<Integer> pq=new PriorityQueue<>((v1,v2)->v2-v1);
        List<String> ints=Arrays.asList(new String[]{"",""});
        var list = Arrays.asList(2, 5, 9, 1, 3, 8, 10);
        pq.addAll(list);
        System.out.println(pq);
        while(!pq.isEmpty()){
            System.out.println(pq.poll());
        }
    }
}
