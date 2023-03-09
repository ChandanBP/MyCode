import java.util.Scanner;

public class WeirdSum2 {

    long numbers[];
    long dp[][];
    int N,K;
    long M;

    public long getMaxSum(){

        for(int n=1;n<=N;n++){
            for(int k=1;k<=K;k++){
                if(k<n){
                    dp[n][k]=Math.max(dp[n-1][k],dp[n-1][k-1]+(numbers[n]*(k%M)));
                }
                else if(n==k){
                    dp[n][k]=dp[n-1][k-1]+(numbers[n]*(k%M));
                }
                else{
                    dp[n][k]=-1000000000000000000L;
                }
            }
        }
        return dp[N][K];
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        WeirdSum2 weirdSum2 = new WeirdSum2();
        weirdSum2.N = scanner.nextInt();
        weirdSum2.K = scanner.nextInt();
        weirdSum2.M = scanner.nextLong();
        weirdSum2.dp = new long[weirdSum2.N+1][weirdSum2.K+1];
        weirdSum2.numbers = new long[weirdSum2.N+1];

        for(int n=1;n<=weirdSum2.N;n++){
            weirdSum2.numbers[n]=scanner.nextLong();
        }
        if(weirdSum2.M==1 && weirdSum2.K<=weirdSum2.N){
            System.out.println(weirdSum2.numbers[1]);
        }else{
            System.out.println(weirdSum2.getMaxSum());
        }
    }
}