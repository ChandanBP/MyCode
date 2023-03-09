import java.time.ZoneId;
import java.time.ZonedDateTime;

public class _24SwapNode {

    public ListNode swapPairs(ListNode head) {

        if(head==null||head.next==null)return head;

        ListNode p1=head,p2=head.next,prev=null,h1=null;

        while(p1!=null && p2!=null){

            ListNode temp = p2.next;
            p2.next = p1;
            p1.next = temp;

            // update the header
            if(prev==null){
                prev = p1;
                h1 = p2;
            }else{
                prev.next = p2;
                prev = p1;
            }
            p1 = temp;
            if(p1!=null)
                p2 = p1.next;
        }

        return h1;
    }

    public static void main(String[] args) {
        System.out.println(ZonedDateTime.now(ZoneId.of("UTC")));
    }
}
