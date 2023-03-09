public class _727MinWindowSubsequence {

    public String minWindow(String S, String T) {
        int N = S.length();
        int L = T.length();

        int[][] dp = new int[N + 1][L + 1]; // dp[i][j] = x is the starting index of shortest postfix of S[0,i) that contains subsequence T[0,j)
        for (int i = 0; i <= N; i++) {
            dp[i][0] = i; // can always find postfix containing ""
        }
        for (int j = 1; j <= L; j++) {
            dp[0][j] = -1; // impossible
        }
        for (int i = 1; i <= N; i++) {
            for (int j = 1; j <= L; j++) {
                dp[i][j] = S.charAt(i - 1) == T.charAt(j - 1) ? dp[i - 1][j - 1] : dp[i - 1][j];
            }
        }

        // Find the shortest postfix of S[0, i) that contains T for all i
        int minLen = N + 1;
        int start = -1;
        for (int i = 1; i <= N; i++) {
            if (dp[i][L] >= 0 && i - dp[i][L] < minLen) {
                minLen = i - dp[i][L];
                start = dp[i][L];
            }
        }
        return minLen > N ? "" : S.substring(start, start + minLen);
    }

    public static void main(String[] args) {
        //System.out.println(new _727MinWindowSubsequence().minWindow("abcdebddl","dl"));
        System.out.println(new _727MinWindowSubsequence().minWindow("ffynmlzesdshlvugsigobutgaetsnjlizvqjdpccdylclqcbghhixpjihximvhapymfkjxyyxfwvsfyctmhwmfjyjidnfryiyajmtakisaxwglwpqaxaicuprrvxybzdxunypzofhpclqiybgniqzsdeqwrdsfjyfkgmejxfqjkmukvgygafwokeoeglanevavyrpduigitmrimtaslzboauwbluvlfqquocxrzrbvvplsivujojscytmeyjolvvyzwizpuhejsdzkfwgqdbwinkxqypaphktonqwwanapouqyjdbptqfowhemsnsl","ntimcimzah"));
    }
}
