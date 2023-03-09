public class _695MaxArea {

    public int maxAreaOfIsland(int[][] grid) {

        boolean visited[][]=new boolean[grid.length][grid[0].length];

        int max=0;
        for(int i=0;i<grid.length;i++){
            for(int j=0;j<grid[i].length;j++){
                if(!visited[i][j]){
                    max=Math.max(max,dfs(visited,grid,i,j));
                }
            }
        }

        return max;
    }

    public int dfs(boolean visited[][],int [][]grid,int i,int j){

        visited[i][j]=true;
        if(grid[i][j]==0)return 0;

        int num=1;
        if(i-1>=0 && !visited[i-1][j])
            num+=dfs(visited,grid,i-1,j);

        if(i+1<grid.length && !visited[i+1][j])
            num+=dfs(visited,grid,i+1,j);

        if(j-1>=0 && !visited[i][j-1])
            num+=dfs(visited,grid,i,j-1);

        if(j+1<grid[0].length && !visited[i][j+1])
            num+=dfs(visited,grid,i,j+1);

        return num;
    }

    public static void main(String[] args) {
        int grid[][]  = {
                {0,0,1,0,0,0,0,1,0,0,0,0,0},
                {0,0,0,0,0,0,0,1,1,1,0,0,0},
                {0,1,1,0,1,0,0,0,0,0,0,0,0},
                {0,1,0,0,1,1,0,0,1,0,1,0,0},
                {0,1,0,0,1,1,0,0,1,1,1,0,0},
                {0,0,0,0,0,0,0,0,0,0,1,0,0},
                {0,0,0,0,0,0,0,1,1,1,0,0,0},
                {0,0,0,0,0,0,0,1,1,0,0,0,0}
        };
        System.out.println(new _695MaxArea().maxAreaOfIsland(grid));
    }
}
