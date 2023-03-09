import java.util.Arrays;
import java.util.List;

public class _396RoateFunction {

    public int maxRotateFunction(int[] nums) {
        int sum = 0;
        int res = 0;

        for(int i=0;i<nums.length;i++){
            sum+=nums[i];
            res+=nums[i]*i;
        }

        int max = res;
        for(int i=nums.length-1;i>0;i--){
            res = res-(nums[i]*(nums.length-1))+(sum-nums[i]);
            max = Math.max(max,res);
        }
        return max;
    }

    public static void main(String[] args) {
        //new _396RoateFunction().maxRotateFunction(new int[]{4,3,2,6});
        List<Integer> integers = Arrays.asList(1, 2, 3, 4, 5);
        Integer sum = integers.stream()
                .reduce(1, (a, b) -> a + b);
        System.out.println(sum);

        Thread t = new Thread();
    }
}
