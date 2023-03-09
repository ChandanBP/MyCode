import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;

public class _387FirstUniqueCharacter implements Comparable<_387FirstUniqueCharacter> {

    @Override
    public int compareTo(_387FirstUniqueCharacter firstUniqueCharacter) {
        return 0;
    }

    public int firstUniqChar(String s) {
        LinkedHashMap<Character,Integer>map = new LinkedHashMap();
        HashMap<Character,Integer>index = new HashMap<>();
        for(int i=0;i<s.length();i++){
            map.put(s.charAt(i),map.getOrDefault(s.charAt(i),0)+1);
            index.put(s.charAt(i),i);
        }

        Iterator<Map.Entry<Character,Integer>>iterator = map.entrySet().iterator();
        while (iterator.hasNext()){
            Map.Entry<Character,Integer>entry = iterator.next();
            if(entry.getValue()==1)return index.get(entry.getKey());
        }
        return 0;
    }

    public static void main(String[] args) {
        System.out.println(new _387FirstUniqueCharacter().firstUniqChar("loveleetcode"));
    }
}
