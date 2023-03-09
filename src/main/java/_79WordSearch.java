public class _79WordSearch {

    char wordBoard[][];

    public boolean dfs(int i,int j,boolean[][] visited,String word,StringBuilder result){
        if(word.equals(result.toString()))return true;
        visited[i][j]=true;

        int rowOffsets[] = {-1,1,0,0};
        int colOffsets[] = {0,0,-1,1};

        for(int d=0;d<4;d++){
            int row = i+rowOffsets[d];
            int col = j+colOffsets[d];

            if(row>=0 && row<visited.length && col>=0 && col<visited[0].length){
                if(!visited[row][col] && wordBoard[row][col]==word.charAt(result.length()))
                    if(dfs(row,col,visited,word,new StringBuilder(result).append(wordBoard[row][col])))return true;
            }
        }
        visited[i][j]=false;
        return false;
    }

    public boolean exist(char[][] board, String word) {

        wordBoard=board;
        for(int i=0;i<board.length;i++){
            for(int j=0;j<board[i].length;j++){
                if(board[i][j]==word.charAt(0)){
                    boolean visited[][] = new boolean[board.length][board[0].length];
                    if(dfs(i,j,visited,word,new StringBuilder().append(word.charAt(0))))
                        return true;
                }
            }
        }
        return false;
    }

    public static void main(String[] args) {
        char board[][] = {{'A','B','C','E'},{'S','F','C','S'},{'A','D','E','E'}};
        System.out.println(new _79WordSearch().exist(board,"ABCB"));
    }
}
