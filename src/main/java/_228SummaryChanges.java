import java.util.LinkedList;
import java.util.List;

public class _228SummaryChanges {

    class Range{
        int start;
        int end;
        public Range(int start,int end){
            this.start = start;
            this.end = end;
        }
    }

    public List<String> summaryRanges(int[] nums) {

        if(nums==null ||nums.length<1)return null;

        List<String>list = new LinkedList<>();
        if(nums.length==1){
            list.add(String.valueOf(nums[0]));
            return list;
        }

        List<Range>rangeList = new LinkedList<>();
        Range range = new Range(nums[0],nums[0]);
        rangeList.add(range);
        Range prev = range;
        for(int i=1;i<nums.length;i++){

            if(nums[i]==nums[i-1]+1){
                prev.end = nums[i];
            }else{
                Range r = new Range(nums[i],nums[i]);
                rangeList.add(r);
                prev = r;
            }
        }

        rangeList.forEach(r ->{
                if(r.start==r.end)list.add(String.valueOf(r.start));
                else list.add(r.start+"->"+r.end);
           }
        );

        return list;
    }

    public static void main(String[] args) {
        List<String> l = new _228SummaryChanges().summaryRanges(new int[]{0,2,3,4,6,8,9});
        l.forEach(s -> System.out.println(s));
    }
}
