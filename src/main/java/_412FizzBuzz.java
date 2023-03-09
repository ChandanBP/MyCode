import java.util.LinkedList;
import java.util.List;

public class _412FizzBuzz {

    public List<String> fizzBuzz(int n) {
        List<String> list = new LinkedList();
        for(int i=1;i<=n;i++){
            if(n%3==0 && n%5!=0){
                list.add("Fizz");
            }else if(n%3!=0 && n%5==0){
                list.add("Buzz");
            }else if(n%3==0 && n%5==0){
                list.add("FizzBuzz");
            }else{
                list.add(String.valueOf(i));
            }
        }
        return list;
    }

    public static void main(String[] args) {
        System.out.println(1%5);
        new _412FizzBuzz().fizzBuzz(15);
    }
}
