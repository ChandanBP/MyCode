public class _198HouseRobber {

    public int rob(int[] nums){

        if(nums==null||nums.length==0)return 0;
        if(nums.length==1)return nums[0];
        if(nums.length==2)return Math.max(nums[0],nums[1]);

        int res[] = new int[nums.length+1];
        for(int i=0;i<nums.length;i++){
            res[i+1]=nums[i];
        }

        for(int i=1;i<nums.length;i++){
            res[i+1] = Math.max(res[i+1]+res[i+1-2],res[i+1-1]);
        }
        return res[nums.length];
    }

    public static void main(String[] args) {
        System.out.println(new _198HouseRobber().rob(new int[]{2,1,1,2}));
    }
}
