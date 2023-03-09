import java.util.Arrays;
import java.util.HashMap;

public class _846HandOfStraights {

    public boolean isNStraightHand(int[] hand, int W) {

        if((hand==null || hand.length==0) && W>0)return false;
        if(W==0)return false;

        Arrays.sort(hand);

        HashMap<Integer,Integer>count = new HashMap<>();
        for(int num:hand){
            count.put(num,count.getOrDefault(num,0)+1);
        }

        for(int i=0;i<hand.length;i++){
            int num = hand[i];
            int countA = count.get(num);
            if(countA>0){

                int w = W-1;
                int t = num;
                while(w>0){
                    ++t;
                    if(count.containsKey(t) && count.get(t)>0){
                        count.put(t,count.get(t)-1);
                    }else{
                        return false;
                    }
                    --w;
                }
                count.put(num,countA-1);
            }
        }
        return true;
    }

    public static void main(String[] args) {
        System.out.println(new _846HandOfStraights().isNStraightHand(new int[]{1,2,3,4,5,6},2));
    }
}
