import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;

public class _187RepeatedDNA {
    public List<String> findRepeatedDnaSequences(String s) {

        HashMap<Character,Integer> map = new HashMap();
        map.put('A',0);
        map.put('C',1);
        map.put('G',2);
        map.put('T',3);

        int hash = 0;
        int K = 10;
        int n = s.length();
        int nums[] = new int[s.length()];
        for(int i=0;i<s.length();i++){
            nums[i] = map.get(s.charAt(i));
        }

        int pow = (int)Math.pow(4,9);
        HashSet<String> answer = new HashSet();
        HashSet<Integer>visited = new HashSet();
        for(int i=0;i<n-K+1;i++){
            if(i==0){
                for(int c=0;c<K;++c){
                    hash = hash*4+nums[c];
                }
            }else{
                hash = (hash-(nums[i-1]*pow))*4+(nums[i+9]);
                hash = hash * 4 - nums[i - 1] * pow + nums[i + 10 - 1];
            }
            if(visited.contains(hash))
                answer.add(s.substring(i,i+10));
            visited.add(hash);
        }
        return new ArrayList(answer);
    }

    public static void main(String[] args) {
        //new _187RepeatedDNA().findRepeatedDnaSequences("AAAAACCCCCAAAAACCCCCCAAAAAGGGTTT");

        String one = "One";
        ArrayList<String>list = new ArrayList<>();
        list.add(one);
        System.out.println(one);
        System.out.println(list.get(0));

        one = "two";
        System.out.println(one);
        System.out.println(list.get(0));
    }
}
