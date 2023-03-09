public class _1423MaxPoints {

    public int maxScore(int[] cardPoints, int k) {

        int left[] = new int[cardPoints.length];
        int right[] = new int[cardPoints.length];

        int i=0,j=cardPoints.length-1;
        while(i<cardPoints.length){
            left[i]=(i==0)?cardPoints[i]:left[i-1]+cardPoints[i];
            right[j]=(j==cardPoints.length-1)?cardPoints[j]:cardPoints[j]+right[j+1];
            ++i;
            --j;
        }
        if(k==cardPoints.length)return left[cardPoints.length-1];

        i=0;
        int sum=0;
        int max=0;
        while (i<k){
            sum=left[i];
            j = k-(i+1);
            if(j!=0)
                sum+=right[cardPoints.length-j];
            max = Math.max(max,sum);
            ++i;
        }

        j=cardPoints.length-1;
        sum=0;
        int c=0;
        while(c<k){
            sum=right[j];
            i = k-(c+1)-1;
            if(i>=0)
                sum+=left[i];
            max=Math.max(max,sum);
            --j;
            ++c;
        }
        return max;
    }

    public static void main(String[] args) {
        System.out.println(new _1423MaxPoints().maxScore(new int[]{9,7,7,9,7,7,9},3));
    }
}
