public class MetrixZero {

    public static void main(String[] args) {
        int[][] arr={
                {1,2,3,4},
                {1,0,1,0},
                {1,2,4,3}
        };
        markMetricZero(arr);
        for (int i=0;i<arr.length;i++){

            for (int j=0;j<arr[0].length;j++){
                System.out.print(arr[i][j]);
            }
            System.out.println("");
        }
    }

    static void markMetricZero(int[][] matrix){
        boolean isRowZero=false;
        boolean isColZero=false;
        for(int i=0;i<matrix.length;i++){
            if(matrix[i][0]==0){
                isRowZero=true;
                break;
            }
        }
        for(int i=0;i<matrix[0].length;i++){
            if(matrix[0][i]==0){
                isColZero=true;
                break;
            }
        }
        for(int i=0;i<matrix.length;i++)
            for(int j=0;j<matrix[0].length;j++){
                if(matrix[i][j]==0){
                    matrix[i][0]=0;
                    matrix[0][j]=0;
                }
            }
        for(int i=0;i<matrix.length;i++){
            if(matrix[i][0]==0)nullifyRow(matrix,i);
        }
        for(int i=0;i<matrix[0].length;i++){
            if(matrix[0][i]==0)nullifycolumn(matrix,i);
        }
        if(isRowZero)nullifyRow(matrix,0);
        if(isColZero)nullifycolumn(matrix,0);

    }

    static void nullifyRow(int[][] matrix, int row){
        for(int i=0;i<matrix[0].length;i++)matrix[row][i]=0;
    }

    static void nullifycolumn(int[][] matrix, int column){
        for(int i=0;i<matrix.length;i++)matrix[i][column]=0;
    }
}
