class Node {
    public int val;
    public Node left;
    public Node right;
}

public class _426BSTToDLL {
    Node head=null,tail=null;
    public void treeToList(Node root){

        if(root==null)return;
        treeToList(root.left);
        if(head==null){
            head = tail = root;
        }else{
            tail.right = root;
            root.left = tail;
            tail = tail.right;
        }
        treeToList(root.right);
    }

    public Node treeToDoublyList(Node root) {

        treeToList(root);
        if(head!=null && tail!=null){
            tail.right = head;
            head.left = tail;
        }
        return head;
    }
}
