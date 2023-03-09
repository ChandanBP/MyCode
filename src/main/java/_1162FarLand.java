import java.util.LinkedList;
import java.util.Queue;

public class _1162FarLand {

    int dist[][];
    boolean visited[][];

    class Position{
        int x;
        int y;
        public Position(int x,int y){
            this.x=x;
            this.y=y;
        }
    }

    public int maxDistance(int[][] grid) {

        Queue<Position>queue = new LinkedList<>();
        dist = new int[grid.length][grid.length];
        visited = new boolean[grid.length][grid.length];

        int zeros=0;
        for(int i=0;i<grid.length;i++){
            for(int j=0;j<grid.length;j++){
                if(grid[i][j]==1){
                    queue.add(new Position(i,j));
                    dist[i][j]=0;
                }else{
                    ++zeros;
                    dist[i][j]=Integer.MAX_VALUE;
                }
            }
        }

        if(zeros==(grid.length*grid.length))return -1;

        int rows[] = {1,-1,0,0};
        int cols[] = {0,0,1,-1};
        while(!queue.isEmpty()){

            int size = queue.size();
            for(int k=0;k<size;k++){
                Position position = queue.poll();
                int x1 = position.x;
                int y1 = position.y;
                if(visited[x1][y1])continue;

                for(int i=0;i<rows.length;i++){
                    int r = x1+rows[i];
                    int c = y1+cols[i];
                    if(r>=0 && r<grid.length && c>=0 && c<grid.length){
                        if(grid[r][c]==0){
                            dist[r][c]=(dist[r][c]==Integer.MAX_VALUE)?1+dist[x1][y1]:Math.min(dist[r][c],1+dist[r][c]);
                            if(!visited[r][c])
                                queue.add(new Position(r,c));
                        }
                    }
                }
                visited[x1][y1]=true;
            }
        }

        int max = Integer.MIN_VALUE;
        for(int i=0;i<grid.length;i++) {
            for (int j = 0; j < grid.length; j++) {
                if(grid[i][j]==0)
                    max = Math.max(max,dist[i][j]);
            }
        }
        return max;
    }

    public static void main(String[] args) {
        int grid[][] = new int[][]{{1,0,1},{0,0,0},{1,0,1}};
        System.out.println(new _1162FarLand().maxDistance(grid));
    }
}
