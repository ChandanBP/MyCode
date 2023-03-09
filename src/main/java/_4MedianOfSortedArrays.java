public class _4MedianOfSortedArrays {

    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int res[] = new int[nums1.length+nums2.length];

        int i=0;
        int j=0;
        int k=0;
        while(i<nums1.length && j<nums2.length){
            if(nums1[i]<nums2[j]){
                res[k++]=nums1[i++];
            }
            else if(nums1[i]>nums2[j]){
                res[k++]=nums2[j++];
            }
            else{
                res[k++]=nums1[i++];
                res[k++]=nums2[j++];
            }
        }

        while(i<nums1.length){
            res[k++]=nums1[i++];
        }

        while(j<nums2.length){
            res[k++]=nums2[j++];
        }

        if((res.length%2)!=0)return res[res.length/2];
        else{
            int mid = res.length/2;
            double val = (res[mid-1]+res[mid])/2.0;
            return val;
        }
    }

    public static void main(String[] args) {
        System.out.println(new _4MedianOfSortedArrays().findMedianSortedArrays(new int[]{1,2},new int[]{3,4}));
    }
}
