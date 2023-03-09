import java.util.Stack;

class ListNode {
  int val;
  ListNode next;
  ListNode() {}
  ListNode(int val) { this.val = val; }
}

public class _206ReverseLinkedList {

    ListNode head = new ListNode();
    public _206ReverseLinkedList(){
        head = new ListNode(1);
        head.next = new ListNode(2);
        head.next.next = new ListNode(3);
        head.next.next.next = new ListNode(4);
        head.next.next.next.next = new ListNode(5);
    }

    public ListNode recurse(ListNode head){

        if(head==null || head.next==null)return head;
        ListNode node = recurse(head.next);
        head.next.next=head;
        head.next = null;

        return node;
    }

    public ListNode reverseList(ListNode head){
        if(head==null || head.next==null)return head;

        ListNode p1,p2,p3;
        p1=head;
        p2=p1.next;
        p3=p2.next;

        while(p2!=null){
            p2.next=p1;
            if(p1==head)
                p1.next=null;
            p1=p2;
            p2=p3;
            if(p2==null)break;
            p3=p2.next;
        }
        return p1;
    }

    public static void main(String[] args) {
        _206ReverseLinkedList obj = new _206ReverseLinkedList();
        //obj.reverseList(obj.head);
        obj.recurse(obj.head);
    }
}
