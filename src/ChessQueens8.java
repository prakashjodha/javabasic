import java.util.ArrayList;

public class ChessQueens8 {
    static final int GRID_SIZE=8;
    public static void main(String[] args) {

    }

    static void placeQueens(int row, Integer[] columns, ArrayList<Integer[]> results){
        if(row==GRID_SIZE){
            results.add(columns.clone());
        }else{
            for(int col=0;col<GRID_SIZE;col++){
                if(checckValid(columns,row,col)){
                    columns[row]=col;
                    placeQueens(row+1, columns, results);
                }
            }
        }

    }

    static boolean checckValid(Integer[] colomns, int row, int col){
        for(int i=0;i<row;i++){
            if(colomns[row]==col)return false; // col previously mapped with other row
            if(Math.abs(colomns[row]-col)==row-i)return false;
        }
        return true;
    }


}
