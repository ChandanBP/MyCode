import java.util.HashMap;
import java.util.Random;
import java.util.concurrent.*;

public class _2488MedianSubArray {

    public int countSubarrays(int[] nums, int k) {
        HashMap<Integer,Integer>map = new HashMap<>();
        map.put(0,1);
        int sum = 0;
        int res = 0;
        boolean found = false;
        for(int i=0;i<nums.length;i++){
            if(nums[i]<k)sum--;
            else if(nums[i]>k)sum++;
            else found = true;
            if(found) res += map.getOrDefault(sum,0)+map.getOrDefault(sum-1,0);
            else
            map.put(sum,map.getOrDefault(sum,0)+1);
        }
        return res;
    }
    public static void main(String[] args) throws ExecutionException, InterruptedException {
        Random random = new Random(System.currentTimeMillis());
        class TrivialTask implements Runnable {

            int n;

            public TrivialTask(int n) {
                this.n = n;
            }

            public void run() {
                try {
                    // sleep for one second
                    Thread.sleep(random.nextInt(101));
                    //System.out.println(n*n);
                    ThreadLocal<Integer>t = ThreadLocal.withInitial(()->1);

                } catch (InterruptedException ie) {
                    // swallow exception
                }
            }
        }
//        System.out.println(new _2488MedianSubArray().countSubarrays(new int[]{3,2,1,4,5,6,7,8,9,10},4));
        ExecutorService threadPool = Executors.newFixedThreadPool(3);
        ExecutorCompletionService<Integer>service = new ExecutorCompletionService<>(threadPool);
        // Submit 10 trivial tasks.
        for (int i = 0; i < 10; i++) {
            service.submit(new TrivialTask(i), 100);
        }

        // wait for all tasks to get done
        int count = 10;
        while (count != 0) {
            Future<Integer> f = service.poll();
            if (f != null) {
                System.out.println("Thread" + f.get() + " got done.");
                count--;
            }
        }

        threadPool.shutdown();
    }
}
