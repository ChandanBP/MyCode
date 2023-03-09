import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;

public class _139WordBreak {

    public boolean wordBreak(String s, List<String> wordDict){

        StringBuilder sb = new StringBuilder();
        HashSet<String> set = new HashSet<String>();
        for(int i=0;i<wordDict.size();i++){
            set.add(wordDict.get(i));
        }
        int count=0;
        int start = 0;
        for(int i=0;i<s.length();i++){

            if(set.contains(s.substring(i))){
                count+=(s.length()-i);
            }

            sb.append(s.charAt(i));
            if(set.contains(sb.toString())){
                count+=(i-start)+1;
                start=i+1;
                sb = new StringBuilder();
            }
        }
        return (count==s.length())?true:false;
    }

    public static void main(String[] args) {
        LinkedList<String>list = new LinkedList<>();
        list.add("dog");
        list.add("s");
        list.add("gs");
        System.out.println(new _139WordBreak().wordBreak("dogs",list));
    }
}
