import java.util.Collections;
import java.util.LinkedList;

public class LP1326_2 {

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

    public static int minTaps(int n, int[] ranges) {

        int reach[] = new int[n+1];
        for(int i = 0;i<=n;i++){
            reach[Math.max(0,i-ranges[i])] = Math.max(reach[Math.max(0,i-ranges[i])],Math.min(n,i+ranges[i]));
        }

        int next = reach[0];
        int i = 0;
        int nextMax = next;
        int ans = 1;
        while(i<=next && i<n)
        {
            nextMax = Math.max(nextMax,reach[i]);
            if(i == next){
                if(nextMax == next && next!=n){
                    return -1;
                }
                next = nextMax;
                ans++;
                if(next == n){
                    break;
                }
            }
            i++;
        }
        return next!=n?-1:ans;
    }

    public static int method2(int n, int[] ranges) {

        LinkedList<Range>rangeList = new LinkedList<>();

        for(int i=0;i<ranges.length;i++){
            Range range = new Range(Math.max(0,i - ranges[i]), Math.min(i + ranges[i],n));
            rangeList.add(range);
        }
        Collections.sort(rangeList);

        int beg=-1,end=0;
        int ans = 0;
        for(int i = 0;i<rangeList.size();i++)
        {
            Range r = rangeList.get(i);
            if(r.start > end){
                return -1;
            }
            if(r.start>beg && r.end>end){
                ans++;
                beg = end;
            }
            end = Math.max(end,r.end);
        }
        return end<n?-1:ans;
    }

    public static void main(String[] args) {
        //System.out.println(minTaps(3,new int[]{0,0,0,0}));
        System.out.println(method2(7,new int[]{1,2,1,2,2,1,0,1}));
    }
}
