import java.util.HashMap;
import java.util.LinkedList;

public class _886PossibleBipartition {

    public boolean dfs(int root,
                       int c,
                       LinkedList[]graph,
                       HashMap<Integer,Integer>color){

        if(color.containsKey(root)){
            return color.get(root)==c;
        }
        color.put(root,c);

        LinkedList<Integer>children = graph[root];
        if(children!=null && children.size()>0){
            for(int i=0;i<children.size();i++){
                int ch = children.get(i);
                if(!color.containsKey(ch)){
                    return dfs(c,1-c,graph,color);
                }
            }
        }
        return true;
    }

    public boolean possibleBipartition(int N, int[][] dislikes) {

        HashMap<Integer,Integer>color = new HashMap<>();
        LinkedList[]graph = new LinkedList[N+1];
        for(int dislike[]:dislikes){
            if(graph[dislike[0]]==null)
                graph[dislike[0]] = new LinkedList();

            if(graph[dislike[1]]==null)
                graph[dislike[1]] = new LinkedList();

            graph[dislike[0]].add(dislike[1]);
            graph[dislike[1]].add(dislike[0]);
        }

        for(int i=1;i<=N;i++){
            if(!color.containsKey(i) && !dfs(i,0,graph,color)){
                return false;
            }
        }

        return true;
    }

    public static void main(String[] args) {

    }
}
