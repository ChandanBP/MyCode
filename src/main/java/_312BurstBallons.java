public class _312BurstBallons {

    public int maxCoins(int[] nums) {
        int[] numsCopy = new int[nums.length+2];
        int n = 1;
        for(int i:nums) {
            numsCopy[n++] = i;
        }
        numsCopy[0] = 1;
        numsCopy[n++] = 1;
        int[][] dp = new int[n][n];
        for(int len=0;len<n;len++) {
            for(int j=len;j<n;j++) {
                int i = j-len, temp = 0;
                for(int k=i+1;k<j;k++) {
                    temp = Math.max(temp, dp[i][k]+dp[k][j]+(numsCopy[i]*numsCopy[k]*numsCopy[j]));
                }
                dp[i][j] = temp;
            }
        }
        return dp[0][n-1];
    }

    public static void main(String[] args) {
        System.out.println(new _312BurstBallons().maxCoins(new int[]{3,1,5,8}));
    }
}
