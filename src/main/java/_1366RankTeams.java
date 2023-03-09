import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.LinkedList;

public class _1366RankTeams {

    public String rankTeams(String[] votes) {

        HashMap<Character,int[]>map = new HashMap<>();
        Arrays.stream(votes).forEach(vote ->{
            for(int i=0;i<vote.length();i++){
                char c = vote.charAt(i);
                int count[] = map.getOrDefault(c,new int[vote.length()]);
                count[i]++;
                map.put(c,count);
            }
        });

        LinkedList<Character>list = new LinkedList<>(map.keySet());
        Collections.sort(list,(a,b)->{
            for(int i=0;i<votes[0].length();i++){
                int c1 = map.get(a)[i];
                int c2 = map.get(b)[i];
                if(c1!=c2)return c2-c1;
            }
            return a.compareTo(b);
        });
        StringBuilder sb = new StringBuilder();
        for(int i=0;i<list.size();i++){
            sb.append(list.get(i));
        }
        return sb.toString();
    }

    public static void main(String[] args) {
        System.out.println(new _1366RankTeams().rankTeams(new String[]{"M","M","M","M"}));
    }
}
