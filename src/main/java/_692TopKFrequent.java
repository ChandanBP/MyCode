import java.util.*;

public class _692TopKFrequent {

    public List<String> topKFrequent(String[] words, int k) {

        HashMap<String,Integer>count = new HashMap<>();
        Arrays.stream(words).forEach(word->count.put(word,count.getOrDefault(word,0)+1));

        PriorityQueue<String>queue = new PriorityQueue<>((word1,word2)->{
            if(count.get(word1)==count.get(word2))
                return word2.compareTo(word1);
            return count.get(word1)-count.get(word2);}
        );

        count.forEach((word,c)->{
            queue.add(word);
            if(queue.size()>k)queue.poll();
        });

        List<String>list = new LinkedList<>();
        while (!queue.isEmpty()){
            list.add(queue.poll());
        }
        Collections.reverse(list);
        return list;
    }

    public static void main(String[] args) {
        new _692TopKFrequent().topKFrequent(new String[]{"i", "love", "leetcode", "i", "love", "coding"},2);
    }
}
