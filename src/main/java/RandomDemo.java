import java.util.Random;

public class RandomDemo {

    public static void main(String[] args) {
        Random random = new Random();

        for(int i=1;i<=100;i++){
            System.out.println(10+random.nextInt(i));
        }
    }
}
