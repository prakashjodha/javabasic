import java.util.Arrays;

public class MinHeapTest {
    public static void main(String[] args) {
        int[] arr=new int[]{2,6,9,1,5,12,5,8,2,20};
        MinHeap heap=new MinHeap(arr,arr.length);
        heap.printSortedValues();

    }


}
class MinHeap{
    int[] arr;
    int heapSize;

    int getMinValue(){
        if(arr[0]==Integer.MIN_VALUE){
            System.out.println("Heap elements already removed.");
            throw new RuntimeException("Heap is empty");
        }
        return arr[0];
    }

    void replaceMinValue(int value){
        arr[0]=value;
        minHeapify(0);
    }

    void printSortedValues(){
        int i=0;
        while(i<heapSize){
            System.out.print(getMinValue()+", ");
            replaceMinValue(Integer.MAX_VALUE);
            i++;
        }
    }

    MinHeap(int[] arr,int heapSize ){
        this.arr=arr;
        this.heapSize=heapSize;
        int mid=(arr.length-1)/2;
        while(mid>=0){
            minHeapify(mid);
            mid--;
        }

    }

    void minHeapify(int i){
        int smallest=i;
        int left=left(i);
        int right=right(i);
        if(left<heapSize&& arr[left]<arr[smallest])smallest=left;
        if(right<heapSize&& arr[right]<arr[smallest])smallest=right;
        if(smallest!=i){
            swap(i,smallest);
            minHeapify(smallest);
        }

    }

    int left(int i){
        return i*2+1;
    }

    int right(int i){
        return i*2+2;
    }
    void swap(int i, int j){
        int temp=arr[i];
        arr[i]=arr[j];
        arr[j]=temp;
    }
}
