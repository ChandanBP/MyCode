import java.util.Arrays;

public class _179LargestNumber {

    class Number implements Comparable<Number>{
        String num;
        public Number(int num){
            this.num = String.valueOf(num);
        }

        public int compareTo(Number number){
            return (number.num+num).compareTo(num+number.num);
        }
    }

    public String largestNumber(int[] nums) {

        Number numbers[] = new Number[nums.length];
        for(int i=0;i<nums.length;i++){

            numbers[i] = new Number(nums[i]);
        }

        Arrays.sort(numbers);

        StringBuilder sb = new StringBuilder();
        int zeros = 0;
        for(int i=0;i<numbers.length;i++){
            int val = Integer.valueOf(numbers[i].num);
            if(val==0)zeros++;
            sb.append(numbers[i].num);
        }
        String str = sb.toString();

        return (zeros==str.length())?0+"":str;
    }

    public static void main(String[] args) {
        System.out.println("3".compareTo("0"));
    }
}
