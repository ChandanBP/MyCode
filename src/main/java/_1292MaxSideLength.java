public class _1292MaxSideLength {

    public int maxSideLength(int[][] mat, int threshold) {

        int sum[][]=new int[mat.length][mat[0].length];
        int max=1;

        for(int i=0;i<mat.length;i++){
            for(int j=0;j<mat[i].length;j++){
                if(i==0){
                    sum[i][j]=sum[i][j-1]+mat[i][j];
                }else if(j==0){
                    sum[i][j]=sum[i-1][j]+mat[i][j];
                }else{
                    int pi=i-1;
                    int pj=j-1;
                    sum[i][j] = sum[i][pj]+sum[pi][j]-sum[pi][pj]+mat[i][j];
                }
            }
        }
        return max;
    }

    public static void main(String[] args) {
        int mat[][] = {
                {1,1,1,1},
                {1,0,0,0},
                {1,0,0,0},
                {1,0,0,0}
        };
        System.out.println(new _1292MaxSideLength().maxSideLength(mat,6));
    }
}
