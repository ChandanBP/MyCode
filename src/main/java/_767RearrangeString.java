import java.util.PriorityQueue;

public class _767RearrangeString {

    class CharacterCount implements Comparable<CharacterCount>{

        char ch;
        int count;

        public CharacterCount(char ch,int count){
            this.ch = ch;
            this.count = count;
        }

        @Override
        public int compareTo(CharacterCount characterCount) {
            return characterCount.count-this.count;
        }
    }

    public String reorganizeString(String S) {

        int count[] = new int[26];
        for(char ch:S.toCharArray()){
            count[ch-'a']++;
            if(count[ch-'a']>((S.length()+1)/2))return "";
        }

        PriorityQueue<CharacterCount>queue = new PriorityQueue<>();
        for(int i=0;i<count.length;i++){
            if(count[i]>0)
            queue.add(new CharacterCount((char)('a'+i),count[i]));
        }

        StringBuilder sb = new StringBuilder();
        CharacterCount prev=null;
        while (!queue.isEmpty()){
            CharacterCount curr = queue.poll();
            sb.append(curr.ch);

            curr.count--;
            if(prev!=null && prev.count>0)queue.add(prev);

            prev = curr;
        }

        return sb.toString();
    }

    public static void main(String[] args) {
        System.out.println(new _767RearrangeString().reorganizeString("aab"));
    }
}
