import java.util.ArrayList;
import java.util.List;
import java.util.ListIterator;

class TNode {
    public int val;
    public List<TNode> children;


    public TNode() {
        children = new ArrayList<TNode>();
    }

    public TNode(int _val) {
        val = _val;
        children = new ArrayList<TNode>();
    }

    public TNode(int _val, ArrayList<TNode> _children) {
        val = _val;
        children = _children;
    }
};

public class _1506FindRoot {
    public int isParent(List<TNode> tree,int result){
        ListIterator<TNode> iterator = tree.listIterator();
        while(iterator.hasNext()){
            TNode parent = iterator.next();
            result = result^parent.val;
        }
        return result;
    }

    public TNode findRoot(List<TNode> tree) {
        int result = 0;

        ListIterator<TNode>iterator = tree.listIterator();
        while(iterator.hasNext()){
            TNode parent = iterator.next();
            // result = result^parent.val;
            if(parent!=null){
                List<TNode>children = parent.children;
                ListIterator<TNode>iter = children.listIterator();
                while(iter.hasNext()){
                    TNode child = iter.next();
                    result=result^child.val;
                }
            }
        }
        int val = isParent(tree,result);
        iterator = tree.listIterator();
        while(iterator.hasNext()){
            TNode parent = iterator.next();
            if(parent.val == val)return parent;
        }
        return null;
    }
}
