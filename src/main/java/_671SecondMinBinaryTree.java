import java.util.Arrays;

public class _671SecondMinBinaryTree {

    public void findSecondMin(TreeNode root,int numbers[]){
        if(root==null)return;

        findSecondMin(root.left,numbers);
        numbers[root.val]=1;
        findSecondMin(root.right,numbers);
    }

    public int findSecondMinimumValue(TreeNode root) {
        int numbers[] = new int[26];
        Arrays.fill(numbers,-1);
        findSecondMin(root,numbers);
        boolean first = false;
        for(int i=1;i<26;i++){
            if(numbers[i]!=-1 && !first){
                first = true;
            }
            if(numbers[i]!=-1 && first){
                return i;
            }
        }
        return -1;
    }

    public static void main(String[] args) {

    }
}
