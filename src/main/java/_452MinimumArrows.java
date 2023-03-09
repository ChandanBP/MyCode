import java.util.Arrays;
import java.util.Comparator;

public class _452MinimumArrows {

    public int findMinArrowShots(int[][] points) {

        if(points==null)return 0;
        if(points.length<=1)return points.length;

        Arrays.sort(points, Comparator.comparingInt(a -> a[0]));

        int i = 0;
        int arrows = 0;

        if(points[0][0]<points[1][0]){
            System.out.println("true");
        }

        while(i<points.length){

            if(i+1==points.length){
                ++arrows;
                ++i;
                continue;
            }

            int[] point1 = points[i];
            int[] point2 = points[i+1];
            if(point2[0]<=point1[1]){
                i+=2;
            }else{
                ++i;
            }
            ++arrows;
        }
        return arrows;
    }

    public static void main(String[] args) {
        int[][]points = {{-2147483646,-2147483645},{2147483646,2147483647}};
        new _452MinimumArrows().findMinArrowShots(points);
    }
}
