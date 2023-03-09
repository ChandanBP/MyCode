import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.Stack;

public class _103BinaryTreeZigZag {

    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {

        if(root==null)return null;

        Stack<TreeNode> stack1 = new Stack();
        Stack<TreeNode> stack2 = new Stack();

        List<List<Integer>>result = new LinkedList<>();
        stack1.push(root);
        boolean flag = true;
        while(!stack1.isEmpty() && !stack2.isEmpty()){
            List<Integer>r = new LinkedList<>();
            if(flag){
                while (stack1.isEmpty()){
                    TreeNode node = stack1.pop();
                    r.add(node.val);
                    if(node.left!=null)
                        stack2.push(node.left);
                    if(node.right!=null)
                        stack2.push(node.right);
                }
            }else{
                while(stack2.isEmpty()){
                    TreeNode node = stack2.pop();
                    r.add(node.val);
                    if(node.right!=null)
                        stack1.push(node.right);
                    if(node.left!=null)
                        stack1.push(node.left);
                }
            }
            result.add(r);
            flag = !flag;
        }
        return result;
    }

    public static void main(String[] args) {

    }
}
