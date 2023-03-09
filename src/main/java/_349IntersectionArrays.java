import java.util.HashSet;

public class _349IntersectionArrays {

    public int[] intersection(int[] nums1, int[] nums2) {
        HashSet<Integer> set1 = new HashSet<Integer>();
        HashSet<Integer>set2 = new HashSet<Integer>();

        for(int ele:nums1){
            set1.add(ele);
        }

        for(int ele:nums2){
            set2.add(ele);
        }

        set1.retainAll(set2);
        int res[] = new int[set1.size()];

        int i =0;
        for(int ele:set1){
            res[i++]=ele;
        }
        return res;
    }

    public static void main(String[] args) {
        System.out.println(new _349IntersectionArrays().intersection(new int[]{4,9,5},new int[]{9,4,9,8,4}).toString());
    }
}
