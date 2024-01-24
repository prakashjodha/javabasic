import java.util.*;

public class OceanFlowProblem {
    int[][] dir={{0,1},{1,0},{0,-1},{-1,0}};
    public static void main(String[] args) {
        int[][] arr={
                {1,2,2,3,5},
                {3,2,3,4,4},
                {2,4,5,3,1},
                {6,7,1,4,5},
                {5,1,1,2,4}};
        OceanFlowProblem problem=new OceanFlowProblem();
        problem.printIntersectionPoints(arr);
    }

    void printIntersectionPoints(int[][] matrix){
        Set<MatrixPair> visitedOcean1=new HashSet<>();
        Set<MatrixPair> visitedOcean2=new HashSet<>();
        Queue<MatrixPair>  queueOcean1=new LinkedList<>();
        Queue<MatrixPair>  queueOcean2=new LinkedList<>();
        int rows=matrix.length;
        int cols=matrix[0].length;
        // Ocean1's boundryElem
        for (int i=0;i<rows;i++){
            MatrixPair pair=new MatrixPair(i,0);
            visitedOcean1.add(pair);
            queueOcean1.offer(pair);
        }
        for (int j=1;j<cols;j++){
            MatrixPair pair=new MatrixPair(0,j);
            visitedOcean1.add(pair);
            queueOcean1.offer(pair);
        }
        for (int i=0;i<rows;i++){
            MatrixPair pair=new MatrixPair(i,cols-1);
            visitedOcean2.add(pair);
            queueOcean2.offer(pair);
        }
        for (int j=0;j<cols-1;j++){
            MatrixPair pair=new MatrixPair(rows-1,j);
            visitedOcean2.add(pair);
            queueOcean2.offer(pair);
        }
        doBFS(matrix,queueOcean1,visitedOcean1);
        doBFS(matrix,queueOcean2,visitedOcean2);
        visitedOcean1.retainAll(visitedOcean2);
        System.out.println(visitedOcean1);
        visitedOcean1.stream().map(pair -> {
            List<Integer> list = new ArrayList<>();
            list.add(pair.rowIndex);
            list.add(pair.colIndex);
            return list;
        }).toList();
    }

    void doBFS(int[][] matrix, Queue<MatrixPair>  queue, Set<MatrixPair> visited){
        while (!queue.isEmpty()){
            MatrixPair pair=queue.poll();
            for(int i=0;i< dir.length;i++){
                    MatrixPair newPair=new MatrixPair(pair.rowIndex+dir[i][0],pair.colIndex+dir[i][1]);
                    if(newPair.rowIndex<0 || newPair.colIndex<0 ||newPair.rowIndex>=matrix.length || newPair.colIndex>=matrix[0].length || visited.contains(newPair) || matrix[pair.rowIndex][pair.colIndex]>matrix[newPair.rowIndex][newPair.colIndex])
                        continue;
                    visited.add(newPair);
                    queue.offer(newPair);
            }
        }
        System.out.println("visited "+visited);
    }



}

class MatrixPair{
    int rowIndex;
    int colIndex;
    public MatrixPair(int rowIndex, int colIndex){
        this.rowIndex=rowIndex;
        this.colIndex=colIndex;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        MatrixPair that = (MatrixPair) o;
        return rowIndex == that.rowIndex && colIndex == that.colIndex;
    }

    @Override
    public int hashCode() {
        return Objects.hash(rowIndex, colIndex);
    }

    @Override
    public String toString() {
        return "{" +rowIndex +
                "," + colIndex +
                '}';
    }
}
