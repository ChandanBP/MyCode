import java.util.Map;
import java.util.TreeMap;

public class _209MinimumSizeSubArray {

        public int minSubArrayLen(int s, int[] nums) {

            int start = 0;
            int end = 0;
            int sum=0;
            int min = Integer.MAX_VALUE;
            while(end<nums.length){
                sum+=nums[end];
                while(sum>=s && start<=end){
                    min = Math.min(min,end-start+1);
                    sum-=nums[start];
                    ++start;
                }
                ++end;
            }
            return min;
        }

    public int minSubArrayLen1(int s, int[] nums) {

        TreeMap<Integer,Integer>map = new TreeMap<>();

        int sum=0;
        int min = Integer.MAX_VALUE;
        for(int i=0;i<nums.length;i++){
            sum+=nums[i];
            Map.Entry<Integer,Integer>entry = map.ceilingEntry(sum-s);
            if(entry!=null){
                min = Math.min(min,(i-entry.getValue())+1);
            }
            map.put(sum,i);
        }
        return min;
    }

    public static void main(String[] args) {
        System.out.println(new _209MinimumSizeSubArray().minSubArrayLen(7,new int[]{2,3,1,2,4,3}));
    }
}
