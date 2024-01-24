import java.util.HashMap;
import java.util.Map;

public class SlidingWindowExample {

    public static void main(String[] args) {
        getSmallesArrywithDigit(new int[]{1, 1, 2, 2, 3, 3, 4, 5 },3);
    }

    static void getSmallesArrywithDigit(int[] arr, int k){
        if(arr.length<k) System.out.println("invalid k");
        Map<Integer, Integer> map=new HashMap<>();
        int i=0; int start=0; int end=arr.length; int j=0;
        while(j<arr.length){
            map.put(arr[j], map.getOrDefault(arr[j],0)+1);
            j++;
            if(map.size()<k){
                continue;
            }
            while(map.size()==k){
                int windowlen=(j-1)-i;
                int subarrLen=end-start;
                if(windowlen<subarrLen){
                    start=i;
                    end=j-1;
                }

                if(map.get(arr[i])==1)map.remove(arr[i]);
                else map.put(arr[i],map.get(arr[i])-1);
                i++;

            }
        }

        if(start==0 && end==arr.length) System.out.println("Invalid K");
        else System.out.println(start+""+end);

    }
}
