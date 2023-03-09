import java.util.Collections;
import java.util.LinkedList;

public class _732MyCalendar {

    LinkedList<int[]>events;
    public _732MyCalendar() {
        events = new LinkedList<>();
    }

    public int book(int start, int end) {

        events.add(new int[]{0,start});
        events.add(new int[]{1,end});
        Collections.sort(events,(a,b)->{
            if(a[1]==b[1])return b[0]-a[0];
            return a[1]-b[1];}
            );

        int ans = 0;
        int max = 0;
        for(int[] event:events){
            if(event[0]==0){
                ++ans;
                max = Math.max(max,ans);
            }else{
                --ans;
            }
        }
        return max;
    }

    public static void main(String[] args) {
        _732MyCalendar obj = new _732MyCalendar();
        obj.book(10,20);
        obj.book(50,60);
        obj.book(10,40);
        obj.book(5,15);
        obj.book(5,10);
        obj.book(25,55);
    }
}
