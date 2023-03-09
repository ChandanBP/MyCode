import java.util.Arrays;

public class _1101EarliestFriends {

    int parent[];
    int rank[];

    public int find(int x){
        if(parent[x]==x)return x;
        parent[x] = find(parent[x]);
        return parent[x];
    }

    public int earliestAcq(int[][] logs, int n) {

        if(logs==null || logs.length==0) return 0;

        Arrays.sort(logs,(a,b)-> a[0]-b[0]);
        parent = new int[n];
        rank = new int[n];

        for(int i=0;i<n;i++){parent[i] = i;rank[i]=1;}

        for(int i=0;i<logs.length;i++){
            int x = logs[i][1];
            int y = logs[i][2];

            int xroot = find(x);
            int yroot = find(y);
            int p = (xroot!=yroot)?union(xroot,yroot):xroot;
            if(rank[p]==n)return logs[i][0];
        }
        return -1;
    }

    public int union(int x,int y){
        int xroot = find(x);
        int yroot = find(y);
        int p = 0;
        int c = 0;

        if(rank[xroot]<rank[yroot]){
            parent[xroot] = yroot;
            p = yroot;
            c = xroot;
        }else if(rank[xroot]>rank[yroot]){
            parent[yroot] = xroot;
            p = xroot;
            c = yroot;
        }else {
            parent[xroot] = yroot;
            p = yroot;
            c = xroot;
        }
        rank[p] = rank[p] + rank[c];
        return p;
    }

    public static void main(String[] args) {
        System.out.println(new _1101EarliestFriends().earliestAcq(new int[][] {
                {20190101,0,1},
                {20190104,3,4},
                {20190107,2,3},
                {20190211,1,5},
                {20190224,2,4},
                {20190301,0,3},
                {20190312,1,2},
                {20190322,4,5}
        },6));
    }
}