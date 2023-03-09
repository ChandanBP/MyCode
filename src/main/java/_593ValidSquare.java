import java.util.Arrays;

public class _593ValidSquare {

    public int getDistance(int[] p1,int[] p2){
        int dist = (int)Math.pow(p1[0]-p2[0],2)+(int)Math.pow(p1[1]-p2[1],2);
        dist = (int)Math.sqrt(dist);
        return dist;
    }

    public boolean validSquare(int[] p1, int[] p2, int[] p3, int[] p4) {

        int points[][] = new int[4][4];

        points[0] = p1;
        points[1] = p2;
        points[2] = p3;
        points[3] = p4;

        Arrays.sort(points,(point1, point2)->{
            if(point1[0]==point2[0])return point1[1]-point2[1]; return point1[0]-point2[0];});

        int dist[] = new int[4];
        dist[0] = getDistance(points[0],points[2]);
        dist[1] = getDistance(points[1],points[3]);
        dist[2] = getDistance(points[0],points[1]);
        dist[3] = getDistance(points[2],points[3]);

        for(int i=0;i<3;i++)
            if(dist[i]!=dist[i+1] || dist[i]==0)return false;


        int diag1 = getDistance(points[0],points[3]);
        int diag2 = getDistance(points[1],points[2]);

        if(diag1!=diag2)return false;

        return true;
    }

    public static void main(String[] args) {
        int[] p1={0,0};
        int[] p2={-1,0};
        int[] p3={1,0};
        int[] p4={0,1};
        System.out.println(new _593ValidSquare().validSquare(p1,p2,p3,p4));
    }
}
