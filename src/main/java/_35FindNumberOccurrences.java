import java.util.Random;

public class _35FindNumberOccurrences {

    public int findLastOccurence(int arr[],int target){

        int low=0;
        int high=arr.length-1;
        int res=-1;
        while(low<=high){
            int mid = (low+high)/2;
            if(target<arr[mid]){
                high=mid-1;
            }else if(target>arr[mid]){
                low=mid+1;
            }else{
                res = mid;
                low=mid+1;
            }

//            if(low==high){
//                if(arr[low]==target)return low;
//                else return -1;
//            }else if(target>=arr[mid]){
//                if(mid==high && arr[mid]!=target)return -1;
//                if(mid==high || arr[mid]==target && arr[mid+1]>arr[mid])return mid;
//                low=mid+1;
//            }else{
//                high=mid-1;
//            }
        }
        return res;
    }

    public int findFirstOccurence(int arr[],int target){
        int low =0;
        int high=arr.length-1;
        int res=-1;

        while(low<=high){

            int mid = (low+high)/2;
            if(target<arr[mid]){
                high=mid-1;
            }else if(target>arr[mid]){
                low=mid+1;
            }else{
                res = mid;
                high=mid-1;
            }
// ANother approach
//            if(low==high){
//                if(arr[low]==target)return low;
//                else return -1;
//            }else if(target<=arr[mid]){
//                if(mid==0 && arr[mid]!=target)return -1;
//                if(mid==0 || arr[mid]==target && arr[mid-1]<arr[mid])return mid;
//                high=mid-1;
//            }else{
//                low=mid+1;
//            }
        }
        return res;
    }

    public int find(int arr[],int target){
        int index1 = findFirstOccurence(arr,target);
        if(index1==-1)return 0;
        int index2 = findLastOccurence(arr,target);
        return (index2==-1)?1:(index2-index1)+1;
    }

    public static void main(String[] args) {
        //System.out.println(new _35FindNumberOccurrences().find(new int[]{2,2},2));
        System.out.println(Math.random());
        Random random = new Random();
        random.nextInt(10);
    }
}
