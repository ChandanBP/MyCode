import java.util.*;

public class LP1326 {

    static class Range implements Comparable<Range>{

        int start;
        int end;
        Range(int start, int end){
            this.start  =start;
            this.end = end;
        }

        @Override
        public int compareTo(Range range) {
            return this.start-range.start;
        }
    }

    // Merge intervals
    public static LinkedList<Range> mergeRange(LinkedList<Range> rangeList){

        if(rangeList==null || rangeList.size()<=1) return rangeList;

        LinkedList<Range>result = new LinkedList<>();
        result.add(rangeList.getFirst());

        for(int i=1;i<rangeList.size();i++){

            Range currRange = rangeList.get(i);
            Range prevRange = result.getLast();

            // check current is covering previous
            if(prevRange.start>=currRange.start && prevRange.end<=currRange.end){
                prevRange.start = Math.min(prevRange.start,currRange.start);
                prevRange.end = Math.max(prevRange.end,currRange.end);
            }
            else if(currRange.start>=prevRange.start && currRange.end<=prevRange.end){
                // do nothing
            }
            else{
                result.add(currRange);
            }
        }

        return result;
    }

    public static int minTaps(int n, int[] ranges) {

        if(n==1)return 1;

        LinkedList<Range>rangeList = new LinkedList<>();

        for(int i=0;i<ranges.length;i++){
            Range range = new Range(i - ranges[i], i + ranges[i]);
            rangeList.add(range);
        }

        Collections.sort(rangeList);
        rangeList = mergeRange(rangeList);

        return rangeList.size();
    }

//    public static int minTaps(int n, int[] ranges) {
//        int[][] rg = new int[n + 1][2];
//        for (int i = 0; i <= n; ++i)
//            rg[i] = new int[]{i - ranges[i], i + ranges[i]};
//        Arrays.sort(rg, Comparator.comparing(r -> r[0]));
//        int ans = 0;
//        for (int i = 0, start = 0, end = 0; start < n && i <= n; start = end, ++ans) {
//            while (i <= n && rg[i][0] <= start)
//                end = Math.max(end, rg[i++][1]);
//            if (end <= start)
//                return -1;
//        }
//        return ans;
//    }

    public static void main(String[] args) {
        System.out.println(minTaps(7,new int[]{1,2,1,0,2,1,0,1}));
    }
}
