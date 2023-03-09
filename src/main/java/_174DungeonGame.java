public class _174DungeonGame {

    public int calculateMinimumHP(int[][] dungeon) {

        int dp[][] = new int[dungeon.length][dungeon[0].length];

        int lastValue = dungeon[dp.length-1][dungeon[0].length-1];
        dp[dp.length-1][dungeon[0].length-1]=(lastValue<=0)?Math.abs(lastValue)+1:1;

        for(int i=dungeon.length-1;i>=0;i--){
            for(int j=dungeon[0].length-1;j>=0;j--){

                if(i==dp.length-1 && j==dungeon[0].length-1)continue;;

                int cost = Integer.MAX_VALUE;
                if(i+1<=dungeon.length-1){
                    cost = Math.min(cost,dp[i+1][j]);
                }
                if(j+1<=dungeon[0].length-1){
                    cost = Math.min(cost,dp[i][j+1]);
                }
                int curr = dungeon[i][j];
                if(curr<0){
                    dp[i][j]=cost-curr;
                }else{
                    dp[i][j] = (curr<cost)?cost-curr:1;
                }
            }
        }
        return dp[0][0];
    }

    public static void main(String[] args) {
        int[][] dungeon = new int[][]{
                {2,0,-1}
        };

//        int[][] dungeon = new int[][]{
//                {1,2,3},
//                {4,5,6},
//                {7,8,9}};

        System.out.println(new _174DungeonGame().calculateMinimumHP(dungeon));
    }
}
