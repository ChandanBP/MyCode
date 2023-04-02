import java.util.HashMap;
import java.util.LinkedList;
import java.util.Queue;

public class _1263MinimumMoves {

    class Cell{
        int x;
        int y;
        public Cell(int x,int y){
            this.x = x;
            this.y = y;
        }
    }
    HashMap<Character,int[]>positionMap = new HashMap<>();
    char grid[][];
    boolean visited[][];

    int x[] = {0,1,0,-1};
    int y[] = {1,0,-1,0};

    int boxPosition[];

    public boolean isPathExists(Cell source,Cell target,boolean v[][]){
        if(source.x == target.x && source.y == target.y){
            return true;
        };

        v[source.x][source.y] = true;
        for(int d=0;d<4;d++){
            int xi = x[d]+ source.x;
            int yi = y[d]+ source.y;
            if(xi>=0 && xi<grid.length && yi>=0 && yi<grid[0].length && !v[xi][yi]){
                if(grid[xi][yi]!='#' && grid[xi][yi]!='B'){
                    boolean ret = isPathExists(new Cell(xi,yi),target,v);
                    if(ret)return true;
                }
            }
        }
        return false;
    }

    public int minPushBox(char[][] grid) {
        this.grid = grid;
        for(int i=0;i<grid.length;i++){
            for(int j=0;j<grid[i].length;j++){
                if(grid[i][j]=='S' || grid[i][j]=='B' || grid[i][j]=='T')
                    positionMap.put(grid[i][j],new int[]{i,j,0,-1,-1});
            }
        }

        // BFS to see the shortest path
        int targetX = positionMap.get('T')[0];
        int targetY = positionMap.get('T')[1];
        int playerPosition[] = positionMap.get('S'); // Player location
        boxPosition = positionMap.get('B');
        visited = new boolean[grid.length][grid[0].length];

        Queue<int[]>queue = new LinkedList<>();
        queue.add(new int[]{boxPosition[0],boxPosition[1],playerPosition[0],playerPosition[1],0});
        grid[boxPosition[0]][boxPosition[1]] = '.';

        while(!queue.isEmpty()){
            int[] boxPos = queue.poll();
            int boxX = boxPos[0];
            int boxY = boxPos[1];
            int pX = boxPos[2];
            int pY = boxPos[3];
            int dist = boxPos[4];

            if(boxX==targetX && boxY==targetY)return dist;

            int newx=-1,newy=-1;

            // If player is to the right of the box
            if(boxY+1==pY && boxX==pX){
                newx = boxX;
                newy = boxY-1;
            }

            // If player is to the left of the box
            if(boxY-1==pY && boxX==pX){
                newx = boxX;
                newy = boxY+1;
            };

            // If player is below the box
            if(boxX+1==pX && boxY==pY) {
                newx = boxX-1;
                newy = boxY;
            };

            // If player is above the box
            if(boxX-1==pX && boxY==pY) {
                newx = boxX+1;
                newy = boxY;
            };

            if(withinBoundary(newx,newy) && grid[newx][newy]!='#' && !visited[newx][newy]){
                queue.add(new int[]{newx,newy,boxX,boxY,1+dist});
                visited[newx][newy] = true;
            }

            grid[boxX][boxY] = 'B';
            for(int dir=0;dir<4;dir++){
                int X = boxX+x[dir];
                int Y = boxY+y[dir];
                boolean v[][] = new boolean[grid.length][grid[0].length];
                if(X!=newx && Y!=newy && withinBoundary(X,Y) && grid[X][Y]!='#' &&
                    isPathExists(new Cell(pX,pY),new Cell(X,Y),v)){
                    int oppY = y[dir]-boxY;
                    int oppX = x[dir]-boxX;
                    if((boxX==X && withinBoundary(X,oppY)&&!visited[X][oppY] && grid[X][oppY]!='#') ||
                        boxY==Y && withinBoundary(oppX,Y) && !visited[oppX][Y] && grid[oppX][Y]!='#'
                    ){
                        queue.add(new int[]{boxX,boxY,X,Y,dist});
                    }
                }
            }
            grid[boxX][boxY] = '.';
        }
        return -1;
    }

    public boolean withinBoundary(int x,int y){
        return x>=0 && x<grid.length && y>=0 && y<grid[0].length;
    }

    public static void main(String[] args) {
        System.out.println(new _1263MinimumMoves().minPushBox(new char[][]
                {
                        {'#','.','.','#','T','#','#','#','#'},
                        {'#','.','.','#','.','#','.','.','#'},
                        {'#','.','.','#','.','#','B','.','#'},
                        {'#','.','.','.','.','.','.','.','#'},
                        {'#','.','.','.','.','#','.','S','#'},
                        {'#','.','.','#','.','#','#','#','#'}}));
    }
}
