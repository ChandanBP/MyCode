import java.util.Arrays;
import java.util.PriorityQueue;

public class _1167MinCostToConnectSticks {

    public int connectSticks(int[] sticks) {

        if(sticks==null||sticks.length==0)return 0;
        if(sticks.length==1)return 0;

        PriorityQueue<Integer> queue = new PriorityQueue();
        Arrays.stream(sticks).forEach(ele->queue.add(ele));

        int cost = 0;
        while(!queue.isEmpty() && queue.size()>1){
            int x = queue.poll();
            int y = queue.poll() ;
            cost+=x+y;
            queue.offer(x+y);
        }
        return cost;
    }

    public static void main(String[] args) {

    }
}
