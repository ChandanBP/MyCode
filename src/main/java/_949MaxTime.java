import java.util.Iterator;
import java.util.LinkedHashSet;

public class _949MaxTime {

    int time[];
    int max = Integer.MIN_VALUE;
    String result="";

    public boolean isValidHour(int hour){

        int f = hour/10;
        int s = hour%10;

        if(f>2)return false;
        if(f==2 && s>3)return false;
        return true;
    }

    public boolean isValidMinute(int minute){

        int f = minute/10;
        if(f>5)return false;
        return true;
    }

    public void findLargestTime(int arr[],LinkedHashSet used){

        if(used.size()==4){
            Iterator<Integer>ite = used.iterator();
            int c=0;
            int h=10;
            int m=10;
            boolean isValidTime = true;
            while(ite.hasNext()){
                if(c==0){
                    h*=time[ite.next()];
                }else if(c==1){
                    h+=time[ite.next()];
                    if(!isValidHour(h)){
                        isValidTime=false;
                        break;
                    }
                }else if(c==2){
                    m*=time[ite.next()];
                }else{
                    m+=time[ite.next()];
                    if(!isValidMinute(m)){
                        isValidTime=false;
                        break;
                    }
                }
                ++c;
            }
            if(isValidTime){

                StringBuilder sb = new StringBuilder();
                if(String.valueOf(h).length()==1)
                    sb.append(0);
                sb.append(h);

                sb.append(":");

                if(String.valueOf(m).length()==1)
                    sb.append("0");
                sb.append(m);
                h*=100;
                h+=m;
                if(h>max){
                    max=h;
                    result=sb.toString();
                }
            }
            return;
        }

        for(int i=0;i<4;i++){
            if(!used.contains(i)){
                LinkedHashSet set = new LinkedHashSet(used);
                set.add(i);
                findLargestTime(arr,set);
            }
        }
    }

    public String largestTimeFromDigits(int[] arr) {

        if(arr==null || arr.length<4)return "";

        time = arr;
        for(int i=0;i<4;i++){
            LinkedHashSet<Integer>visited = new LinkedHashSet<>();
            visited.add(i);
            findLargestTime(time,visited);
        }
        return result;
    }

    public static void main(String[] args) {
        System.out.println(new _949MaxTime().largestTimeFromDigits(new int[]{0,0,1,0}));
    }
}
