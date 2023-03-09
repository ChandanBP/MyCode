import java.util.LinkedList;
import java.util.ListIterator;

public class _986IntervalListIntersection {

    LinkedList<int[]>list = new LinkedList<>();

    public int[][] intervalIntersection(int[][] A, int[][] B) {

        int i=0;
        int j=0;
        while(i<A.length && j<B.length){

            int[] ainterval = A[i];
            int[] binterval = B[j];

            if( (ainterval[1]>=binterval[0] && ainterval[1]<=binterval[1]) ||
                (binterval[1]>=ainterval[0] && binterval[1]<=ainterval[1]) ){
                int s = Math.max(ainterval[0],binterval[0]);
                int e = Math.min(ainterval[1],binterval[1]);
                list.add(new int[]{s,e});
            }
            if(ainterval[1]==binterval[1]){
                ++i;
                ++j;
            }else if(ainterval[1]<binterval[1]){
                ++i;
            }else{
                ++j;
            }
        }

        int res[][] = new int[list.size()][2];
        i=0;
        ListIterator<int[]>listIterator = list.listIterator();
        while(listIterator.hasNext()){
            res[i++] = listIterator.next();
        }
        return res;
    }

    public static void main(String[] args) {
        int A[][] = {{0,2},{5,10},{13,23},{24,25}};
        int B[][] = {{1,5},{8,12},{15,24},{25,26}};
        new _986IntervalListIntersection().intervalIntersection(A,B);
    }
}
