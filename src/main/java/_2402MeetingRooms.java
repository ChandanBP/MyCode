import java.util.*;

class Meeting{
    int start;
    int end;
    int room_no;

    public Meeting(int start,int end){
        this.start = start;
        this.end = end;
        this.room_no = -1;
    }
}
public class _2402MeetingRooms {

    PriorityQueue<Integer> free_rooms = new PriorityQueue();
    PriorityQueue<Meeting> occupied_rooms = new PriorityQueue<>((a, b)->{
       if(a.end==b.end)return a.room_no-b.room_no;
       return a.end-b.end;
    });


    int[] room_count;
    public int mostBooked(int n, int[][] meetings) {

        room_count = new int[n];
        for(int i=0;i<n;i++)
            free_rooms.add(i);

        Arrays.sort(meetings,(a,b)->a[0]-b[0]);
        for(int i=0;i<meetings.length;i++){

            int start = meetings[i][0];
            int end = meetings[i][1];

            while(!occupied_rooms.isEmpty() && occupied_rooms.peek().end<start){
                Meeting meeting = occupied_rooms.poll();
                free_rooms.add(meeting.room_no);
            }

            Meeting meeting = new Meeting(start,end);
            int r=0;
            if(!free_rooms.isEmpty()){
                r = free_rooms.poll();
            }else{
                Meeting m = occupied_rooms.poll();
                int duration = end-start;
                start = m.end;
                end = start+duration;
                meeting = new Meeting(start,end);
                r = m.room_no;
            }
            meeting.room_no = r;
            room_count[r]++;
            occupied_rooms.add(meeting);
        }
        int max = Integer.MIN_VALUE;
        int maxi = 0;
        for(int i=0;i< room_count.length;i++){
            if(room_count[i]>max){
                max = room_count[i];
                maxi = i;
            }
        }
        return maxi;
    }

    public static void main(String[] args) {
        System.out.println(new _2402MeetingRooms().mostBooked(2,new int[][]{
                {0,10},
                {1,5},
                {2,7},{3,4}
        }));
    }
}
