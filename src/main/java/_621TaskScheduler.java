import java.util.ArrayList;
import java.util.PriorityQueue;

public class _621TaskScheduler {
    public int leastInterval(char[] tasks, int n) {

        if(tasks==null || tasks.length==0)return 0;
        if(n==0)return tasks.length;

        int chars[] = new int[26];
        for(int i=0;i<tasks.length;i++){
            chars[tasks[i]-65]++;
        }

        PriorityQueue<int[]> queue = new PriorityQueue(26,(a, b)->((int[])b)[1]-((int[])a)[1]);
        for(int i=0;i<26;i++){
            if(chars[i]!=0)
                queue.add(new int[]{i,chars[i]});
        }

        StringBuilder sb = new StringBuilder();
        while(!queue.isEmpty()){
            int[]cc = queue.poll();
            sb.append((char)(cc[0]+65));
            cc[1]--;
            ArrayList<Integer[]> list = new ArrayList();

            if(queue.isEmpty() && cc[1]==0)break;

            for(int k=1;k<=n;k++){
                if(!queue.isEmpty()){
                    int cc1[] = queue.poll();
                    sb.append((char)(cc1[0]+65));
                    cc1[1]--;
                    if(cc1[1]!=0)
                        list.add(new Integer[]{cc1[0],cc1[1]});
                }
                else{
                    sb.append("_");
                }
            }
            if(list.size()>0){
                for(int i=0;i<list.size();i++){
                    Integer[] t = list.get(i);
                    queue.add(new int[]{t[0],t[1]});
                }
            }
            if(cc[1]!=0)
                queue.add(new int[]{cc[0],cc[1]});
        }
        return sb.length();
    }

    public static void main(String[] args) {

    }
}
