import java.util.*;

public class _919CompleteBinaryTreeInserter {

    Deque<TreeNode> deque;
    TreeNode root;
    public _919CompleteBinaryTreeInserter(TreeNode root) {
        deque = new ArrayDeque();
        this.root = root;

        Queue<TreeNode> queue = new LinkedList();
        queue.add(root);

        while(queue.isEmpty()){

            for(int i=0;i<queue.size();i++){

                TreeNode node = queue.poll();
                if(node.left==null || node.right==null){
                    deque.offerLast(node);
                }

                if(node.left!=null)queue.offer(node.left);
                if(node.right!=null)queue.offer(node.right);
            }
        }
    }

    public int insert(int val) {
        TreeNode tail = deque.peekFirst();
        TreeNode node = new TreeNode(val);
        deque.offerLast(node);
        if(tail.left==null){
            tail.left = node;
        }else{
            tail.right = node;
            deque.pollFirst();
        }
        return tail.val;
    }

    public TreeNode get_root() {
        return root;
    }

    public static void main(String[] args) {
        TreeSet<Integer>set = new TreeSet<>();
        set.add(10);
        set.add(5);
        set.add(1);
        System.out.println(set.first());
        System.out.println(set.last());
        TreeMap<Integer,Integer>treeMap;
    }
}
