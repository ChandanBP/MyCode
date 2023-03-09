public class _189RotateArray {

    public void rotate(int[] nums, int k) {

        int count =0;
        int len = nums.length;
        for(int i=0;i<nums.length;i++){

            int j = i;
            int t = nums[i];
            do {
                int temp = nums[(j+k)%len];
                nums[(j+k)%len] = t;
                t = temp;
                ++count;
                j=(j+k)%len;
            }while (count<len && j!=i);

            if(count==nums.length)break;
        }
    }

    public static void main(String[] args) {
        new _189RotateArray().rotate(new int[]{1,2,3,4,5,6},2);
    }
}
