import java.util.HashMap;
import java.util.Map;

public class LeastRecentCache {

    public static void main(String[] args) {
        LeastRecentCache lrCache=new LeastRecentCache(5);
        for(int i=0;i<5;i++){
            lrCache.put(i,i+1);
            System.out.println(lrCache);
        }

    }

    Map<Integer, LRNode> map;
    LRNode head;
    LRNode tail;

    int capacity;

    @Override
    public String toString() {
        return "LeastRecentCache{" +
                "head=" + head +
                '}';
    }

    public LeastRecentCache(int capacity){
        this.capacity=capacity;
        map=new HashMap<>(capacity);
    }

    Integer get(Integer key){
        if(map.get(key)==null)
            return null;
        else{

            LRNode node=map.get(key);
            updateCache(node);
            return node.data;
        }

    }

    void updateCache(LRNode node){
        if(node==head)return;
        if(node!=head)
            node.left.right=node.right;
        if(node!=tail)
            node.right.left=node.left;
        if(node==tail)
            tail=node.left;
        head.left=node;
        node.left=null;
        node.right=head;
        head=node;
    }

    void put(Integer key, Integer value){
        if(map.get(key)!=null){
            LRNode node=map.get(key);
            node.data=value;
            updateCache(map.get(key));
        }else{
            LRNode node=new LRNode();
            node.data=value;
            if(map.size()==capacity){
                LRNode oldTail=tail;
                tail.left.right=null;
                tail =tail.left;
                oldTail.left=null;
            }
            if(head==null){
                tail =node;
                head=node;
            }else{
                head.left=node;
                node.left=null;
                node.right=head;
                head=node;
            }

        }

    }
}
class LRNode{
    LRNode left;
    LRNode right;
    int data;

    @Override
    public String toString() {
        return "value "+data;
    }
}
