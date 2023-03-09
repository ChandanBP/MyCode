public class _1155DiceRollTargetSum {

    public int numRollsToTarget(int D, int F, int target) {

        if(D==0 || F==0 || target==0)return 0;
        if(target>(D*F))return 0;
        int dp[][] = new int[D+1][target+1];
        int mod = 1000000007;

        for(int i=1;i<=target;i++){
            dp[1][i]=(i<=F)?1:0;
        }

        for(int d=2;d<=D;d++){
            for(int f=1;f<=F;f++){
                for(int t=1;t<=target;t++){
                    if(f>=t)continue;
                    else if(dp[d-1][t-f]==0)continue;
                    else{
                        dp[d][t]= ((dp[d][t]%mod)+(dp[d-1][t-f]%mod))%mod;
                    }
                }
            }
        }
        return dp[D][target];
    }

    public static void main(String[] args) {
        System.out.println(new _1155DiceRollTargetSum().numRollsToTarget(30,30,500));
    }
}
