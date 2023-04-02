public class _231PowerOfTwo {

    public boolean isPowerOfTwo(int n) {

        if(n==0)return true;

        while(n>0){
            if((n&1)==0)return false;
            n = n>>1;
        }
        return true;
    }

    public static void main(String[] args) {
        System.out.println(Math.log(16)/Math.log(2));
        System.out.println(Math.log(3)/Math.log(2));
    }
}
