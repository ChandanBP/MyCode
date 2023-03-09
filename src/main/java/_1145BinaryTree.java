public class _1145BinaryTree {

    public boolean btreeGameWinningMove(TreeNode root, int n, int x) {
        if(root == null) {
            return false;
        }

        if(root.val == x) {
            int leftCount = count(root.left);
            int rightCount = count(root.right);
            int parentCount = n - (leftCount + rightCount + 1);
            return (leftCount > rightCount+parentCount || rightCount > leftCount+parentCount || parentCount > leftCount+rightCount);
        }

        return btreeGameWinningMove(root.left, n, x) || btreeGameWinningMove(root.right, n, x);
    }

    private int count(TreeNode node) {
        if(node == null) return 0;
        return count(node.left) + count(node.right) + 1;
    }

    public static void main(String[] args) {

    }
}
