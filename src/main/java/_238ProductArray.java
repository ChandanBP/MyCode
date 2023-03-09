import java.util.Arrays;
import java.util.stream.Stream;

public class _238ProductArray {

    public int[] productExceptSelf(int[] nums) {

        int output[] = new int[nums.length];
        for(int i=0;i<nums.length;i++){
            if(i==0)output[i]=nums[i];
            else output[i]=output[i-1]*nums[i];
        }

        int p=1;
        for(int i=nums.length-1;i>=0;i--){
            int soFarP = (i==0)?1:output[i-1];
            output[i]=soFarP*p;
            p*=nums[i];
        }
        return output;
    }

    public static void main(String[] args) {
        //new _238ProductArray().productExceptSelf(new int[]{1,2,3,4});
        Stream.iterate(1,x->x*2).limit(10).forEach(System.out::println);
    }
}
