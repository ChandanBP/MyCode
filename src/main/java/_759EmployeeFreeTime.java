import java.util.*;
import java.util.concurrent.CompletableFuture;

class Interval {
    public int start;
    public int end;

    public Interval() {}

    public Interval(int _start, int _end) {
        start = _start;
        end = _end;
    }
}

public class _759EmployeeFreeTime {

    public List<Interval> employeeFreeTime(List<List<Interval>> schedule) {

        ArrayList<Interval> intervals = new ArrayList<>();
        for(List<Interval>list:schedule)
            for(Interval interval:list)
                intervals.add(interval);

        Collections.sort(intervals,(a, b)->{if(a.start==b.start)return a.end-b.end;
            return a.start-b.start;
        });

        ArrayList<Interval>sortedIntervals = new ArrayList<>();
        sortedIntervals.add(intervals.get(0));
        Interval prev = intervals.get(0);
        List<Interval>result = new ArrayList<>();
        for(int i=1;i<intervals.size();i++){
            Interval curr = intervals.get(i);
            if(curr.start<=prev.end){
                prev.end = Math.max(prev.end,curr.end);
            }else{
                sortedIntervals.add(curr);
                result.add(new Interval(prev.end,curr.start));
                prev = curr;
            }
        }
        CompletableFuture.runAsync(new Runnable() {
            @Override
            public void run() {

            }
        });
        return result;
    }
}
