import java.util.Arrays;

public class MergeSortedArrays {

    public static void merge(int[] nums1, int m, int[] nums2, int n){
        int i = 0;
        int j = 0;
        int k = 0;
        int res[] = new int[m+n];
        while(i<m && j<n){
            if(nums1[i]<nums2[j]){
                res[k++]=nums1[i++];
            }
            else if(nums1[i]>nums2[j]){
                res[k++] = nums2[j++];
            }
            else{
                res[k++] = nums1[i];
                res[k++] = nums2[j];
                i++;
                j++;
            }
        }

        while(i<m){
            res[k++]=nums1[i++];
        }

        while(j<n){
            res[k++]=nums2[j++];
        }

        nums1 = new int[m+n];
        for(i=0;i<res.length;i++){
            nums1[i] = res[i];
        }
        System.out.println(Arrays.toString(nums1));
    }

    public static void main(String[] args) {
        int nums1[] = {1,2,3,0,0,0};
        int nums2[] = {2,5,6};
        merge(nums1,3,nums2,3);
    }
}
