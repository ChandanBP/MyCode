public class _1312MinInsertionPalindrome {

    public int minInsertions(String s) {

        if(s==null||s.length()==0)return 0;

        int n = s.length();
        int i, j, cl;
        int L[][] = new int[n][n];
        for (i = 0; i < n; i++)
            L[i][i] = 1;

        for (cl=2; cl<=n; cl++)
        {
            for (i=0; i<n-cl+1; i++)
            {
                j = i+cl-1;
                if (s.charAt(i) == s.charAt(j) && cl == 2)
                    L[i][j] = 2;
                else if (s.charAt(i) == s.charAt(j))
                    L[i][j] = L[i+1][j-1] + 2;
                else
                    L[i][j] = Math.max(L[i][j-1], L[i+1][j]);
            }
        }
        return n-L[0][n-1];
    }

    public static void main(String[] args) {
        System.out.println(new _1312MinInsertionPalindrome().minInsertions("leetcode"));
    }
}
