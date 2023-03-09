import java.util.*;

public class _347TopKFrequent {

    class Frequency implements Comparable<Frequency>{
        int num;
        int count;

        public Frequency(int num,int count){
            this.num = num;
            this.count = count;
        }

        @Override
        public int compareTo(Frequency frequency) {
            return frequency.count-this.count;
        }
    }

    public List<Integer> topKFrequent2(int[] nums, int k){

        int maxCount = Integer.MIN_VALUE;

        HashMap<Integer,Integer>map1 = new HashMap<>();
        for(int num:nums){
            int count = map1.getOrDefault(num,0)+1;
            maxCount = Math.max(maxCount,count);
            map1.put(num,count);
        }

        if(k>map1.size())return null;

        HashMap<Integer,LinkedList<Integer>>map2 = new HashMap<>();
        map1.forEach((key,value)->{
            LinkedList<Integer>l = map2.get(value);
            if(l==null)l = new LinkedList<>();
            l.add(key);
            map2.put(value,l);
        });

        List<Integer>result = new LinkedList<>();
        while (k!=0 && maxCount!=0){
            if(map2.containsKey(maxCount)){
                LinkedList l = map2.get(maxCount);
                ListIterator<Integer>ite = l.listIterator();
                while (k!=0 && ite.hasNext()){
                    result.add(ite.next());
                    --k;
                }
            }
            --maxCount;
        }

        return result;
    }

    public List<Integer> topKFrequent3(int[] nums, int k){
        HashMap<Integer,Integer>map = new HashMap<>();
        for(int num:nums){
            map.put(num,map.getOrDefault(num,0)+1);
        }

        if(k>map.size())return null;
        final int t = k;
        PriorityQueue<Frequency>queue = new PriorityQueue<>(k);
        map.forEach((key,value)->{
            if(queue.size()<t){
                queue.add(new Frequency(key,value));
            }
            else{
                if(value>queue.peek().count){
                    queue.poll();
                    queue.add(new Frequency(key,value));
                }
            }
        });


        List<Integer>list = new LinkedList<>();
        while (k!=0 && !queue.isEmpty()){
            list.add(queue.poll().num);
            --k;
        }
        return list;
    }

    public List<Integer> topKFrequent(int[] nums, int k) {

        HashMap<Integer,Integer>map = new HashMap<>();
        for(int num:nums){
            map.put(num,map.getOrDefault(num,0)+1);
        }

        PriorityQueue<Frequency>queue = new PriorityQueue<>();
        map.forEach((key,value)->{
            queue.add(new Frequency(key,value));
        });

        if(k>map.size())return null;

        List<Integer>list = new LinkedList<>();
        while (k!=0 && !queue.isEmpty()){
            list.add(queue.poll().num);
            --k;
        }
        return list;
    }

    public static void main(String[] args) {
        new _347TopKFrequent().topKFrequent2(new int[]{1,2},2);
    }
}
