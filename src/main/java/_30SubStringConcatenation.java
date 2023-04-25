import java.util.*;
import java.util.stream.Collectors;

public class _30SubStringConcatenation {

    public List<Integer> findSubstring(String s, String[] words) {
        int wordLength = words[0].length();
        int totalWordsLength = wordLength * words.length;
       List<Integer>result = new LinkedList();
       HashMap<String,Integer>map = new HashMap();
       for(String word:words)
           map.put(word,map.getOrDefault(word,0)+1);

       for(int i=0;i<=s.length()-totalWordsLength;i++){

           HashMap<String,Integer>seen = new HashMap();
            for(int j=0;j<words.length;j++){
                int index = i+j*wordLength;
                String word = s.substring(index,index+wordLength);

                if(!map.containsKey(word))break;

                seen.put(word,seen.getOrDefault(word,0)+1);
                if(seen.get(word)>map.get(word))break;
                if(j+1==words.length)result.add(i);
            }
       }
       return result;
    }

    public static void main(String[] args) {
        System.out.println(new _30SubStringConcatenation().findSubstring("lingmindraboofooowingdingbarrwingmonkeypoundcake",
                new String[]{"fooo","barr","wing","ding","wing"}));
    }
}
