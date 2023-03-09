import java.util.ArrayList;

public class _901StockSpan {

    ArrayList<Integer>prices = new ArrayList<>();
    ArrayList<Integer>weights = new ArrayList<>();

    public int next(int price) {
        int w=1;
        int i = prices.size()-1;
        while(i>=0 && prices.get(i)<=price){
            int tw =weights.get(i);
            w+=tw;
            i=i-tw;
        }
        prices.add(price);
        weights.add(w);
        return w;
    }

    public static void main(String[] args) {
        _901StockSpan stockSpan = new _901StockSpan();
        System.out.println(stockSpan.next(100));
        System.out.println(stockSpan.next(80));
        System.out.println(stockSpan.next(60));
        System.out.println(stockSpan.next(70));
        System.out.println(stockSpan.next(60));
        System.out.println(stockSpan.next(75));
        System.out.println(stockSpan.next(85));
    }
}
