import java.util.LinkedList;
import java.util.List;

public class VerticalWords {

    public List<String> printVertically(String s) {

        String words[] = s.split("\\s+");
        int max = Integer.MIN_VALUE;
        for(int i=0;i<words.length;i++){
            max = Math.max(max,words[i].length());
        }

        StringBuilder sb[] = new StringBuilder[max];
        for(int i=0;i<words.length;i++){

            int diff = max - words[i].length();
            StringBuilder sb1 = new StringBuilder();
            sb1.append(words[i]);
            while(diff>0){
                sb1.append(' ');
                --diff;
            }

            String word = sb1.toString();
            for(int j=0;j<word.length();j++){
                if(sb[j]==null)sb[j]= new StringBuilder();
                sb[j].append(word.charAt(j));
            }
        }

        List<String>list = new LinkedList<>();
        for(int i=0;i<sb.length;i++){
            list.add(sb[i].toString().stripTrailing());
        }
        return list;
    }

    public static void main(String[] args) {
        VerticalWords verticalWords = new VerticalWords();
        List<String>words = verticalWords.printVertically("CONTEST IS COMING");
        for(String word: words){
            System.out.println(word);
        }
    }
}
