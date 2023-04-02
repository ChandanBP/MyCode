import java.util.*;
import java.util.function.Function;
import java.util.stream.Collectors;

public class Java8Demo {
    public static void main(String[] args) {

        List<Integer> list = new LinkedList();
        list.add(1);
        list.add(2);
        list.add(3);
        list.add(4);
        list.add(5);
        list.add(2);

        System.out.println(list.stream().reduce(Integer.MAX_VALUE, (a, b) -> (a < b) ? a : b));
        System.out.println(list.stream().reduce(Integer.MIN_VALUE, (a, b) -> (a < b) ? b : a));

        System.out.println(list.stream().map(i -> i * i).filter(i -> i < 30).reduce(Integer.MIN_VALUE, (a, b) -> (a < b) ? b : a));
        System.out.println(list.stream().anyMatch(x -> x == 2));

        System.out.println(list.stream().map(i -> String.valueOf(i)).collect(Collectors.joining("-")));
        System.out.println(list.stream().collect(Collectors.counting()));
        System.out.println(list.stream().collect(Collectors.groupingBy(i->i, Collectors.summingInt(i -> 2))));
        System.out.println(list.stream().collect(Collectors.mapping(i->i,Collectors.summingInt(i->2))));

        System.out.println(list.stream().collect(Collectors.maxBy((a,b)->a-b)));


        Optional<String>optional = Optional.of("chandan");
        System.out.println(optional.filter(x->x.equals("chandan")).orElseGet(()->"Nothing"));
    }
}