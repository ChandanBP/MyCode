import java.util.HashMap;

public class _159LongestSubstring {

    public int lengthOfLongestSubstringTwoDistinct(String s) {
        
        HashMap<Character,Integer>map = new HashMap<>();
        int start=0,end=0;
        int max=-1;
        while(end<s.length()){
            char e = s.charAt(end);
            map.put(e,map.getOrDefault(e,0)+1);
            if(map.size()==2){
                int len = end-start+1;
                if(len>max){
                    max=len;
                }
            }
            if(map.size()>2){
                while(map.size()>2){
                    int c = map.get(s.charAt(start));
                    --c;
                    if(c>0)map.put(s.charAt(start),c);
                    if(c==0)map.remove(s.charAt(start));
                    ++start;
                }
            }
            ++end;
        }
        if(map.size()==1)return s.length();
        return max;
    }

    public static void main(String[] args) {
        //System.out.println(new _159LongestSubstring().lengthOfLongestSubstringTwoDistinct("eceba"));
        System.out.print('b'-'a');
    }
}
