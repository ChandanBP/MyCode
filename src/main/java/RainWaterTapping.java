public class RainWaterTapping {
    public int maxArea(int[] arr){
        int n = arr.length;
        int left[] = new int[n];
        int right[] = new int[n];
        int water = 0;
        left[0] = arr[0];
        for (int i = 1; i < n; i++)
            left[i] = Math.max(left[i - 1], arr[i]);
        right[n - 1] = arr[n - 1];
        for (int i = n - 2; i >= 0; i--)
            right[i] = Math.max(right[i + 1], arr[i]);

        for (int i = 0; i < n; i++){
            int min = Math.min(left[i], right[i]);
            water +=  min- arr[i];
        }
        return water;
    }

    public static void main(String[] args) {
        System.out.println(new RainWaterTapping().maxArea(new int[]{1,0,8,0,6,0,2,0,5,0,4,0,8,0,3,0,7}));
    }
}
