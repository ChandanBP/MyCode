public class _542Matrix01 {
    public int[][] updateMatrix(int[][] mat) {

        int dp[][] = new int[mat.length][mat[0].length];
        int dir[][] = new int[][]{{-1,0},{0,-1}};


        // from top left
        for(int i=0;i<mat.length;i++){
            for(int j=0;j<mat[0].length;j++){
                if(mat[i][j]==0)dp[i][j]=0;
                else{
                    dp[i][j] = Integer.MAX_VALUE;
                    for(int k=0;k<dir.length;k++){
                        int r = i+dir[k][0];
                        int c = j+dir[k][1];
                        if(r>=0 && r<mat.length && c>=0 && c<mat[0].length){
                            dp[i][j] = Math.min(dp[i][j],dp[r][c]);
                        }
                    }
                    dp[i][j] = (dp[i][j]==Integer.MAX_VALUE)?Integer.MAX_VALUE:dp[i][j]+1;
                }
            }
        }

        dir = new int[][]{{1,0},{0,1}};
        // from bottom right
        for(int i=mat.length-1;i>=0;i--){
            for(int j=mat[0].length-1;j>=0;j--){
                if(mat[i][j]==1){
                    int min = dp[i][j];
                    for(int k=0;k<dir.length;k++){
                        int r = i+dir[k][0];
                        int c = j+dir[k][1];
                        if(r>=0 && r<mat.length && c>=0 && c<mat[0].length){
                            min = Math.min(min,dp[r][c]);
                        }
                    }
                    min = (i==mat.length-1&&j==mat[0].length-1)?min:min+1;
                    dp[i][j] = Math.min(dp[i][j],min);
                }
            }
        }
        return dp;
    }
}
