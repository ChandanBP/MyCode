public class _1277CountSquareMatrices {

    public int countSquares(int[][] matrix) {

        int min[][] = new int[matrix.length][matrix[0].length];
        int res=0;
        for(int i=0;i<matrix.length;i++){
            for(int j=0;j<matrix[i].length;j++){
                if(matrix[i][j]==1){
                    ++res;
                    min[i][j] = (i==0||matrix[i-1][j]==0)?i:min[i-1][j];
                    if(min[i][j]==i)continue;

                    int ti = i-1;
                    int tj = j-1;

                    int max = min[i][j];
                    while(ti>=0 && tj>=0){

                        max = Math.max(max,min[i][tj]);
                        if(max>ti)break;
                        if(min[i][tj]==Integer.MAX_VALUE || min[i][tj]>ti)break;
                        ++res;

                        --ti;
                        --tj;
                    }
                }else{
                    min[i][j]=Integer.MAX_VALUE;
                }
            }
        }
        return res;
    }

    public static void main(String[] args) {
        int mat[][] = {
                {0,0,0},
                {0,1,0},
                {0,1,0},
                {1,1,1},
                {1,1,0}
        };
        System.out.println(new _1277CountSquareMatrices().countSquares(mat));
    }
}
