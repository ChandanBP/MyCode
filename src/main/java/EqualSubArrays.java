import java.util.Scanner;
import java.util.concurrent.Flow;

public class EqualSubArrays {

    long arr[];
    long segMentTree[];
    long sumArr[];
    long K;
    long max = -1;

    public static int nextPowerOf2(int num){
        if(num ==0){
            return 1;
        }
        if(num > 0 && (num & (num-1)) == 0){
            return num;
        }
        while((num & (num-1)) > 0){
            num = num & (num-1);
        }
        return num<<1;
    }

    public void getMax(){

        for(int length=1;length<=arr.length;length++){
            for(int i=0;i<arr.length-length;i++){
                int j = i+length;
                long sum2 = sumArr[j];
                long sum1 = (i==0)?0:sumArr[i-1];
                long sum = sum2 - sum1;
                long maxInRange = queryMaxInRange(i,j,0,arr.length-1,0); // reduce this logn
                long val = (j-i+1)*maxInRange;
                long diff = val-sum;
                if(diff<=K){
                    max = Math.max(max,(j-i+1));
                }else{
                    continue;
                }
            }
        }

    }

    public long queryMaxInRange(int qlow,int qhigh,int low,int high,int pos){

        // total overlap
        if(qlow<=low && high<=qhigh){
            return segMentTree[pos];
        }

        // no over lap
        if(high<qlow || qhigh<low){
            return Integer.MIN_VALUE;
        }

        // Partial overlap
        int mid = (low+high)/2;
        return Math.max(queryMaxInRange(qlow,qhigh,low,mid,2*pos+1),
                queryMaxInRange(qlow,qhigh,mid+1,high,2*pos+2));
    }

    public void constructSegMentTree(int low,int high,int pos){
        if(low==high){
            segMentTree[pos] = arr[low];
            return;
        }

        int mid = (low+high)/2;
        constructSegMentTree(low,mid,2*pos+1);
        constructSegMentTree(mid+1,high,2*pos+2);
        segMentTree[pos] = Math.max(segMentTree[2*pos+1],segMentTree[2*pos+2]);
    }

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        EqualSubArrays equalSubArrays = new EqualSubArrays();

        int N = scanner.nextInt();
        long K = scanner.nextLong();
        long arr[] = new long[N];
        long sum = 0;
        long sumArr[] = new long[N];
        for(int i=0;i<N;i++){
            arr[i] = scanner.nextLong();
            sum+=arr[i];
            sumArr[i] = sum;
        }

        long max = -1;
        long finalMax = -1;
        for(int i=0;i<arr.length;i++){
            max = arr[i];
            for(int j=i+1;j<arr.length;j++){
                max = Math.max(max,arr[j]);
                long sum2 = sumArr[j];
                long sum1 = (i==0)?0:sumArr[i-1];
                long sumT = sum2 - sum1;
                long val = (j-i+1)*max;
                long diff = val-sumT;
                if(diff<=K){
                    finalMax = Math.max(finalMax,(j-i+1));
                }else{
                    break;
                }
            }
        }

        int segTreeSize = nextPowerOf2(N);
        equalSubArrays.segMentTree = new long[2*segTreeSize-1];
        equalSubArrays.constructSegMentTree(0,equalSubArrays.arr.length-1,0);
        equalSubArrays.getMax();
        System.out.println(finalMax==-1?1:finalMax);
    }
}
