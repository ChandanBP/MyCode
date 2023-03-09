import java.util.PriorityQueue;

public class _1102PathWithMaxMinValue {

    public int maximumMinimumPath(int[][] A) {

        if(A==null || A.length==0)return -1;

        boolean visited[][] = new boolean[A.length][A[0].length];
        PriorityQueue<int[]>queue = new PriorityQueue((a,b)->((int[])b)[2]-((int[])a)[2]);

        int a[] = {0,0,A[0][0]};
        int dir[][] = {{1,0},{-1,0},{0,-1},{0,1}};
        queue.offer(a);
        visited[0][0] = true;
        while(!queue.isEmpty()){
            int t[] = queue.poll();
            if(t[0]==A.length-1 && t[1]==A[0].length-1){
                return t[2];
            }
            for(int i=0;i<4;i++){
                int r = t[0]+dir[i][0];
                int c = t[0]+dir[i][1];
                if(r>=0 && r<A.length && c>=0 && c<A[0].length && !visited[r][c]){
                    int n[] = {r,c,Math.min(t[2],A[r][c])};
                    queue.offer(n);
                }
            }
        }

        return -1;
    }

    public static void main(String[] args) {

    }
}
