import java.util.Collections;
import java.util.PriorityQueue;

public class _295FindMedianDataStream {

    PriorityQueue<Integer>maxHeap;
    PriorityQueue<Integer>minHeap;

    public _295FindMedianDataStream(){
        maxHeap = new PriorityQueue<>(Collections.reverseOrder());
        minHeap = new PriorityQueue<>();
    }

    public void addNum(int num) {

        if(minHeap.size()==0 && maxHeap.size()==0){
            maxHeap.add(num);
        }else if(maxHeap.size()==0 || num<=maxHeap.peek()){
            maxHeap.add(num);
        }else{
            minHeap.add(num);
        }

        if(Math.abs(maxHeap.size()-minHeap.size())>1){
            if(maxHeap.size()>minHeap.size()){
                minHeap.add(maxHeap.poll());
            }else{
                maxHeap.add(minHeap.poll());
            }
        }
    }

    public double findMedian() {
        if(maxHeap.size()==0 && minHeap.size()==0)return 0;
        else if(maxHeap.size()==0)return minHeap.peek();
        else if(minHeap.size()==0)return maxHeap.peek();
        else if(minHeap.size()==maxHeap.size())return (double) (minHeap.peek()+maxHeap.peek())/2;
        else if(minHeap.size()>maxHeap.size())return minHeap.peek();
        else return maxHeap.peek();
    }

    public static void main(String[] args) {
        _295FindMedianDataStream obj = new _295FindMedianDataStream();
        obj.addNum(12);
        System.out.println(obj.findMedian());
        obj.addNum(10);
        System.out.println(obj.findMedian());
        obj.addNum(13);
        System.out.println(obj.findMedian());
        obj.addNum(11);
        System.out.println(obj.findMedian());
        obj.addNum(5);
        System.out.println(obj.findMedian());
        obj.addNum(15);
        System.out.println(obj.findMedian());
        obj.addNum(1);
        System.out.println(obj.findMedian());
        obj.addNum(11);
        System.out.println(obj.findMedian());
        obj.addNum(6);
        System.out.println(obj.findMedian());
        obj.addNum(17);
        System.out.println(obj.findMedian());
        obj.addNum(14);
        System.out.println(obj.findMedian());
        obj.addNum(8);
        System.out.println(obj.findMedian());
        obj.addNum(17);
        System.out.println(obj.findMedian());
        obj.addNum(6);
        System.out.println(obj.findMedian());
        obj.addNum(4);
        System.out.println(obj.findMedian());
        obj.addNum(16);
        System.out.println(obj.findMedian());
        obj.addNum(8);
        System.out.println(obj.findMedian());
        obj.addNum(10);
        System.out.println(obj.findMedian());
        obj.addNum(2);
        System.out.println(obj.findMedian());
        obj.addNum(12);
        System.out.println(obj.findMedian());
        obj.addNum(0);
        System.out.println(obj.findMedian());
    }
}
