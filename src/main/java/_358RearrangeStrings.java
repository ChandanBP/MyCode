import java.util.*;

public class _358RearrangeStrings {

    class CharacterCount implements Comparable<CharacterCount>{
        char c;
        int count;
        public CharacterCount(char c,int count){
            this.c=c;
            this.count=count;
        }

        @Override
        public int compareTo(CharacterCount characterCount) {
            if(this.count==characterCount.count)return this.c-characterCount.c;
            return characterCount.count-this.count;
        }
    }

    public String rearrangeString(String s, int k) {

        if(k==0||s.length()<=1)return s;

        HashMap<Character,Integer>map = new HashMap<>();
        for(int i=0;i<s.length();i++){
            map.put(s.charAt(i),map.getOrDefault(s.charAt(i),0)+1);
        }
        PriorityQueue<CharacterCount>pq = new PriorityQueue<>();

        map.forEach((key,value)->{
            CharacterCount cc = new CharacterCount(key,value);
            pq.add(cc);
        });

        StringBuilder sb = new StringBuilder();
        while(!pq.isEmpty()){

            CharacterCount ccp = pq.poll();
            sb.append(ccp.c);
            ccp.count--;
            LinkedList<CharacterCount> list = new LinkedList();
            if(ccp.count>0)list.add(ccp);
            for(int t=0;t<k-1;t++){
                if(pq.isEmpty() && sb.toString().length()!=s.length())return "";
                CharacterCount cc = pq.poll();
                if(cc!=null){
                    sb.append(cc.c);
                    cc.count--;
                    if(cc.count>0)list.add(cc);
                }
            }
            list.forEach(cc->pq.add(cc));
        }
        return sb.toString();
    }

    public static void main(String[] args) {
        System.out.println(new _358RearrangeStrings().rearrangeString("a",2));
    }
}
