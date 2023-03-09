public class _53MaximumSubArray {

    public int maxSubArray(int[] nums) {

        int max=nums[0];
        int sum=0;

        for(int num:nums){
            sum=max+num;
            int max1 = Math.max(sum,num);
            max = Math.max(max1,sum);
        }
        return max;
    }

    public static void main(String[] args) {
        System.out.println(new _53MaximumSubArray().maxSubArray(new int[]{-2,1,-3,4,-1,2,1,-5,4}));
    }
}
