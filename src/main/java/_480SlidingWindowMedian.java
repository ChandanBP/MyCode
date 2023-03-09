import java.util.Collections;
import java.util.HashMap;
import java.util.PriorityQueue;

public class _480SlidingWindowMedian {

    public double[] medianSlidingWindow(int[] nums, int k) {

        PriorityQueue<Integer> maxHeap = new PriorityQueue(Collections.reverseOrder());
        PriorityQueue<Integer>minHeap = new PriorityQueue();
        HashMap<Integer,Integer> map = new HashMap();
        int numValidElements = 0;

        for(int i=0;i<k;i++){
            maxHeap.add(nums[i]);
        }

        for(int i=0;i<k/2;i++){
            minHeap.add(maxHeap.poll());
        }

        int end = k;
        double answer[] = new double[nums.length-k+1];
        int res=0;
        while(end<=nums.length){

            answer[res++] = ((k&1)!=0)?maxHeap.peek():((double)maxHeap.peek()+(double)minHeap.peek())/2;

            if(end==nums.length)break;

            int leftNum = nums[end-k];
            int rightNum = nums[end];

            numValidElements = (leftNum<=maxHeap.peek())?-1:1;
            map.put(leftNum,1+map.getOrDefault(leftNum,0));

            if(!maxHeap.isEmpty() && rightNum<=maxHeap.peek()){
                maxHeap.add(rightNum);
                ++numValidElements;
            }else{
                minHeap.add(rightNum);
                --numValidElements;
            }

            if(numValidElements<0){
                maxHeap.add(minHeap.poll());
                ++numValidElements;
            }
            if(numValidElements>0){
                minHeap.add(maxHeap.poll());
                --numValidElements;
            }

            while(!maxHeap.isEmpty() && map.getOrDefault(maxHeap.peek(),0)>0){
                int c = map.get(maxHeap.peek());
                --c;
                map.put(maxHeap.peek(),c);
                maxHeap.poll();
            }
            while(!minHeap.isEmpty() && map.getOrDefault(minHeap.peek(),0)>0){
                int c = map.get(minHeap.peek());
                --c;
                map.put(minHeap.peek(),c);
                minHeap.poll();
            }
            ++end;
        }
        return answer;
    }
}