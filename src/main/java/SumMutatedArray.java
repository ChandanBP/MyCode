import java.io.*;
import java.util.Arrays;
import java.util.Scanner;

public class SumMutatedArray {

    public int arraySum(int arr[],int start,int end){
        int arr_sum = 0;
        for(int i = start;i<=end;i++){
            arr_sum+=arr[i];
        }
        return arr_sum;
    }

    public int findBestValue(int[] arr, int target) {

        if(arr.length==1)return arr[0];

        Arrays.sort(arr);
        int position = target/arr.length;
        if(position<arr[0]){
            int min1 = Math.abs(target-(position*arr.length));
            int min2 = Math.abs(target-((position+1)*arr.length));
            return (min1<min2)?position:position+1;
        }

        int arr_sum = arraySum(arr,0,arr.length-1);
        int lsum = 0,rsum = 0;
        int rightSum = 0;
        int diff = Integer.MAX_VALUE;
        int index = arr.length-1;
        boolean first = true;

        for(int i=arr.length-1;i>=0;i--){

            rightSum+=arr[i];
            rsum = ((arr.length-1)-i+1)*arr[i];
            lsum = arr_sum-rightSum;

            index = i;
            int currDiff = Math.abs(target-(lsum+rsum));
            if(first && currDiff<diff ){
                first = false;
                diff = currDiff;
            } else {
                if(diff<currDiff){
                    break;
                } else {
                    diff = currDiff;
                }
            }
        }

        if(index == arr.length-1) return arr[arr.length-1];

        int start = arr[index];
        int end = arr[index+1];
        end = (start==end)?end+1:end;
        diff = Integer.MAX_VALUE;
        int val = ((arr.length-1)-(index+1)+1);
        lsum = arraySum(arr,0,index);

        while(start<=end){
            rsum = val*end;
            if(Math.abs(lsum+rsum-target)<=diff){
                diff = Math.abs(lsum+rsum-target);
                position = end;
            }
            --end;
        }

        return position;
    }

    public static void main(String[] args)throws IOException {
        int arr[] = new int[10000];
        int target = 38303;

        Scanner scanner = new Scanner(new InputStreamReader(System.in));
        for(int i=0;i<10000;i++){
            arr[i] = scanner.nextInt();
        }

        SumMutatedArray sumMutatedArray = new SumMutatedArray();
        System.out.println(sumMutatedArray.findBestValue(arr,target));
    }
}
