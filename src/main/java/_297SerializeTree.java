import java.util.LinkedList;
import java.util.Queue;

public class _297SerializeTree {

    TreeNode root;
    _297SerializeTree(){
        root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);

        root.right.left = new TreeNode(4);
        root.right.right = new TreeNode(5);
    }

    public String serialize(TreeNode root) {
        if(root==null)return "";

        Queue<TreeNode>queue = new LinkedList<>();
        StringBuilder sb = new StringBuilder();
        queue.add(root);

        while(!queue.isEmpty()){

            TreeNode node = queue.poll();
            sb.append(node.val);
            sb.append(",");

            if(node.val!=Integer.MIN_VALUE){
                TreeNode lnode = (node.left==null)?new TreeNode(Integer.MIN_VALUE):node.left;
                TreeNode rnode = (node.right==null)?new TreeNode(Integer.MIN_VALUE):node.right;
                queue.add(lnode);
                queue.add(rnode);
            }
        }
        return sb.toString();
    }

    public TreeNode deserialize(String data) {

       if(data==null||data.length()<1)return null;

       String input[] = data.split(",");

       Queue<TreeNode>queue = new LinkedList<>();
       int i=0;
       TreeNode root = new TreeNode(Integer.parseInt(input[i]));
       queue.add(root);

       while(!queue.isEmpty()){

            TreeNode node = queue.poll();
            if(node.val!=Integer.MIN_VALUE){
                ++i;
                int left = Integer.parseInt(input[i]);
                if(left!=Integer.MIN_VALUE){
                    TreeNode lNode = new TreeNode(Integer.parseInt(input[i]));
                    node.left = lNode;
                    queue.add(lNode);
                }

                ++i;
                int right = Integer.parseInt(input[i]);
                if(right!=Integer.MIN_VALUE){
                    TreeNode rNode = new TreeNode(Integer.parseInt(input[i]));
                    node.right = rNode;
                    queue.add(rNode);
                }
            }
       }
        return root;
    }

    public static void main(String[] args) {
        _297SerializeTree obj = new _297SerializeTree();
        obj.deserialize("0,8,1,-1,-1,3,2,-1,4,5,-1,-1,7,6");
        //obj.deserialize(obj.serialize(obj.root));
    }
}
