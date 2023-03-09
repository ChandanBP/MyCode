import java.util.HashMap;

public class _397IntegerReplacement {

    HashMap<Long,Integer> result = new HashMap();
    public int minOperations(long n){

        if(n==1)return 0;
        if(result.containsKey(n))return result.get(n);

        int count = 0;
        while((n%2)==0){
            ++count;
            n = n/2;
        }
        if(n==1){
            result.put((long)n,count);
            return count;
        }else{
            int val = 1+count+Math.min(minOperations(n-1),minOperations(n+1));
            result.put((long)n,val);
            return val;
        }
    }

    public static void main(String[] args) {
        System.out.println(Integer.MAX_VALUE);
        System.out.println(new _397IntegerReplacement().minOperations(Integer.MAX_VALUE));
    }
}
