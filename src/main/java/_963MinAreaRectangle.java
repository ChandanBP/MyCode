import java.util.Arrays;

public class _963MinAreaRectangle {

    public double isRectangle(int x1,int y1,int x2,int y2,int x3,int y3,int x4,int y4){

        int adjacent = (int)Math.pow(x2-x1,2)+(int)Math.pow(y2-y1,2);
        int opposite1 = (int)Math.pow(x1-x3,2)+(int)Math.pow(y1-y3,2);
        int opposite2 = (int)Math.pow(x2-x4,2)+(int)Math.pow(y2-y4,2);
        int hyp1 = (int)Math.pow(x1-x4,2)+(int)Math.pow(y1-y4,2);
        int hyp2 = (int)Math.pow(x2-x3,2)+(int)Math.pow(y2-y3,2);

        if(hyp1==(adjacent+opposite1) && hyp2==(adjacent+opposite2)) return Math.sqrt(adjacent)*Math.sqrt(opposite1);

        return -1;
    }

    public double minAreaFreeRect(int[][] points) {

        if(points==null || points.length<4)return -1;

        Arrays.sort(points,(a,b)->a[0]-b[0]);

        /*

        * */
        double area = Double.MAX_VALUE;
        for(int i=0;i<points.length-3;i++){
            for(int j=i+1;j<points.length-2;j++){
                for(int k=j+1;k<points.length-1;k++){
                    for(int l=k+1;l<points.length;l++){

                        if(i==0 && j==3 && k==4 && l==5){
                            System.out.println();
                        }
                        int x1 = points[i][0];
                        int y1 = points[i][1];

                        int x2 = points[j][0];
                        int y2 = points[j][1];

                        int x3 = points[k][0];
                        int y3 = points[k][1];

                        int x4 = points[l][0];
                        int y4 = points[l][1];
                        double a = isRectangle(x1,y1,x2,y2,x3,y3,x4,y4);
                        if (a>0) area = Math.min(area,a);
                    }
                }
            }
        }

        return (area==Double.MAX_VALUE)?0:area;
    }

    public static void main(String[] args) {
        System.out.println(new _963MinAreaRectangle().minAreaFreeRect(new int[][]{{0,2},{0,1},{3,3},{1,0},{2,3},{1,2},{1,3}}));
    }
}
