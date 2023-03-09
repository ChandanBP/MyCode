import java.util.ArrayDeque;
import java.util.HashMap;
import java.util.Map.Entry;
import java.util.Optional;

public class _128LongestConsecutiveSequence {

    HashMap<Integer,Node>parentMap = new HashMap<>();
    ArrayDeque<Integer>deque = new ArrayDeque<>();

    class Node{
        int count;
        int parent;

        public Node(){
            this.parent = Integer.MIN_VALUE;
            this.count = 1;
        }
    }

    public int find(int u){

        Node p = parentMap.get(u);
        if(p==null)return Integer.MIN_VALUE+1;
        if(p.parent==Integer.MIN_VALUE)return u;
        int pa = find(p.parent);
        p.parent = pa;
        return pa;
    }

    public void union(int u,int v){

        int pu = find(u);
        int pv = find(v);
        if(pv==Integer.MIN_VALUE+1)return;

        Node npu = parentMap.get(pu);
        Node npv= parentMap.get(pv);
        npv.count = npu.count+npv.count;
        npu.parent = pv;
        parentMap.put(pu,npu);
        parentMap.put(pv,npv);
    }

    public int longestConsecutive(int[] nums) {

        for(int ele:nums){
            if(!parentMap.containsKey(ele)){
                Node node = new Node();
                parentMap.put(ele,node);
                deque.addLast(ele);
            }
        }

        for(int ele:deque){
            union(ele,ele-1);
        }

        Optional<Entry<Integer,Node>> entry =  parentMap.entrySet().stream().max((e1, e2)->e1.getValue().count-e2.getValue().count);
        return entry.get().getValue().count;
    }

    public static void main(String[] args) {
        System.out.println(new _128LongestConsecutiveSequence().longestConsecutive(new int[]{0,0,1,-1}));
    }
}
