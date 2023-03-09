public class _304RangeQuerySum {

    int matrix[][];
    public _304RangeQuerySum(int[][] matrix) {
        this.matrix=matrix;
    }

    public int sumRegion(int row1, int col1, int row2, int col2) {

        int Sum[][] = new int[matrix.length][matrix[0].length];

        for(int i=0;i<matrix.length;i++){
            for(int j=0;j<matrix[i].length;j++){
                if(i==0 && j==0)Sum[i][j]+=matrix[i][j];
                else if(i-1<0)Sum[i][j]+=matrix[i][j]+Sum[i][j-1];
                else if(j-1<0)Sum[i][j]+=matrix[i][j]+Sum[i-1][j];
                else Sum[i][j]=matrix[i][j]+Sum[i-1][j]+Sum[i][j-1]-Sum[i-1][j-1];
            }
        }

        int sum = Sum[row2][col2];
        if(row1-1>=0 && col1-1>=0)sum+=Sum[row1-1][col1-1];
        if(row1-1>=0)sum-=Sum[row1-1][col2];
        if(col1-1>=0)sum-=Sum[row2][col1-1];

        return sum;
    }

    public static void main(String[] args) {
        System.out.println(new _304RangeQuerySum(new int[][]{
                {3, 0, 1, 4, 2},
                {5, 6, 3, 2, 1},
                {1, 2, 0, 1, 5},
                {4, 1, 0, 1, 7},
                {1, 0, 3, 0, 5}
        }).sumRegion(1,2,2,4));
    }
}
