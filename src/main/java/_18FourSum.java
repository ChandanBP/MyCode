import java.util.Arrays;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;

public class _18FourSum {
    public List<int[]> findTwoSum(int nums[],int start,int end,long target){
        List<int[]>result = new LinkedList();
        while(start<end){
            if(nums[start]+nums[end]==target){
                result.add(new int[]{nums[start],nums[end]});
                ++start;
                --end;
            }else if(nums[start]+nums[end]<target){
                ++start;
            }else{
                --end;
            }
        }
        return result;
    }

    public List<List<Integer>> fourSum(int[] nums, int target) {
        Arrays.sort(nums);

        List<List<Integer>>res = new LinkedList();
        HashSet<String> set = new HashSet();
        for(int i=0;i<nums.length;i++){
            for(int j=i+3;j<nums.length;j++){
                long l = target-(nums[i]+nums[j]);
                List<int[]>result = findTwoSum(nums,i+1,j-1,l);
                if(result.size()>0){
                    for(int[] arr:result){

                        List<Integer>temp = new LinkedList();
                        int t[] = new int[]{nums[i],nums[j],arr[0],arr[1]};
                        Arrays.sort(t);
                        if(!set.contains(t[0]+"-"+t[1]+"-"+t[2]+"-"+t[3])){
                            set.add(t[0]+"-"+t[1]+"-"+t[2]+"-"+t[3]);
                            temp.add(nums[i]);
                            temp.add(nums[j]);
                            temp.add(arr[0]);
                            temp.add(arr[1]);
                            res.add(temp);
                        }
                    }
                }
            }
        }
        return res;
    }

    public static void main(String[] args) {
        // [1000000000,1000000000,1000000000,1000000000]
        //-294967296
        new _18FourSum().fourSum(new int[]{1000000000,1000000000,1000000000,1000000000},-294967296);
    }
}
