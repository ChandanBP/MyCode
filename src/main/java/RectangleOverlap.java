public class RectangleOverlap {

    public boolean isRectangleOverlap(int[] rec1, int[] rec2) {
        long y1 = Math.max(rec1[1],rec2[1]);
        long y2 = Math.min(rec1[3],rec2[3]);
        long x1 = Math.max(rec1[0],rec2[0]);
        long x2 = Math.min(rec1[2],rec2[2]);
        return (x2-x1)>0 && (y2-y1)>0?true:false;
    }

    public static void main(String[] args) {
        System.out.println(new RectangleOverlap().isRectangleOverlap(new int[]{7,8,13,15},new int[]{10,8,12,20}));
    }
}
