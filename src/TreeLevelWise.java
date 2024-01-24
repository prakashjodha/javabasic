import java.util.ArrayList;
import java.util.LinkedList;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class TreeLevelWise {

    public static void main(String[] args) {
        //TreeNode<Integer> t1=createTree(new int[]{2,4,3,5,2,6,7,10,22},0);
       // printTree(t1);
       // printLevelWise(t1);

        Stream.of("one", "two", "three", "four")
               .peek(e -> System.out.println("Filtered value: " + e))
                .map(String::toUpperCase)
                .peek(e -> System.out.println("Mapped value: " + e))
                .collect(Collectors.toList());


    }
    static void printTree(TreeNode<Integer> node){
        if(node!=null){
            System.out.println(node.data);
            printTree(node.left);
            printTree(node.right);
        }
    }

    static void printLevelWise(TreeNode<Integer> tree){
        // BFS traversal
        ArrayList<LinkedList<TreeNode<Integer>>> listOfLevel=new ArrayList<>();
        getLevelWise(tree, listOfLevel, 0);
        for(LinkedList<TreeNode<Integer>> list:listOfLevel){
            list.stream().forEach(elem-> System.out.print(elem.data+", "));
            System.out.println("");
        }
    }

    static void getLevelWise(TreeNode<Integer> node, ArrayList<LinkedList<TreeNode<Integer>>> listOfLevel, int level){
        if(node==null)return;
        LinkedList<TreeNode<Integer>> list=null;
        if(listOfLevel.size()==level){
            list=new LinkedList<>();
            listOfLevel.add(list);
        }else{
            list=listOfLevel.get(level);
        }
        list.add(node);
        getLevelWise(node.left,listOfLevel,level+1);
        getLevelWise(node.right,listOfLevel,level+1);

    }
    static TreeNode<Integer> createTree(int arr[], int i){
        if(i>= arr.length)return null;
        TreeNode<Integer> tree=new TreeNode<>(arr[i]);
        tree.left=createTree(arr, 2*i+1);
        tree.right=createTree(arr, 2*i+2);
        return tree;
    }
}
