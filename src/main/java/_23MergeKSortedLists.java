import java.util.Comparator;
import java.util.PriorityQueue;

public class _23MergeKSortedLists {

    static class ListNode implements Comparable<ListNode>{
        int val;
        ListNode next;
        ListNode(int val) { this.val = val; }

        @Override
        public int compareTo(ListNode listNode) {
            return this.val-listNode.val;
        }
    }

    public ListNode mergeKLists(ListNode[] lists) {

        PriorityQueue<ListNode>queue = new PriorityQueue<>(new Comparator<ListNode>() {
            @Override
            public int compare(ListNode listNode, ListNode t1) {
                return listNode.val-t1.val;
            }
        });

        for(int i=0;i<lists.length;i++){
            if(lists[i]!=null)
            queue.add(lists[i]);
        }
        ListNode head = null,tail=null;
        while (!queue.isEmpty()){

            ListNode node = queue.poll();
            ListNode newNode = new ListNode(node.val);

            if(head==null){
                head=newNode;
                tail=newNode;
            }else{
                tail.next=newNode;
                tail=tail.next;
            }
            if(node.next!=null)queue.add(node.next);
        }

        return head;
    }

    public static void main(String[] args) {
        ListNode head1 = new ListNode(1);
        head1.next = new ListNode(2);
        head1.next.next = new ListNode(5);

        ListNode head2 = new ListNode(1);
        head2.next = new ListNode(3);

        ListNode head3 = new ListNode(3);
        head3.next = new ListNode(4);
        head3.next.next = new ListNode(5);

        ListNode nodes[] = new ListNode[3];
        nodes[0]=head1;
        nodes[1]=head2;
        nodes[2]=head3;
        new _23MergeKSortedLists().mergeKLists(nodes);
    }
}
