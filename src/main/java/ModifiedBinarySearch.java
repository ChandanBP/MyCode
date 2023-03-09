public class ModifiedBinarySearch {

    public int binarySearch(int a[],int low,int high,int key){
        if(low>high)return -1;
        if(low==high){
            if(a[low]==key)return low;
            else return -1;
        }

        int mid = (low+high)/2;
        if(a[mid]==key && a[mid]>a[mid-1] || (a[mid-1]<key && key<a[mid])){
            return mid;
        }else if(key<=a[mid]){
            return binarySearch(a,low,mid,key);
        }else{
            return binarySearch(a,mid+1,high,key);
        }
    }

    public static int findClosest(int arr[], int target)
    {
        int n = arr.length;

        if (target <= arr[0])
            return 0;
        if (target >= arr[n - 1])
            return n-1;

        int i = 0, j = n, mid = 0;
        while (i < j) {
            mid = (i + j) / 2;

            if (arr[mid] == target)
                return mid;

            if (target < arr[mid]) {

                if (mid > 0 && target > arr[mid - 1])
                    return getClosest(arr[mid - 1],
                            arr[mid],mid-1,mid, target);

                j = mid;
            }
            else {
                if (mid < n-1 && target < arr[mid + 1])
                    return getClosest(arr[mid],
                            arr[mid + 1], mid,mid+1,target);
                i = mid + 1;
            }
        }
        return mid;
    }

    public static int getClosest(int val1, int val2,int m1,int m2,
                                 int target)
    {
        if (target - val1 >= val2 - target)
            return m2;
        else
            return m1;
    }

    public static void main(String[] args) {
        ModifiedBinarySearch mbs = new ModifiedBinarySearch();
        //System.out.println(mbs.binarySearch(new int[]{1, 3, 5, 5, 5, 5, 67, 123, 125},0,8,5));
        System.out.println(mbs.findClosest(new int[]{1,2,5,5,6,6,7,7,8,9},7));
    }
}
