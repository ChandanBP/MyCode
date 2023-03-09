import java.util.HashMap;

public class _70ClimbingStairs {

    HashMap<Integer,Integer> dp = new HashMap<>();

    public _70ClimbingStairs(){
        dp.put(0,1);
    }

    public int climbStairs(int n) {

        if(dp.containsKey(n))return dp.get(n);

        int res=0;
        if(n-1>=0)
            res=climbStairs(n-1);
        dp.put(n-1,res);

        if(n-2>=0){
            int t = climbStairs(n-2);
            dp.put(n-2,t);
            res+=t;
        }
        return res;
    }

    public static void main(String[] args) {
        System.out.println(new _70ClimbingStairs().climbStairs(44));
    }
}
