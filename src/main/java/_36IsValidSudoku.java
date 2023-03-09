public class _36IsValidSudoku {

    int rows[] = new int[9];
    int cols[] = new int[9];
    int[][] mat = new int[3][3];

    public boolean isValidSudoku(char[][] board){
        for(int i=0;i<9;i++){
            for(int j=0;j<9;j++){
                if(board[i][j] != '.') {
                    int mask = 1<<(board[i][j]-'0');
                    if( (rows[i]&mask)!=0 || (cols[j]&mask)!=0 || (mat[i/3][i/3]&mask)!=0)
                        return false;

                    rows[i]|=mask;
                    cols[j]|=mask;
                    mat[i/3][i/3]|=mask;
                }
            }
        }
        return true;
    }

    public static void main(String[] args) {

    }
}
