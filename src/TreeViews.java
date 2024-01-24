import java.util.HashMap;
import java.util.Map;

public class TreeViews {
    static int maxLevel=0;
    public static void main(String[] args) {
        TreeNode root = new TreeNode(10);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        root.left.left = new TreeNode(7);
        root.left.right = new TreeNode(8);
        root.right.right = new TreeNode(15);
        root.right.left = new TreeNode(12);
        root.right.right.left = new TreeNode(14);
        //showLeftOrRightView(root,1,true); // left view
       // showLeftOrRightView(root,1,true); //right view
        Map<Integer, Integer> map=new HashMap<>();
        showTopBottomView(root,0,map,true);
        System.out.println(map);
    }

    static void showLeftOrRightView(TreeNode<Integer> node, int level,boolean isLeft){
        if(node==null)return;
        if(maxLevel<level){
            maxLevel=level;
            System.out.println(node.data);

        }
        if(isLeft){
            showLeftOrRightView(node.left,level+1,isLeft);
            showLeftOrRightView(node.right,level+1,isLeft);
        }else{
            showLeftOrRightView(node.right,level+1,isLeft);
            showLeftOrRightView(node.left,level+1,isLeft);
        }
    }

    static void showTopBottomView(TreeNode<Integer> node, int hDistance , Map<Integer,Integer> viewMap, boolean isBottom){
        if(node==null)return;
        if(viewMap.get(hDistance)==null || isBottom) {
            viewMap.put(hDistance, node.data);
        }
        showTopBottomView(node.left,hDistance+1,viewMap,isBottom);
        showTopBottomView(node.right,hDistance-1,viewMap,isBottom);
    }
}
