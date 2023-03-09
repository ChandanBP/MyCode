import java.util.ArrayList;
import java.util.Optional;
import java.util.OptionalInt;

public class _1153StringTransform {

    public boolean canConvert(String str1, String str2) {

        if(str1.length()!=str2.length())return false;

        ArrayList<Integer> list[] = new ArrayList[26];
        for(int i=0;i<str1.length();i++){
            if(list[str1.charAt(i)-'a']==null)
                list[str1.charAt(i)-'a'] = new ArrayList();

            list[str1.charAt(i)-'a'].add(i);
        }

        for(int i=0;i<26;i++){
            if(list[i]==null || list[i].size()<=1)continue;

            char c = str2.charAt(list[i].get(0));
            for(int j=1;j<list[i].size();j++){
                if(str2.charAt(list[i].get(j))!=c)return false;
            }
        }

        return true;
    }

    public static void main(String[] args) {
        Optional<Integer>optional = Optional.of(10);
        System.out.println(optional.get());
    }
}
