import java.util.Collections;
import java.util.LinkedList;

public class _148SortList {
    public ListNode sortList(ListNode head) {

        LinkedList<ListNode>list = new LinkedList<>();
        while (head!=null){
            list.add(head);
            head = head.next;
        }
        Collections.sort(list,(node1,node2)->node1.val-node2.val);
        return (list.size()>0)?list.get(0):null;
    }
}
