import java.util.Map;
import java.util.TreeMap;

public class _715RangeModule {

    TreeMap<Integer,Integer> map;
    public _715RangeModule() {
        map = new TreeMap();
    }

    public void addRange(int left, int right) {
        //see if left variable can be expanded
        Integer prevInteval = map.floorKey(left);
        if(prevInteval!=null && left <= map.get(prevInteval)){
            left = prevInteval; //get minimum among both intervals
        }

        //see if right variable can be expanded
        Integer nextInteval = map.floorKey(right);
        if(nextInteval!=null && map.get(nextInteval) > right){
            right = map.get(nextInteval); //get max among both intervals
        }

        map.put(left,right);

        //remove all except (left,right)
        map.subMap(left,false,right,false).clear();
    }

    public boolean queryRange(int left, int right) {
        //since we know that we are storing condensed(merged) intervals so just check prev
        Integer prevInterval = map.floorKey(left);
        if(prevInterval != null){
            return map.get(prevInterval) >= right;
        }
        return false;
    }

    public void removeRange(int left, int right) {
        //see if intersection with next (Do this step first to avoid changing the map)
        Integer nextInteval = map.floorKey(right);
        if(nextInteval!=null && map.get(nextInteval) > right){
            map.put(right,map.get(nextInteval));//reset nextInteval
        }

        //see if intersection with prev
        Integer prevInteval = map.floorKey(left);
        if(prevInteval!=null && left < map.get(prevInteval)){
            map.put(prevInteval,left);//reset prevInterval
        }

        //remove all the other things in between
        map.subMap(left,true,right,false).clear();
    }

    public static void main(String[] args) {
        _715RangeModule obj = new _715RangeModule();
        obj.addRange(6,8);
        obj.addRange(9,10);
//        obj.removeRange(7,8);
//        obj.removeRange(8,9);
//        obj.addRange(8,9);
//        obj.removeRange(1,3);
//        obj.addRange(1,8);
//        obj.queryRange(2,4);
//        obj.queryRange(2,9);
//        obj.queryRange(4,6);
    }
}
