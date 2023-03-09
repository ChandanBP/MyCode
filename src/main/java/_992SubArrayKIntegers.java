import java.util.HashMap;
import java.util.Map;

public class _992SubArrayKIntegers {

    public int subarraysWithKDistinct(int[] A, int K) {
        // brainstorm: subarrays with at most K distinct values contains two parts:
        // subarrays with exactly K distinct values + subarrays with at most K - 1 distinct values
        int val1 = atMostK(A, K);
        int val2 = atMostK(A, K - 1);
        return val1-val2;
    }

    private int atMostK(int[] A, int k) {
        // use a map to control what we've seen before, map.size() compared to k during the process.
        Map<Integer, Integer> map = new HashMap<>();
        int start = 0;
        int end = 0;
        int res = 0;
        while (end < A.length) {
            // put it into map anyway
            map.put(A[end], map.getOrDefault(A[end], 0) + 1);

            // if map size is larger then k, must reduce it to exactly k by moving start and deleting the count in map
            while (map.size() > k) {
                map.put(A[start], map.getOrDefault(A[start], 0) - 1);
                if (map.get(A[start]) == 0) map.remove(A[start]);
                start++;
            }
            res += end - start + 1; // brainstorm: when you get a range that satisfy at most k distinct values,
            // how many subarrays are there ending with this "end" pointer? exactly end - start + 1
            end++; // move end one by one
        }
        return res;
    }

    public static void main(String[] args) {
        new _992SubArrayKIntegers().subarraysWithKDistinct(new int[]{1,2,1,2,3},2);
    }
}
