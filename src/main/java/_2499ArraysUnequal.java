public class _2499ArraysUnequal {

    public long minimumTotalCost(int[] nums1, int[] nums2){

        int count[] = new int[nums1.length+1];
        int totalEqualNums = 0;
        long sum = 0;
        int maxVal = Integer.MIN_VALUE;
        for(int i=0;i<nums1.length;i++){

            if(nums1[i]==nums2[i]){
                sum+=i;
                ++totalEqualNums;
                ++count[nums1[i]];

                if(maxVal<count[nums1[i]]){
                    maxVal = count[nums1[i]];
                }
            }
        }

        long swapsReq = 2*maxVal-totalEqualNums;
        for(int i=0;i<nums1.length&&swapsReq>0;i++){
            if(nums1[i]!=nums2[i] && nums1[i]!=maxVal && nums2[i]!=maxVal){
                --swapsReq;
                sum+=i;
            }
        }
        return (swapsReq>0)?-1:sum;
    }
}
