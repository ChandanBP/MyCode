import java.util.HashSet;

public class _1062LongestRepeatingSubString {

    int longest = 0;
    HashSet<Long> runningHash = new HashSet<>();

    public int longestRepeatingSubstring(String S) {

        int start = 0;
        int end = S.length()-1;

        while(start<=end){
            int mid = (start+end)/2;
            boolean match = hash(S,mid);
            if(match){
                start=mid+1;
            }else{
                end=mid-1;
            }
        }
        return longest;
    }

    public boolean hash(String s,int K){

        int k=0;
        int mod = 1000000007;
        int position = K;
        long res=0;
        while(k<=K){
            res+= (Math.pow(10,position)%mod)*(1+s.charAt(k)-'a')%mod;
            --position;
            ++k;
        }
        runningHash.add(res);

        int end = K+1;
        int start = 0;
        while(end<s.length()){
            char ch = s.charAt(start);
            res -= ((Math.pow(10,K)%mod)*(1+(ch-'a')))%mod;
            res = ((res%mod)*10)%mod;
            res = ((res%mod)+(1+s.charAt(end)-'a'))%mod;

            if(runningHash.contains(res)){
                if((K+1)>longest){
                    longest = K+1;
                    return true;
                }
            }
            runningHash.add(res);
            ++start;
            ++end;
        }
        return false;
    }

    public static void main(String[] args) {
        _1062LongestRepeatingSubString obj = new _1062LongestRepeatingSubString();
        System.out.println(obj.longestRepeatingSubstring("abcd"));
        System.out.println(obj.longestRepeatingSubstring("abbaba"));
        System.out.println(obj.longestRepeatingSubstring("aabcaabdaab"));
        System.out.println(obj.longestRepeatingSubstring("aaaaa"));
        System.out.println(obj.longestRepeatingSubstring("banana"));
    }
}
