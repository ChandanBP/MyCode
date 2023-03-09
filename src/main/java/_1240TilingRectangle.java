public class _1240TilingRectangle {

    public int tilingRectangle(int n, int m){

        int dp[][] = new int[n+1][m+1];
        dp[1][1]=1;
        for(int i=1;i<=n;i++){
            dp[i][1]=i;
        }

        for(int j=1;j<=m;j++){
            dp[1][j]=j;
        }

        for(int i=2;i<=n;i++){
            for(int j=2;j<=m;j++){
                if(i==j){
                    dp[i][j]=1;
                }else if(i<j){
                    dp[i][j]=1+dp[i][j-i];
                }else{
                    dp[i][j]=1+dp[i-j][j];
                }
            }
        }
        return dp[n][m];
    }

    public static void main(String[] args) {
        System.out.println(new _1240TilingRectangle().tilingRectangle(11,13));
    }
}
