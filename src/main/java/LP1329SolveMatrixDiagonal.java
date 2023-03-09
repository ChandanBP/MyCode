public class LP1329SolveMatrixDiagonal {

    public static int[][] diagonalSort(int[][] mat) {

        int i = mat.length-1;
        int j = 0;

        // lower left half
        while(i>=0){

            if(mat[i].length==1) return mat;

            int k = i;j = 0;
            int count[] = new int[101];
            while(k<=mat.length-1){
                count[mat[k][j]]++;
                k+=1;
                j+=1;
            }

            k = i;j=0;
            int c = 0;
            while(c<=count.length-1){
                if(count[c]!=0){
                    while(count[c]!=0){
                        mat[k][j] = c;
                        --count[c];
                        k+=1;
                        j+=1;
                    }
                }
                ++c;
            }

            --i;
        }

        i = 0;
        j = 1;

        // upper right half
        while(j<=mat[i].length-1){

            int k = i;
            int l = j;

            int count[] = new int[101];
            while(k<mat.length && l<mat[i].length){
                count[mat[k][l]]++;
                k+=1;
                l+=1;
            }

            k =i;
            l =j;
            int c = 0;
            while(c<=count.length-1){
                if(count[c]!=0){
                    while(count[c]!=0){
                        mat[k][l] = c;
                        --count[c];
                        k+=1;
                        l+=1;
                    }
                }
                ++c;
            }

            ++j;
        }

        return mat;
    }

    public static void main(String[] args) {
        int mat[][] = diagonalSort(new int[][]{
                {58},
                {99}
        });

        for(int i=0;i<mat.length;i++){
            for(int j=0;j<mat[i].length;j++){
                System.out.print(mat[i][j]+" ");
            }
            System.out.println();
        }

    }
}
