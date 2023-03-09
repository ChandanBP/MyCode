import java.util.LinkedList;
import java.util.Queue;

public class _286WallsAndGates {

    public void wallsAndGates(int[][] rooms) {

        Queue<int[]>queue = new LinkedList<>();
        for(int i=0;i<rooms.length;i++){
            for(int j=0;j<rooms[i].length;j++){
                if(rooms[i][j]==0)queue.add(new int[]{i,j});
            }
        }

        int rows[] = {-1,1,0,0};
        int cols[] = {0,0,-1,1};
        while (!queue.isEmpty()){
            int position[] = queue.poll();
            for(int i=0;i<rows.length;i++){
                int r = position[0]+rows[i];
                int c = position[1]+cols[i];
                if(r<0 || c<0 || r==rooms.length || c==rooms[0].length || rooms[r][c]!=Integer.MAX_VALUE || rooms[r][c]==-1)continue;
                rooms[r][c]=rooms[position[0]][position[1]]+1;
                queue.add(new int[]{r,c});
            }
        }
    }

    public static void main(String[] args) {
        int inf = Integer.MAX_VALUE;
        new _286WallsAndGates().wallsAndGates(new int[][]{{inf,-1,0,inf},{inf,inf,inf,-1},{inf,-1,inf,-1},{0,-1,inf,inf}});
    }
}
