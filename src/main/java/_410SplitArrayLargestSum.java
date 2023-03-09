import java.util.Arrays;

public class _410SplitArrayLargestSum {

    public int splitArray(int[] nums, int m) {

        int len = nums.length;
        int sum[] = new int[len+1];
        for(int i=nums.length-1;i>=0;i--){
            sum[i+1] = (i==len-1)?nums[len-1]:nums[i]+sum[i+2];
        }

        int dp[][] = new int[len+1][m+1];

        for(int j=1;j<=m;j++){

            for(int i=1;i<=len;i++){

                if(j==1){
                    dp[i][1] = (i==len)?sum[1]:sum[1]-sum[i+1];
                    continue;
                }

                int min = Integer.MAX_VALUE;
                for(int k=1;k<=i;k++){
                    int val = (k==i)?dp[k][j-1]:Math.max(dp[k][j-1],sum[k+1]-((i==len)?0:sum[i+1]));
                    min = Math.min(min,val);
                }
                dp[i][j]=min;
            }
        }
        return dp[len][m];
    }

    public static void main(String[] args) {
        System.out.println(new _410SplitArrayLargestSum().splitArray(new int[]{7,2,5,10,8},2));
    }
}
