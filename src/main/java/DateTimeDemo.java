import java.util.stream.Stream;

public class DateTimeDemo {
    public static void main(String[] args) {
        System.out.println(Stream.iterate(1,i->i+1).limit(10000000).count());
    }
}
