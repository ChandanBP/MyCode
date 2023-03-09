import java.util.LinkedList;
import java.util.Queue;

public class _1302DeepestLeaveSum {

    class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }

    TreeNode root;

    public void constructTree(){

        root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.left.right = new TreeNode(5);
        root.left.left = new TreeNode(4);
        root.left.left.left = new TreeNode(7);

        root.right = new TreeNode(3);
        root.right.right = new TreeNode(6);
        root.right.right.right = new TreeNode(8);

    }

    public int deepestLeavesSum(TreeNode root) {

        if(root==null) return 0;

        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);

        int sum=0;
        while (!queue.isEmpty()){

            sum = 0;
            int c = queue.size();
            while (c>0){
                TreeNode node = queue.poll();
                sum+=node.val;
                if(node.left!=null){
                    queue.add(node.left);
                }
                if(node.right!=null){
                    queue.add(node.right);
                }
                --c;
            }
        }
        return sum;
    }

    public static void main(String[] args) {
        _1302DeepestLeaveSum objSum = new _1302DeepestLeaveSum();
        objSum.constructTree();
        System.out.println(objSum.deepestLeavesSum(objSum.root));
    }

}
