import java.util.*;

public class _975OddEvenJump {

    TreeMap<Integer, Integer>map = new TreeMap<>();
    boolean oddJumps[];
    boolean evenJumps[];

    public int oddEvenJumps(int[] arr) {

        int count = 1;
        oddJumps = new boolean[arr.length];
        evenJumps = new boolean[arr.length];

        oddJumps[arr.length-1] = evenJumps[arr.length-1] = true;
        map.put(arr[arr.length-1],arr.length-1);

        for(int i =arr.length-2;i>=0;i--){

            Map.Entry<Integer,Integer> oddJumpEntry = map.ceilingEntry(arr[i]);
            Map.Entry<Integer,Integer> evenJumpEntry = map.floorEntry(arr[i]);

            if(oddJumpEntry!=null)
                oddJumps[i] = evenJumps[oddJumpEntry.getValue()];

            if(evenJumpEntry!=null)
                evenJumps[i] = oddJumps[evenJumpEntry.getValue()];

            if(oddJumps[i])++count;
            map.put(arr[i],i);
        }
        return count;
    }

    public static void main(String[] args) {
        System.out.println(new _975OddEvenJump().oddEvenJumps(new int[]{5,1,3,4,2}));
    }
}
