import java.util.LinkedList;
import java.util.Queue;

public class _317ShortesDistance {

    public int shortestDistance(int[][] grid) {

        if(grid==null||grid.length==0)return -1;

        int dist[][] = new int[grid.length][grid[0].length];
        int count[][] = new int[grid.length][grid[0].length];
        int totalBuildings = 0;
        int distance = Integer.MAX_VALUE;

        for(int i=0;i<grid.length;i++){
            for(int j=0;j<grid[i].length;j++){
                if(grid[i][j]==1){
                    ++totalBuildings;
                    bfs(grid,dist,i,j,count);
                }
            }
        }

        for(int i=0;i<grid.length;i++) {
            for (int j = 0; j < grid[i].length; j++) {
                if(count[i][j]==totalBuildings && dist[i][j]<distance)
                    distance = dist[i][j];
            }
        }

        return (distance==Integer.MAX_VALUE)?-1:distance;
    }

    public boolean isValidCell(int i,int j,int grid[][],boolean visited[][]){
        if(i<0||j<0||i>=grid.length||j>=grid[0].length)return false;
        if(visited[i][j])return false;
        if(grid[i][j]==2)return false;
        return true;
    }

    public void bfs(int grid[][],int dist[][],int row,int col,int count[][]){

        boolean visited[][] = new boolean[grid.length][grid[0].length];
        Queue<int []>queue = new LinkedList<>();
        queue.add(new int[]{row,col});
        visited[row][col]=true;

        int rows[] = {-1,0,1,0};
        int cols[] = {0,1,0,-1};

        int d=0;
        while(!queue.isEmpty()){

            int size = queue.size();
            for(int i=0;i<size;i++){
                int[] rc = queue.poll();
                ++d;
                for(int k=0;k<rows.length;k++){
                    int r = rows[k]+rc[0];
                    int c = cols[k]+rc[1];
                    if(!isValidCell(r,c,grid,visited))continue;

                    if (grid[r][c] == 0){
                        dist[r][c]+=d;
                        count[r][c]++;
                        queue.add(new int[]{r,c});
                    }
                    visited[r][c]=true;
                }
            }
        }
    }
}
