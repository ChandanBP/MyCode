import java.util.LinkedList;
import java.util.List;
import java.util.ListIterator;

public class _524LongestWordDelete {

    // Is str1 is a subsequence of str2
    public boolean isSubSequence(String str1,String str2){
        int m = str1.length();
        int n = str2.length();
        int j = 0; // for str1

        for(int i=0;i<n && j<m;i++){
            if(str1.charAt(j)==str2.charAt(i)){
                ++j;
            }
        }
        return (j==m)?true:false;
    }

    public String findLongestWord(String s, List<String> d) {

        int len = Integer.MIN_VALUE;
        ListIterator<String>listIterator = d.listIterator();
        String res="";

        while(listIterator.hasNext()){
            String str = listIterator.next();
            if(isSubSequence(str,s) && str.length()>=len){
                if(str.length()==len){
                    if(res.compareTo(str)>0)res = str;
                }else{
                    res = str;
                }
                len = str.length();
            }
        }
        return res;
    }

    public static void main(String[] args) {
        List<String>list = new LinkedList<>();
        list.add("ale");
        list.add("apple");
        list.add("monkey");
        list.add("plea");
        System.out.println(new _524LongestWordDelete().findLongestWord("abpcplea",list));
    }
}
