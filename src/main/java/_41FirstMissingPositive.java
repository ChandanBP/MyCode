public class _41FirstMissingPositive {

    public int firstMissingPositive(int[] nums) {

        if(nums==null||nums.length==0)return 1;

        int n = nums.length;
        boolean isOnePresent=false;

        for(int i=0;i<nums.length;i++){
            if(nums[i]==1)isOnePresent=true;
            if(nums[i]<=0 || nums[i]>n)nums[i]=1;
        }

        if(!isOnePresent)return 1;

        for(int i=0;i<nums.length;i++){
            int index = Math.abs(nums[i])-1;
            if(nums[index]>0)nums[index]*=-1;
        }

        for(int i=0;i<nums.length;i++){
            if(nums[i]>0)return i+1;
        }
        return n+1;
    }

    public static void main(String[] args) {
        System.out.println(new _41FirstMissingPositive().firstMissingPositive(new int[]{1,0,3,3,0,2}));
    }
}
