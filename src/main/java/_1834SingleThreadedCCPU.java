import java.util.Arrays;
import java.util.PriorityQueue;

public class _1834SingleThreadedCCPU {

    class Task{
        int start;
        int end;
        int index;
        public Task(int start,int end,int index){
            this.start = start;
            this.end = end;
            this.index = index;
        }
    }

    public int[] getOrder(int[][] task) {

        Task tasks[] = new Task[task.length];
        for(int i=0;i<task.length;i++){
            tasks[i] = new Task(task[i][0],task[i][1],i);
        }
        Arrays.sort(tasks,(a,b)->a.start-b.start);

        int t = tasks[0].start;
        int i = 0,k=0;
        int res[] = new int[task.length];
        PriorityQueue<Task>queue = new PriorityQueue<>((a,b)->{
            if(a.end!=b.end)return a.end-b.end;
            return a.index-b.index;
        });

        while(i<tasks.length){
            while(i<tasks.length && tasks[i].start<=t){
                queue.add(tasks[i++]);
            }

            if(queue.isEmpty()){
                t = tasks[i].start;
            }else{
                Task ta= queue.poll();
                res[k++]=ta.index;
                t+=ta.end;
            }
        }

        while(!queue.isEmpty())
            res[k++]=queue.poll().index;
        return res;
    }

    public static void main(String[] args) {
        new _1834SingleThreadedCCPU().getOrder(new int[][]{
                {5,2},
                {7,2},
                {9,4},
                {6,3},
                {5,10},
                {1,1},
        });
    }
}
