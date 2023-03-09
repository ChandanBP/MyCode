import java.util.*;

public class _737SentenceSimliarity {

    String words1[] = {"an","extraordinary","meal"};
    String words2[] = {"one","good","dinner"};
    HashSet<String>visited;
    HashMap<String,List<String>>map;
    List<List<String>>pairs;

    _737SentenceSimliarity(){
        pairs = new LinkedList<>();

        LinkedList<String>list1 = new LinkedList<>();
        list1.add("great");
        list1.add("fine");

        LinkedList<String>list2 = new LinkedList<>();
        list2.add("drama");
        list2.add("acting");

        /*LinkedList<String>list3 = new LinkedList<>();
        list3.add("acting");
        list3.add("drama");*/

        LinkedList<String>list4 = new LinkedList<>();
        list4.add("skills");
        list4.add("talent");

        pairs.add(list1);
        pairs.add(list2);
        //pairs.add(list3);
        pairs.add(list4);
    }

    public void addToGraph(String word1,String word2){
        List<String>list = (map.containsKey(word1))?map.get(word1):new LinkedList<>();
        list.add(word2);
        map.put(word1,list);
    }

    public boolean dfs(String root,int i){

        List<String>children = map.get(root);

        if(children==null) return false;

        Iterator<String>ite = children.listIterator();
        while(ite.hasNext()){
            String meaning = ite.next();
            if(words1[i].equals(meaning)){
                return true;
            }
            if(!visited.contains(meaning)){
                visited.add(meaning);
                return dfs(meaning,i);
            }
        }
        return false;
    }

    public boolean areSentencesSimilarTwo(String[] words1, String[] words2, List<List<String>> pairs) {

        if(words1.length!=words2.length) return false;

        map = new HashMap<>();
        pairs.parallelStream().forEach(pair ->{
            String word1 = pair.get(0);
            String word2 = pair.get(1);
            addToGraph(word1,word2);
            addToGraph(word2,word1);
        });

        for(int i=0;i<words2.length;i++){

            String word = words2[i];
            visited = new HashSet<>();

            if(!visited.contains(word)){
                visited.add(word);
                if(!dfs(word,i))
                    return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        _737SentenceSimliarity obj = new _737SentenceSimliarity();
        System.out.println(obj.areSentencesSimilarTwo(obj.words1,obj.words2,obj.pairs));
    }
}
