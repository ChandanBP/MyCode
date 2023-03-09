public class SegmentTrees {

    int arr[];
    int segMentTree[];

    public static int nextPowerOf2(int num){

        if(0 == num)
            return 1;

        if(num > 0 && (num & (num-1)) == 0){
            return num;
        }
        while((num & (num-1)) > 0){
            num = num & (num-1);
        }
        return num<<1;
    }

    public void constructSegMentTree(int low,int high,int pos){
        if(low==high){
            segMentTree[pos] = arr[low];
            return;
        }

        int mid = (low+high)/2;
        constructSegMentTree(low,mid,2*pos+1);
        constructSegMentTree(mid+1,high,2*pos+2);
        segMentTree[pos] = segMentTree[2*pos+1]+segMentTree[2*pos+2];
    }

    public static void main(String[] args) {

//        SegmentTrees segmentTrees = new SegmentTrees();
//
        int N = 6;
        int segTreeSize = nextPowerOf2(N);
//        segmentTrees.segMentTree = new int[2*segTreeSize-1];
//        segmentTrees.arr = new int[]{-2, 0, 3, -5, 2, -1};
//        segmentTrees.constructSegMentTree(0,segmentTrees.arr.length-1,0);

    }
}
