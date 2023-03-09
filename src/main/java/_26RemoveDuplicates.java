public class _26RemoveDuplicates {

    public int removeDuplicates(int[] nums) {

        if(nums==null||nums.length==0)return 0;
        if(nums.length==1)return 1;

        int p1=0;
        int i=1;

        while(i<nums.length){
            if(nums[i]!=nums[i-1]){
                nums[++p1]=nums[i];
            }
            ++i;
        }

        return p1;
    }

    public static void main(String[] args) {

    }
}
