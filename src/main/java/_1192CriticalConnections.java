import java.util.*;

public class _1192CriticalConnections {

    HashMap<Integer,LinkedList<Integer>>graph = new HashMap<>();
    int discovery[];
    int low[];
    List<List<Integer>>result = new LinkedList<>();
    int c=0;

    public void dfs(int root,int p){

        discovery[root] = low[root]= ++c;
        LinkedList<Integer>children = graph.get(root);
        if(children!=null && children.size()>0){
            for(int i=0;i<children.size();i++){
                int c = children.get(i);
                if(c==p)continue;
                if(discovery[c]==0){
                    dfs(c,root);
                    low[root] = Math.min(low[root], low[c]);
                    if (low[c] > discovery[root]) {
                        result.add(Arrays.asList(root, c));
                    }
                }else{
                    low[root]=Math.min(low[root],discovery[c]);
                }
            }
        }
    }

    public List<List<Integer>> criticalConnections(int n, List<List<Integer>> connections) {

        discovery = new int[n];
        low = new int[n];

        connections.stream().forEach(
                list -> {
                    int u = list.get(0);
                    int v = list.get(1);
                    LinkedList<Integer>list1 = graph.getOrDefault(u,new LinkedList<>());
                    LinkedList<Integer>list2 = graph.getOrDefault(v,new LinkedList<>());
                    list1.add(v);
                    list2.add(u);
                    graph.put(u,list1);
                    graph.put(v,list2);
                }
        );
        dfs(0,0);
        return result;
    }

    public static void main(String[] args) {
        List<List<Integer>>connections = new LinkedList<>();
        connections.add(Arrays.asList(0,1));
        connections.add(Arrays.asList(1,2));
        connections.add(Arrays.asList(2,0));
        connections.add(Arrays.asList(1,3));

        _1192CriticalConnections obj = new _1192CriticalConnections();
        obj.criticalConnections(4,connections);
        System.out.println();
    }
}
