import java.util.*;

public class _1377FrogPosition {

    HashMap<Integer, LinkedList<Integer>> graph = new HashMap();
    HashSet<Integer> visited = new HashSet();
    HashMap<Integer,Long>pProbability = new HashMap();
    HashMap<Integer,Integer>parent = new HashMap();
    HashMap<Integer,LinkedList<Integer>>unvisitedChildren = new HashMap();
    double probablity = 0;

    public double bfs(int t,int target) {

        if(target==1){
            int cSize = (graph.containsKey(1))?graph.get(1).size():0;
            probablity=(cSize==0)?1:0;
            return probablity;
        }

        Queue<Integer>queue = new LinkedList();
        queue.add(1);
        parent.put(1, -1);
        pProbability.put(1, (long)1);

        int time=0;
        while(!queue.isEmpty()) {

            int size = queue.size();
            for(int i=0;i<size;i++) {

                int p = queue.poll();
                visited.add(p);

                // Generate unvisited vertices for this p
                LinkedList<Integer>pChildren = graph.get(p);
                LinkedList<Integer>unvisited = new LinkedList();
                ListIterator<Integer>ite = pChildren.listIterator();
                while(ite.hasNext()) {
                    int c = ite.next();
                    if(!visited.contains(c)) {
                        unvisited.add(c);
                        queue.add(c);
                        parent.put(c, p);
                    }
                }
                unvisitedChildren.put(p, unvisited);

                // Put probability to reach this node
                int parentP = parent.get(p);
                if(parentP==-1)continue;
                pProbability.put(p, pProbability.get(parentP)*unvisitedChildren.get(parentP).size());

                if(p==target) {
                    probablity = (double) 1/pProbability.get(p);
                    probablity = (time>t||(time<t && unvisited.size()>0))?0:probablity;
                    return probablity;
                }
            }
            ++time;
        }
        return probablity;
    }

    public double frogPosition(int n, int[][] edges, int t, int target) {
        Arrays.stream(edges).forEach(edge -> {
            int u = edge[0];
            int v = edge[1];
            LinkedList<Integer> uChildren = graph.getOrDefault(u, new LinkedList());
            LinkedList<Integer> vChildren = graph.getOrDefault(v, new LinkedList());
            uChildren.add(v);
            vChildren.add(u);
            graph.put(u, uChildren);
            graph.put(v, vChildren);
        });
        bfs(t,target);
        return probablity;
    }

    public static void main(String[] args) {
        _1377FrogPosition obj = new _1377FrogPosition();
        int edges[][] = new int[][] { { 1, 2 }, { 1, 3 }, { 1, 7 }, { 2, 4 }, { 2, 6 }, { 3, 5 } };
        System.out.println(obj.frogPosition(7, edges, 1, 7));
    }
}

