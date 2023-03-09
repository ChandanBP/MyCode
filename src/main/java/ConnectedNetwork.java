import java.util.LinkedList;

public class ConnectedNetwork {

    LinkedList<Integer>[] graph;
    int n;
    int connections[][];
    boolean visited[] = new boolean[n];

    public void dfs(int u){

        for(int i=0;i<graph[u].size();i++){
            int v = graph[u].get(i);
            if(!visited[v]){
                visited[v] = true;
                dfs(v);
            }
        }
    }

    public int makeConnected(int n, int[][] connections) {

        if(connections.length<n-1)return -1;

        this.n = n;
        this.connections = connections;

        graph = new LinkedList[n];
        for(int i=0;i<graph.length;i++){
            graph[i] = new LinkedList<>();
        }

        for(int i=0;i<connections.length;i++){
            graph[connections[i][0]].add(connections[i][1]);
            graph[connections[i][1]].add(connections[i][0]);
        }

        visited = new boolean[n];
        // Traverse the graph
        int connectedComponents = 0;
        for(int i=0;i<n;i++){

            if(!visited[i]){
                visited[i] = true;
                connectedComponents+=1;
                dfs(i);
            }
        }

        return connectedComponents-1;
    }

    public static void main(String[] args) {
        ConnectedNetwork connectedNetwork = new ConnectedNetwork();
        int arr[][] = {{0,1},{0,2},{3,4},{2,3}};
        int n = 5;
        System.out.println(connectedNetwork.makeConnected(n,arr));
    }
}
