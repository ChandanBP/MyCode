import java.util.Map;
import java.util.TreeMap;

public class _900RLEIterator {
    class Node{
        int si;
        int ei;
        int val;
        public Node(int si,int ei,int val){
            this.si = si;
            this.ei = ei;
            this.val = val;
        }
    }

    int n;
    int index=0;
    TreeMap<Integer,Node>map;

    public _900RLEIterator(int[] A) {

        if(A.length==0)return;

        int count = 0;
        map = new TreeMap();
        for(int i=0;i<A.length;i+=2){
            if(A[i]==0)continue;
            count+=A[i];
            map.put(index,new Node(index,index+A[i]-1,A[i+1]));
            index = index+A[i];
        }
        n = count;
        index = -1;
    }

    public int next(int n) {
        index = index+n;
        System.out.println(index);
        if(index>this.n-1)return -1;
        Map.Entry<Integer,Node>entry = map.floorEntry(index);
        Node node = entry.getValue();
        if(node==null)return -1;
        return node.val;
    }

    public static void main(String[] args) {
        int n = 612783106;
        int index = 612783105;

        System.out.println(index>=n);
//        _900RLEIterator obj = new _900RLEIterator(new int[]{3,8,0,9,2,5});
//        obj.next(2);
//        obj.next(1);
//        obj.next(1);
//        obj.next(2);
    }
}
