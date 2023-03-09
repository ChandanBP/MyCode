import java.util.HashMap;
import java.util.LinkedList;
import java.util.ListIterator;

public class _979DistributeCoins {

    LinkedList<TreeNode>nodes = new LinkedList<>();

    public void addNodes(TreeNode root){
        if(root==null);
        if(root.val>0)nodes.add(root);
        addNodes(root.left);
        addNodes(root.right);
    }

    public int distributeCoins(TreeNode root) {

        ListIterator<TreeNode>ite = nodes.listIterator();
        while(ite.hasNext()){

        }
        HashMap<Integer,Integer>map = new HashMap();
        return 1;
    }

    public static void main(String[] args) {

    }
}
