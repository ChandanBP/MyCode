import java.util.HashMap;

public class _560SubArraySum {

    public int subarraySum(int[] nums, int k) {

        int sum=0;
        int num=0;
        HashMap<Integer,Integer>map = new HashMap<>();
        map.put(0,1);
        for(int i=0;i<nums.length;i++){
            sum+=nums[i];
            if(map.containsKey(sum-k)){
                num+=map.get(sum-k);
            }
            map.put(sum,map.getOrDefault(sum,0)+1);
        }
        return num;
    }

    public static void main(String[] args) {
        System.out.println(new _560SubArraySum().subarraySum(new int[]{0,0,0},0));
    }
}
