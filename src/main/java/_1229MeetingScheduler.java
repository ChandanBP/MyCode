import java.util.Arrays;
import java.util.List;

public class _1229MeetingScheduler {

    public List<Integer> minAvailableDuration(int[][] slots1, int[][] slots2, int duration) {

        if(slots1==null || slots2==null)return Arrays.asList();

        Arrays.sort(slots1,(a,b)->a[0]-b[0]);
        Arrays.sort(slots2,(a,b)->a[0]-b[0]);

        int i=0;
        int j=0;
        while(i<slots1.length && j<slots2.length){
            int[] s1 = slots1[i];
            int[] s2 = slots2[j];

            // calculate the intersection time interval
            int maxStart = Math.max(s1[0],s2[0]);
            int minEnd = Math.min(s1[1],s2[1]);
            int d = minEnd-maxStart;
            if(d>=duration){
                return Arrays.asList(maxStart,maxStart+duration);
            }else{
                if(s1[0]<s2[0]){
                    ++i;
                }else if(s1[0]>s2[0]){
                    ++j;
                }else{
                    if(s1[1]<s2[1]){
                        ++i;
                    }else if(s1[1]>s2[1]){
                        ++j;
                    }else{
                        ++i;
                        ++j;
                    }
                }
            }
        }
        return Arrays.asList();
    }

    public static void main(String[] args) {

        int slots1[][] = {{216397070,363167701},{98730764,158208909},{441003187,466254040},{558239978,678368334},{683942980,717766451}};
        int slots2[][] = {{50490609,222653186},{512711631,670791418},{730229023,802410205},{812553104,891266775},{230032010,399152578}};
        new _1229MeetingScheduler().minAvailableDuration(slots1,slots2,456085);
    }
}
