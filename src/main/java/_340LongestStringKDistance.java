import java.util.Collections;
import java.util.HashMap;

public class _340LongestStringKDistance {

    public int lengthOfLongestSubstringKDistinct(String s, int k) {

        if(k>s.length())return s.length();
        HashMap<Character,Integer>map = new HashMap<>();
        int i=0,j=0;
        int max=0;
        while(j<s.length()){

            map.put(s.charAt(j),map.getOrDefault(s.charAt(j),0)+1);
            if(map.size()==k){
                int len = (j-i)+1;
                max = Math.max(max,len);
            }

            while(map.size()>k){
                int c = map.get(s.charAt(i));
                --c;
                if(c>0)map.put(s.charAt(i),c);
                if(c==0)map.remove(s.charAt(i));
                ++i;
            }
            if(map.size()==k)max=Math.max(max,j-i+1);
            ++j;
        }
        return (max==0)?j:max;
    }

    public static void main(String[] args) {
        System.out.println(new _340LongestStringKDistance().lengthOfLongestSubstringKDistinct("aa",2));
    }
}
