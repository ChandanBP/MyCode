import java.util.Arrays;

public class _1465MaximumAreaCake {

    public int maxArea(int h, int w, int[] horizontalCuts, int[] verticalCuts) {

        Arrays.sort(horizontalCuts);
        Arrays.sort(verticalCuts);

        int lastHorizontal = 0;
        int lastVertical = 0;

        int area = -1;
        int mod = 1000000007;
        for(int i=0;i<verticalCuts.length;i++){
            for(int j=0;j<horizontalCuts.length;j++){
                int horDist = verticalCuts[i]-lastVertical;
                int verDist = horizontalCuts[j]-lastHorizontal;
                int tempArea = ((horDist%mod)*(verDist%mod)%mod);
                area = Math.max(area,tempArea);
                lastHorizontal = horizontalCuts[j];
            }
            lastVertical = verticalCuts[i];
        }

        lastHorizontal = 0;
        for(int j=0;j<horizontalCuts.length;j++){
            int horDist = w-lastVertical;
            int verDist = horizontalCuts[j]-lastHorizontal;
            int tempArea = ((horDist%mod)*(verDist%mod)%mod);
            area = Math.max(area,tempArea);
            lastHorizontal = horizontalCuts[j];
        }

        return area;
    }

    public static void main(String[] args) {
        System.out.println(new _1465MaximumAreaCake().maxArea(5,4,new int[]{3,1},new int[]{1}));
    }
}
