import java.util.HashMap;

public class _1010PairDivisible60 {

    public int numPairsDivisibleBy60(int[] time) {

        for(int i=0;i<time.length;i++){
            time[i]%=60;
        }

        HashMap<Integer,Integer>map = new HashMap<>();
        int numPairs=0;
        for(int i=0;i<time.length;i++){
            int ele = time[i];
            int d = (ele==0)?0:60-ele;
            int t = map.getOrDefault(d,0);
            if(t>0)numPairs+=t;
            map.put(ele,map.getOrDefault(ele,0)+1);
        }

        return numPairs;
    }

    public static void main(String[] args) {
        System.out.println(new _1010PairDivisible60().numPairsDivisibleBy60(new int[]{30,20,150,100,40}));
    }
}
