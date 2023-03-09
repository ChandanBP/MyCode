import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

public class _1512NumGoodPairs {

    public int numIdenticalPairs(int[] nums) {
        HashMap<Integer,Integer> map = new HashMap();

        for(int i=0;i<nums.length;i++){
            int ele = nums[i];
            map.put(ele,map.getOrDefault(ele,0)+1);
        }

        int count = 0;
        Iterator<Map.Entry<Integer,Integer>> iterator = map.entrySet().iterator();
        while(iterator.hasNext()){

        }


        return count;
    }
}
