public class _173BSTIterator {

    TreeNode root,curr;
    BSTIteratorNode prevIterate;

    class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode() {}
        TreeNode(int val) { this.val = val; }
        TreeNode(int val, TreeNode left, TreeNode right) {
          this.val = val;
          this.left = left;
          this.right = right;
        }
    }

    public int next() {

        if(curr==null)return -1;

        while(curr.left!=null){
            curr=curr.left;
            BSTIteratorNode node = new BSTIteratorNode(curr);
            prevIterate.next=node;
            node.prev=prevIterate;
            prevIterate=node;
        }
        int val = curr.val;
        if(curr.right==null){
            prevIterate=prevIterate.prev;
            if(prevIterate!=null){
                prevIterate.next=null;
                curr=prevIterate.val;
            }
        }else{
            curr=curr.right;
            if(curr!=null){
                prevIterate = new BSTIteratorNode(curr);
            }
        }
        return val;
    }

    public boolean hasNext() {
        if(prevIterate==null)return false;
        return true;
    }

    public _173BSTIterator(TreeNode root) {
        this.root=root;
        curr=root;
        prevIterate = new BSTIteratorNode(root);
    }

    class BSTIteratorNode {
        TreeNode val;
        public BSTIteratorNode(TreeNode val){
            this.val=val;
        }
        BSTIteratorNode prev;
        BSTIteratorNode next;
    }

    public static void main(String[] args) {

    }
}
