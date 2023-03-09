public class _115DistinctSubsequences {

    public int numDistinct(String s, String t) {

        if(s.length()<t.length())return 0;
        int dp[][] = new int[t.length()][s.length()];

        for(int i=0;i<s.length();i++){
            if(s.charAt(i)==t.charAt(0))
                dp[0][i] = 1+((i==0)?0:dp[0][i-1]);
            else
                dp[0][i] = (i==0)?0:dp[0][i-1];
        }

        for(int i=1;i<t.length();i++){
            int val = 0;
            for(int j=0;j<s.length();j++){

                if(t.charAt(i)==s.charAt(j)){
                    val+= (j==0)?0:dp[i-1][j-1];
                    dp[i][j] = val;
                }else
                    dp[i][j] = (j==0)?0:dp[i][j-1];
            }
        }
        return dp[t.length()-1][s.length()-1];
    }
}
