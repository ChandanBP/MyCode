public class _50Pow {

    public double myPowCalc(double x, int n){
        if(n==0)return 1;

        double res1 = myPowCalc(x, n/2);

        if(n%2==0)
            return res1*res1;
        else
            return res1*res1*x;
    }

    public double myPow(double x, int n) {


        int t = n;
        if(t<0)t=t*-1;

        double res = myPowCalc(x,t);
        return (n>0)?res:(1/res);
    }

    public static void main(String[] args) {
        System.out.println(new _50Pow().myPow(2.00000,-2147483648));
    }
}
