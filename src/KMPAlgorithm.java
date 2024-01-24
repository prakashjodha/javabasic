public class KMPAlgorithm {
    public static void main(String[] args) {
        String pattern="AABAAB";
        calculateLps(pattern,new int[pattern.length()]);
    }

    static void calculateLps(String pattern,int[] arr ){
        int len=0;
        arr[0]=0;
        int i=1;
        while(i<pattern.length()){
            if(pattern.charAt(i)==pattern.charAt(len)){
                len++;
                arr[i]=len;
                i++;
            }else{
                if(len!=0){
                    len=arr[len-1];
                }else{
                    arr[i]=len;
                    i++;
                }
            }

        }
        for (int j:arr){
            System.out.println(j);
        }
    }
}
