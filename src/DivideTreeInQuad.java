import java.util.LinkedList;
import java.util.Queue;

public class DivideTreeInQuad {
    public static void main(String[] args) {

        int arr[][]={
                {2,2,3,3,3},
                {2,2,3,3,3},
                {4,2,5,5,3},
                {3,2,5,5,3},
                {3,2,5,5,3}
        };

        int arr2[][]={
                {2,2,3,3},
                {2,2,3,3},
                {4,2,5,5},
                {3,2,5,5}
        };

        QuadTree quadTree=createQuadTree(arr2);
       // printQuadTree(quadTree);
        printQuadTreeRecursive(quadTree,"");
        Queue<Integer> queue=new LinkedList<>();

    }

    static void printQuadTree(QuadTree quadTree){
        Queue<QuadTree> queue1 =new LinkedList<>();
        queue1.add(quadTree);
        while(!queue1.isEmpty()){
            QuadTree tree=queue1.poll();
            if(tree.isLeaf){
                System.out.println(tree.data);
            }
            if(tree.ne!=null)queue1.offer(tree.ne);
            if(tree.nw!=null)queue1.offer(tree.nw);
            if(tree.se!=null)queue1.offer(tree.se);
            if(tree.sw!=null)queue1.offer(tree.sw);
        }
    }

    static void printQuadTreeRecursive(QuadTree quadTree,String dir){
        if(quadTree==null) return;
        if(quadTree.isLeaf){
            System.out.println(dir+": "+quadTree.data);
        }
        printQuadTreeRecursive(quadTree.ne,"ne");
        printQuadTreeRecursive(quadTree.nw,"nw");
        printQuadTreeRecursive(quadTree.se,"se");
        printQuadTreeRecursive(quadTree.sw,"sw");
    }

    static QuadTree createQuadTree(int arr[][]){
        int width=arr.length;
        int depth=arr[0].length;
        return createQuadTree(arr,0,0,width-1,depth-1);
    }

    static QuadTree createQuadTree(int arr[][], int x1, int y1, int x2, int y2 ){
        if(x1>x2 || y1>y2)return null;
        boolean isLeaf = true;
        int val = arr[x1][y1];
        for (int i = x1; i <= x2; i++)
            for (int j = y1; j <= y2; j++)
                if (arr[i][j] != val) {
                    isLeaf = false;
                    break;
                }
        if(isLeaf)
            return new QuadTree(val, true, null, null, null, null);
        int rowMid = (x1 + x2) / 2, colMid = (y1 + y2) / 2;
        QuadTree tree=new QuadTree();
        tree.ne=createQuadTree(arr,x1,y1,rowMid, colMid);
        tree.nw=createQuadTree(arr,x1,colMid+1,rowMid, y2);
        tree.se=createQuadTree(arr,rowMid+1,y1,x2,colMid);
        tree.sw=createQuadTree(arr,rowMid+1,colMid+1,x2, y2);
        tree.isLeaf=false;
        tree.data=0;
        return tree;
    }


}

class QuadTree{
    int data;
    boolean isLeaf;
    QuadTree ne,nw,se,sw;
    QuadTree(int data){
        this.data=data;
    }

    QuadTree(){

    }

    public QuadTree(int data, boolean isLeaf,  QuadTree ne,QuadTree nw,QuadTree se,QuadTree sw) {
        this.data = data;
        this.isLeaf = isLeaf;
        this.ne = ne;
        this.nw = nw;
        this.se = se;
        this.sw = sw;
    }

    @Override
    public String toString() {
        return "QuadTree{" +
                "data=" + data +
                ", isLeaf=" + isLeaf +
                ", ne=" + ne +
                ", nw=" + nw +
                ", se=" + se +
                ", sw=" + sw +
                '}';
    }
}
