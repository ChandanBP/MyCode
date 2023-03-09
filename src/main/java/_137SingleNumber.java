public class _137SingleNumber {

    public int singleNumber(int[] nums) {
        int val = 0;
        for(int ele:nums){
            val^=ele;
        }
        return val;
    }

    public static void main(String[] args) {
        System.out.println(new _137SingleNumber().singleNumber(new int[]{2,2,3,2}));
    }
}
