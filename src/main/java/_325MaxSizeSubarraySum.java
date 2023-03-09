import java.util.HashMap;

public class _325MaxSizeSubarraySum {

    public int maxSubArrayLen(int[] nums, int k) {

        HashMap<Integer,Integer>map = new HashMap<>();
        int sum=0;
        int max=0;
        for(int i=0;i<nums.length;i++){
            sum+=nums[i];

            if(sum==k){
                max=i+1;
            }

            if(!map.containsKey(sum))map.put(sum,i);

            if(map.containsKey(sum-k)){
                max=Math.max(max,i-map.get(sum-k));
            }
        }
        return max;
    }

    public static void main(String[] args) {
        System.out.println(new _325MaxSizeSubarraySum().maxSubArrayLen(new int[]{1,0,-1},-1));
    }
}
