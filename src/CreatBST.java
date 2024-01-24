import java.util.ArrayList;

public class CreatBST {

    public static void main(String[] args) {
        var arr=new int[]{3,4,10,15,20,30,50};
        TreeNode<Integer> node=creatArrayBST(arr);
        printTree(node);
        var isValid = checkTreeIsBST(node, arr);
        System.out.println("is valid "+isValid);
    }

    static TreeNode<Integer>  creatArrayBST(int arr[]){

        //let's assume this is a sorted array.
        return createBST(arr,0, arr.length-1);

    }

    static void printTree(TreeNode<Integer> node){
        if(node!=null){
            System.out.println(node.data);
            printTree(node.left);
            printTree(node.right);
        }
    }

    static TreeNode<Integer> createBST(int[] arr, int start, int end){
        if(start>end)return null;
        int mid=(end+start)/2;
        TreeNode<Integer> node=new TreeNode<>(arr[mid]);
        node.left=createBST(arr, start, mid-1);
        node.right=createBST(arr, mid+1, end);
        return node;
    }

    public static boolean checkTreeIsBST(TreeNode<Integer> head, int[] arr){
        var list=new ArrayList<Integer>();
        inorderTraversal(head,list);
        if(list.size()!=arr.length)return false;
       for(int i=0;i<arr.length;i++){
            if(list.get(i)!=arr[i])return false;
        }
        return true;
    }

    public static void inorderTraversal(TreeNode<Integer> head, ArrayList<Integer> list){
        if(head==null)return;
        inorderTraversal(head.left,list);
        list.add(head.data);
        inorderTraversal(head.right,list);

    }
}

class TreeNode<T>{
    TreeNode left;
    TreeNode right;
    T data;
    public TreeNode(T data){
        this.data=data;

    }
}
