public class _110BalancedBinaryTree {

    public int[] height(TreeNode root){
        if(root==null)return new int[]{0,1};

        int[] left = height(root.left);
        if(left[1]==-1)return new int[]{0,-1};

        int[] right = height(root.right);
        if(right[1]==-1)return new int[]{0,-1};

        int diff = Math.abs(left[0]-right[0]);
        int h = 1+Math.max(left[0],right[0]);
        return new int[]{h,(diff<=1)?1:-1};
    }

    public boolean isBalanced(TreeNode root) {
        if(root==null)return true;

        int res[] = height(root);
        return (res[1]==1);
    }

}
