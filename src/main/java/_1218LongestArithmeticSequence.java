import java.util.HashMap;

public class _1218LongestArithmeticSequence {

    public int longestSubsequence(int[] arr, int difference) {

        HashMap<Integer,Integer>map = new HashMap<>();
        int max = 0;
        for(int i=0;i<arr.length;i++){
            int x = arr[i]-difference;
            int c = 1+map.getOrDefault(x,0);
            map.put(arr[i],c);
            max = Math.max(max,c);
        }
        return max;
    }

    public static void main(String[] args) {

    }
}
