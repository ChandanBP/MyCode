public class _1351CountNegativeNumbers {

    public static int countNegatives(int[][] grid) {

        int i = 0;
        int j = 0;
        int count = 0;

        while(i<grid.length){

            if(grid[i][j]>=0){
                while(j<grid[i].length && grid[i][j]>=0){
                    j++;
                }
                count = count+(grid[i].length-j);
                if(j==grid[i].length)
                    j--;
            }
            else{
                while(j>=0 && grid[i][j]<0){
                    j--;
                }
                count = count+(grid[i].length-j-1);
                if(j==-1)
                    j=0;
            }
            i++;
        }
        return count;
    }

    public static void main(String[] args) {
        int grid[][] = {
                {3,2},
                {1,0}
        };
        System.out.println(countNegatives(grid));
    }
}
