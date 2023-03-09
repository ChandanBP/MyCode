import java.util.Arrays;
import java.util.HashSet;

public class _817LinkedListComponents {

    public int numComponents(ListNode head, int[] G) {
        if(head==null || G==null || G.length==0)return 0;

        HashSet<Integer>glist = new HashSet<>();
        Arrays.stream(G).forEach(g->glist.add(g));

        boolean first = false;
        int connected = 0;
        while(head!=null){
            if(glist.contains(head.val)){
                if(!first){
                    first = true;
                }
            }else{
                if(first)
                ++connected;
            }
            head = head.next;
        }

        return 1+connected;
    }

    public static void main(String[] args) {

    }
}
