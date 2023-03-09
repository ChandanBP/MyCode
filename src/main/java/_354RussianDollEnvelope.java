import java.util.Arrays;

public class _354RussianDollEnvelope {

    public int maxEnvelopes(int[][] envelopes) {

        if(envelopes.length==1)return 1;
        Arrays.sort(envelopes,(a,b)->a[0]-b[0]);

        int dp[] = new int[envelopes.length];
        for(int i=0;i<dp.length;i++)
            dp[i] = 1;

        int max = 0;
        for(int i=1;i<dp.length;i++){
            for(int j=0;j<i;j++){
                if(envelopes[i][0]>envelopes[j][0] && envelopes[i][1]>envelopes[j][1] && 1+dp[j]>dp[i]){
                    dp[i] = 1+dp[j];
                    max = Math.max(max,dp[i]);
                }
            }
        }
        return max;
    }

    public static void main(String[] args) {

    }
}
