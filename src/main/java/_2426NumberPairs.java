import java.util.*;

public class _2426NumberPairs {

    public long numberOfPairs(int[] nums1, int[] nums2, int diff) {

        TreeSet<Integer>set = new TreeSet();
        long count = 0;
        for(int i=nums1.length-1;i>=0;i--){
            if(i==nums1.length-1){
                set.add(nums2[i]-nums1[i]);
                continue;
            }else{
                int iDiff = nums1[i]-nums2[i];
                int diffRequired = diff-iDiff;
                Integer from = set.first();
                Integer to = set.floor(diffRequired);
                if(to!=null){
                    SortedSet<Integer>sortedSet =  set.subSet(from,to+1);
                    if(sortedSet!=null)count+=sortedSet.size();
                }else{
                    count+=1;
                }
            }
            set.add(nums2[i]-nums1[i]);
        }
        return count;
    }

    public static void main(String[] args) {
        System.out.println(new _2426NumberPairs().numberOfPairs(new int[]{3,2,5},new int[]{2,2,1},1));
    }
}
