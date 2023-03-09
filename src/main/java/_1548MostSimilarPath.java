import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.ListIterator;

public class _1548MostSimilarPath {

    String tp[];
    Path dp[][];
    LinkedList graph[];
    String names[];

    public List<Integer> mostSimilar(int n, int[][] roads, String[] names, String[] targetPath){

        this.names = names;
        tp = targetPath;
        dp = new Path[n][tp.length];
        for(int i=0;i<n;i++){
            Arrays.fill(dp[i],new Path(null,Integer.MAX_VALUE));
        }
        graph = new LinkedList[n];

        for(int i=0;i<roads.length;i++){
            int u = roads[i][0];
            int v = roads[i][1];

            if(graph[u]==null)graph[u] = new LinkedList();
            if(graph[v]==null)graph[v] = new LinkedList();

            graph[u].add(v);
            graph[v].add(u);
        }

        Path minPath=null;
        int min = Integer.MAX_VALUE;
        for(int i=0;i<n;i++){

            Path path = getMinEditDistancePath(i,0);
            if(path.cost<min){
                min = path.cost;
                minPath = path;
            }
        }
        return minPath.path;
    }

    public Path getMinEditDistancePath(int u,int index){

        if(index==tp.length)return new Path(new LinkedList(),0);
        if(dp[u][index].path!=null)return dp[u][index];

        String tcity = tp[index];
        String pcity = names[u];

        Path p = new Path(new LinkedList(),Integer.MAX_VALUE);
        p.path.add(u);
        p.cost = (pcity.equals(tcity))?0:1;

        // loop for all edges of u to find min edit distance to node at index
        ListIterator<Integer>ite = graph[u].listIterator();
        Path minPath = null;
        while(ite.hasNext()){
            int v = ite.next();
            Path p1 = getMinEditDistancePath(v,index+1);
            if(minPath==null)minPath = p1;
            else if(p1.cost<minPath.cost){
                minPath = p1;
            }
        }

        p.path.addAll(minPath.path);
        p.cost+=minPath.cost;
        dp[u][index] = p;
        return dp[u][index];
    }

    class Path{
        LinkedList<Integer>path;
        int cost;
        public Path(LinkedList<Integer>path,int cost){
            this.path = path;
            this.cost = cost;
        }
    }
}
