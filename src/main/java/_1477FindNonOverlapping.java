public class _1477FindNonOverlapping {

    public int minSumOfLengths(int[] arr, int target) {

        long[] left=new long[arr.length];
        long[] right=new long[arr.length];
        long leftlen=Integer.MAX_VALUE;
        int sum=0;
        int start=0;
        for(int i=0;i<arr.length;i++){
            sum+=arr[i];
            while(sum>target){
                sum-=arr[start++];
            }
            if(sum==target){
                leftlen=Math.min(leftlen,i-start+1);
            }
            left[i]=leftlen;
        }
        sum=0;
        start=arr.length-1;
        long rightlen=Integer.MAX_VALUE;
        for(int i=arr.length-1;i>=0;i--){
            sum+=arr[i];
            while(sum>target){
                sum-=arr[start--];
            }
            if(sum==target){
                rightlen=Math.min(rightlen,start-i+1);
            }
            right[i]=rightlen;
        }

        long max=Integer.MAX_VALUE;
        for(int i=1;i<arr.length;i++){
            max=Math.min(left[i-1]+right[i],max);
        }
        return (int)(max>=Integer.MAX_VALUE?-1:max);
    }

    public static void main(String[] args) {
        System.out.println(new _1477FindNonOverlapping().minSumOfLengths(new int[]{2,2,4,4,4,4,4,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1},20));
    }
}
