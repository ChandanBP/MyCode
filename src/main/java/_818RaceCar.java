public class _818RaceCar {
    private int max_pos = Integer.MAX_VALUE;
    private int[] power;
    private Integer[] dp;

    public static int log(int x, int y) {
        return (int) (Math.log(x) / Math.log(y) + 1e-10);
    }

    private int callMe(int target) {

        if(target == 0) {
            return 0;
        }
        if(target == 1) {
            return 1;
        }
        if(target == 2) {
            return 4;
        }
        if(target == 3) {
            return 2;
        }
        if(dp[target] != null)
            return dp[target];

        int l = log(target, 2);
        int r = l + 1;
        int lpos = power[l] - 1;
        int rpos = power[r] - 1;

        if(lpos == target) {
            return dp[target] = l;
        }
        if(rpos == target) {
            return dp[target] = r;
        }
        int ans = Integer.MAX_VALUE;
        for(int j=0;j<l;j++) {
            int x1 = callMe(target - power[l] + power[j]);
            x1 = x1 == Integer.MAX_VALUE ? x1 : l + 1 + j + 1 + x1;
            ans = Math.min(ans, x1);
        }
        int x2 = callMe(rpos - target);
        x2 = x2 == Integer.MAX_VALUE ? x2 : r + 1 + x2;
        ans = Math.min(ans, x2);
        return dp[target] = ans;
    }

    private int[] calcPower(int x, int p_max) {
        int[] power = new int[p_max + 1];
        int p = 1;
        for(int i=0;i<=p_max;i++) {
            power[i] = p;
            p *= x;
        }
        return power;
    }

    public int racecar(int target) {
        int max = log(target, 2);
        this.power = calcPower(2, max + 1);
        max_pos = power[max + 1];
        dp = new Integer[max_pos + 1];
        return callMe(target);
    }

    public static void main(String[] args) {
        System.out.println(new _818RaceCar().racecar(20));
    }
}
