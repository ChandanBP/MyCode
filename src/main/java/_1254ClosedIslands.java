public class _1254ClosedIslands {

    boolean visited[][];
    int connectedComponents = 0;

    public void dfs(int grid[][],int i,int j){
        visited[i][j]=true;

        int rows[] = {1,-1,0,0};
        int cols[] = {0,0,-1,1};

        for(int k=0;k<rows.length;k++){
            int r = i+rows[k];
            int c = j+cols[k];
            if(r>=0 && r<grid.length &&
                    c>=0 && c<grid[0].length &&
                    grid[r][c]==0 && !visited[r][c]){
                dfs(grid,r,c);
            }
        }
    }

    public int closedIsland(int[][] grid) {

        visited = new boolean[grid.length][grid[0].length];

        for(int i=0;i<grid.length;i++){
            for(int j=0;j<grid[i].length;j++){
                if((grid[i][j]==0) && (i==0 || i==grid.length-1 || j==0 || j==grid[0].length-1) && !(visited[i][j])){
                    dfs(grid,i,j);
                }
            }
        }

        for(int i=0;i<grid.length;i++) {
            for (int j = 0; j < grid[i].length; j++) {
                if(grid[i][j]==0 && !visited[i][j]){
                    dfs(grid,i,j);
                    ++connectedComponents;
                }
            }
        }

        return connectedComponents;
    }

    public static void main(String[] args) {

    }
}
