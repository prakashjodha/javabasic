public class KnapsackProblem {

    static int[][] dbMetix;
    public static void main(String[] args) {
        int W=50;
        int [] wt=new int[]{10,20,30};
        int[] val=new int[]{60,100,120};
        dbMetix=new int[W+1][val.length+1];
        for(int i=0;i<=W;i++){
            for(int j=0;j<=val.length;j++){
                dbMetix[i][j]=-1;
            }
        }
        int maxVal=getMaxValue(W,wt,val,val.length);
        System.out.println(maxVal);
    }

    static int getMaxValue(int W, int[] wt, int[] val, int n){
        if(n==0||W==0)return 0;
        if(dbMetix[W][n-1]!=-1) return dbMetix[W][n-1];
        if(wt[n-1]>W) {
            dbMetix[W][n] = getMaxValue(W, wt, val, n - 1);
        }
        else{
            dbMetix[W][n]= Math.max(val[n-1]+getMaxValue(W-wt[n-1],wt,val,n-1),getMaxValue(W,wt,val,n-1));
        }
        return dbMetix[W][n];
    }
}
