import java.util.Comparator;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.stream.Collectors;

public class _290WordPattern {
    public boolean wordPattern(String p, String s) {

        String arr[]=s.split(" ");
        if(p.length()!=arr.length)return false;
        HashMap<Character, String> map =new HashMap<>();

        for(int i=0; i<p.length(); i++){
            if(!map.containsKey(p.charAt(i))){
                if(map.containsValue(arr[i]))return false;
                map.put(p.charAt(i), arr[i]);
            }else{
                if(!map.get(p.charAt(i)).equals(arr[i]))return false;
            }
        }
        return true;
    }
}
