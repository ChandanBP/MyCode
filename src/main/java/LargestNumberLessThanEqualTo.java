public class LargestNumberLessThanEqualTo {

    public int binarySearch(int arr[],int start,int end,int key){

        while(start<end){
            int mid = start+(end-start)/2;

            if(arr[mid]<=key && key<arr[mid+1]){
                return mid;
            }else if(arr[mid]>key){
                end = mid;
            }else{
                start = mid+1;
            }
        }
        return end;
    }

}
