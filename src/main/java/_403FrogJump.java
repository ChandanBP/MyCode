import java.util.Arrays;

public class _403FrogJump {

    int dp[][];
    int stones[];

    public int isCrossing(int index,int k){

        if(index== stones.length-1)return dp[index][k]=1;
        if(dp[index][k]!=-1)return dp[index][k];
        int steps[] = {k-1,k,k+1};
        int res = 0;
        for(int i=0;i<steps.length;i++){
            if(steps[i]<=0)continue;
            int nextStep = stones[index]+steps[i];
            int in = Arrays.binarySearch(stones,index+1,stones.length,nextStep);
            if(in>0)res|= isCrossing(in,steps[i]);
        }
        return dp[index][k] = res;
    }

    public boolean canCross(int[] stones) {

        if(stones[1]!=1)return false;
        this.stones = stones;
        dp = new int[stones.length][stones.length];
        for(int i=0;i<dp.length;i++)Arrays.fill(dp[i],-1);
        isCrossing(0,0);
        for(int k=0;k<dp.length;k++) if(dp[stones.length-1][k]>0)return true;
        return false;
    }

    public static void main(String[] args) {
        _403FrogJump obj = new _403FrogJump();
        System.out.println(obj.canCross(new int[]{0,1,3,5,6,8,12,17}));
    }
}
