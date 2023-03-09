import java.util.Arrays;

public class _1235JobScheduling {

    class Job{
        int start;
        int end;
        int profit;
        public Job(int start,int end,int profit){
            this.start=start;
            this.end=end;
            this.profit=profit;
        }
    }

    public int binarySearch(Job jobs[],int index){

        int low=index+1;
        int high=jobs.length-1;
        Job job = jobs[index];

        while(low<=high){
            int mid = (low+high)/2;
            if(jobs[mid].start>=job.end){
                if(jobs[mid-1].start>=job.end)high=mid-1;
                else return mid;
            }else{
                low=mid+1;
            }
        }

        return -1;
    }

    public int jobScheduling(int[] startTime, int[] endTime, int[] profit) {

        Job jobs[] = new Job[startTime.length];
        for(int i=0;i<startTime.length;i++){
            jobs[i] = new Job(startTime[i],endTime[i],profit[i]);
        }

        Arrays.sort(jobs,(a,b)->a.start-b.start);

        int max[] = new int[jobs.length];
        for(int i=0;i<jobs.length;i++){
            max[i]=jobs[i].profit;
        }

        int finalMax=-1;
        for(int i=startTime.length-1;i>=0;i--){
            Job jobi = jobs[i];
            int m=jobi.profit;
            int index = binarySearch(jobs,i);
            if(index!=-1){
                m+=max[index];
            }
            max[i] = (i==startTime.length-1)?m:Math.max(max[i+1],m);
            finalMax = Math.max(finalMax,max[i]);
        }
        return finalMax;
    }

    public static void main(String[] args) {
        System.out.println(new _1235JobScheduling().jobScheduling(new int[]{1,2,3,3},new int[]{3,4,5,6},new int[]{50,10,40,70}));
    }
}
