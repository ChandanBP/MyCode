import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class _1610MaxVisiblePoints {

    public static int getAngle(int x1,int y1,int x2,int y2){
        int deltaY = y2-y1;
        int deltaX = x2-x1;
        double x = Math.atan2(deltaY, deltaX)*57.2958;
        return (int)((x+360)%360); // this will give theta in degrees
    }

    class Point{
        int x;
        int y;
        int angle;
        public Point(int x,int y,int px,int py){
            this.x = x;
            this.y = y;
            this.angle = getAngle(px,py,x,y);
        }
    }

    public int visiblePoints(List<List<Integer>> list, int angle, List<Integer> location) {

        int px = location.get(0);
        int py = location.get(1);

        List<List<Integer>> temp = new LinkedList<>();
        list.stream().filter(p->p.get(0)!=px && p.get(1)!=py).map(m->temp.add(m));

        int atOrigin = list.size()-temp.size();
        Point points[] = new Point[temp.size()];
        int i=0;
        for(List<Integer>p:temp){
            points[i] = new Point(p.get(0),p.get(1),px,py);
            i++;
        }

        Arrays.sort(points,(a, b)->{
            int x1 = a.x;
            int y1 = a.y;
            int x2 = b.x;
            int y2 = b.y;
            return getAngle(px,py,x1,y1)-getAngle(px,py,x2,y2);
        });

        int max = 0;
        int start = 0;
        for(int end=0;end<points.length;end++){
            while(points[end].angle-points[start].angle>angle){
                ++start;
            }
            max = Math.max(max,end-start+1);
        }
        return max+atOrigin;
    }

    public static void main(String[] args) {

        //System.out.println(getAngle(1,1,1,0));
        _1610MaxVisiblePoints obj = new _1610MaxVisiblePoints();

        List<List<Integer>>list = new LinkedList<>();

        List<Integer>list1 = new LinkedList<>();
        list1.add(1);
        list1.add(1);
        list.add(list1);

        list1 = new LinkedList<>();
        list1.add(2);
        list1.add(2);
        list.add(list1);

        list1 = new LinkedList<>();
        list1.add(3);
        list1.add(3);
        list.add(list1);

        list1 = new LinkedList<>();
        list1.add(4);
        list1.add(4);
        list.add(list1);

        list1 = new LinkedList<>();
        list1.add(1);
        list1.add(2);
        list.add(list1);

        list1 = new LinkedList<>();
        list1.add(2);
        list1.add(1);
        list.add(list1);

        List<Integer>position = new LinkedList<>();
        position.add(1);
        position.add(1);
        System.out.println(obj.visiblePoints(list,0,position));
    }
}
