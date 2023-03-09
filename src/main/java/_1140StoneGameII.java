public class _1140StoneGameII {

    public int stoneGameII(int[] piles) {
        int dp[][] = new int[piles.length][piles.length];

        for(int i=piles.length-1;i>=0;i--){
            dp[i][0]=piles[i];
            int max=-1;
            int sum=0;
            for(int j=i+1;j<piles.length;j++){
                sum+=piles[j];
                max=Math.max(max,sum-((j+1<piles.length)?dp[i][j+1]:0));
            }
        }
        return 1;
    }

    public static void main(String[] args) {

    }
}
