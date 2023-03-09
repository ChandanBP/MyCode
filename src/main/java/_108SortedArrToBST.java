public class _108SortedArrToBST {

    public TreeNode addToTree(int[] nums,int start,int end){

        if(start>end)return null;

        int mid = start+(end-start)/2;
        TreeNode node = new TreeNode(nums[mid]);
        node.left = addToTree(nums,start,mid-1);
        node.right = addToTree(nums,mid+1,end);
        return node;
    }

    public TreeNode sortedArrayToBST(int[] nums) {
        return addToTree(nums,0,nums.length-1);
    }
}