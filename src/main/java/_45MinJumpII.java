import java.util.Arrays;

public class _45MinJumpII {

    public int jump(int[] nums) {
        if(nums==null || nums.length==0)return 0;
        int minJump[] = new int[nums.length];

        Arrays.fill(minJump,Integer.MAX_VALUE);

        int n = minJump.length-1;
        minJump[n] = 0;
        for(int i=n-1;i>=0;i--){
            if(i+nums[i]>=n){
                minJump[i] = 1;
            }else{
                for(int j=i+1;j<=i+nums[i] && j<=n;j++){
                    if(minJump[j]!=Integer.MAX_VALUE)
                        minJump[i] = Math.min(minJump[i],1+minJump[j]);
                }
            }
        }
        return minJump[0];
    }

    public static void main(String[] args) {
        System.out.println(new _45MinJumpII().jump(new int[]{2,3,1,1,4}));
    }
}
