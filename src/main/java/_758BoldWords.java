import java.util.Arrays;

public class _758BoldWords {
    public static void main(String[] args) {
        int bold[] = new int[5];
        Arrays.fill(bold,0,4,1);
        String s = "";
        Arrays.stream(bold).forEach(System.out::println);
    }
}
