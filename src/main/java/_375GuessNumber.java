public class _375GuessNumber {

    int start=1;
    int res=0;

    public int getMoneyAmount(int n) {

        if(n==1)return 0;
        if(n<=start)return -1;

        int mid = (start+n)/2;
        res+=mid;
        start=mid+1;
        getMoneyAmount(n);
        return res;
    }

    public static void main(String[] args) {
        System.out.println(new _375GuessNumber().getMoneyAmount(10));
    }
}
