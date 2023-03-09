import java.util.HashMap;
import java.util.LinkedList;

public class UnionByRank {

    class Node{
        int parent;
        int rank;
    }

    LinkedList<Integer> nodes[] = new LinkedList[10];
    HashMap<Integer,Integer> parentMap = new HashMap<>();
    HashMap<Integer,Node>nodeMap = new HashMap<>();

    public int find(int v){
        if(parentMap.get(v)==-1)return v;
        int p = find(parentMap.get(v));
        parentMap.put(v,p);
        return p;
    }

    public void union(int u,int v){
        int parentu = find(u);
        int parentv = find(v);

        Node unode = nodeMap.get(parentu);
        Node vnode = nodeMap.get(parentv);
        if(unode.rank> vnode.rank){
            vnode.parent = u;
        }else if(vnode.rank>unode.rank){
            unode.parent = v;
        }else{
            unode.parent = v;
            vnode.rank++;
        }
    }

    public boolean isCyclic(){

        for(int i=0;i<nodes.length;i++){
            int from = i;

            for(int j=0;j<nodes[i].size();j++){
                int to = nodes[i].get(j);
                if(find(from)==find(to))return true;
                union(from,to);
            }
        }
        return false;
    }

    public static void main(String[] args) {


    }
}
