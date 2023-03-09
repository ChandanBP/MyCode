import java.util.TreeMap;

public class _731MyCalendar2 {

    TreeMap<Integer, Integer> map;

    public _731MyCalendar2() {
        map = new TreeMap();
    }

    public boolean book(int start, int end) {
        map.put(start, map.getOrDefault(start, 0) + 1);
        map.put(end, map.getOrDefault(end, 0) - 1);

        int active = 0;
        for (int d: map.values()) {
            active += d;
            if (active >= 3) {
                map.put(start, map.get(start) - 1);
                map.put(end, map.get(end) + 1);
                if (map.get(start) == 0)
                    map.remove(start);
                return false;
            }
        }
        return true;
    }

    public void print(){
        for(int value:map.values()){
            System.out.println(value);
        }
    }


    public static void main(String[] args) {
        _731MyCalendar2 obj = new _731MyCalendar2();
        obj.book(10,20);
        obj.book(50,60);
        obj.book(10,40);
        obj.book(5,15);
        obj.book(5,10);
        obj.book(25,55);
        obj.print();
    }
}
