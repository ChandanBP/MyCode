public class _1406StoneGameIII {

    public String stoneGameIII(int[] stoneValue) {

        int dp[] = new int[stoneValue.length];
        for(int i=stoneValue.length-1;i>=0;i--){
            int ans = (i==stoneValue.length-1)?stoneValue[i]:stoneValue[i]-dp[i+1];
            if(i+1<stoneValue.length){
                ans = Math.max(ans,stoneValue[i]+stoneValue[i+1]-((i+2<stoneValue.length)?dp[i+2]:0));
            }
            if(i+2<stoneValue.length){
                ans = Math.max(ans,stoneValue[i]+stoneValue[i+1]+stoneValue[i+2]-((i+3<stoneValue.length)?dp[i+3]:0));
            }
            dp[i]=ans;
        }
        if(dp[0]<0){
            return "Bob";
        }else if(dp[0]>0){
            return "Alice";
        }else{
            return "Tie";
        }
    }

    public static void main(String[] args) {
        System.out.println(new _1406StoneGameIII().stoneGameIII(new int[]{1,2,3,7}));
    }
}
