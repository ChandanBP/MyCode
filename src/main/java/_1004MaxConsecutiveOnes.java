public class _1004MaxConsecutiveOnes {

    public int longestOnes(int[] A, int K) {
        int left = 0;
        for(int right = 0; right < A.length; right++) {
            K -= A[right] ^ 1; //do a flip only when A[right] is 0
            if(K < 0) {
                K += A[left] ^ 1;
                left++;
            }
        }
        return A.length - left;
    }

    public static void main(String[] args) {
        new _1004MaxConsecutiveOnes().longestOnes(new int[]{1,1,1,0,0,0,1,1,1,1,0},2);
    }
}
