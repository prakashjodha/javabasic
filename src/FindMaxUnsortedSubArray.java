public class FindMaxUnsortedSubArray {

    public static void main(String[] args) {
        int[] arr={1, 2, 4, 7, 10, 11, 8, 12, 5, 6, 16, 18, 19};
        printArryaIndex(arr);
    }

    static void printArryaIndex(int[] arr){
        int endOFLeft=findEndOfLeft(arr);
        if(endOFLeft==arr.length-1)return;
        int startOfRight=findStartOfRight(arr);
        int maxLeftMid=endOFLeft;
        int minRightMid=startOfRight;
        for(int i=endOFLeft+1;i<startOfRight;i++){
            if(arr[i]<arr[maxLeftMid])maxLeftMid=i;
            if(arr[i]>arr[minRightMid])minRightMid=i;
        }
        int leftStart=shirnkLeft(arr, maxLeftMid,endOFLeft);
        int rightend=expendRight(arr, minRightMid, startOfRight);

        System.out.println(leftStart+"  "+rightend);

    }

    static int shirnkLeft(int[] arr, int maxIndex, int start){
        int val=arr[maxIndex];
        for(int i=start-1;i>=0;i--){
            if(arr[i]<=val)return i+1;
        }
        return 0;

    }

    static int expendRight(int[] arr, int minindex, int start){
        int val=arr[minindex];
        for(int i=start;i<arr.length;i++){
            if(arr[i]>=val){
                return i-1;
            }
        }
        return arr.length-1;
    }

    static int findEndOfLeft(int[] arr){
        for(int i=1;i<arr.length;i++){
            if(arr[i]<arr[i-1])return i-1;
        }
        return arr.length-1;
    }

    static int findStartOfRight(int[] arr){
        for (int i=arr.length-2;i>=0;i--){
            if(arr[i]>arr[i-1])return i-1;
        }
        return 0;
    }

}
