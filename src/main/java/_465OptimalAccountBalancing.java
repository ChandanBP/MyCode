import java.util.HashMap;

public class _465OptimalAccountBalancing {

    public int minTransfers(int[][] transactions) {

        HashMap<Integer,Integer>map = new HashMap<>();

        for(int i=0;i<transactions.length;i++){
            int s = transactions[i][0];
            int t = transactions[i][1];
            int m = transactions[i][2];

            map.putIfAbsent(s,0);
            map.putIfAbsent(t,0);

            map.put(s,map.get(s)+m);
            map.put(t,map.get(t)-m);
        }
        int positive = (int) map.entrySet().stream().filter(entry -> entry.getValue()>0).count();
        int negative = (int) map.entrySet().stream().filter(entry -> entry.getValue()<0).count();
        return Math.max(positive,negative);
    }

    public static void main(String[] args) {
        System.out.println(Integer.parseInt("9646324351"));
        System.out.println(Integer.MAX_VALUE);
        int arr[][] = {{2,0,5},{3,4,4}};
        new _465OptimalAccountBalancing().minTransfers(arr);
    }
}
