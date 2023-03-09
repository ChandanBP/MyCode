import java.util.LinkedList;
import java.util.List;

public class _46Permutation {

    List<List<Integer>>result = new LinkedList<>();
    public void generatePerm(String nums,String root){

        if(nums.length()<=1){
            String res = root+nums;
            List<Integer>list = new LinkedList<>();
            for(int i=0;i<res.length();i++){
                list.add(Integer.parseInt(res.charAt(i)+""));
            }
            result.add(list);
            return;
        }

        for(int i=0;i<nums.length();i++){
            String before = nums.substring(0,i);
            String after = nums.substring(i+1,nums.length());

            StringBuilder sb1 = new StringBuilder();
            sb1.append(before);
            sb1.append(after);

            StringBuilder sb2 = new StringBuilder();
            sb2.append(root);
            sb2.append(nums.charAt(i));
            generatePerm(sb1.toString(),sb2.toString());
        }
    }

    public List<List<Integer>> permute(int[] nums) {

        StringBuilder sb = new StringBuilder();
        for(int num:nums){
            sb.append(num);
        }
        String num = sb.toString();
        if(num.length()==0) result.add(new LinkedList<>());
        for(int i=0;i<num.length();i++){
            String before = num.substring(0,i);
            String after = num.substring(i+1,num.length());
            sb = new StringBuilder();
            sb.append(before);
            sb.append(after);

            StringBuilder sb1 = new StringBuilder();
            sb1.append(num.charAt(i));
            generatePerm(sb.toString(),sb1.toString());
        }
        return result;
    }

    public static void main(String[] args) {
        new _46Permutation().permute(new int[]{1,2,3});
        System.out.println();
    }
}
