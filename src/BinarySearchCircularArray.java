public class BinarySearchCircularArray {
    public static void main(String[] args) {

    }

    static int binarySearchArray(int[] arr, int x, int start, int end){
        int mid=(start+end)/2;
        if(arr[mid]==x)return mid;
        if(start>end)return -1;
        if(arr[start]<arr[mid]){
            if(x<arr[mid] && x>=arr[start])binarySearchArray(arr, x, start,mid-1);
            else binarySearchArray(arr,x,mid+1,end);
        }else if(arr[start]>arr[mid]){
            if(x>arr[mid] && x<=arr[end])binarySearchArray(arr, x, mid+1,end);
            else binarySearchArray(arr, x, start,mid-1);

        }else if(arr[start]==arr[mid]){
            int result =binarySearchArray(arr, x, start,mid-1);
            if(result==-1)return binarySearchArray(arr, x, mid+1,end);
            else return result;
        }
        return  -1;
    }
}
