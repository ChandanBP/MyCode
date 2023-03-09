import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;

public class _2013DetectSquares {

    HashMap<Integer, HashSet<Integer>> xmap = new HashMap<>();
    //HashMap<Integer, HashSet<Integer>> ymap = new HashMap<>();

    public _2013DetectSquares() {

    }

    public void add(int[] point) {
        HashSet<Integer>yset = (xmap.containsKey(point[0]))?xmap.get(point[0]):new HashSet<>();
        yset.add(point[1]);
        xmap.put(point[0],yset);
    }

    public int count(int[] point) {

        int x = point[0];
        int y = point[1];
        int c = 0;

        HashSet<Integer>yPoints = xmap.get(x);
        if(yPoints==null || yPoints.size()==0)return 0;

        Iterator<Integer>yIter = yPoints.iterator();
        while(yIter.hasNext()){
            Integer yp = yIter.next();
            if(yp-y==0) continue;
            int length = (yp-y)<0?(yp-y)*-1:yp-y;

            int xtobe;
            HashSet<Integer>ySet;
            xtobe = x-length;
            if(xmap.containsKey(xtobe)){
                ySet = xmap.get(xtobe);
                if(ySet.contains(y) && ySet.contains(yp))++c;
            }
            xtobe = x+length;
            if(xmap.containsKey(xtobe)){
                ySet = xmap.get(xtobe);
                if(ySet.contains(y) && ySet.contains(yp))++c;
            }
        }
        return c;
    }
}
