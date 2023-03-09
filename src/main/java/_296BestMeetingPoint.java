import java.util.LinkedList;
import java.util.List;
import java.util.ListIterator;

public class _296BestMeetingPoint {

    int dist = Integer.MAX_VALUE;
    class Point{
        int x;
        int y;
        public Point(int x,int y){
            this.x = x;
            this.y = y;
        }
    }
    LinkedList<Point>points = new LinkedList<>();

    public int minTotalDistance(int[][] grid) {

        for(int i=0;i<grid.length;i++){
            for(int j=0;j<grid[i].length;j++){
                if(grid[i][j]==1)points.add(new Point(i,j));
            }
        }

        for(int i=0;i<grid.length;i++){
            for(int j=0;j<grid[i].length;j++){

                int d=0;
                ListIterator<Point>ite = points.listIterator();
                while(ite.hasNext()){
                    Point p = ite.next();
                    d+=Math.abs(p.x-i) + Math.abs(p.y-j);
                }
                dist = Math.min(dist,d);
            }
        }

        return dist;
    }

    public int minTotalDistance2(int[][] grid) {
        List<Integer> rows = collectRows(grid);
        List<Integer> cols = collectCols(grid);
        int row = rows.get(rows.size() / 2);
        int col = cols.get(cols.size() / 2);
        return minDistance1D(rows, row) + minDistance1D(cols, col);
    }

    private List<Integer> collectRows(int[][] grid) {
        List<Integer> rows = new LinkedList<>();
        for (int row = 0; row < grid.length; row++) {
            for (int col = 0; col < grid[0].length; col++) {
                if (grid[row][col] == 1) {
                    rows.add(row);
                }
            }
        }
        return rows;
    }

    private List<Integer> collectCols(int[][] grid) {
        List<Integer> cols = new LinkedList<>();
        for (int col = 0; col < grid[0].length; col++) {
            for (int row = 0; row < grid.length; row++) {
                if (grid[row][col] == 1) {
                    cols.add(col);
                }
            }
        }
        return cols;
    }

    private int minDistance1D(List<Integer> points, int origin) {
        int distance = 0;
        for (int point : points) {
            distance += Math.abs(point - origin);
        }
        return distance;
    }

    public static void main(String[] args) {
        _296BestMeetingPoint obj = new _296BestMeetingPoint();
        int grid[][] = {
                {1,0,0,0,1},
                {0,0,0,0,0},
                {0,0,1,0,0}
        };
        //System.out.println(obj.minTotalDistance(grid));
        System.out.println(obj.minTotalDistance2(grid));
    }
}
