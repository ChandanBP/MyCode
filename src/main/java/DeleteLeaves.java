

public class DeleteLeaves {

    int target = 1;
    TreeNode root;

    public void constructTree(){
        root = new TreeNode(1);
        root.left = new TreeNode(1);
        root.right = new TreeNode(1);
//        root.left.left = new TreeNode(2);
//        root.right.left = new TreeNode(2);
//        root.right.right = new TreeNode(4);
    }

    public TreeNode dfs(TreeNode root,int target){

        if (root==null)return null;
        if(root.left==null &&
           root.right==null &&
           root.val==target)return null;

        root.left = dfs(root.left,target);
        root.right = dfs(root.right,target);

        if(root.left==null &&
                root.right==null &&
                root.val==target)return null;

        return root;
    }

    public TreeNode removeLeafNodes(TreeNode root, int target) {
        return dfs(root,target);
    }

    public static void main(String[] args) {
//        DeleteLeaves deleteLeaves = new DeleteLeaves();
//        deleteLeaves.constructTree();
//        deleteLeaves.removeLeafNodes(deleteLeaves.root,deleteLeaves.target);
        System.out.println(Integer.toBinaryString(345));
        System.out.println(Integer.toBinaryString(255));
    }
}
