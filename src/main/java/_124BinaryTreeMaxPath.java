public class _124BinaryTreeMaxPath {

    int res = Integer.MIN_VALUE;

    TreeNode root;
    public class TreeNode {
      int val;
      TreeNode left;
      TreeNode right;
      TreeNode(int x) { val = x; }
    }

    public _124BinaryTreeMaxPath(){
        root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
    }

    public int updateMax(TreeNode root){
        if(root==null)return 0;

        int left = updateMax(root.left);
        int right = updateMax(root.right);

        int max1 = Math.max(root.val,Math.max(root.val+left+right,Math.max(root.val+right,root.val+left)));

        res = Math.max(max1,res);

        return Math.max(root.val,Math.max(root.val+right,root.val+left));
    }

    public int maxPathSum() {
        updateMax(root);
        return res;
    }

    public static void main(String[] args) {
        System.out.println(new _124BinaryTreeMaxPath().maxPathSum());
    }
}
