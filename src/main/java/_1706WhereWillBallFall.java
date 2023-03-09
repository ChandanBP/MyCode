public class _1706WhereWillBallFall {

    String dp[][];
    int grid[][];

    public String dfs(int i,int j){

        if(dp[i][j]!=null)return dp[i][j];
        if(i==grid.length-1){
            dp[i][j] = i+","+j;
            return dp[i][j];
        }

        for(int r=i;r<grid.length;r++){
            if(grid[r][j]==1 && (j+1>=grid[0].length || grid[r][j+1]==-1)){
                dp[r][j] = r+","+j;
                break;
            }

            if(grid[r][j]==-1 && (j-1<0 || grid[r][j-1]==1)){
                dp[r][j] = r+","+j;
                break;
            }
            dp[r][j] = (grid[r][j]==1)?dfs(r+1,j+1):dfs(r+1,j-1);
        }

        return dp[i][j];
    }

    public int[] findBall(int[][] grid) {

        dp = new String[grid.length+1][grid[0].length];
        this.grid = grid;

        for(int j=0;j<grid[0].length;j++)
            dp[0][j] = dfs(0,j);


        int res[] = new int[grid[0].length];
        for(int j=0;j<grid[0].length;j++){
            if(dp[0][j]==null)
                res[j] = -1;
            else{
                String rc[] = dp[0][j].split(",");
                int row = Integer.parseInt(rc[0]);
                int col = Integer.parseInt(rc[1]);

                int ans = -1;
                if(row==grid.length-1){
                    if( (col==0 && grid[row][col]==-1) ||
                            (col==grid[0].length-1 &&grid[row][col]==1) )
                        res[j]=-1;
                    else
                        ans = (grid[row][col]==-1)?col-1:col+1;
                }
                res[j] = ans;
            }
        }
        return res;
    }

    public static void main(String[] args) {
        new _1706WhereWillBallFall().findBall(new int[][]{
                {1 ,  1,  1,  1,  1,  1},
                {-1, -1, -1, -1, -1, -1},
                {1 ,  1,  1,  1,  1,  1},
                {-1, -1, -1, -1, -1, -1}
        });
    }
}
