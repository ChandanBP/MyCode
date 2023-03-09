import java.util.HashMap;

public class _1027LongestArithmeticSubsequence {

    public int longestArithSeqLength(int[] A) {

        int max = 1;
        HashMap<Integer, HashMap<Integer,Integer>>map = new HashMap();
        for(int i=0;i<A.length;i++){
            if(!map.containsKey(A[i])){
                HashMap<Integer,Integer>m = new HashMap<>();
                m.put(0,1);
                map.put(A[i],m);
            }
            int c1=1;
            HashMap<Integer,Integer>m1 = map.get(A[i]);
            for(int j=0;j<i;j++){
                if(A[i]==A[j]){
                    ++c1;
                    continue;
                }
                int diff = A[i]-A[j];
                HashMap<Integer,Integer>m2 = map.get(A[j]);
                int c;
                if(m2.containsKey(diff)){
                    c = 1+m2.get(diff);
                }else{
                    c = 2;
                }
                m1.put(diff,c);
                map.put(A[i],m1);
                max = Math.max(max,c);
            }
            m1.put(0,c1);
            max = Math.max(max,c1);
        }
        return max;
    }

    public static void main(String[] args) {
        System.out.println(new _1027LongestArithmeticSubsequence().longestArithSeqLength(new int[]{3,3,3,3}));
    }
}
