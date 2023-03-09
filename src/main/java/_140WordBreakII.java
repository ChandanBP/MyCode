import java.util.Arrays;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;

public class _140WordBreakII {

    List<String>result = new LinkedList();
    HashSet<String>dict;

    public void addWords(String s, int start,StringBuilder sb){

        if(start>=s.length()){
            if(sb.length()>=s.length()){
                result.add(sb.toString());
            }
            return;
        }

        for(int i=start;i<=s.length();i++){
            String str = s.substring(start,i);
            if(str.length()>0 && dict.contains(str)){
                if(sb.length()>0){
                    StringBuilder sbtemp = new StringBuilder(sb);
                    sbtemp.append(" ");
                    sbtemp.append(str);
                    addWords(s,i,sbtemp);
                }
            }
        }
    }

    public List<String> wordBreak(String s, List<String> wordDict) {

        dict = new HashSet(wordDict);
        for(int i=0;i<s.length();i++){
            String str = s.substring(0,i+1);
            if(str.length()>0 && dict.contains(str)){
                StringBuilder sb = new StringBuilder();
                sb.append(str);
                addWords(s,i+1,sb);
            }
        }
        return result;
    }

    public static void main(String[] args) {
        new _140WordBreakII().wordBreak("pineapplepenapple", Arrays.asList("apple","pen","applepen","pine","pineapple"));
    }
}
