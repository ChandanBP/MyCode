import java.util.*;

public class _133CloneGraph {

    class Node {

        public int val;
        public List<Node> neighbors;

        public Node() {
            val = 0;
            neighbors = new ArrayList();
        }

        public Node(int _val) {
            val = _val;
            neighbors = new ArrayList();
        }

        public Node(int _val, ArrayList<Node> _neighbors) {
            val = _val;
            neighbors = _neighbors;
        }
    }

    public Node cloneGraph(Node node) {

        Queue<Node>queue = new LinkedList<>();
        HashMap<Node,Node>visited = new HashMap<>();

        visited.put(node,new Node(node.val));

        while(!queue.isEmpty()){
            Node n = queue.poll();
            for(Node neighbour:n.neighbors){
                if(!visited.containsKey(neighbour)){
                    visited.put(neighbour,new Node(neighbour.val));
                    queue.add(neighbour);
                }
                visited.get(n).neighbors.add(visited.get(neighbour));
            }
        }

        return visited.get(node);
    }

    public static void main(String[] args) {

    }
}
