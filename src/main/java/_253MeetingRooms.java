import java.util.Arrays;

public class _253MeetingRooms {

    class Event implements Comparable<Event>{
        int value;
        int isStart;
        Event(int value,int isStart){
            this.value=value;
            this.isStart=isStart;
        }

        @Override
        public int compareTo(Event event) {
            if(this.isStart==1&&event.isStart==0&&this.value==event.value){
                return event.isStart-this.isStart;
            }
            return this.value-event.value;
        }
    }

    public int minMeetingRooms(int[][] intervals) {

        Event[] events = new Event[intervals.length*2];
        int k=0;
        for(int i=0;i<intervals.length;i++){
            events[k++]=new Event(intervals[i][0],0);
            events[k++]=new Event(intervals[i][1],1);
        }

        int num_rooms=0;
        Arrays.sort(events);
        int max=0;
        for(Event event:events){
            num_rooms=(event.isStart==0)?num_rooms+1:num_rooms-1;
            max=Math.max(max,num_rooms);
        }
        return max;
    }

    public static void main(String[] args) {
        int intervals[][] = {{13,15},{1,13}};
        System.out.println(new _253MeetingRooms().minMeetingRooms(intervals));
    }
}
