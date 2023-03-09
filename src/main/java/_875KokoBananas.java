import java.util.Arrays;

public class _875KokoBananas {

    public int minEatingSpeed(int[] piles, int h) {

        int min = Integer.MAX_VALUE;
        int max = Integer.MIN_VALUE;
        for(int i=0;i<piles.length;i++){
            min = Math.min(min,piles[i]);
            max = Math.max(max,piles[i]);
        }

        int start = min,end = max;
        while(start<end){
            int mid = (start+end)/2;
            int count = countHours(mid,piles);
            if(count<=h){
                end = mid-1;
            }else if(count>h){
                start = mid+1;
            }
        }

        return start;
    }

    public int countHours(int mid,int[] piles){
        int count=0;
        for(int b:piles){
            count+= (b/mid);
            if(b%mid!=0)++count;
        }
        return count;
    }

    public static void main(String[] args) {
        System.out.println(new _875KokoBananas().minEatingSpeed(new int[]{30,11,23,4,20},6));

    }
}
