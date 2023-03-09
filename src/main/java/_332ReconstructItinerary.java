import java.util.*;

public class _332ReconstructItinerary {

    HashMap<String,LinkedList<String>> graph = new HashMap<>();
    LinkedList<String>result = new LinkedList();

     public void dfsHelper(String root){

        if(graph.containsKey(root)){
            LinkedList<String> destList = graph.get(root);
            while(!destList.isEmpty()){
                String dest = destList.pollFirst();
                dfsHelper(dest);
            }
        }
        result.addFirst(root);
    }

    public void dfs(){
        dfsHelper("JFK");
    }

    public List<String> findItinerary(List<List<String>> tickets) {

        ListIterator<List<String>>ite = tickets.listIterator();
        while(ite.hasNext()){
            List<String> list = ite.next();

            String parent = list.get(0);
            String child = list.get(1);

            LinkedList<String>children;
            if(graph.containsKey(parent)){
                children = graph.get(parent);
            }else{
                children = new LinkedList();
            }
            children.add(child);
            graph.put(parent,children);
        }

        graph.forEach((key,value)->Collections.sort(value));
        dfs();
        return result;
    }

    public static void main(String[] args) {
        LinkedList<List<String>>res = new LinkedList<>();

        LinkedList<String>list = new LinkedList<>();
        list.add("JFK");
        list.add("KUL");
        res.add(list);

        list = new LinkedList<>();
        list.add("JFK");
        list.add("NRT");
        res.add(list);

        list = new LinkedList<>();
        list.add("NRT");
        list.add("JFK");
        res.add(list);

        _332ReconstructItinerary obj =  new _332ReconstructItinerary();
        obj.findItinerary(res);
        Collections.reverse(obj.result);
        System.out.print(obj.result);
    }
}
