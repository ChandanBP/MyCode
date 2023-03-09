import java.util.LinkedList;
import java.util.List;

public class _46Permutation1 {

    List<List<Integer>>result = new LinkedList<>();

    public void generatePerm(int nums[],int root[]){

        if(nums.length<=1){
            LinkedList<Integer>list = new LinkedList<>();
            for(int i=0;i<root.length;i++){
                list.add(root[i]);
            }
            for(int i=0;i<nums.length;i++){
                list.add(nums[i]);
            }
            result.add(list);
            return;
        }

        for(int i=0;i<nums.length;i++){
            int res[] = mergeArray(nums,0,i-1,i+1,nums.length-1);
            int res1[] = new int[1+root.length];
            int k=0;
            for(int j=0;j<root.length;j++){
                res1[k++]=root[j];
            }
            res1[k]=nums[i];
            generatePerm(res,res1);
        }
    }


    public int[] mergeArray(int[] arr,int l1,int r1,int l2,int r2){

        int len1 = (l1>r1)?0:(r1-l1+1);
        int len2 = (l2>r2)?0:(r2-l2+1);

        int res[] = new int[len1+len2];
        int k=0;
        for(int i=l1;i<=r1;i++){
            res[k++]=arr[i];
        }
        for(int i=l2;i<=r2;i++){
            res[k++]=arr[i];
        }
        return res;
    }

    public List<List<Integer>> permute(int[] nums){

        if(nums.length==0) result.add(new LinkedList<>());

        for(int i=0;i<nums.length;i++){
            int res[] = mergeArray(nums,0,i-1,i+1,nums.length-1);
            generatePerm(res,new int[]{nums[i]});
        }
        return result;
    }

    public static void main(String[] args) {

        new _46Permutation1().permute(new int[]{1,2,3});
    }
}
