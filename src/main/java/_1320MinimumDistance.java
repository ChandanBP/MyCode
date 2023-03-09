import java.util.Arrays;

public class _1320MinimumDistance {

    int dp[][];
    int n;
    int cost[][] = new int[6][5];
    String word;

    public _1320MinimumDistance(){

        int c=0;
        for(int i=0;i<5;i++){
            for(int j=0;j<5;j++){
                cost[i][j] = ++c;
            }
        }
    }

    public int recurse(int f1,int f2,int pf1,int pf2){

        if(dp[f1][f2]!=Integer.MAX_VALUE)return dp[f1][f2];
        char prevf1 = word.charAt(pf1);
        char prevf2 = word.charAt(pf2);
        char ccur1 = word.charAt(f1);
        char ccur2 = word.charAt(f2);

        int px1 = (prevf1-'A')/6;
        int py1 = (prevf1-'A')%6;

        int cx1 = (ccur1-'A')/6;
        int cy1 = (ccur1-'A')%6;

        int px2 = (prevf2-'A')/6;
        int py2 = (prevf2-'A')%6;

        int cx2 = (ccur2-'A')/6;
        int cy2 = (ccur2-'A')%6;
        if(f1==n||f2==n){
            if(f1!=pf1){
                dp[f1][f2] = Math.abs(px1-cx1)+Math.abs(py1-cy1);
                return dp[f1][f2];
            }else{
                dp[f1][f2] = Math.abs(px2-cx2)+Math.abs(py2-cy2);
                return dp[f1][f2];
            }
        }

        int c=0;
        if(f1!=pf1){
            c+=Math.abs(px1-cx1)+Math.abs(py1-cy1);
        }if(f2!=pf2){
            c+=Math.abs(px2-cx2)+Math.abs(py2-cy2);
        }
        dp[f1][f2] = c+Math.min(recurse(Math.max(f1,f2)+1,f2,f1,f2),
                                recurse(f1,Math.max(f1,f2)+1,f1,f2));
        return dp[f1][f2];
    }

    public int minimumDistance(String word) {

        this.word = word;
        dp = new int[word.length()][word.length()];
        for(int i=0;i<word.length();i++){
            Arrays.fill(dp[i],Integer.MAX_VALUE);
        }
        n = word.length()-1;

        int c[] = new int[word.length()];
        for(int i=0;i<word.length();i++){
            if(i==0){
                c[i]=0;
            }else{
                char ch = word.charAt(i);
                char pch = word.charAt(i-1);

                int x1 = (pch-'A')/6;
                int y1 = (pch-'A')%6;

                int x2 = (ch-'A')/6;
                int y2 = (ch-'A')%6;
                c[i]=Math.abs(x1-x2)+Math.abs(y1-y2);
            }
        }

        int min = Integer.MAX_VALUE;
        for(int i=0;i<word.length()-1;i++){
            //for(int j=i+1;j<word.length()-1;j++){
                min = Math.min(min,c[i]+recurse(i,i+1,i,i+1));
            //}
        }
        return min;
    }

    public static void main(String[] args) {
        _1320MinimumDistance obj = new _1320MinimumDistance();
        //System.out.println(obj.minimumDistance("CAKE"));
        System.out.println(obj.minimumDistance("HAPPY"));
        System.out.println(obj.minimumDistance("NEW"));
        System.out.println(obj.minimumDistance("YEAR"));
    }
}
