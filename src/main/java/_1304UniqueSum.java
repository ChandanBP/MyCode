import java.util.Arrays;

public class _1304UniqueSum {

    public static int[] sumZero(int n) {
        if(n==1) return new int[]{0};

        int[] arr = new int[n];
        int start = 1;
        int j = (n%2==0)?arr.length-1:arr.length-2;

        for(int i=0;i<j;i+=2){
            arr[i] = start;
            arr[i+1] = start*-1;
            start++;
        }
        return arr;
    }

    public static void main(String[] args) {
        System.out.println(Arrays.toString(sumZero(5)));
    }
}
