import java.util.HashMap;
import java.util.LinkedList;
import java.util.Queue;

public class _1376TimeNeeded {

    HashMap<Integer, LinkedList<Integer>>graph = new HashMap<>();
    int[] informTime;
    boolean visited[];
    int time=0;

    public int numOfMinutes(int n, int headID, int[] manager, int[] informTime) {

        visited = new boolean[n];
        this.informTime = informTime;

        for(int i=0;i<manager.length;i++){
            LinkedList<Integer>list = graph.getOrDefault(manager[i],new LinkedList<>());
            list.add(i);
            graph.put(manager[i],list);
        }
        bfs(headID);
        return time;
    }

    public void bfs(int root){
        Queue<Integer>queue = new LinkedList<>();
        Queue<Integer>t = new LinkedList<>();

        queue.add(root);
        t.add(0);

        int max=0;
        while(!queue.isEmpty()){
            int m = queue.poll();
            int tc = t.poll();
            int ct = tc+informTime[m];

            LinkedList<Integer>children = graph.get(m);
            if(children!=null && children.size()>0){
                max = Math.max(max,ct);
                for(int i=0;i<children.size();i++){
                    if(graph.containsKey(children.get(i))){
                        queue.add(children.get(i));
                        t.add(ct);
                    }
                }
            }
        }
        time=max;
    }

    public static void main(String[] args) {
        System.out.println(new _1376TimeNeeded().numOfMinutes(11,4,new int[]{5,9,6,10,-1,8,9,1,9,3,4},
                new int[]{0,213,0,253,686,170,975,0,261,309,337}));
    }
}
