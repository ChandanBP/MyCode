public class _1483KAncestor {

    int dp[][];
    int n;
    int log;
    int[] parent;

    public _1483KAncestor(int n, int[] parent) {
        log = 1+(int)(Math.log(n)/Math.log(2));
        dp = new int[n][log];
        this.n = n;
        this.parent = parent;
        preProcess();
    }

    public void preProcess(){

        for(int i=0;i<n;i++){
            dp[i][0] = parent[i];
            for(int j=1;j<log;j++)
                dp[i][j] = (dp[i][j-1]==-1)?-1:dp[dp[i][j-1]][j-1];
        }
    }

    public int getKthAncestor(int node, int k) {

        int level = 0;
        while(k>0){
            if((k&1)==1)node = dp[node][level];
            if(node==-1)break;
            k>>=1;
            ++level;
        }
        return node;
    }

    public static void main(String[] args) {
        _1483KAncestor obj = new _1483KAncestor(7, new int[]{-1, 0, 0, 1, 1, 2, 2});
        System.out.println(obj.getKthAncestor(3,1));
        System.out.println(obj.getKthAncestor(5,2));
        System.out.println(obj.getKthAncestor(6,4));
    }
}
