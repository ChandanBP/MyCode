public class _7ReverseInteger {

    public int reverse(int x) {

        if(x>0 && x+1<0)return 0;
        if(x<0 && x-1>0)return 0;

        if(x==0)return 0;
        StringBuilder sb = new StringBuilder();
        int y =1;
        if(x<0){
            x=x*-1;
            y=-1;
        }
        while(x>0){
            int r = x%10;
            int q = x/10;
            sb.append(r);
            x=x/10;
        }
        try{
            return Integer.parseInt(sb.toString())*y;
        }catch (NumberFormatException ex){
            return 0;
        }
    }

    public static void main(String[] args) {
        System.out.println(new _7ReverseInteger().reverse(1534236469));
    }
}
