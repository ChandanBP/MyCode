import java.util.Arrays;

public class _31NextPermutation {

    public void swap(int[] nums,int pos1,int pos2){
        int t = nums[pos1];
        nums[pos1] = nums[pos2];
        nums[pos2] = t;
    }

    public void nextPermutation(int[] nums) {

        if(nums.length<=1)return;

        int i = nums.length-1;
        boolean flag = false;
        i=i-1;
        int s=0,e=0;
        while(i>=0){
            if(nums[i]<nums[i+1]){
                s=i;
                e=i+1;
                flag = true;
                break;
            }
            i--;
        }
        int count[] = new int[10];
        if(flag){

            int min=Integer.MAX_VALUE;
            for(int k=s+1;k<=nums.length-1;k++){
                if(nums[k]!=nums[s] && nums[k]>nums[s] && Math.abs(nums[s]-nums[k])<min){
                    min = Math.abs(nums[s]-nums[k]);
                    e = k;
                }
            }

            swap(nums,s,e);
            int t = s+1;
            Arrays.sort(nums,t,nums.length);
        }else{
            Arrays.sort(nums);
        }
    }

    public static void main(String[] args) {
        new _31NextPermutation().nextPermutation(new int[]{1,3,2});
    }
}
