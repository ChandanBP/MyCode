import java.util.*;

public class _2503MaxPoints {
    private int[][] dirs = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};

    public int[] maxPoints(int[][] grid, int[] q) {
        int r = grid.length;
        int c = grid[0].length;
        int[] res = new int[q.length];
        Integer[] index = new Integer[q.length];
        for (int i = 0; i < q.length; i++) {
            index[i] = i;
        }
        Arrays.sort(index, new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return q[o1] - q[o2];
            }
        });
        Queue<int[]> q1 = new ArrayDeque<>();
        PriorityQueue<int[]> q2 = new PriorityQueue<>((a, b) -> (a[2] - b[2]));
        q2.offer(new int[]{0, 0, grid[0][0]});
        boolean[][] visited = new boolean[r][c];
        int count = 0;
        visited[0][0] = true;
        for(int i = 0; i < q.length; i++) {
            int currlimit = q[index[i]];;
            while(!q2.isEmpty() && q2.peek()[2] < currlimit) {
                q1.offer(q2.poll());
            }
            while(!q1.isEmpty()) {
                int[] curr = q1.poll();
                count++;
                for(int[] dir : dirs) {
                    int x = dir[0] + curr[0];
                    int y = dir[1] + curr[1];
                    if(x < 0 || y < 0 || x >= r || y >= c || visited[x][y]) {
                        continue;
                    }
                    if(!visited[x][y] && grid[x][y] < currlimit) {
                        q1.offer(new int[]{x, y, grid[x][y]});
                    } else {
                        q2.offer(new int[]{x, y, grid[x][y]});
                    }
                    visited[x][y] = true;
                }
            }
            res[index[i]] = count;
        }
        return res;
    }
}
