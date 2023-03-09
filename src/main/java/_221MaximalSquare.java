public class _221MaximalSquare {

    public int maximalSquare(char[][] matrix){

        if(matrix==null || matrix.length==0)return 0;
        int min[][] = new int[matrix.length][matrix[0].length];
        int max = 0;

        for(int i=0;i<matrix.length;i++){
            System.out.println("");
            for(int j=0;j<matrix[0].length;j++){
                if(matrix[i][j]=='1'){
                    min[i][j] = (i==0||matrix[i-1][j]=='0')?i:min[i-1][j];
                    max = Math.max(max,1);

                    int r = i-1;
                    int c = j-1;
                    int m = min[i][j];
                    while(r>=0 && c>=0){
                        m = Math.max(m,min[i][c]);
                        if(m>r)break;
                        if(min[i][c]==-1 || min[i][c]>r)break;

                        max = Math.max(max,(i-r+1)*(j-c+1));
                        --r;
                        --c;
                    }
                }else{
                    min[i][j] = -1;
                }
            }
        }
        return max;
    }

    public static void main(String[] args) {
        System.out.println(new _221MaximalSquare().maximalSquare(new char[][]{
                {'0','0','0','1'},
                {'1','1','0','1'},
                {'1','1','1','1'},
                {'0','1','1','1'},
                {'0','1','1','1'}
        }));
    }
}
