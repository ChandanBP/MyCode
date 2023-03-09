import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.LinkedList;

public class _1048LongestStringChain {

    public boolean differsByOne(int count1[],int count2[]){
        int sum=0;
        for(int i=0;i<26;i++){
            sum+=Math.abs(count1[i]-count2[i]);
        }
        return (sum==1)?true:false;
    }

    public int longestStrChain(String[] words) {

        if(words==null || words.length==0)return 0;

        int count[][] = new int[words.length][26];
        HashMap<Integer, LinkedList<Integer>>map = new HashMap<>();

        for(int i=0;i<words.length;i++){
            String word = words[i];
            for(int j=0;j<word.length();j++){
                count[i][word.charAt(j)-'a']++;
            }
            LinkedList<Integer>indices = map.getOrDefault(word.length(),new LinkedList<>());
            indices.add(i);
            map.put(word.length(),indices);
        }

        LinkedList<Integer>list = new LinkedList<>(map.keySet());
        Collections.sort(list);

        int max = 1;
        int dp[] = new int[words.length];
        Arrays.fill(dp,1);

        for(int k=0;k<list.size();k++){
            int len = list.get(k);
            if(len==1)continue;

            LinkedList<Integer>iIndices = map.get(len);
            if(iIndices!=null && iIndices.size()>0){

                for(int i=0;i<iIndices.size();i++){
                    int iIndex = iIndices.get(i);
                    int count1[] = count[iIndex];

                    LinkedList<Integer>jIndices = map.get(len-1);
                    if(jIndices!=null && jIndices.size()>0){

                        for(int j=0;j<jIndices.size();j++){

                            int jIndex = jIndices.get(j);
                            int count2[] = count[jIndex];
                            if(differsByOne(count1,count2)){
                                dp[iIndex] = Math.max(dp[iIndex],1+dp[jIndex]);
                                max = Math.max(max,dp[iIndex]);
                            }
                        }
                    }
                }
            }
        }
        return max;
    }

    public static void main(String[] args) {
        System.out.println(new _1048LongestStringChain().longestStrChain(new String[]{"a","b","ba","bca","bda","bdca"}));
    }
}
