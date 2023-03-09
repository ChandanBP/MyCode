import java.util.Arrays;
import java.util.List;

public class _539MinimumTimeDiff {

    class Time implements Comparable<Time>{
        int hh;
        int mm;
        int d;
        int t;
        public Time(int hh,int mm){
            this.hh = hh;
            this.mm = mm;
            d = 1440-hh*60+mm;
            this.t = hh*60+mm;
        }

        public int compareTo(Time time){
            return this.d-time.d;
        }
    }
    public int findMinDifference(List<String> timePoints) {
        Time result[] = new Time[timePoints.size()];
        int i =0;
        for(String time:timePoints){
            String input[] = time.split(":");
            int hh = Integer.parseInt(input[0]);
            int mm = Integer.parseInt(input[1]);
            Time t = new Time(hh,mm);
            result[i++] = t;
        }

        Arrays.sort(result);

        if(result.length==1)return 0;

        int diff = Integer.MAX_VALUE;
        for(i=1;i<result.length;i++){
            int min1 = result[i].t -result[i-1].t;
            int min2 = 1440-result[i].t+result[i-1].t;
            diff = Math.min(diff,Math.min(min1,min2));
        }
        return diff;
    }
}
