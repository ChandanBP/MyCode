import java.util.Arrays;

public class _1438LongestSubarray {

    int arr[];
    int minSegMentTree[];
    int maxSegMentTree[];

    public static int nextPowerOf2(int num){

        if(num ==0){
            return 1;
        }
        if(num > 0 && (num & (num-1)) == 0){
            return num;
        }
        while((num & (num-1)) > 0){
            num = num & (num-1);
        }
        return num<<1;
    }

    public void constructMinSegmentTree(int low,int high,int pos){

        if(low==high){
            minSegMentTree[pos] = arr[low];
            return;
        }
        int mid = (low+high)/2;
        constructMinSegmentTree(low,mid,2*pos+1);
        constructMinSegmentTree(mid+1,high,2*pos+2);
        minSegMentTree[pos]=Math.min(minSegMentTree[2*pos+1],minSegMentTree[2*pos+2]);
    }

    public void constructMaxSegmentTree(int low,int high,int pos){

        if(low==high){
            maxSegMentTree[pos] = arr[low];
            return;
        }
        int mid = (low+high)/2;
        constructMaxSegmentTree(low,mid,2*pos+1);
        constructMaxSegmentTree(mid+1,high,2*pos+2);
        maxSegMentTree[pos]=Math.max(maxSegMentTree[2*pos+1],maxSegMentTree[2*pos+2]);
    }

    public int query(int qlow, int qhigh, int low, int high, int pos){

        if(qlow<=low && qhigh>=high)return minSegMentTree[pos];
        if(qlow>high || qhigh<low)return Integer.MAX_VALUE;
        int mid = (low+high)/2;
        return Math.min(query(qlow,qhigh,low,mid,2*pos+1),
                query(qlow,qhigh,mid+1,high,2*pos+2));
    }

    public int queryMax(int qlow, int qhigh, int low, int high, int pos){

        if(qlow<=low && qhigh>=high)return maxSegMentTree[pos];
        if(qlow>high || qhigh<low)return Integer.MIN_VALUE;
        int mid = (low+high)/2;
        return Math.max(queryMax(qlow,qhigh,low,mid,2*pos+1),
                queryMax(qlow,qhigh,mid+1,high,2*pos+2));
    }

    public int longestSubarray(int[] nums, int limit) {
        arr = nums;
        int size= nextPowerOf2(arr.length);
        minSegMentTree = new int[2*size-1];
        maxSegMentTree = new int[2*size-1];

        Arrays.fill(minSegMentTree,Integer.MAX_VALUE);
        Arrays.fill(maxSegMentTree,Integer.MIN_VALUE);

        constructMinSegmentTree(0,arr.length-1,0);
        constructMaxSegmentTree(0,arr.length-1,0);

        int start= 0;
        int end =0;
        int maxLen=0;

        while(end<arr.length){
            int min = query(start,end,0,arr.length-1,0);
            int max = queryMax(start,end,0,arr.length-1,0);

            if((max-min)<=limit){
                maxLen = Math.max(maxLen,(end-start)+1);
                ++end;
            }else{
                ++start;
            }
        }
        return maxLen;
    }

    public static void main(String[] args) {
        _1438LongestSubarray longestSubarray = new _1438LongestSubarray();
        longestSubarray.arr = new int[]{8, 4, 2, 6, 7};
        longestSubarray.longestSubarray(longestSubarray.arr,4);
    }
}
