import java.util.Arrays;

public class _853CarFleet {

    class CarPosition{
        int position;
        int speed;
        double arrivalTime;
        public CarPosition(int position,int speed,int target){
            this.position = position;
            this.speed = speed;
            arrivalTime = (double) (target-position)/speed;
        }
    }

    public int carFleet(int target, int[] position, int[] speed){

        CarPosition cars[] = new CarPosition[position.length];
        for(int i=0;i<position.length;i++){
            cars[i] = new CarPosition(position[i],speed[i],target);
        }

        Arrays.sort(cars,(a,b)->a.position-b.position);
        int carFleets = 0;
        int i = position.length-1;
        while(i>0){
            if(cars[i].arrivalTime<cars[i-1].arrivalTime)++carFleets;
            else cars[i-1]=cars[i];
            --i;
        }

        return carFleets+ ((i==0)?1:0);
    }

    public static void main(String[] args) {
        System.out.println(new _853CarFleet().carFleet(12,new int[]{10,8,0,5,3},new int[]{2,4,1,1,3}));
    }
}
