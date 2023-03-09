import java.util.Collections;
import java.util.HashMap;
import java.util.PriorityQueue;

public class StockPrice {

    int latest;
    HashMap<Integer,Integer>map;
    PriorityQueue<int[]>maxHeap;
    PriorityQueue<int[]>minHeap;

    public StockPrice() {
        map = new HashMap<>();
        maxHeap = new PriorityQueue<>((a,b)-> b[0]-a[0]);
        minHeap = new PriorityQueue<>((a,b)-> a[0]-b[0]);
    }

    public void update(int timestamp, int price){

        map.put(timestamp,price);
        latest = price;

        maxHeap.add(new int[]{price,timestamp});
        minHeap.add(new int[]{price,timestamp});
    }

    public int current() {
        return latest;
    }

    public int maximum() {
        int pr[] = maxHeap.peek();

        while (!maxHeap.isEmpty() && map.get(pr[1])!=pr[0]){
            maxHeap.poll();
            pr = maxHeap.peek();
        }

        return maxHeap.peek()[0];
    }

    public int minimum() {
        int pr[] = minHeap.peek();

        while (!minHeap.isEmpty() && map.get(pr[1])!=pr[0]){
            minHeap.poll();
            pr = minHeap.peek();
        }

        return minHeap.peek()[0];
    }

    public static void main(String[] args) {
        StockPrice stockPrice = new StockPrice();
        stockPrice.update(1,10);
        stockPrice.update(2,5);
        System.out.println(stockPrice.current());
        System.out.println(stockPrice.maximum());
        stockPrice.update(1,3);
        System.out.println(stockPrice.maximum());
        stockPrice.update(4,2);
        System.out.println(stockPrice.minimum());
    }
}
