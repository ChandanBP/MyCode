public class _1504CountSubMatrices {

    public int numSubmat(int[][] mat) {

        int min[][] = new int[mat.length][mat[0].length];

        int res=0;
        for(int i=0;i<mat.length;i++){
            for(int j=0;j<mat[i].length;j++){
                if(mat[i][j]==1){
                    min[i][j] = (i==0||mat[i-1][j]==0)?i:min[i-1][j];

                    int m=min[i][j];
                    for(int l=j;l>=0;l--){

                        if(mat[i][l]==0)break;

                        m = Math.max(m,min[i][l]);
                        int k=m;
                        while(k<=i){
                            ++res;
                            ++k;
                        }
                    }
                }else{
                    min[i][j]=-1;
                }
            }
        }
        return res;
    }

    public static void main(String[] args) {
        System.out.println(new _1504CountSubMatrices().numSubmat(new int[][]{
                {1,0,1},
                {1,1,0},
                {1,1,0}}
                ));
    }
}
