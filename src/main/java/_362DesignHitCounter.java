import java.util.Map;
import java.util.TreeMap;

public class _362DesignHitCounter {

    TreeMap<Integer,Integer>counter;
    _362DesignHitCounter(){
        counter = new TreeMap<>();
    }

    public void hit(int timestamp) {
        Map.Entry<Integer,Integer>entry =  counter.floorEntry(timestamp);
        if(entry==null){
            counter.put(timestamp,1);
        }else{
            counter.put(timestamp,entry.getValue()+1);
        }
    }

    public int getHits(int timestamp) {

        Map.Entry<Integer,Integer>end = counter.floorEntry(timestamp);
        if(end==null)return 0;

        int startTime = timestamp-300;
        Map.Entry<Integer,Integer>start = counter.floorEntry(startTime);

        if(startTime<=0 || start==null)return end.getValue();

        return end.getValue()-start.getValue();
    }

    public static void main(String[] args) {
        _362DesignHitCounter hitCounter = new _362DesignHitCounter();
        hitCounter.hit(1);
        hitCounter.hit(2);
        hitCounter.hit(3);
        System.out.println(hitCounter.getHits(4));
        hitCounter.hit(300);
        hitCounter.hit(300);
        System.out.println(hitCounter.getHits(300));
        System.out.println(hitCounter.getHits(301));
    }
}
