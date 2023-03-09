public class _1131AbsoluteValueMax {

    public int maxAbsValExpr(int[] arr1, int[] arr2) {

        int max=Integer.MIN_VALUE;
        for(int i=0;i<arr1.length;i++){
            for(int j=0;j<arr1.length;j++){
                int sum = Math.abs(arr1[i]-arr1[j])+Math.abs(arr2[i]-arr2[j])+(i-j);
                max = Math.max(sum,max);
            }
        }
        return max;
    }

    public static void main(String[] args) {

    }
}
