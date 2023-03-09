import java.util.TreeMap;

public class SnapshotArray {

    int snap_id=-1;
    TreeMap<Integer,Integer>arr[];
    public SnapshotArray(int length) {
        arr = new TreeMap[length];
    }

    public void set(int index, int val) {
        if(arr[index]==null)arr[index]=new TreeMap<>();
        arr[index].put(snap_id,val);
    }

    public int snap() {
        ++snap_id;
        return snap_id;
    }

    public int get(int index, int snap_id) {
        if(arr[index]==null)return 0;
        return arr[index].floorEntry(snap_id).getValue();
    }

    public static void main(String[] args) {

    }
}
