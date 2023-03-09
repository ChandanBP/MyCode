public class _9PalindromNumber {

    public boolean isPalindrome(int x) {
        if(x==0)return true;
        if(x<0)return false;

        int t=x;
        int res=0;
        while(x>0){
            int rem = x%10;
            res=(res*10)+rem;
            x/=10;
        }
        return (t==res);
    }

    public static void main(String[] args) {
        System.out.println(new _9PalindromNumber().isPalindrome(1));
    }
}
