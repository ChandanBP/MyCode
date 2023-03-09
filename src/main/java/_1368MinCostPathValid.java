import java.util.PriorityQueue;

public class _1368MinCostPathValid {
    public int minCost(int[][] grid) {

        int cost[][] = new int[grid.length][grid[0].length];

        for(int i=0;i<grid.length;i++){
            for(int j=0;j<grid[0].length;j++){
                cost[i][j] = Integer.MAX_VALUE;
            }
        }

        PriorityQueue<int[]> queue = new PriorityQueue((a, b)->((int[])a)[2]-((int[])b)[2]);
        int dir[][] = {{-1,0},{0,1},{1,0},{-1,0}};
        cost[0][0] = 0;
        queue.add(new int[]{0,0,0});
        while(!queue.isEmpty()){
            int []arr = queue.poll();
            if(arr[0]==grid.length-1 && arr[1]==grid[0].length-1)return arr[2];

            int r = arr[0];
            int c = arr[1];
            for(int i=0;i<4;i++){

                int newr = r+dir[i][0];
                int newc = c+dir[i][1];
                if(newr>=0 && newr<grid.length && newc>=0 && newc<grid[0].length){
                    int cos = arr[2]+((i+1==grid[newr][newc])?0:1);
                    if(cos<cost[newr][newc]){
                        queue.add(new int[]{newr,newc,cos});
                    }
                }
            }
        }

        return Integer.MAX_VALUE;
    }
}
