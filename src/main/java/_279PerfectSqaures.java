public class _279PerfectSqaures {

    public int numSquares(int n) {
        int result[] = new int[n+1];

        for(int i=1;i<n+1;i++){
            result[i]=Integer.MAX_VALUE;
        }

        for(int i=1;i*i<n+1;i++){
            result[i*i]=1;
        }

        for(int i=1;i<n+1;i++){
            for(int j=1;j<i;j++){
                result[i]=Math.min(result[i],result[j]+result[i-j]);
            }
        }
        return result[n];
    }

    public static void main(String[] args) {
        System.out.println(new _279PerfectSqaures().numSquares(12));
    }
}
