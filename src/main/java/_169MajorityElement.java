public class _169MajorityElement {

    public int majorityElement(int[] nums) {

        int count=0;
        int maxEle=nums[0];

        for(int ele:nums){
            if(count==0)maxEle=ele;
            count+=(ele==maxEle)?+1:-1;
        }
        return maxEle;
    }

    public static void main(String[] args) {
        new _169MajorityElement().majorityElement(new int[]{1,1,2,2,2});
    }
}
