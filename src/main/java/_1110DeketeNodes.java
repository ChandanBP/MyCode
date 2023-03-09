import java.util.*;

public class _1110DeketeNodes {

    class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int val) { this.val = val; }
    }

    TreeNode root;
    LinkedList<TreeNode> result = new LinkedList();
    HashSet<Integer> toBeDeleted = new HashSet();
    HashSet<Integer>roots = new HashSet();
    HashMap<Integer,TreeNode> map = new HashMap();
    HashMap<Integer,TreeNode>parent = new HashMap<>();

    public List<TreeNode> delNodes(TreeNode root, int[] to_delete) {
        if(root==null)return result;

        for(int ele:to_delete){
            toBeDeleted.add(ele);
        }

        Queue<TreeNode> queue = new LinkedList();
        queue.add(root);
        roots.add(root.val);
        parent.put(root.val,root);

        while(!queue.isEmpty()){
            TreeNode node = queue.poll();
            map.put(node.val,node);
            if(toBeDeleted.contains(node.val)){
                roots.remove(node.val);
                if(node.left!=null){
                    roots.add(node.left.val);
                    queue.add(node.left);
                    parent.put(node.left.val,node);
                }
                if(node.right!=null){
                    roots.add(node.right.val);
                    queue.add(node.right);
                    parent.put(node.right.val,node);
                }
                TreeNode p = parent.get(node.val);
                if(p.val==node.val)p=null;
                if(p.left.val==node.val)p.left=null;
                if(p.right.val==node.val)p.right=null;
            }else{
                if(node.left!=null){
                    queue.add(node.left);
                    parent.put(node.left.val,node);
                }

                if(node.right!=null){
                    queue.add(node.right);
                    parent.put(node.right.val,node);
                }
            }
        }

        roots.forEach(i->{
            result.add(map.get(i));
        });
        return result;
    }

    public void init(){
        root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.left.left = new TreeNode(4);
        root.left.right = new TreeNode(5);

        root.right = new TreeNode(3);
        root.right.left = new TreeNode(6);
        root.right.right = new TreeNode(7);
    }

    public static void main(String[] args) {
        _1110DeketeNodes obj = new _1110DeketeNodes();
        obj.init();
        obj.delNodes(obj.root,new int[]{3,5});
    }
}
