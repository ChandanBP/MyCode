import java.util.*;
import java.util.concurrent.ConcurrentSkipListMap;

public class _1851MinimumInterval {

    public int[] minInterval(int[][] intervals, int[] queries) {

        int result[] = new int[queries.length];
        Arrays.fill(result,-1);

        ConcurrentSkipListMap<Integer,LinkedList<Integer>>treeMap = new ConcurrentSkipListMap<>();
        for(int i=0;i< queries.length;i++){
            LinkedList<Integer>indices = (treeMap.containsKey(queries[i]))?treeMap.get(queries[i]):new LinkedList<>();
            indices.add(i);
            treeMap.put(queries[i],indices);
        }

        Arrays.sort(intervals,(a,b)->(a[1]-a[0]+1)-(b[1]-b[0]+1));

        for(int i=0;i< intervals.length;i++){
            int interval[] = intervals[i];
            Map.Entry<Integer,LinkedList<Integer>>startEntry = treeMap.ceilingEntry(interval[0]);
            Map.Entry<Integer,LinkedList<Integer>>endEntry = treeMap.floorEntry(interval[1]);
            if(startEntry==null||endEntry==null)continue;
            if(interval[1]<startEntry.getKey() || endEntry.getKey()<interval[0])continue;

            SortedMap<Integer,LinkedList<Integer>> subMap = treeMap.subMap(startEntry.getKey(),endEntry.getKey()+1);
            Iterator<Map.Entry<Integer,LinkedList<Integer>>>iterator = subMap.entrySet().iterator();
            while(iterator.hasNext()){
                Map.Entry<Integer,LinkedList<Integer>>entry = iterator.next();
                int k = entry.getKey();
                ListIterator<Integer>listIterator = entry.getValue().listIterator();
                while (listIterator.hasNext()){
                    result[listIterator.next()] = interval[1]-interval[0]+1;
                }
                treeMap.remove(k);
            }
        }
        return result;
    }

    public static void main(String[] args) {
        System.out.println(new _1851MinimumInterval().minInterval(new int[][]{{4,5},{5,8},{1,9},{8,10},{1,6}},
                new int[]{7,9,3,9,3}));
    }
}
