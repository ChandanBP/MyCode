import java.util.LinkedList;

public class _1466ReorderRoutes {

    LinkedList<Edge> graph[];
    int min=0;
    class Edge{
        int u;
        int v;
        int type; // 0 for outgoing,1 for incoming
        boolean isVisited;
        public Edge(int u,int v,int type){
            this.u=u;
            this.v=v;
            this.type=type;
            isVisited=false;
        }
    }

    public void findMinimum(int root){

        for(Edge edge:graph[root]){
            if(!edge.isVisited){
                edge.isVisited=true;
                if(edge.u==root){
                    ++min;
                    findMinimum(edge.v);
                }else{
                    findMinimum(edge.u);
                }
            }
        }
    }

    public int minReorder(int n, int[][] connections) {

        graph = new LinkedList[n];
        for(int []connection:connections){
            if(graph[connection[0]]==null)graph[connection[0]]=new LinkedList();
            if(graph[connection[1]]==null)graph[connection[1]]=new LinkedList();

            Edge edge = new Edge(connection[0],connection[1],0);
            graph[connection[0]].add(edge);
            graph[connection[1]].add(edge);
        }
        findMinimum(0);
        return min;
    }

    public static void main(String[] args) {
        System.out.println(new _1466ReorderRoutes().minReorder(6,new int[][]{{0,1},{1,3},{2,3},{4,0},{4,5}}));
    }
}
