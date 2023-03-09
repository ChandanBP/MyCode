import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

public class _658FindKClosest {

    public int findClosest(int arr[], int target) {

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
                    return getClosest(arr[mid-1],arr[mid],mid-1,mid,target);

                j = mid;
            }
            else {
                if (mid < n-1 && target < arr[mid + 1])
                    return getClosest(arr[mid],arr[mid+1],mid,mid+1,target);
                i = mid + 1;
            }
        }
        return mid;
    }

    public static int getClosest(int val1, int val2,int m1,int m2,
                                 int target){
        if(target-val1>val2-target){
            return m2;
        }else if(target-val1<val2-target){
            return m1;
        }else{
            return m1;
        }
    }

    public List<Integer> findClosestElements(int[] arr, int k, int x)     {
        int index = findClosest(arr,x);
        List<Integer>result = new LinkedList();
        result.add(arr[index]);
        int p1=index-1;
        int p2=index+1;
        while(p1>=0 && p2<arr.length){
            if(result.size()==k)break;

            int diff1 = arr[p2]-x;
            int diff2 = x-arr[p1];
            if(diff1==diff2){
                result.add(arr[p1--]);
            }else if(diff1<diff2){
                result.add(arr[p2++]);
            }else{
                result.add(arr[p1--]);
            }
        }
        if(result.size()==k){
            Collections.sort(result);
            return result;
        }
        while(p1>=0 && result.size()<k){
            result.add(arr[p1--]);
        }
        while(p2<arr.length && result.size()<k){
            result.add(arr[p2++]);
        }
        Collections.sort(result);
        return result;
    }

    public static void main(String[] args) {
        _658FindKClosest obj = new _658FindKClosest();
        System.out.println(obj.findClosestElements(new int[]{0,2,2,3,4,6,7,8,9,9},4,5));
    }
}
