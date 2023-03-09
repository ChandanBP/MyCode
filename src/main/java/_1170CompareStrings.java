import java.util.Arrays;
import java.util.HashMap;

public class _1170CompareStrings {

    int qc[];
    int wc[];

    public int calcMinCount(String str){
        HashMap<Character,Integer>map = new HashMap<>();
        char min='\0';
        for(int i=0;i<str.length();i++){
            if(min=='\0')
                min=str.charAt(i);
            else
                if(str.charAt(i)<min)
                    min=str.charAt(i);

            map.put(str.charAt(i),map.getOrDefault(str.charAt(i),0)+1);
        }
        return map.get(min);
    }

    public int bs(int arr[],int key){

        int low=0;
        int high=arr.length-1;
        int res=-1;
        while(low<=high){
            int mid = (low+high)/2;
            if(key<arr[mid]){
                res=mid;
                high=mid-1;
            }else if(key==arr[mid]){
                low=mid+1;
            }else{
                low=mid+1;
            }
        }
        return res;
    }

    public int[] numSmallerByFrequency(String[] queries, String[] words) {

        qc = new int[queries.length];
        wc = new int[words.length];

        for(int i=0;i<queries.length;i++){
            qc[i] = calcMinCount(queries[i]);
        }

        for(int i=0;i<words.length;i++){
            wc[i] = calcMinCount(words[i]);
        }
        Arrays.sort(wc);

        int res[] = new int[queries.length];
        for(int i=0;i<qc.length;i++){
            int index = bs(wc,qc[i]);
            res[i]=(index==-1)?0:wc.length-index;
        }
        return res;
    }

    public static void main(String[] args) {
        String queries[] = {"bbb","cc"};
        String words[] = {"a","aa","aaa","aaaa"};
        new _1170CompareStrings().numSmallerByFrequency(queries,words);
    }
}
